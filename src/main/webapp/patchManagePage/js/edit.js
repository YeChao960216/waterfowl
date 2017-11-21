var data=[{
    idPoultry:1111,
    type:"鸭子",
    position:"东",
    size:100,
    affiliation:"归属的大禽舍1",
    idFowlery:"归属的禽舍1",
    idRecorder:"wenzhi",
    idCharge:"zhuowenzhi"
}];


console.log(data);
$(function () {
    $('#btn').click(function () {
        ///生成下拉框的
        $.ajax({
            url: "",
            type: "post",
            dataType: "json",
            success: function () {
                console.log("发送成功！！！");
                $('#idpoultry').append("<input type='text' placeholder='输入养殖批次'>");
                $('#type').append("<option>"+type+"</option>");
                $('#position').append("<option>"+position+"</option>");
                $('#size').append("<option>"+size+"</option>");
                $('#affiliation').append("<option>"+affiliation+"</option>");
            }
        })
        //发送数据到养殖批次表
        $.ajax({
            url: "",
            data: {
                "idPoultry":$('#idPoultry').val(),//养殖批次
            },
            type: "post",
            dataType: "json",
            success: function () {
                console.log("发送成功！！！");
            }
        })

        //发送数据到字典的
        $.ajax({
            url: "",
            data: {
                "type":$('#type').val(),//类型
                "position":$('#position').val(),//方位
                "size":$('#size').val(),//规格
            },
            type: "post",
            dataType: "json",
            success: function () {
                console.log("发送成功！！！");
            }
        })
        //发送数据到禽舍表的
        $.ajax({
            url: "",
            data: {
                "idFowlery":$('#idFowlery').val(),//使用状态
            },
            type: "post",
            dataType: "json",
            success: function () {
                console.log("发送成功！！！");
            }
        })

        //发送数据到user表的
        $.ajax({
            url: "",
            data: {
                "idCharge": $('#idCharge').val(),//负责人编号
                "idRecorder":$('#idRecorder').val(),//记录者编号
            },
            type: "post",
            dataType: "json",
            success: function () {
                console.log("发送成功！！！");
            }
        });

        $.ajax({
            url:"",
            type:"post",
            dataType:"json",
            // data: {
            //     "idPoultry":$('#idPoultry').val(),//养殖批次
            //     "type":$('#type').val(),//类型
            //     "position":$('#position').val(),//方位
            //     "size":$('#size').val(),//规格
            //     "affiliation":$('#affiliation').val(),//归属的大禽舍
            //     "idFowlery":$('#idFowlery').val(),//使用状态
            //     " idCharge": $('#idCharge').val(),//负责人编号
            //     "idRecorder":$('#idRecorder').val(),//记录者编号
            // },
        })
    });

    succFunction(data);
    function succFunction(data1) {
        var json = data1;
        $.each(json,function (index,item) {
            //循坏数据
            alert(item);
            var  idPoultry=item.idPoultry;
            var  type=item.type;
            var  position=item.position;
            var  size=item.size;
            var  affiliation=item.affiliation;
            var  idFowlery=item.idFowlery;
            var  idCharge=item.idCharge;
            var  idRecorder=item.idRecorder;
            var  html="<tr>" +
                "<td><input type='text' value='"+idPoultry+"'></td>" +
                "<td><input type='text'>"+type+"</td>" +
                "<td><input type='text' value='"+position+"'></td>" +
                "<td><input type='text' value='"+size+"'></td>" +
                "<td><input type='text' value='"+affiliation+"'></td>" +
                "<td><input type='text' value='"+idFowlery+"'></td>" +
                "<td><input type='text' value='"+idCharge+"'></td>" +
                "<td><input type='text' value='"+idRecorder+"'></td>" +
                "<td><input type='button' value='修改' class='btn edit'></td></tr>";

        });
        $('#tbody').html(html);
    }
    $('.delete').click(function () {
        $('#tbody').innerHTML='';
    });
});
console.log($('#tbody')[0]);