/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 17:42:59 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-21 13:57:30
 */

 (function(){


    /**
     * url 对象
     */
    const oURL = {
        PRONAME : '/waterfowl' ,
        POST : '/outpoultry/add',//最终数据提交路径
        GETTYPE : '/getDicName/getBreedingType',//获取禽舍类型
        GETPATCH : '/outstorage/show',//?s = 获取出厂批次
    }

    var cache = {
        outstorageData :'',
    }

    /**
     * 列出家禽种类
     */
    $.get(oURL.PRONAME+oURL.GETTYPE,function(res){
        if(res){
            viewCommand({
                command:'display',
                param:[$('#type')[0],res,'option']
            });
        }else{
            alert('获取家禽种类失败');
        }
    });

     /**
      * 列出出库编号
      */
      $.get(oURL.PRONAME+oURL.GETPATCH,function(res){
            if(res){
                viewCommand({
                    command:'display',
                    param:[$('#id_patch')[0],res.list,'outStorage']
                });

                /**
                 * 显示第一条的数量先
                 */

                $('#quantity').val(res.list[0].quantity);

                /**
                 *缓存批次信息
                 */
                cache.outstorageData = res.list;
            }else{
                alert('获取批次编号失败');
            }
        });

    $('#id_patch').change(function () {
        var value = $(this).val();
        var quantity = cache.outstorageData.forEach(function (val) {
            if (val.idOutstorage == value) {
                return val.quantity;
            }
        });
        $('#quantity').val(quantity);
    });

    /** 
     * 提交表单
     */
    $('#submit')[0].onclick = function(){

        var json = JSON.stringify(queryParse.call($('form')));
            $.post(oURL.PRONAME+oURL.POST,json,function(res){
                if(res.status){
                    alert(res.msg);
                }else{
                    alert('增加出库信息失败');
                }
            });
    }
    
 })();