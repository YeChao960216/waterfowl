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
        POST : '/aquaculture/add',//最终数据提交路径
        GETOURSTRORAGE : '/outstorage/show',// 获取出库编号
        GETSTATUSLIST:'/getDicName/getStatus',//获取禽类养殖标识
        GETPATCH:'/admin/patch/getNewPatch', //获取批次号
    }

    $('#id_fowlery')[0].onkeyup = function () {
        if($(this).val().length>4){
            /**
             * 列出批次号
             */
            $.get(oURL.PRONAME+oURL.GETPATCH,function(res){
                if(res){
                    viewCommand({
                        command:'display',
                        param:[$('#id_patch')[0],res,'option']
                    })
                }else{
                    alert('获取批次号失败');
                }
            });
        }
    }

     /**
      * 列出出库编号
      */
      $.get(oURL.PRONAME+oURL.GETOURSTRORAGE,function(res){
        if(res){

            viewCommand({
                command:'display',
                param:[$('#id_outstorage')[0],res.list,'outStorage']
            })
        }else{
            alert('获取出库编号');
        }
    });

    /**
     * 列出禽类养殖标识
     */
    $.get(oURL.PRONAME+oURL.GETSTATUSLIST,function(res){
        if(res){

            viewCommand({
                command:'display',
                param:[$('#status')[0],res,'option']
            })
        }else{
            alert('获取禽舍养殖标识失败');
        }
    });

    /** 
     * 提交表单
     */
    $('#submit')[0].onclick = function(){
        var json = JSON.stringify(queryParse.call($('form')));
            $.post(oURL.PRONAME+oURL.POST,json,function(res){
                if(res.status){
                    alert('提交成功');
                }else{
                    alert('增加禽舍信息失败');
                }
            });
    }
    
 })();