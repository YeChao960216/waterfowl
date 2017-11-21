/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 17:42:59 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-19 20:39:18
 */

 (function(global){

    var document = global.document;
    /**
     * url 对象
     */
    const oURL = {
        PRONAME : '/waterfowl' ,
        POST : '/admin/aquaculture/add',//最终数据提交路径
        GETNAME : '/aquaculture/getName',//获取禽舍类型
        GETOURSTRORAGE : '/aquaculture/getOutStorage',//?s = 获取出库编号
        GETSTATUSLIST:'/aquaculture/getStatusList'//获取禽类养殖标识
        
    }

    /**
     * 列出禽舍类型
     */
    $.get(oURL.PRONAME+oURL.GETNAME,function(res){
        if(res.status){
            viewCommand({
                command:'display',
                param:[$('name')[0],res.list,'option']
            })
        }else{
            alert('获取禽舍类型失败');
        }
    });

     /**
      * 列出出库编号
      */
      $.get(oURL.PRONAME+oURL.GETNAME,function(res){
        if(res.status){
            viewCommand({
                command:'display',
                param:[$('id_outstorage')[0],res.list,'option']
            })
        }else{
            alert('获取出库编号');
        }
    });

    /**
     * 列出禽类养殖标识
     */
    $.get(oURL.PRONAME+oURL.GETSTATUSLIST,function(res){
        if(res.status){
            viewCommand({
                command:'display',
                param:[$('id_outstorage')[0],res.list,'option']
            })
        }else{
            alert('获取禽舍养殖标识失败');
        }
    });

    /** 
     * 提交表单
     */
    document.getElementById('#submit').onclick = function(){

        var json = JSON.stringify(queryParse.call($('form')));
            $.post(oURL.PRONAME+oURL.POST,json,function(res){
                if(res.status){

                }else{
                    alert('增加禽舍信息失败');
                }
            });
    }
    
 })(this);