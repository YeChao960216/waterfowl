/*
    增加禽舍
 */
$(function () {
    $('#add').click(function () {
        alert(1111);
        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "",
            /*data发送至服务器的key/value数据*/
            data: {
                "size":$('#size').val(),//规格
                "status":$('#status').val(),//使用状态
                "affiliation":$('#affiliation').val(),//归属的大禽舍
                " idCharge": $('#idCharge').val(),//负责人编号
                "idRecorder":$('#idRecorder').val(),//记录者编号
            },
            /*客户端请求的类型*/
            type: "post",
            dataType: "json",
            /*请求完成时的回调函数*/
            success: function (msg) {
               /* if (msg=='1'){
                    alert("您好,新增禽舍成功！！！");
                }else{
                    alert("抱歉，新增禽舍失败！！！");}*/

                alert(1111);

            }
        })

    })
});