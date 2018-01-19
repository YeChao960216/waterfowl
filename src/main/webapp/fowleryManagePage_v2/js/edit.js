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
        POST : '/admin/fowlery/editFowlery/',//最终数据提交路径
        GETSIZE:'/dict/list?pid=60000', //获取禽舍规格
        GETENTITY:'/admin/affiliation/showAffiliation/', //id=1
        GETBHOME:'/admin/affiliation/listAffiliation',
        GETEMP:'/admin/user/list' //人员
    }

    var selectNodes = document.getElementsByTagName('select');
    /**
     * 获取禽舍规格
     */
    $.get(oURL.PRONAME+oURL.GETSIZE,function(res){
        if(res.list){
            viewCommand({
                command:'display',
                param:[$('#size')[0],res.list,'id_name']
            })
        }else{
            alert('获取禽舍养殖标识失败');
        }
    });

    /**
     * 获取禽舍规格
     */
    $.get(oURL.PRONAME+oURL.GETBHOME,function(res){
        if(res){
            viewCommand({
                command:'display',
                param:[$('#bHome')[0],res.list,'id']
            })
        }else{
            alert('获取大禽舍编号失败');
        }
    });

    $.get(oURL.PRONAME+oURL.GETEMP,function(res){        //人员
        if(res){
            viewCommand({
                command:'display',
                param:[selectNodes[3],res.list,'id_name']
            });
            viewCommand({
                command:'display',
                param:[selectNodes[4],res.list,'id_name']
            });
        }else{
            alert('获取人员信息失败');
        }
    });

    /**
     * 提交表单
     */
    $('#submit')[0].onclick = function(){
        // var json = JSON.stringify(queryParse.call($('form')));
        var json = queryParse.call($('form'));
        var id = getRequest()['id'];
        $.post(oURL.PRONAME+oURL.POST+id,json,function(res){
            if(res.status){
                alert(res.msg);
            }else{
                alert('增加禽舍信息失败');
            }
        });
    }


})();