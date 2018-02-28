/*
 * @Author: 伟龙-Willon qq:1061258787
 * @Date: 2017-11-19 17:42:59
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-28 14:14:27
 */

(function(){

    /**
     * url 对象
     */
    const oURL = {
        PRONAME : '/waterfowl' ,
        POST : '/manufacture/add',//最终数据提交路径
        GETMANUMETHOD:'/dict/list?pid=15000',//获取加工方式
        GETPATCHS:'/outpoultry/list',//获取可以加工的批次号
        GETEMP:'/admin/user/list',//查找人元,
        GETPATCHINFOBYID:'/',//通过批次号找到的批次数量
        
    }

    var selectNodes = $('select');

    var mapper = new Map(); //存放批次与数量的关系

    var nav = getRequest();//获取路由信息
    console.log(nav);
    if(!nav.idPatch){  //路由信息，没有我就自己加载必要信息
        /**
         * 获取批次号
         */
        $.get(oURL.PRONAME+oURL.GETPATCHS,function(res){
            if(res){
                viewCommand({
                    command:'display',
                    param:[selectNodes[0],res.list,'idPatch']
                });
                res.list.forEach(function (ele) {
                    mapper.set(ele.idPatch,ele.quantity);
                });

                $('#quantity').val(res.list[0].quantity);
                $('#quantity-none').val(res.list[0].quantity);
            }else{
                alert('获取批次号失败');
            }
        });

        /**
         * 批次号的改变->更新加工数量
         */
        selectNodes[0].onchange = function () {
            $('#quantity').val(mapper.get(this.value));
            $('#quantity-none').val(mapper.get(this.value));
        }
    }else{

        /**
         *填充路由信息
         */
        $('#idPatch').html("<option value="+nav.idPatch+">"+nav.idPatch+"</option>");
        $('#quantity').val(nav.quantity);
        $('#quantity-none').val(nav.quantity);
        $('#firm').val(nav.firmId);
        $('#site').val(nav.firmName);
    }


    /**
     * 获取加工方式
     */
    $.get(oURL.PRONAME+oURL.GETMANUMETHOD,function(res){
        if(res){
            viewCommand({
                command:'display',
                param:[selectNodes[1],res.list,'id_name']
            });
        }else{
            alert('获取加工方式失败');
        }
    });

    /**
     * 获取人员信息
     */
    $.get(oURL.PRONAME+oURL.GETEMP,function(res){
        if(res){

            viewCommand({
                command:'display',
                param:[selectNodes[2],res.list,'id_name']
            });
        }else{
            alert('人员获取失败');
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