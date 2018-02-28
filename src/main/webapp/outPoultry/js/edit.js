(function(){

    /**
     * url对象
     */
    const oURL = {
        PRONAME:'/waterfowl',
        ID : getRequest()['id'],
        GETINFOBYID:'/outpoultry/show/',
        GETTYPE : '/getDicName/getBreedingType',//获取家禽种类
        GETPATCH : '/outpoultry/list',//?s = 获取出厂批次
        EDIT:'/outpoultry/edit'
    };

    
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
      * 列出出厂批次
      */
      $.get(oURL.PRONAME+oURL.GETPATCH,function(res){

        if(res){
            var patchList = [];
            res.list.forEach(function (val) {
                patchList.push({'idPatch':val.idPatch});
            });

            viewCommand({
                command:'display',
                param:[$('#id_patch')[0],patchList,'outPatch']
            });

        }else{
            alert('获取批次编号失败');
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
            $('#type')[0].value = data.type;
            $('#id_patch')[0].value = data.idPatch;
            $('#quantity')[0].value = data.quantity;
            $('#unit')[0].value = data.unit;
            $('#firm')[0].value = data.firm;
            $('#phone')[0].value = data.phone;
            $('#id_recorde')[0].value = data.idRecorde;
            $('#id_charge')[0].value = data.idCharge;
            $('#remark')[0].value = data.remark;
            
        }else{
            console.error('获取出库详细信息失败');
        }
    })

    /**
     * 提交修改
     */
    $('#submit')[0].onclick = function(){
        var json = JSON.stringify(queryParse.call($('form')));
            $.post(oURL.PRONAME+oURL.EDIT,json,function(res){
                if(res.status){

                }else{
                    alert('增加禽舍信息失败');
                }
            });
    }

})();

    



   
