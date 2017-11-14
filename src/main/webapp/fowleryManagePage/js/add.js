//alert($);
var oMaxNum=document.getElementById(dateEstablish);
function findMaxNum() {
    if(oMaxNum.innerHTML>maxNum){
        alert("抱歉，您输入的数量已超过最大纳员数");
    }
}

findMaxNum();
$(function () {
    $('#btn').click(function () {
        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "",
            /*data发送至服务器的key/value数据*/
            data: {
                "dateEstablish":$('#dateEstablish').val()h,
                "address":$('#address').val(),
                "numMax":$('#numMax').val(),
                "type":$('#type').val(),
                "idRecorder":$('#idRecorder').val(),
                " idCharge": $('#idCharge').val(),
                "remark":$('#remark').val()
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