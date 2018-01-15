/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-10-26 16:27:25 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-10-26 17:09:40
 */
(function () {
    /**
     * 向后台发送URL，获取所有在职人员的信息
     */
    const oURL = {
        PRONAME:'/waterfowl/',
        SHOWEMPINFO:'admin/user/list',
    };
    /**
     * 实例化一个分页控制者
     */
    console.log($('#content')[0]);
    var pageController = new PageController({

        url:oURL.PRONAME+oURL.SHOWEMPINFO,

        view:{
            container : $('#content')[0],
            tpl:'empInfo',
            nowView:$('#now')[0],
            allView:$('#all')[0],
        },
        pageBean:{
            pageDescription:'pageNum',
            countDescription:'pageSize',
            dataDescription:'list',
            totalDescription:'pages',
            count:'10',
            other:'&sign=1'
        },
        dataFilter:{
            tpl:'userInfo',
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
     * jq
     * 跳转页面进行职员详细信息的查看操作
     *
     */
    $('#content').on("click","[id*=show]",function(){
        var emp_id = $(this).attr('id').substr(4);
        window.location.href="./showEmpDetail.html?id="+emp_id;
    });

    $("[type=radio]").change(function () {
        pageController.other = '&sign='+$(':checked').val();
        pageController.init();
    });
})()

