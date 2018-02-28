/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 20:06:12 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-29 21:48:16
 */

(function(){
    
        /**
         * oURL 对象
         */
        const oURL = {
            PRONAME:'/waterfowl',
            GETLIST:'/transcompany/listtranscompany',
            DEL:'/transcompany/delete/',
            GETCOMTYPE:'/dict/list?pid=17000',//获取公司类型

        };

    /**
     * 实例化一个分页控制者
     */
    var pageController = new PageController({

        url:oURL.PRONAME+oURL.GETLIST,

        view:{
            container : $('#content')[0],
            tpl:'transferFirm_find',
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
        dataFilter:{
            tpl:'filterTimeAndNull'
        },
        dom:{
            nextBtn :$('#next')[0],
            preBtn:$('#pre')[0],
            jumpBtn:$('#jumpTo')[0],
            jumpVal:$('#jumpText')[0],
        },

    });

    pageController.init();

    $.get(oURL.PRONAME+oURL.GETCOMTYPE,function (res) { //渲染公司类型
        if(res.list.length>0){
            viewCommand({
                command:'display',
                param:[$('#type'),res.list,'id_name']
            });
        }else{
            alert('溯源提示:\n\n公司类型这一栏目的资料为空，请前往栏目管理模块中添加');
        }
    });
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
        $('#back').show();
        pageController.other = '&'+qStr.join('&');
        pageController.init();
    });

    /**
     * 返回键
     * 每当成功查找出一项时 此按钮显示
     * 此按钮被按下时
     *      清空查询表单的字
     *      并初始化页面
     */
    $('#back').click(function () {
        $('#searchForm input').val('');
        $(this).hide();
        pageController.other = '';
        pageController.init();
    });

    
    /**
     * 提交删除的id值
     1、删除成功后，初始化视图
     */
    $('#content').on('click',"[data-id*='del']",function(){
        if(confirm('溯源提示:\n\n确认删除该条记录吗？')){
            var id = $(this).attr('data-id').substr(3);
            new Image().src = oURL.PRONAME+oURL.DEL+id;
            pageController.init();
        }
    });

})();