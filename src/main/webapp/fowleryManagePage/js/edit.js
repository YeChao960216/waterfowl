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


console.log(data);
$(function () {
    //查询
    $('#btn').click(function () {
        //Ajax先获取后台传来的size值生成下拉框，status生成显示的可用状态，归属的大禽舍的下拉框，负责人，记录人
        $.ajax({
            url:"",
            type:"POST",
            seccess:function (data) {
                console.log("Ajax先获取后台传来的size值生成下拉框，status生成显示的可用状态，归属的大禽舍的下拉框");
                console.log("-------success----");
                $('#size').append("<option value='"+size+"'>"+"规格"+size+"</option>");
                $('#status').append("<option value='"+status+"'>"+"使用状态"+size+"</option>");
                $('#affiliation').append("<option value='"+affiliation+"'>"+"大禽舍"+affiliation+"</option>");
                $('#idCharge').append("<option value='"+idCharge+"'>"+"负责人"+idCharge+"</option>");
                $('#idRecorder').append("<option value='"+idRecorder+"'>"+"记录者"+idRecorder+"</option>");
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

        //显示页面的所有记录
        $.ajax({
            url:"",
            type:"post",
            dataType:"json",
            data: {
                "size":$('#size').val(),
                "status":$('#status').val(),
                "affiliation":$("#affiliation"),
                "idRecorder":$('#idRecorder').val(),
                "idCharge": $('#idCharge').val()
            },
            success:function (){
                alert(1111);
            }

        })
    });
    //修改
    $('#edit').click(function () {
        alert("111");
        $.ajax({
            url:"",
            type:"post",
            dataType:"json",
            data: {
                "size":$('#size').val(),
                "status":$('#status').val(),
                "affiliation":$("#affiliation"),
                "idRecorder":$('#idRecorder').val(),
                "idCharge": $('#idCharge').val()
            },
            success:function(){
                alert(111);
            }

        })
    });
    var html = '';
    succFunction(data);
    function succFunction(data1) {
        //eval将字符转化为对象数组 eval('1'+'2') //3
        var json = data1;
        $.each(json,function (index,item) {
            //循坏数据
            var html='';
            alert(item);
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
