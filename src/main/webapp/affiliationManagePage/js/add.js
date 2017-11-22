/*
    增加禽舍
 */

var datatype=[{
    type:["鸭子1","鸭子2","鸭子3"]

}];
var data2=[{
    size:[99,100,101],
    position:["东","西","南"]
}];

var data3=[{
    type:"鸭子1",
    size:99,
    position:"东"
}]

$.ajax({
    url:"",
    datatype:"post",
    success:function () {
        $('#type select').each(function (index,data) {
            $('option').each(function (data,text) {
                $('#type').append("<option>"+datatype.type+"</option>");
            })
        });

    }
})
$(function () {

    //数据字典查出type，position，size，status生成下拉框
    $.ajax({
        url:"",
        type:"POST",
        datatype:json,
        success:function (data) {
            console.log("-------success-----");
            $("#type").append("<option>"+type+"</option>");
            $("#position").append("<option>"+position+"</option>");
            $("#size").append("<option>"+size+"</option>");
            $("#status").append("<option>"+status+"</option>");
        }
    })
    $('#add').click(function () {

        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "",
            /*data发送至服务器的key/value数据*/
            data: {
                "type":$('#type').val(),//养殖类型
                "position":$('#position'),//方位
                "size":$('#size').val(),//规格
                "idCharge": $('#idCharge').val(),//负责人编号
                "idRecorder":$('#idRecorder').val()//记录者编号
            },
            /*客户端请求的类型*/
            type: "post",
            dataType: "json",
            /*请求完成时的回调函数*/
            success: function () {
                console.log("success");
            }
        })

    })
});