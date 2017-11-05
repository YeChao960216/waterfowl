//alert($);
$(function () {
    $('#btn').click(function () {
        var dateEstablish=$('#dateEstablish').val();
        var numMax=$('#numMax').val();
        var idRecorder=$('#idRecorder').val();
        var idCharge=$('#idCharge').val();
        var remark=$('#remark').val();

        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "",
            /*data发送至服务器的key/value数据*/
            data: {
                "dateEstablish":dateEstablish,"numMax":numMax,"idRecorder":idRecorder," idCharge": idCharge,"remark":remark
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