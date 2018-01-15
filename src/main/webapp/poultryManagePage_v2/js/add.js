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
        POST : '/poultry/add',//最终数据提交路径
        GETTYPE:'/dict/list?pid=60000',//养殖类型 pid=60000
        GETEMP:'/admin/user/list',//查找人元

    }

     /**
      *养殖类型
      */
     $.get(oURL.PRONAME+oURL.GETTYPE,function(res){
         if(res){
             viewCommand({
                 command:'display',
                 param:[$('#type')[0],res,'option']
             });
         }else{
             alert('获取养殖类型失败');
         }
     });

     /**
      *查找人员
      */
     $.get(oURL.PRONAME+oURL.GETEMP,function(res){
         if(res){
             viewCommand({
                 command:'display',
                 param:[$('#idCharge')[0],res.list,'option']
             });
             viewCommand({
                 command:'display',
                 param:[$('#idRecorder')[0],res.list,'option']
             });
         }else{
             alert('查找人员失败');
         }
     });

    /** 
     * 提交表单
     */
    $('#submit')[0].onclick = function(){
        if(confirm('溯源提示：\n数据一旦提交无法修改')){
            var json = JSON.stringify(queryParse.call($('form')));
            $.post(oURL.PRONAME+oURL.POST,json,function(res){
                if(res.status){
                    alert('提交成功');
                }else{
                    alert('提交失败');
                }
            });
        }
    }
 })();