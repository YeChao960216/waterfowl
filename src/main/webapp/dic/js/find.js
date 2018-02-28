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
            GETLIST:'/dict/list',
            DEL:'/admin/delete/',
        };
    /**
     * 实例化一个分页控制者
     */
    var pageController = new PageController({

        url:oURL.PRONAME+oURL.GETLIST,

        view:{
            container : $('#content')[0],
            tpl:'dict',
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


    /**
     * 查询功能
     * 点击了就序列化表单
     * 更改视图控制器的other属性
     * 初始化页面
     */
    $.get(oURL.PRONAME+oURL.GETLIST+'?pid=0&pageSize=1000&pageNum=1',function (res) {  //渲染所有的栏目
        if(res.list){

            viewCommand({
                command:'display',
                param:[$('select')[0],res.list,'id_name']
            });

            pageController.other = '&pid='+$('select')[0].value;

            pageController.init();
        }
    });



    $('select')[0].onchange = function () {

        pageController.other = '&pid='+this.value;

        pageController.init();

    }

    /**
     * 提交删除的id值
     1、删除成功后，初始化视图
     */
    $('#content').on('click',"[data-id*='del']",function(){
        if(confirm('溯源提示:\n\n若删除次栏目，跟随的子栏目都会被删除')){
            var id = $(this).attr('data-id').substr(3);
            console.log(id);
            new Image().src = oURL.PRONAME+oURL.DEL+id;
            pageController.init();
        }
    });
})();