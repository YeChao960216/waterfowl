/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 20:06:12 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-28 14:18:14
 */

(function(){
    
        /**
         * oURL 对象
         */
        const oURL = {
            PRONAME:'/waterfowl',
            GETLIST:'/customer/listCustomer',
            DEL:'/customer/delete/',
            EDITSTATUS:'/transportation/finishTransportation?id=',//修改批次为完成状态
            GETINFOLIST:'/transportation/listtransportation?cid=',//通过id获取批次信息
            CHECK:'/admin/patch/showPatch/'
        };

    /**
     * 实例化一个分页控制者
     */
    var pageController = new PageController({

        url:oURL.PRONAME+oURL.GETLIST,

        view:{
            container : $('#content')[0],
            tpl:'order',
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
        if(confirm('溯源提示:\n\n确认删除该条加工记录吗？')){
            var id = $(this).attr('data-id').substr(3);
            new Image().src = oURL.PRONAME+oURL.DEL+id;
            pageController.init();
        }
    });

    /**
     * 完成配送
     */
    $('#content').on('click',"[data-id*='ok']",function(){
        if(confirm('溯源提示:\n\n确认该批次完成配送吗？')){
            var id = $(this).attr('data-id').substr(2);
            $.get(oURL.PRONAME+oURL.GETINFOLIST+id,function (r) {
                if(r){
                    $.get(oURL.PRONAME+oURL.CHECK+r.list[0].idPatch,function (res) {
                        console.log(+res.status);
                        if(+res.status >= 30007){
                            if(+res.status === 30008){
                                alert('溯源提示:\n\n确认该批次已完成配送,无法重复此操作');
                                return
                            }else{
                                $.get(oURL.PRONAME+oURL.EDITSTATUS+r.list[0].idPatch,function (resp) {
                                    if(resp){
                                        alert('溯源提示:\n\n'+resp.msg);
                                    }else{
                                        alert('溯源提示:\n\n'+resp.msg);
                                    }
                                });
                            }
                        }else{
                            alert('溯源提示:\n\n确认该批次处于非运输状态,无法进行此操作');
                        }
                    });
                }else{
                    alert('溯源提示:\n\n获取该批发商的物流信息失败');
                }
            });

        }
    });

})();