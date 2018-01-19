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
        POST : '/admin/affiliation/editAffiliation/',//最终数据提交路径
        GETEMP:'/admin/user/list',//查找人元,
        GETPOSITION:'/dict/list?pid=70000', //方位
        GETGUIMO:'/dict/list?pid=60000',   //大小规模
        ID:getRequest()['id'],//需要被修改的ID
        GETINFOBYID:'/admin/affiliation/showAffiliation/'  //findById
    }



    /**
     * 方位、规模
     */
    $.get(oURL.PRONAME+oURL.GETPOSITION,function(res){
        if(res){
            viewCommand({
                command:'display',
                param:[$('select')[0],res.list,'id_name']
            });
        }else{
            alert('溯源提示:\n\n获取方位信息失败');
        }
    });
    $.get(oURL.PRONAME+oURL.GETGUIMO,function(res){
        if(res){
            viewCommand({
                command:'display',
                param:[$('select')[1],res.list,'id_name']
            });
        }else{
            alert('溯源提示:\n\n获取规模信息失败');
        }
    });


    /**
     * 人员信息
     */
    $.get(oURL.PRONAME+oURL.GETEMP,function(res){      //人员信息
        if(res){
            viewCommand({
                command:'display',
                param:[$('select')[3],res.list,'id_name']
            });
            viewCommand({
                command:'display',
                param:[$('select')[4],res.list,'id_name']
            });
        }else{
            alert('溯源提示:\n\n获取人员信息失败');
        }
    });

    /**
     * 获取对应信息
     */
    $.get(oURL.PRONAME+oURL.GETINFOBYID+oURL.ID,function (res) {
       if(res){
           var data = res;
           $('#id')[0].innerText = data.id;
           $('#type')[0].value = data.type;
           $('#position')[0].value = data.position;
           $('#size')[0].value = data.size;
           $('#status').val(data.status);
           $('#idRecord').val(data.idRecord);
           $('#idCharge').val(data.idCharge);
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