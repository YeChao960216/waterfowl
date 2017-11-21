(function(global){

    var document = global.document;
    /**
     * url对象
     */
    const oURL = {
        PRONAME:'/waterfowl',
        ID : getRequest()['id'],
        GETAQUACULTUREDETAILINFO:'/aquaculture/show/',
        EDIT:'/aquaculture/edit',
        GETNAME : '/aquaculture/getName',//获取禽舍类型
        GETOURSTRORAGE : '/aquaculture/getOutStorage',//?s = 获取出库编号
        GETSTATUSLIST:'/aquaculture/getStatusList',//获取禽类养殖标识
        EDIT:'/aquaculture/edit'
    };

    
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
     * 先填充数据
     */
    /**
     *呈现该禽舍详细信息
     */
    $.get(oURL.PRONAME+oURL.GETAQUACULTUREDETAILINFO+oURL.ID,function (res) {
        if(res){
            /**
             * 数据适配
             */
            // data = new DataFilter({
            //     data:[data],
            //     type:'userInfo'
            // })[0];
            
            var data = res.data;
            $('#name')[0].value = data.name;
            $('#id_fowlery')[0].value = data.id_fowlery;
            $('#id_patch')[0].value = data.id_patch;
            $('#num_total')[0].value = data.num_total;
            $('#feed_type')[0].value = data.feed_type;
            $('#feed_weight')[0].value = data.feed_weight;
            $('#record_date')[0].value = data.record_date;
            $('#id_recorder')[0].value = data.id_recorder;
            $('#id_charge')[0].value = data.id_charge;
            $('#id_outstorage')[0].value = data.id_outstorage;
            $('#status')[0].value = data.status;
            $('#remark')[0].value = data.remark;
            
        }else{
            console.error('获取禽舍详细信息失败');
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

})(this);

    



   
