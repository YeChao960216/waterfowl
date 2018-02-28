/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 19:47:25 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-19 20:01:54
 */

 (function(global){

    /**
     * oURL 对象
     */
    const oURL = {
        PRONAME:'/waterfowl',
        GETAQUACULTURELIST:'/admin/fowlery/listFowlery',
        DEL:'/admin/fowlery/deleteFowlery/',//{{id}}
    };

     /**
      * 实例化一个分页控制者
      */
     var pageController = new PageController({

         url:oURL.PRONAME+oURL.GETAQUACULTURELIST,

         view:{
             container : $('#content')[0],
             tpl:'fowlery_del',
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
      * 提交删除的id值
        1、删除成功后，初始化视图
      */
      $('#content').on('click',"[data-id*='del']",function(){
          var id = $(this).attr('data-id').substr(3);
         $.get(oURL.PRONAME+oURL.DEL+id,function(res){
            if(res){
                pageController.init();
            }else{
                alert('删除对象条目失败');
            }
         });
      });
      
 })(this);