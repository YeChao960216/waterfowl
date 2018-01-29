/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 20:06:12 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-19 20:07:52
 */

(function(global){

    /**
     * oURL 对象
     */
    const oURL = {
        PRONAME:'/waterfowl',
        GETPOUTLTRYLIST:'/poultry/list',
    };
    /**
     * 实例化一个分页控制者
     */
    var pageController = new PageController({

        url:oURL.PRONAME+oURL.GETPOUTLTRYLIST,

        view:{
            container : $('#content')[0],
            tpl:'patch_first',
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
        $('#back').show();
        // pageController.url = oURL.PRONAME+oURL.GETAQUACULTURELIST;
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
        // pageController.url = oURL.PRONAME+oURL.GETPOUTLTRYLIST;
        pageController.other = '';
        pageController.init();
    });

    /**
     * 切换视图
     * 提交的id值
     1、成功后，切换视图
     */
    $('#content').on('click',"[data-id*='P']",function(){
        var $this = $(this),
            id = $this.attr('data-id').substr(1),
            associatedFirm = $this.attr('data-firm'),
            phone = $this.attr('data-phone'),
            idRecorder = $this.attr('data-idR'),
            idCharge = $this.attr('data-idC'),
            type = $this.attr('data-type'),
            recordeDate = $this.attr('data-recordeDate'),
            quantity = $this.attr('data-quantity');
        window.location.href="./aqua_list.html?id="+id+'&associatedFirm='+associatedFirm+'&idRecorder='+idRecorder+
            '&idCharge='+idCharge+'&recordeDate='+recordeDate+'&phone='+phone+'&type='+type+'&quantity='+quantity;
    });

})();