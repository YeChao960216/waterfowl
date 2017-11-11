
$(function () {
    $('#btn').click(function () {
        var recordDate=$('#recordDate').val();
        var type=$('#type').val();
        var status=$('#status').val();
        var idRecorder=$('#idRecorder').val();
        var idCharge=$('#idCharge').val();

        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "",
            /*data发送至服务器的key/value数据*/
            data: {
                "recordDate":recordDate,"type":type,"status":status,"idRecorder":idRecorder,"idCharge":idCharge},
            /*客户端请求的类型*/
            type: "post",
            dataType: "json",
            /*请求完成时的回调函数*/
            success: function (data) {

            }
        })

    })
})