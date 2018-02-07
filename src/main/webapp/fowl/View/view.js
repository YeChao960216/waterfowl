/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2018-02-05 17:34:09 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-02-06 09:56:53
 */

var View = (function(){

    var V = {};
    
    V.TPL = {};

    V.init = function(tpl){

        var html = '';

        try {

            /**
             *因为vsc的emment插件书写模板够快所以我偷懒用这招了，后续mvp版本会优化视图层
             *也考虑到这次模板的复用率不高
             *所以模板直接写在html上
             * @type {string}
             */
                html = document.getElementById(tpl).innerHTML;

                V.TPL[tpl] = html;           //填充新的模板
                
                return html;
            
        } catch (error) {

            console.log('获取模板元素失败');

            console.log(error);
        }
    }


    return{

        getTPL:function(tpl){

            return V.TPL[tpl]?V.TPL[tpl]:V.init(tpl);

        }

    }
    
})();

/**冻结对象 下个版本再完善*/
// Object.freeze(View);
