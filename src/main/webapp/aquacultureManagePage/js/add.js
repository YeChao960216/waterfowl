//alert($);
var oMaxNum=document.getElementById(dateEstablish);
//判断是否超过最大的纳员数
function findMaxNum() {
    if(oMaxNum.innerHTML>maxNum){
        alert("抱歉，您输入的数量已超过最大纳员数");
    }
}
//Ajax请求
$(function () {
    $('#btn').click(function () {
        var idPoultry=$('#idPoultry').val();
        var fowleryId=$('#fowleryId').val();
        var recordDate=$('#recordDate').val();
        var numTotal=$('#numTotal').val();
        var feedWeight=$('#feedWeight').val();
        var feedType=$('#feedType').val();
        var type=$('#type').val();
        var idRecorder=$('#idRecorder').val();
        var idCharge=$('#idCharge').val();
        var remark=$('#remark').val();
        var status=$('#status');

        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "",
            /*data发送至服务器的key/value数据*/
            data: {
                "recordDate":recordDate,"idPoultry":idPoultry,"fowleryId":fowleryId,"type":type,"numTotal":numTotal,"feedType":feedType,
                "feedWeight":feedWeight,"status":status,"idRecorder":idRecorder,"idCharge":idCharge,"remark":remark},
            /*客户端请求的类型*/
            type: "post",
            dataType: "json",
            /*请求完成时的回调函数*/
            success: function (data) {
                if (msg=='1'){
                    alert("您好,新增养殖记录成功！！！");
                }else{
                    alert("抱歉，新增养殖记录失败！！！");
                }
            }
        })

    })
})