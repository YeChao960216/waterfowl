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
        POST : '/ddl/edit',//最终数据提交路径
        ID:getRequest()['id'],//ID
        GETEMP:'/admin/user/list',//查找人元,
        GETGEIYAO:'/dict/list?pid=95000',//处理方式
        GETINFOBYPID:"/ddl/show/"+getRequest()['id'], //获取对应信息
    }


    /**
     * 处理方式
     */
    $.get(oURL.PRONAME+oURL.GETGEIYAO,function (res) {
       if(res.list){
           viewCommand({
               command:'display',
               param:[$('select')[0],res.list,'id_name']
           });
       }else{
            alert('溯源提示:\n\n获取处理方式失败');
       }
    });

    /**
     * 人员信息
     */
    $.get(oURL.PRONAME+oURL.GETEMP,function(res){      //人员信息
        if(res){
            viewCommand({
                command:'display',
                param:[$('select')[1],res.list,'id_name']
            });
            viewCommand({
                command:'display',
                param:[$('select')[2],res.list,'id_name']
            });
        }else{
            alert('溯源提示:\n\n获取人员信息失败');
        }
    });

    /**
     * 获取对应信息
     */
    $.get(oURL.PRONAME+oURL.GETINFOBYPID,function (res) {
       if(res){
           var data = res;
           $('#idPatch')[0].innerText = data.idPatch;//呈现操作的批次号
           $('select')[0].value = data.processingMode;
           $('select')[1].value = data.idRecorder;
           $('select')[2].value = data.idCharge;
           $('#numProcessed').val(data.numProcessed);
           $('#remark').val(data.remark);
       }else{
           alert('溯源提示:\n\n获取该批次号对应信息失败');
       }
    });
    /**
     * 提交表单
     */
    $('#submit')[0].onclick = function(){
        var json = queryParse.call($('form'));
        $.post(oURL.PRONAME+oURL.POST+oURL.ID,json,function(res){
            if(res.status){
                alert('溯源提示:\n\n'+res.msg);
            }else{
                alert('溯源提示:\n\n'+res.msg);
            }
        });
    }

})();