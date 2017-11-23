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
            GETAQUACULTURELIST:'/aquaculture/list?pageNum=1&pageSize=10',
        };
    
        /**
         * 渲染禽舍列表视图
         * 1、初始化视图
         */
        var initView = function(){
    
            $.get(oURL.PRONAME+oURL.GETAQUACULTURELIST,function(res){
                if(res.list.length>=1){
                   var data = new DataFilter({
                        type:'filterTimeAndNull',
                        data:res.list
                   });
                    viewCommand({
                        command:'display',
                        param:[$('#content')[0],data,'find_edit_aquaculture']
                    });
                }else{
                    alert('获取禽舍信息失败');
                }
             });
        }
        initView();
          
})(this);