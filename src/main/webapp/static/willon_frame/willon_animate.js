/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2018-01-11 21:51:08 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-11 21:51:39
 */
window.requestAnimationFrame = window.requestAnimationFrame||function(fn){
    return setTimeout(fn,1000/60);
}
window.cancelAnimationFrame = window.cancelAnimationFrame||clearTimeout;
//Element.prototype.animation = animation; obj=this  这样可以简化使其更像jquery
var moveFrame = {
    getStyle:function(obj,attr){
       var data = window.getComputedStyle?window.getComputedStyle(obj)[attr]:obj.currentStyle[attr];
        return data;
    },
    animation:function(obj,json,dur_t,cb){
        var init_time = new Date();//获取调用这个函数时的时间值
        var init_val={},tar_val={};//前者存放初始值，后者存放目标属性值
        for(var attr in json){
            tar_val[attr] = parseFloat(json[attr]);   //遍历存放目标属性,顺便把px去掉
            init_val[attr] = parseFloat(this.getStyle(obj,attr));
        }
        (function continueAnimation(){
            var run_t = new Date() - init_time;//多次调用时都要获取时间长度
            if(run_t/dur_t>=1){
                run_t = dur_t;
            }else{
                window.requestAnimationFrame(continueAnimation);
            }
            for(var attr in json){
                var a = (tar_val[attr]-init_val[attr])*2/Math.pow(dur_t,2);//s = 1/2at^2 => a = 2s/t^2获取某个属性的加速度
                var thisMove_distance = a*Math.pow(run_t,2)/2;//这个时刻前进的路程
                var unit = '';
                switch(attr){      //处理属性
                    case 'opacity':break;
                    case 'zIndex':break;
                    default:unit='px';break;
                }
                obj.style[attr] = init_val[attr]+thisMove_distance+unit;
            }
            run_t>=dur_t?cb&&cb.call(obj):'';

        })();
    },
};

/**
 *
 * @param {事件对象} e
 */
var getEvent = function(e){
    e=e?e:window.event;
    return e;
}
/**
 * 这个是用在事件委托上的
 * @param {事件对象} event
 */
var getTarget = function(event){
    var event = getEvent(event);
    return event.target = event.srcElement;//后者兼容IE
}

/**
 * 阻止默认行为
 * @param {事件对象} event
 */
var preventDefault = function(event){
    var event = getEvent(event);
    (event.preventDefault)?event.preventDefault():event.returnValue = false;//后者为兼容IE
}
var getY = function(event){
    var ev = getEvent(event);
    return ev.clientY;
}
var getX = function(event){
    var ev = getEvent(event);
    return ev.clientX;
}

/**
 * 事件的监听
 * @param dom
 * @param type
 * @param fn
 * @param flag
 */
var bindEvent = function(dom,type,fn,flag){//这里还可以加上一个data 访问者模式中对事件绑定进一步的拓展；往事件函数的回掉函数中添加数据
    flag = flag || false;//冒泡
    if(dom.addEventListener){//dom2事件
        dom.addEventListener(type,fn,flag);
    }else if(dom.attachEvent){
        dom.attachEvent('on'+type,function(e){
            fn.call(dom,e);
        });
    }else{//dom0事件
        dom['on'+type] = fn;
    }
}

/**
 * 拖动
 * @param dom
 * @param raletiveDom
 */

var dragByOther = function(obj,raletiveDom){
    raletiveDom = raletiveDom || document.body;
    obj.draggable = true;
    if(!raletiveDom){
        raletiveDom = document.body;
        raletiveDom.style.width = document.documentElement.clientWidth +'px' || window.innerWidth +'px';
        raletiveDom.style.height = document.documentElement.clientHeight +'px'|| window.innerHeight +'px';
    }
    window.onresize = function(){
        raletiveDom.style.width = document.documentElement.clientWidth +'px' || window.innerWidth +'px';
        raletiveDom.style.height = document.documentElement.clientHeight +'px'|| window.innerHeight +'px';
    }
    obj.onmousedown = function(ev){
        var e = getEvent(ev);
        preventDefault(e);//处理默认事件
        var init_X = parseFloat(moveFrame.getStyle(obj,'left'));
        var init_Y = parseFloat(moveFrame.getStyle(obj,'top'));
        var X = e.clientX;
        var Y = e.clientY;

        raletiveDom.onmousemove = function(ev){
            e = getEvent(ev);
            console.log(e);
            var disX = e.clientX-X;//偏移值
            var disY = e.clientY-Y;
            obj.style.left = init_X+disX+'px';
            obj.style.top = init_Y+disY+'px';
        }
        raletiveDom.onmouseup = function(){
            raletiveDom.onmousemove = null;
            raletiveDom.onmouseup = null;
        }
        bindEvent(raletiveDom,'mouseleave',function(){
            raletiveDom.onmousemove = null;
            raletiveDom.onmouseup = null;
        });
    }

}