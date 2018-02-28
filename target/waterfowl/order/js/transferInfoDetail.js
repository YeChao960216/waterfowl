/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 20:06:12 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-30 19:45:29
 */

(function(){
    
        /**
         * oURL 对象
         */
        const oURL = {
            PRONAME:'/waterfowl',
            GETINFOLIST:'/transportation/listtransportation',
            DEL:'/transportation/delete/',
        };

        var nav = getRequest();
    /**
     * 实例化一个分页控制者
     */
    var pageController = new PageController({

        url:oURL.PRONAME+oURL.GETINFOLIST,

        view:{
            container : $('#content')[0],
            tpl:'transferInfoList_find',
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
            tpl:'filterTimeAndNull_curDate'
        },
        dom:{
            nextBtn :$('#next')[0],
            preBtn:$('#pre')[0],
            jumpBtn:$('#jumpTo')[0],
            jumpVal:$('#jumpText')[0],
        },

    });
    pageController.other = '&idPatch='+nav.idPatch;
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
        pageController.other = '&'+qStr.join('&')+'&idPatch='+nav.idPatch;
        pageController.init();
    });

    /**
     * 添加物流记录
     */
    $('#addTransInfo').click(function () {

        $.get(oURL.PRONAME+oURL.GETINFOLIST+'?idPatch='+nav.idPatch,function (res) {
            if(res.list.length){
                var data = res.list[res.list.length-1];//第一条记录记录着出发地
                window.location.href = './transferInfoAdd.html?idPatch='+nav.idPatch+'&cid='+data.cid+'&curquantity='+data.curquantity+'&tid='+data.tid;
            }else{
                window.location.href = './transferInfoAdd.html?idPatch='+nav.idPatch;
            }
        });

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
        pageController.other = '&idPatch='+nav.idPatch;
        pageController.init();
    });

    
    /**
     * 提交的id值
     1、成功后，跳转到对应id的所有物流记录
     */
    $('#content').on('click',"[data-id*='del']",function(){
        if(confirm('溯源提示:\n\n确认删除该条记录吗？')){
            var id = $(this).attr('data-id').substr(3);
            new Image().src = oURL.PRONAME+oURL.DEL+id;
            pageController.init();
        }
    });


})();