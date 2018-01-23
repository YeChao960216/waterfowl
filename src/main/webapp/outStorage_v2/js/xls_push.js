/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 17:42:59 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-22 20:44:37
 */

 (function(){

    /**
     * url 对象
     */
    const oURL = {
        PRONAME : '/waterfowl' ,
        POST : '/outstorage/excel/push',//最终数据提交路径
    }

    /** 
     * 提交表单
     */
    $('#submit')[0].onclick = function(){
        $.get(oURL.PRONAME+oURL.POST,function (res) {
           if(res){
               alert('溯源提示:\n\n'+res.msg);
           }
        });
    }
    
 })();