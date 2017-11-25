/*
    增加禽舍
 */
var data=[{
    size:100,
    status:"可用",
    affiliation:"归属的大禽舍1",
    idRecorder:"wenzhi",
    idCharge:"zhuowenzhi"
}];

$(function () {
    //Ajax先获取后台传来的size值生成下拉框，status生成显示的可用状态，归属的大禽舍的下拉框
    $.ajax({
        url:"",
        type:"POST",
        seccess:function (data) {
            console.log("Ajax先获取后台传来的size值生成下拉框，status生成显示的可用状态，归属的大禽舍的下拉框");
            console.log("-------success----");
            $('#size').append("<option value='"+size+"'>"+"规格"+size+"</option>");
        }
    });

    //把size发送到字典，返回数据生成下拉框，status只允许显示，不能修改
    $('#add').click(function () {
        $.ajax({
            url:"",
            type:"POST",
            datatype:"json",
            data:{
                "size":$('#size').val(),//规格字典查
                "status":$('#status').val(),
            },
            success:function(data){
               console.log("传送规格成功");
            }
        });

        //归属的大禽舍,大禽舍表查
        $.ajax({
            url:"",
            type:"POST",
            datatype:"json",
            data:{
                "affiliation":$('#affiliation').val(),//归属的大禽舍,大禽舍表查
            },
            success:function(data){
                console.log("传送归属的大禽舍成功");
                $('#affiliation').append("<option value='"+affiliation+"'>"+affiliation+"</option>");

            }
        });

        //负责人编号，user表查,记录者编号，user表查,返回所有表格的数据
        $.ajax({
            url:"",
            type:"POST",
            datatype:"json",
            data:{
                "idCharge": $('#idCharge').val(),//负责人编号，user表查
                "idRecorder":$('#idRecorder').val(),//记录者编号，user表查
            },
            success:function(data){
                console.log("传送归属的负责人编号成功,记录者编号");
            }
        });

        alert(data);
    })
});