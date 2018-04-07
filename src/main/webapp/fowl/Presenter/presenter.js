/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2018-02-05 16:00:18 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-02-24 23:27:36
 * MVP框架设计
 */

 /**
  * ~屏蔽后期压缩带来的错误
  */

~function (global){
    
    var MVP = function(modelName,pst){

        if(MVP.P[modelName]){

            console.log('该组件已经存在，无法重复添加');

            return
        }

        MVP.P[modelName] = pst;

    };

    MVP.M = Model;

    MVP.V = View;

    MVP.P = {};

    MVP.init = function(){             //渲染每个在管理器里的组件

        for(var modules in MVP.P){

            MVP.P[modules] && MVP.P[modules](MVP.M,MVP.V);
            
        }
    }
    
    MVP.partlyInit = function (modelName) {   //局部刷新某个组件
        var that = this;
        that.P[modelName] && that.P[modelName](that.M,that.V);
    }
    
    global.MVP = MVP              //向最顶层对象暴露MVP超级对象

    global.render = function (str,objArr,dom) { //针对该系统设计的渲染函数
        var html = '';
        var data = Object.prototype.toString.call(objArr) === '[object Array]' ? objArr : [objArr];
            data.forEach(function (item) {
                html += str.replace(/\{\{(\w+)\}\}/g,function (matchArr,key) {

                    if(key == 'curdate' || key == 'date' || key == 'recordDate' || key == 'collectDate' || key == 'incubationDate'){
                        return new Date(item[key]).toLocaleDateString();
                    }
                    if(key == 'tid' || key == 'cid' || key == 'firm'){ //公司信息翻译
                        var word = localStorage.getItem('waterfowl'+item[key]);     //字典过滤
                        if(word){
                            return word
                        }else{
                            return item[key]
                        }

                    }
                    if(+item[key] && key != 'id'){   //是数字又不是id值证明就是字典里的东西
                        var word = localStorage.getItem('waterfowl'+item[key]);     //字典过滤
                        if(word){          //利用强制类型转换 是数字的
                            return word;
                        }else{
                            return item[key];
                        }
                    }else{
                        return item[key];
                    }

                });
            })
            dom.innerHTML = html;
    }

    Object.seal(global.MVP);//不可拓展，删除，但可以修改
    Object.freeze(global.render);//仅仅可以访问

    // Object.defineProperty(global,'render',{  //防止他人修改render函数
    //
    //     get:function (str,obj,dom) {
    //         var html = '';
    //         html = str.replace(/\{\{(\w+)\}\}/g,function (matchArr,key) {
    //             if(+obj[key] && key != 'id'){   //判断是不是数字
    //                 var word = localStorage.getItem('waterfowl'+obj[key]);     //字典过滤
    //                 if(word){          //利用强制类型转换 是数字的
    //                     return word;
    //                 }else{
    //                     return obj[key];
    //                 }
    //             }else{
    //                 return obj[key];
    //             }
    //         });
    //         dom.innerHTML = html;
    //     },
    //     writable:false,
    //     enumerable:true,
    //     configurable:false
    // });

}(this);

