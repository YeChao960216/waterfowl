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
        GETTYPE:'/dict/list?pid=80000',//养殖类型 pid=80000
        GETEMP:'/admin/user/list',//查找人元
        GETFIRM:'/dict/list?pid=75000',//查找供货厂商
    }

     /**
      *查找供货厂商
      */
     $.get(oURL.PRONAME+oURL.GETFIRM,function(res){
         if(res.list){
             viewCommand({
                 command:'display',
                 param:[$('#associatedFirm')[0],res.list,'id_name']
             });
         }else{
             alert('查找供货厂商失败');
         }
     });

     /**
      *养殖类型
      */
     $.get(oURL.PRONAME+oURL.GETTYPE,function(res){
         if(res.list){
             viewCommand({
                 command:'display',
                 param:[$('#type')[0],res.list,'id_name']
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
                 param:[$('#idCharge')[0],res.list,'id_name']
             });
             viewCommand({
                 command:'display',
                 param:[$('#idRecorder')[0],res.list,'id_name']
             });
         }else{
             alert('查找人员失败');
         }
     });

    /** 
     * 提交表单
     */
    $('#submit')[0].onclick = function(){
            var json = queryParse.call($('form'));
            if(/^[1-9]\d{0,6}$/.test(json.quantity) && /^1[3-9]\d{9}$/.test(json.phone)){
                if(confirm('溯源提示：\n\n数据一旦提交无法修改')){
                    $.post(oURL.PRONAME+oURL.POST,json,function(res){
                        if(res.status){
                            alert('提交成功');
                        }else{
                            alert('提交失败');
                        }
                    });
                }
            }else{
                alert('溯源提示：\n\n您输入的数据不合法');
            }

    }
 })();