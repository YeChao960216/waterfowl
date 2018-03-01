/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 17:42:59 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-31 22:02:19
 */

 (function(){

    /**
     * url 对象
     */
    const oURL = {
        PRONAME : '/waterfowl' ,
        POST : '/germchit/save ',//最终数据提交路径
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
      *查找人员
      */
     $.get(oURL.PRONAME+oURL.GETEMP,function(res){
         if(res){
             viewCommand({
                 command:'display',
                 param:[$('#idCharge')[0],res.list,'id_name']
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
            if(json.numTotal){
                if(confirm('溯源提示：\n\n数据一旦提交无法修改')){
                    $.post(oURL.PRONAME+oURL.POST,json,function(res){
                        if(res.status){
                            window.location.href = './poultry_add.html?idGermchit='+res.key+'&numTotal='+json.numTotal+'&firm='+json.incubationPlant+'&idCharge='+json.idCharge
                        }else{
                            alert('溯源提示：\n\n提交失败');
                        }
                    });
                }
            }else{
                alert('溯源提示：\n\n进货数量为必填项');
            }
            
    }
 })();