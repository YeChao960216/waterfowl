/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 20:06:12 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-21 14:10:13
 */

(function(){
    
        /**
         * oURL 对象
         */
        const oURL = {
            PRONAME:'/waterfowl',
            GETOUTPOULTRYLIST:'/outpoultry/list?pageSize=10&pageNum=1',
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
                            param:[$('#content')[0],res.list,'find_out_poultry']
                        });
                    }
                }else{
                    alert('获取出库信息失败');
                }
             });
        }
        initView();
          
})();