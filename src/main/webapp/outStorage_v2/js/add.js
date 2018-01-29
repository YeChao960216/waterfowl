/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 17:42:59 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-19 20:39:18
 */

 (function(){

    /**
     * url 对象
     */
    const oURL = {
        PRONAME : '/waterfowl' ,
        POST : '/outstorage/add',//最终数据提交路径
        GETTYPE:'/dict/list?pid=65000',//货物类型
        GETUNIT:'/dict/list?pid=20000',//货物类型
        GETEMP:'/admin/user/list',//查找人元,
    }

     $.get(oURL.PRONAME+oURL.GETTYPE,function (res) {  //物质的类型
            if(res){
                viewCommand({
                    command:'display',
                    param:[$('select')[0],res.list,'id_name']
                });
            }
     });

     $.get(oURL.PRONAME+oURL.GETUNIT,function (res) {  //单位
         if(res){
             viewCommand({
                 command:'display',
                 param:[$('select')[1],res.list,'id_name']
             });
         }
     });

     $.get(oURL.PRONAME+oURL.GETEMP,function(res){        //人员
         if(res){

             viewCommand({
                 command:'display',
                 param:[$('select')[2],res.list,'id_name']
             });
         }else{
             alert('溯源提示:\n\n获取人员信息失败');
         }
     });

    /** 
     * 提交表单
     */
    $('#submit')[0].onclick = function(){
        var json = queryParse.call($('form'));
            $.post(oURL.PRONAME+oURL.POST,json,function(res){
                if(res.status){
                    alert('溯源提示:\n\n'+res.msg);
                }else{
                    alert('溯源提示:\n\n增加物质信息失败');
                }
            });
    }
    
 })();