//alert($);
$(function () {
    $('#btn').click(function () {
        var inventoryId=$('#inventoryId').val();
        var fowleryId=$('#fowleryId').val();
        var recordDate=$('#recordDate').val();
        var numTotal=$('#numTotal').val();
        var feedWeight=$('#feedWeight').val();
        var feedType=$('#feedType').val();
        var idBatch=$('#idBatch').val();
        var idRecorder=$('#idRecorder').val();
        var idCharge=$('#idCharge').val();
        var remark=$('#remark').val();
        var riceWeight=$('#riceWeight');
        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "",
            /*data发送至服务器的key/value数据*/
            data: {
                "inventoryId":inventoryId,"fowleryId":fowleryId,"idRecorder":idRecorder," idCharge": idCharge,"remark":remark,"recordDate":recordDate,
                "numTotal":numTotal,"feedType":feedType,"feedWeight":feedWeight,"riceWeight":riceWeight,"idBatch":idBatch},
            /*客户端请求的类型*/
            type: "post",
            dataType: "json",
            /*请求完成时的回调函数*/
            success: function (msg) {
                if (msg=='1'){
                    alert("您好,新增禽舍成功！！！");
                }else{
                    alert("抱歉，新增禽舍失败！！！");
                }
            }
        })

    })
})