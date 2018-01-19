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
        POST : '/admin/new',//最终数据提交路径
        GETDICT:'/dict/list?pid=0&pageSize=10000',//字典
    }

    $.get(oURL.PRONAME+oURL.GETDICT,function (res) {
       if(res){
            viewCommand({
                command:'display',
                param:[$('select')[0],res.list,'id_name']
            });
       }else{
           alert('溯源提示:\n\n'+res.msg);
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
                alert('溯源提示:\n\n'+res.msg);
            }
        });
    }

})();