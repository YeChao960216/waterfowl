/*
    批次
 */
$(function () {
    $('#add').click(function () {
        alert(1111);
        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "",
            /*data发送至服务器的key/value数据*/
            data: {
                "idPoultry":$('#idPoultry').val(),//养殖批次
                "type":$('#type').val(),//类型
                "position":$('#position').val(),//方位
                "size":$('#size').val(),//规格
                "affiliation":$('#affiliation').val(),//归属的大禽舍
                "idFowlery":$('#idFowlery').val(),//使用状态
                " idCharge": $('#idCharge').val(),//负责人编号
                "idRecorder":$('#idRecorder').val(),//记录者编号
            },
            /*客户端请求的类型*/
            type: "post",
            dataType: "json",
            /*请求完成时的回调函数*/
            success: function (msg) {
                /* if (msg=='1'){
                     alert("您好,新增批次成功！！！");
                 }else{
                     alert("抱歉，新增批次失败！！！");}*/

                alert(1111);

            }
        })

    })
});