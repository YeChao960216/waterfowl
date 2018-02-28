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
            GETLIST:'/manufacture/list',
            DEL:'/manufacture/delete/',
            CHECK:'/outpoultry/show/',
            EDITSTATUS:'/manufacture/finishManufacture?idPatch='
        };

    /**
     * 实例化一个分页控制者
     */
    var pageController = new PageController({

        url:oURL.PRONAME+oURL.GETLIST,

        view:{
            container : $('#content')[0],
            tpl:'manu',
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


    pageController.init();

    /**
     * 查询功能
     * 点击了就序列化表单
     * 更改视图控制器的other属性
     * 初始化页面
     */
    /*$.get(oURL.PRONAME+oURL.GETLIST+'?pid=0&pageSize=1000&pageNum=1',function (res) {  //渲染所有的栏目
        if(res.list){

            viewCommand({
                command:'display',
                param:[$('select')[0],res.list,'idPatch']
            });

            pageController.other = '&pid='+$('select')[0].value;

            pageController.init();
        }
    });


    $('select')[0].onchange = function () {

        pageController.other = '&pid='+this.value;

        pageController.init();

    }*/


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

    /**
     * 完成加工
     */
    $('#content').on('click',"[data-id*='ok']",function(){
        if(confirm('溯源提示:\n\n确认该批次完成加工吗？')){
            var idPatch = $(this).attr('data-patch');
            $.get(oURL.PRONAME+oURL.CHECK+idPatch,function (res) {
                if(res.status != 30005 || res.status != 30011){
                    $.get(oURL.PRONAME+oURL.EDITSTATUS+idPatch,function (resp) {
                        if(resp){
                            alert('溯源提示:\n\n'+resp.msg);
                        }else{
                            alert('溯源提示:\n\n'+resp.msg);
                        }
                    });
                }else{
                    alert('溯源提示:\n\n确认该批次处于非加工状态，修改批次状态失败');
                }
            });
        }
    });
})();