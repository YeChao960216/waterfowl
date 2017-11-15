/*Ajax请求*/
$(function () {
    $('#btn').click(function () {
        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "",
            /*data发送至服务器的key/value数据*/
            data: {
                "dateEstablish":$('#dateEstablish').val(),
                "type":$('#type').val(),
                "idRecorder":$('#idRecorder').val(),
                " idCharge": $('#idCharge').val()
            },
            /*客户端请求的类型*/
            type: "post",
            dataType: "json",
            /*请求完成时的回调函数*/
            success: function (data) {
                $(data).each(function (i,n) {
                    $("#tboby").append("<tr><td>"+n.dateEstablish+"</td><td>"+n.type+"</td><td>"+n.idRecorder+"</td><td>"+n.idCharge+"</td></tr>");
                })
            }
        })

    })
})