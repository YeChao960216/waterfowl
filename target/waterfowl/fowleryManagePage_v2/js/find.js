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
            GETAQUACULTURELIST:'/admin/fowlery/listFowlery',
            DEL:'/admin/fowlery/deleteFowlery/',//{{id}}
            GETALLAFFI:'/admin/affiliation/listAffiliation?pageSize=1000&pageNum=1'
        };
    /**
     * 实例化一个分页控制者
     */
    var pageController = new PageController({

        url:oURL.PRONAME+oURL.GETAQUACULTURELIST,

        view:{
            container : $('#content')[0],
            tpl:'fowlery_find',
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
     * 罗列出所有的大禽舍编号
     */
    $.get(oURL.PRONAME+oURL.GETALLAFFI,function (res) {
        if(res.list){
            viewCommand({
                command:'display',
                param:[$('select')[0],res.list,'option']
            });

            pageController.other = '&affiliation='+$('select')[0].value;
            pageController.init();
        }
    });

    $('select')[0].onchange = function () {
        pageController.other = '&affiliation='+this.value;
        pageController.init();
    }

    /**
     * 新增页面
     */
    $('#new ').click(function () {
       window.location.href = './add.html'
    });

    /**
     * 提交删除的id值
     1、删除成功后，初始化视图
     */
    $('#content').on('click','[data-id*="del"]',function () {
        var id = $(this).attr('data-id').substr(3);
        if(confirm('溯源提示:\n\n确认删除该信息吗？')){
            pageController.init();
            var pointer = new Image();//利用图片信标发送请求
            pointer.src = oURL.PRONAME+oURL.DEL+id;
        }
    });
})();