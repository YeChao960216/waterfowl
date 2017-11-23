/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 17:42:59 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-21 13:57:30
 */

 (function(global){

    var document = global.document;
    /**
     * url 对象
     */
    const oURL = {
        PRONAME : '/waterfowl' ,
        POST : '/outpoultry/add',//最终数据提交路径
        GETNAME : '/outpoultry/list',//获取禽舍类型
        GETPATCH : '/outpoultry/list',//?s = 获取出厂批次

    }

    /**
     * 列出家禽种类
     */
    $.get(oURL.PRONAME+oURL.GETNAME,function(res){
        if(res.status){
            viewCommand({
                command:'display',
                param:[$('type')[0],res.list,'option']
            });
        }else{
            alert('获取家禽种类失败');
        }
    });

     /**
      * 列出出库编号
      */
      $.get(oURL.PRONAME+oURL.GETPATCH,function(res){
        if(res.status){
            viewCommand({
                command:'display',
                param:[$('id_patch')[0],res.list,'option']
            });
        }else{
            alert('获取批次编号');
        }
    });


    /** 
     * 提交表单
     */
    document.getElementById('#submit').onclick = function(){

        var json = JSON.stringify(queryParse.call($('form')));
            $.post(oURL.PRONAME+oURL.POST,json,function(res){
                if(res.status){
                    alert(res.msg);
                }else{
                    alert('增加禽舍信息失败');
                }
            });
    }
    
 })(this);