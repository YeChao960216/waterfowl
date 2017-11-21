(function(global){

    var document = global.document;
    /**
     * url对象
     */
    const oURL = {
        PRONAME:'/waterfowl',
        ID : getRequest()['id'],
        GETINFOBYID:'/outpoultry/show',
        GETNAME : '/outpoultry/list',//获取禽舍类型
        GETPATCH : '/outpoultry/list',//?s = 获取出厂批次
        EDIT:'/outpoultry/edit'
    };

    
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
     * 先填充数据
     */
    /**
     *呈现该禽舍详细信息
     */
    $.get(oURL.PRONAME+oURL.GETINFOBYID+oURL.ID,function (res) {
        if(res){
            /**
             * 数据适配
             */
            // data = new DataFilter({
            //     data:[data],
            //     type:'userInfo'
            // })[0];
            
            var data = res.data;
            $('#type')[0].innerHTML = data.type;
            $('#id_patch')[0].innerHTML = data.id_patch;
            $('#quantity')[0].innerHTML = data.quantity;
            $('#unit')[0].innerHTML = data.unit;
            $('#firm')[0].innerHTML = data.firm;
            $('#phone')[0].innerHTML = data.phone;
            $('#id_recorde')[0].innerHTML = data.id_recorde;
            $('#id_charge')[0].innerHTML = data.id_charge;
            $('#remark')[0].value = data.remark;
            
        }else{
            console.error('获取出库详细信息失败');
        }
    })

    /**
     * 提交修改
     */
    document.getElementById('#submit').onclick = function(){
        var json = JSON.stringify(queryParse.call($('form')));
            $.post(oURL.PRONAME+oURL.EDIT,json,function(res){
                if(res.status){

                }else{
                    alert('增加禽舍信息失败');
                }
            });
    }

})(this);

    



   
