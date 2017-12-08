/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 19:47:25 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-21 14:07:32
 */

 (function(global){

    /**
     * oURL 对象
     */
    const oURL = {
        PRONAME:'/waterfowl',
        GETOUTPOULTRYLIST:'/outpoultry/list?pageSize=10&pageNum=1',
        DEL:'/outpoultry/delete/',
    };

    /**
     * 渲染禽舍列表视图
     * 1、初始化视图
     */
    var initView = function(){

        $.get(oURL.PRONAME+oURL.GETOUTPOULTRYLIST,function(res){
            if(res){
                if(res.list.length){
                    viewCommand({
                        command:'display',
                        param:[$('#content')[0],res.list,'del_out_poultry']
                    });
                }
            }else{
                alert('获取出库信息失败');
            }
         });
    }
    initView();
    
     /**
      * 提交删除的id值
        1、删除成功后，初始化视图
      */
      $('#content').on('click',"[data-id*='del']",function(){
         var id = $(this).attr('data-id').substr(3);
         $.get(oURL.PRONAME+oURL.DEL+id,function(res){
            if(res.status){
                initView();
            }else{
                alert('删除条目失败');
            }
         });
      });
      
 })(this);