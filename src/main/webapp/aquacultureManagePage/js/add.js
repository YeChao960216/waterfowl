/*var oMaxNum=document.getElementById(dateEstablish);
//判断是否超过最大的纳员数
function findMaxNum() {
    if(oMaxNum.innerHTML>maxNum){
        alert("抱歉，您输入的数量已超过最大纳员数");
    }
}*/


$(function () {
    $('.btn').click(function () {

        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "",
            /*data发送至服务器的key/value数据*/
            data: {
                "recordDate":$('#recordDate').val(),
                "idPoultry":$('#idPoultry').val(),
                "fowleryId":$('#fowleryId').val(),
                "type":$('#type').val(),
                "numTotal":$('#numTotal').val(),
                "feedType":$('#feedType').val(),
                "feedWeight":$('#feedWeight').val(),
                "status":$('#status'),
                "idRecorder":$('#idRecorder').val(),
                "idCharge":$('#idCharge').val(),
                "remark":$('#remark').val()},
            /*客户端请求的类型*/
            type: "post",
            dataType: "json",
            /*请求完成时的回调函数*/
            success: function (data) {
                // if (msg=='1'){
                //     alert("您好,新增养殖记录成功！！！");
                // }else{
                //     alert("抱歉，新增养殖记录失败！！！");
                // }
                alert(data);
            }

        })

    })
})