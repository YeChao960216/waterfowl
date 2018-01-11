/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 20:06:12 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-21 14:10:13
 */

(function(){
    
        /**
         * oURL 对象
         */
        const oURL = {
            PRONAME:'/waterfowl',
            GETOUTPOULTRYLIST:'/outpoultry/list',
        };

        /**
         * 实例化一个分页控制者
         */
        var pageController = new PageController({

            url:oURL.PRONAME+oURL.GETOUTPOULTRYLIST,

            view:{
                container : $('#content')[0],
                tpl:'find_out_poultry',
                nowView:$('#now')[0],
                allView:$('#all')[0],
            },
            pageBean:{
                pageDescription:'pageNum',
                countDescription:'pageSize',
                dataDescription:'list',
                totalDescription:'total',
                count:'10',
            },
            dom:{
                nextBtn :$('#next')[0],
                preBtn:$('#pre')[0],
                jumpBtn:$('#jumpTo')[0],
                jumpVal:$('#jumpText')[0],
            },

        });

        /**
         * 初始化视图,绑定事件操作，分页功能完成
         */
        pageController.init();
          
})();