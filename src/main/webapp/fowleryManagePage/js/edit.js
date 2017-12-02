/*
1.加载整个页面的数据（不用发送直接在获取数据渲染整个页面）
2.点击查询按钮查询
 */
var data=[{
    size:100,
    status:"可用",
    affiliation:"归属的大禽舍1",
    idRecorder:"wenzhi",
    idCharge:"zhuowenzhi"
}];
var size=[{
    size:[99,100,101]

}];
var status=[{
    status:["满员","未满员"]

}];
var affiliation=[{
    affiliation:["东1","西2","南3"]
}]
var data3=[{
    size:99,
    affiliation:"东1"
}]


//先从数据字典获取所有的数据生成下拉框
$.ajax({
    url:"",
    datatype:"post",
    success:function (data3) {
        for (var j=0;j<size.length;j++)
        {
            $("#size").append("<option>"+size[j]+"</option>");
        }
        for (var j=0;j<status.length;j++)
        {
            $("#status").append("<option>"+status[j]+"</option>");
        }

        for(var n=0;n<affiliation;n++)
        {
            $("#affiliation").append("<option>"+affiliation[n]+"</option>");
        }
    }
})



$(function () {
    //查询按钮
    $('#btn').click(function () {

        //把size发送到字典，返回数据生成下拉框，status只允许显示，不能修改
        $('#btn').click(function () {
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
                    console.log("传送状态成功");
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
                    $('#affiliation').append("<option value='"+affiliation+"'>"+"大禽舍"+affiliation+"</option>");

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
    //修改按钮
    $('.edit').click(function () {
        //把size发送到字典，返回数据生成下拉框，status只允许显示，不能修改
        $('#btn').click(function () {
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
                    console.log("传送状态成功");
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
                    $('#affiliation').append("<option value='"+affiliation+"'>"+"大禽舍"+affiliation+"</option>");

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


    //显示页面的所有记录
    $.ajax({
        url:"",
        type:"post",
        dataType:"json",
        success:succFunction(data)
    })
    var html = '';
    succFunction(data);
    function succFunction(data1) {
        var json = data1;
        $.each(json,function (index,item) {
            //循坏数据
            var  size=item.size;
            var  status=item.status;
            var  affiliation=item.affiliation;
            var  idCharge=item.idCharge;
            var  idRecorder=item.idRecorder;
                  html="<tr>" +
                    "<td><input type='text' value='"+size+"'></td>" +
                    "<td><input type='text' value='"+status+"'></td>" +
                    "<td><input type='text' value='"+affiliation+"'></td>" +
                    "<td><input type='text' value='"+idCharge+"'></td>" +
                    "<td><input type='text' value='"+idRecorder+"'></td>" +
                    "<td><input type='button' value='修改' class='btn edit' id='edit'></td></tr>";
        });
        $('#tbody').html(html);
    }

});
