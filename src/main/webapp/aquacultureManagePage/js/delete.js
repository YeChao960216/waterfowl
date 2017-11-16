
$(function () {

    /*全选按钮*/
    function changeState(isChecked)
    {
        var chkList=document.getElementsByTagName("#tbody input");
        for(var i=0;i<chkList.length;i++)
        {
            if(chkList[i].type=="checkbox")
            {
                chkList[i].checked=isChecked;
            }
        }
    }

    /*ajax请求*/
    $('#btn').click(function () {

        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "",
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
                $(data).each(function (i,n) {
                    $("#tobdy").append("<tr><td>"+n.recordDate+"</td><td>"+n.type+"</td><td>"+n.status+"</td><td>"+n.idRecorder+"</td><td>"+n.idCharge+"</td></tr>");
                })
            }
        })

    })

    /*删除按钮*/
        $(".btns").onclick=function () {
            $("#tboby").innerHTML="";
        }

})