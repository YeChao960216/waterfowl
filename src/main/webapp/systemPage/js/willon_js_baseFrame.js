/*
 * @Author: 伟龙-Willon 
 * @Date: 2017-09-16 23:10:32 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-10-24 14:55:30
 */

/**
 * 
 * 简单的jq 选择器
 * @param {any} o 
 * @returns 
 */
var W = function(o){
    var type = typeof(o);
    switch(type){
        case 'function':window.onload=o();break;
        case 'string': return checkType(o);break;
    }

}
var checkType = function(str){
    var new_str = str.toLowerCase(),
            n = new_str.substr(0,1),
            el = new_str.substring(1);
        if(!n.match(/[a-z]/)){
            switch(n){
                case '#':return document.getElementById(el);break;
                case '.':return document.getElementsByClassName(el);break;
                default:throw new Error('请检查你选择器');break;
            };
        }else{
            return document.querySelectorAll(new_str);
        }
}
/**
 * 访问者模式,外观模式亦可，dom2级事件绑定
 * @param {dom对象} dom 
 * @param {事件属性} type 
 * @param {事件函数} fn 
 * @param {是否捕获} flag 
 * @param {往回调中掺入数据} data 
 */
var bindEvent = function(dom,type,fn,flag){//这里还可以加上一个data 访问者模式中对事件绑定进一步的拓展；往事件函数的回掉函数中添加数据
    flag = flag || false;//冒泡
    //data = data || {};
    // dom[type] = handle;
    // if(type ==='mousewheel'){
    //     var browserName=navigator.userAgent.toLowerCase();  
    //     if(/firefox/i.test(browserName)){
    //         console.log('firefox');
    //         dom.addEventListener?dom.addEventListener('DOMMouseScroll',dom[type],flag):false;   //兼容firefox
    //     }else
    //         dom.onmousewheel = dom[type];//兼容ie chrome
    // }else{
    //     if(dom.addEventListener){//dom2事件
    //         dom.addEventListener(type,dom[type],flag);
    //     }else if(dom.attachEvent){
    //         dom.attachEvent('on'+type,dom[type]);
    //     }else{//dom0事件
    //         dom['on'+type] = dom[type];
    //     }
    // }
    // function handle(e){
    //     e = getEvent(e);
    //     e.wheel = e.wheelDelta?e.wheelDelta:-e.detail*40;
    //     fn.call(dom,e);
    // }
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
var removeEvent = function(dom,type,fn){
    //flag = flag || false;
    if(dom.removeEventListener){
        dom.removeEventListener(type,dom[type]);
    }else if(dom.datachEvent){
        dom.detachEvent('on'+type,function(e){
            dom[type].call(dom,e);
        });
    }else{
        dom['on'+type] = null;
    }
}


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
// document.onclick = function(e){
//     preventDefault(e);
//     if(getTarget(e)!==document.getElementById('test')){
//         //.....
//     }
// }
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
 * @param {移动对象} dom 
 * @param {参照对象} raletiveDom  
 * 同时要求父相子绝
 * ev.stoppropagation()和ev.cancelBubble=true阻止默认行为的冒泡
 */

var moveByOther = function(dom,raletiveDom){
    if(!raletiveDom){
        raletiveDom = document.body;
        raletiveDom.style.width = document.documentElement.clientWidth +'px' || window.innerWidth +'px';
        raletiveDom.style.height = document.documentElement.clientHeight +'px'|| window.innerHeight +'px';
    }
    window.onresize = function(){
        if(raletiveDom === document.body){
            raletiveDom.style.width = document.documentElement.clientWidth +'px' || window.innerWidth +'px';
            raletiveDom.style.height = document.documentElement.clientHeight +'px'|| window.innerHeight +'px';
        }
    }
    bindEvent(raletiveDom,'mousemove',function(event){
        var left = raletiveDom.offsetLeft;
        var right = left+raletiveDom.offsetWidth;
        var top = raletiveDom.offsetTop;
        var bottom = top+raletiveDom.offsetHeight;
        var W = dom.offsetWidth;
        var H = dom.offsetHeight;
        var ev = getEvent(event);
        var x = getX(ev)-W/2-left,y = getY(ev)-H/2-top;
        if(getY(ev)-H/2<=top)
            y = 0;
        if(getY(ev)+H/2>=bottom)
            y = bottom-H-top;
        if(getX(ev)-W/2<=left)
            x = 0;
        if(getX(ev)+W/2>=right)
            x = right-W-left;
        dom.style.top = y + 'px';//获得相对于浏览器窗口定位的横标值
        dom.style.left = x  + 'px';
        
    },false);
}
/**
 * 提示： 链接和图片默认是可拖动的，不需要 draggable 属性。

    在拖放的过程中会触发以下事件：
    在拖动目标上触发事件 (源元素):  ondragstart - 用户开始拖动元素时触发
    ondrag - 元素正在拖动时触发
    ondragend - 用户完成元素拖动后触发


    释放目标时触发的事件:  ondragenter - 当被鼠标拖动的对象进入其容器范围内时触发此事件
    ondragover - 当某被拖动的对象在另一对象容器范围内拖动时触发此事件
    ondragleave - 当被鼠标拖动的对象离开其容器范围内时触发此事件
    ondrop - 在一个拖动过程中，释放鼠标键时触发此事件


    注意： 在拖动元素时，每隔 350 毫秒会触发 ondrag 事件。
    drop 事件的默认行为是以链接形式打开

 */
/**
 * 要求dom1_child一定要有一个id
 */
var dragBetween = function(box1,box2){
    box1.ondragover = function(e){//拖到另一个对象身上时
        e = getEvent(e);
        preventDefault(e);
    }
    box1.ondrop = function(e){//拖动鼠标抬起,释放拖动物
        dragoverOther(e);
    }
    for(var i=0,len=box1.children.length;i<len;i++){//子元素每个都可以拖拽
            
            box1.children[i].draggable = true;
            box1.children[i].ondragstart = function(e){
                e = getEvent(e);
                setDragObj.call(getTarget(e).id,e);
            }
        
    }
    
    box2.ondragover = function(e){//拖到另一个对象身上时
        e = getEvent(e);
        preventDefault(e);
    }
    box2.ondrop = function(e){//拖动鼠标抬起,释放拖动物
        dragoverOther(e);
    }
}
var setDragObj = function(e){
    e.dataTransfer.setData("Text",this);//只能传文本类型 和 url类型
    
}

var dragoverOther = function(e){//获取拖动对象，填充,结束
    var obj = e.dataTransfer.getData("Text");
    e.target.appendChild(document.getElementById(obj));
}

/**
 * 
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
        console.log('ok');
        e = getEvent(ev);
        console.log(e);
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



/* 运动框架
 * @Author: 伟龙-Willon 
 * @Date: 2017-09-26 16:37:21 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-10-09 13:43:02
 */
/**
 * 处理兼容 原生js-请求动画帧
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
    rock:function(obj,shakeArea,freq){
        var init_left = parseFloat(this.getStyle(obj,'left'));
        var init_time  = new Date();
        var shakeD = 1;
        willon.end = false;
        (function run(){
            var cur_t = new Date()-init_time;//动画时长;
            var props = cur_t/freq;//时间比例;
            shakeD = -shakeD;//左右晃动
            shakeArea--;//逐渐减少晃动范围
            willon.timer = window.requestAnimationFrame(run);
            if(props>=1){
                props = 1;
                window.cancelAnimationFrame(willon.timer);
                willon.end = true;
            }
            var val = (shakeArea-init_left)*props*shakeD;
            obj.style.left = init_left+val+'px';
        })(); 
     }
}

/**
 * 访问者、、类数组操作
 */
var Visitor = (function(){
    return{
        splice:function(){
            var args = Array.prototype.splice.call(arguments,1);//切割出1及之后的东西
            return Array.prototype.splice.apply(arguments[0],args);//绑定第一个对象
        },
        push:function(){
            var len = arguments[0].length || 0;//强化类数组;
            var args = this.splice(arguments,1);
            arguments[0].length = len + arguments.length - 1;
            return Array.prototype.push.apply(arguments[0],args);
        },
        pop:function(){
            return Array.prototype.pop.apply(arguments[0]);
        }
    }   
})();

/**
 * 检查是哪个浏览器
 */
var userBrowser = function(){
    var browserName=navigator.userAgent.toLowerCase();  
    if(/msie/i.test(browserName) && !/opera/.test(browserName)){   
        return 'IE';  
    }else if(/firefox/i.test(browserName)){   
        return "Firefox";
    }else if(/chrome/i.test(browserName) && /webkit/i.test(browserName) && /mozilla/i.test(browserName)){  
        return "Chrome";
    }else if(/opera/i.test(browserName)){  
        return "Opera";  
    }else if(/webkit/i.test(browserName) &&!(/chrome/i.test(browserName) && /webkit/i.test(browserName) && /mozilla/i.test(browserName))){  
        return "Safari";  
    }else{  
        alert('您使用的是外星人浏览器呀？');   
    }  
}  

/**
 * cookie的使用
 * @param {any} attrName 
 * @returns 
 */
var getCookie = function(attrName) {
    // (^| )name=([^;]*)(;|$),match[0]为与整个正则表达式匹配的字符串，match[i]为正则表达式捕获数组相匹配的数组；
    var arr = document.cookie.match(new RegExp("(^| )"+attrName+"=([^;]*)(;|$)"));
    if(arr != null) {
        return unescape(arr[2]);
    }
    return null;
}
var setCookie = function(attrName,value){
    var Days = 10; //此 cookie 将被保存 30 天
    var exp  = new Date();    
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    if((typeof value == "string")&&(value.length > 0)){
        document.cookie = attrName + "="+ escape(value) + ";expires=" + exp.toGMTString();
    }else{                          
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval=getCookie(attrName);//如果传入的name属性，在修改之前就存在了
        if(cval!=null)
            document.cookie=attrName +"="+cval+";expires="+exp.toGMTString();
    }
}