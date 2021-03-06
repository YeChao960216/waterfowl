﻿/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 20:06:12 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-27 17:59:17
 */

(function(global){
    
        /**
         * oURL 对象
         */
        const oURL = {
            PRONAME:'/waterfowl',
            DEL:'/admin/patch/deletePatch/',
            GETFINDPATCHBYPID:'/admin/patch/findPatchByPidAndStatusCutPage/'+getRequest()['id'],
            GETPATCHLIST:'/admin/patch/listPatch?id='
        };
        var preDataObj = getRequest();
        viewCommand({
            command:'display',
            param:[$('#preContent')[0],preDataObj,'poultry_nav']
        });
    /**
     * 实例化一个分页控制者
     */
    var pageController = new PageController({

        url:oURL.PRONAME+oURL.GETFINDPATCHBYPID,
        view:{
            container : $('#content')[0],
            tpl:'patch_list',
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
            tpl:'filterTimeAndNull',
        },
        dom:{
            nextBtn :$('#next')[0],
            preBtn:$('#pre')[0],
            jumpBtn:$('#jumpTo')[0],
            jumpVal:$('#jumpText')[0],
        },

    });
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
        $('#back').show();
        pageController.url = oURL.PRONAME+oURL.GETPATCHLIST
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
        pageController.url = oURL.PRONAME+oURL.GETFINDPATCHBYPID;
        pageController.other = '';
        pageController.init();
    });

    /**
     *
     * 提交删除的id值
     1、删除成功后，初始化视图
     */
    $('#content').on('click',"[data-id*='del']",function(){
        var id = $(this).attr('data-id').substr(3);
        $.get(oURL.PRONAME+oURL.DEL+id,function(res){
            if(res.status){
                pageController.init();
            }else{
                alert('删除对象条目失败');
            }
        });
    });

    /**
     * 批次信息的修改
     */
    $('#content').on('click',"[data-id*='edit']",function(){
        var id = $(this).attr('data-id').substr(4);
        window.location.href="./edit.html?id="+id;
    });

})();