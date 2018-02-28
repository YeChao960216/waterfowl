(function(global){

    /**
     * url 对象
     */
    const oURL = {
        PRONAME : '/waterfowl' ,
        POST : '/outstorage/edit/',//最终数据提交路径
        GETTYPE:'/dict/list?pid=65000',//货物类型
        GETUNIT:'/dict/list?pid=20000',//货物类型
        GETEMP:'/admin/user/list',//查找人元,
        GETINFOBYID:'/outstorage/list?idOutstorage=',
        ID:getRequest()['id'],//传递过来的ID
    }

    $.get(oURL.PRONAME+oURL.GETTYPE,function (res) {  //物质的类型
        if(res){
            viewCommand({
                command:'display',
                param:[$('select')[0],res.list,'id_name']
            });
        }
    });

    $.get(oURL.PRONAME+oURL.GETUNIT,function (res) {  //单位
        if(res){
            viewCommand({
                command:'display',
                param:[$('select')[1],res.list,'id_name']
            });
        }
    });

    $.get(oURL.PRONAME+oURL.GETEMP,function(res){        //人员
        if(res){
            viewCommand({
                command:'display',
                param:[$('select')[2],res.list,'id_name']
            });
        }else{
            alert('溯源提示:\n\n获取人员信息失败');
        }
    });

    /**
     * 获取id对应的信息
     */
    $.get(oURL.PRONAME+oURL.GETINFOBYID+oURL.ID,function (res) {
        if(res.list){
            var $selectNodes = $('select'),data = res.list[0];
                $selectNodes[0].value = data.type;
                $selectNodes[1].value = data.unit;
                $selectNodes[2].value = data.idRecorder;
                $selectNodes[3].value = data.idCharge;
                $('#remark').val(data.remark);
                $('#phone').val(data.phone);
                $('#firm').val(data.firm);
                $('#name').val(data.name);
                $('#rest').val(data.rest);
                $('#quantity').val(data.quantity);

        }else{
            alert('溯源提示:\n\n获取该批物料信息失败');
        }
    })
    /**
     * 提交表单
     */
    $('#submit')[0].onclick = function(){
        var json = queryParse.call($('form'));
        $.post(oURL.PRONAME+oURL.POST+oURL.ID,json,function(res){
            if(res.status){
                alert('溯源提示:\n\n'+res.msg);
            }else{
                alert('溯源提示:\n\n增加物质信息失败');
            }
        });
    }

})(this);

    



   
