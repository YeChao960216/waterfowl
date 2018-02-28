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
                totalDescription:'pages',
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

    /**
     * 查询功能
     * 点击了就序列化表单
     * 更改视图控制器的other属性
     * 初始化页面
     */
    $('#search').click(function () {
        var q = queryParse.call($('#searchForm'));
        var qStr = [];
        for(var key in q) {
            if (!q[key]) {
                delete q[key];
                continue;
            }
            qStr.push(key+'='+q[key]);
        }
        console.log(qStr.join('&'));
        pageController.other = '&'+qStr.toString();
        pageController.init();
    })
})();