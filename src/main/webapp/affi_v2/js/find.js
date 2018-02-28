/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 20:06:12 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-19 20:07:52
 */

(function(){
    
        /**
         * oURL 对象
         */
        const oURL = {
            PRONAME:'/waterfowl',
            FINDLIST:'/admin/affiliation/listAffiliation',
            DEL:'/admin/affiliation/deleteAffiliation/',
            GETPOSITION:'/dict/list?pid=70000', //方位
            GETGUIMO:'/dict/list?pid=60000',   //大小规模
        };
    /**
     * 实例化一个分页控制者
     */
    var pageController = new PageController({

        url:oURL.PRONAME+oURL.FINDLIST,

        view:{
            container : $('#content')[0],
            tpl:'affi_v2_show',
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

    /**
     * 初始化视图,绑定事件操作，分页功能完成
     */
    pageController.init();

    /**
     * 方位、规模
     */
    $.get(oURL.PRONAME+oURL.GETPOSITION,function(res){
        if(res){
            viewCommand({
                command:'display',
                param:[$('select')[0],res.list,'id_name']
            });
        }else{
            alert('溯源提示:\n\n获取方位信息失败');
        }
    });
    $.get(oURL.PRONAME+oURL.GETGUIMO,function(res){
        if(res){
            viewCommand({
                command:'display',
                param:[$('select')[1],res.list,'id_name']
            });
        }else{
            alert('溯源提示:\n\n获取规模信息失败');
        }
    });

    /**
     * 新增
     */
    $('#new').click(function () {
       window.location.href = "./add.html"
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
            if (!q[key]) {   //如果填充值为空，我就去除这个属性
                delete q[key];
                continue;    //就不压入堆栈中
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
        var id = $(this).attr('data-id').substr(3);
        $.get(oURL.PRONAME+oURL.DEL+id,function(res){
            if(res.status){
                pageController.init();
            }else{
                alert('删除对象条目失败');
            }
        });
    });
})();