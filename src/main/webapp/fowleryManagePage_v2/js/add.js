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
        POST : '/admin/fowlery/newFowlery',//最终数据提交路径
        GETSIZE:'/dict/list?pid=80000', //获取禽舍规格
        GETENTITY:'/admin/affiliation/showAffiliation/'//id=1
    }

    /**
      * 获取禽舍规格
      */
     $.get(oURL.PRONAME+oURL.GETSIZE,function(res){
         if(res){
             viewCommand({
                 command:'display',
                 param:[$('#size')[0],res,'option']
             })
         }else{
             alert('获取禽舍养殖标识失败');
         }
     });

     /**
      * 根据键值返回相应的实体id
      */
        $('#affiliation').keyup(function () {
            var self = this;
            $.get(oURL.PRONAME+oURL.GETENTITY+self.value,function(res){
                if(res){
                    console.log(res);
                }else{
                    alert('获取禽舍养殖标识失败');
                }
            });
        });

    /** 
     * 提交表单
     */
    $('#submit')[0].onclick = function(){
        var json = JSON.stringify(queryParse.call($('form')));
        // var json = queryParse.call($('form'));
            $.post(oURL.PRONAME+oURL.POST,json,function(res){
                if(res.status){
                    alert('提交成功');
                }else{
                    alert('增加禽舍信息失败');
                }
                console.log(res);
            });
    }


    
 })();