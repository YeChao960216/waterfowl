/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-10-26 16:27:25 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-10-26 18:08:43
 */

    /**
     * 向后台发送数据，获取所有离职人员的信息
     */

    /**
     * 常量url对象
     */
    const oURL = {
        PAGE:1,
        COUNT:15,
        PRONAME:'/waterfowl',
        GETNOTWORKER:'/admin/user/list',
        ADDEMP:'/admin/user/entry/',
    };

/**
 * 实例化一个分页控制者
 */
var pageController = new PageController({

    url:oURL.PRONAME+oURL.GETNOTWORKER,

    view:{
        container : $('#content')[0],
        tpl:'addEmp',
        nowView:$('#now')[0],
        allView:$('#all')[0],
    },
    pageBean:{
        pageDescription:'pageNum',
        countDescription:'pageSize',
        dataDescription:'list',
        totalDescription:'pages',
        count:'10',
        other:'&sign=3'
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
     * 办理入职操作
     *
     */
    $('#content').on("click","[data-id*=add]",function(){
        var emp_id = $(this).attr('data-id').substr(3);
        console.log(emp_id);
        $.post(oURL.PRONAME+oURL.ADDEMP+emp_id,function(data){
            if(data.status==1){//修改成功
                initView();
            }else{
                alert('本次操作失败');
            }
        });
    })

    /**
     * 原生js
     * document.getElementById('content').addEvent('click',function(e){
     *      e = e?e||window.event;
     *      var tarId = e.target.id||e.srcElement.id;
     *      if(tarId.test(/^add/)){
     *          tarId = tarId.substr(2);
     *      }
     *      ajax.post(URL_ADDEMP.ADDEMP,{id:tarId},function(data){
    //         if(data.status==0){//修改成功
    //             initView();
    //         }
    //     });
     * });
     */
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
    pageController.other = '&'+qStr.toString()+'&sign=3';
    pageController.init();
})