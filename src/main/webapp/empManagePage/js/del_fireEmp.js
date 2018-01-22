/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-04 17:52:20 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-04 18:13:26
 */
(function(){
    /**
     * oUrl对象
     * 1、解雇职员
     * 2、完全删除职员信息
     */
    const oURL = {
        PORNAME:'/waterfowl',
        WORKEMPINFO:'../../../admin/user/list',
        FIREEMP : '../../../admin/user/fire/',
        DELEMP:'../../../admin/user/delete/',
    }

    /**
     * 实例化一个分页控制者
     */
    var pageController = new PageController({

        url:oURL.PRONAME+oURL.WORKEMPINFO,

        view:{
            container : $('#content')[0],
            tpl:'del_fireEmp',
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
     * 对应着两个option操作
     * @param {*} url 
     * @param {*} id 
     * @param {*} cb 
     */
    var option = function(url,id,cb){
        $.get(url+id,function(data){
            if(data.status === '1'){//成功
                cb&&cb();
            }
        });
    }

    /**
     * 触发两个事件委托
     */
    $('#content').on("click","[id*='fire']",function(){
        if(confirm('确认解雇该员工吗？')){
            var id = $(this).attr('id').substr(4);
            option(oURL.PRONAME+oURL.FIREEMP,id,pageController.init);
        }
    });

    $('#content').on("click","[id*='del']",function(){
        if(confirm('确认删除该员工的所有信息吗？')){
            var id = $(this).attr('id').substr(3);
            option(oURL.PRONAME+oURL.DELEMP,id,pageController.init);
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
        pageController.other = '&'+qStr.toString();
        pageController.init();
    })
    
})();