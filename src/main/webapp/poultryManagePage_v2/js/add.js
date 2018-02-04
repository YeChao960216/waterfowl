/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 17:42:59 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-31 22:01:52
 */

 (function(){

    /**
     * url 对象
     */
    const oURL = {
        PRONAME : '/waterfowl' ,
        POST : '/poultry/add',//最终数据提交路径
        GETTYPE:'/dict/list?pid=80000',//养殖类型 pid=80000
    }

    /**
     * 接收路由字段
     */
    var nav = getRequest();

    $('#firm').val(nav.firm);
    $('#numTotal').val(nav.numTotal);

     /**
      *养殖类型
      */
     $.get(oURL.PRONAME+oURL.GETTYPE,function(res){
         if(res.list){
             viewCommand({
                 command:'display',
                 param:[$('#type')[0],res.list,'id_name']
             });
         }else{
             alert('获取养殖类型失败');
         }
     });

     /**
      *查找人员
      */
     $.get(oURL.PRONAME+oURL.GETEMP,function(res){
         if(res){
             viewCommand({
                 command:'display',
                 param:[$('#idRecorder')[0],res.list,'id_name']
             });
         }else{
             alert('查找人员失败');
         }
     });

    /** 
     * 提交表单
     */
    $('#submit')[0].onclick = function(){
            var json = queryParse.call($('form'));
                json.associatedFirm = nav.firm;
                json.quantity = nav.numTotal;
                json.idGermchit = nav.idGermchit;
                json.idCharge = nav.idCharge;
            if(/^1[3-9]\d{9}$/.test(json.phone)){
                if(confirm('溯源提示：\n\n数据一旦提交无法修改')){
                    $.post(oURL.PRONAME+oURL.POST,json,function(res){
                        if(res.status){
                            alert('溯源提示：\n\n'+res.msg);
                        }else{
                            alert('溯源提示：\n\n'+res.msg);
                        }
                    });
                }
            }else{
                alert('溯源提示：\n\n您输入手机号不合法');
            }

    }
 })();