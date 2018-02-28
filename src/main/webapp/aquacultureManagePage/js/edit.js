
$(function () {
    $('#btn').click(function () {
        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "/waterfowl/aquaculture/edit/",
            /*data发送至服务器的key/value数据*/
            data: {
                "recordDate":$('#recordDate').val(),
                "type":$('#type').val(),
                "status":$('#status').val(),
                "idRecorder":$('#idRecorder').val(),
                "idCharge":$('#idCharge').val()
            },
            /*客户端请求的类型*/
            type: "post",
            dataType: "json",
            /*请求完成时的回调函数*/
            success: function (data) {
                $("#tobdy").append("<tr><td>"+n.recordDate+"</td><td>"+n.type+"</td><td>"+n.status+"</td><td>"+n.idRecorder+"</td><td>"+n.idCharge+"</td></tr>");
            }
        })

    })
})