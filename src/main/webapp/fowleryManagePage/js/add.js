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
        var dateEstablish=$('#dateEstablish').val();
        var address=$('#address').val();
        var type=$('#type').val();
        var numMax=$('#numMax').val();
        var idRecorder=$('#idRecorder').val();
        var idCharge=$('#idCharge').val();
        var remark=$('#remark').val();
        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "",
            /*data发送至服务器的key/value数据*/
            data: {
                "dateEstablish":dateEstablish,"address":address,"numMax":numMax,"type":type,"idRecorder":idRecorder," idCharge": idCharge,"remark":remark
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