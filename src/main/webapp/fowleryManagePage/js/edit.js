$(function () {
    $('#btn').click(function () {
        var dateEstablish=$('#dateEstablish').val();
        var type=$('#type').val();
        var idRecorder=$('#idRecorder').val();
        var idCharge=$('#idCharge').val();
        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "",
            /*data发送至服务器的key/value数据*/
            data: {
                "dateEstablish":dateEstablish,"type":type,"idRecorder":idRecorder," idCharge": idCharge
            },
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