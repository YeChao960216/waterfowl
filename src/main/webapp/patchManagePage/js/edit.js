
//模拟数据
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


var type=[{
    type:["鸭子1","鸭子2","鸭子3"]

}];

var position=[{
    position:["东","西","南"]
}];
var size=[{
    size:[99,100,101]

}];
var affiliation=[{
    affiliation:["归属的大禽舍1","归属的大禽舍2","归属的大禽舍3"]
}];

var idFowlery=[{
    idFowlery:["idFowlery1","idFowlery2","idFowlery3"]
}];
var data3=[{
    type:"鸭子1",
    position:"东",
    size:100,
    affiliation:"归属的大禽舍1",
    idFowlery:"idFowlery1",
    idRecorder:"wenzhi",
    idCharge:"zhuowenzhi"
}]

//生成下拉框的
$.ajax({
    url: "",
    type: "post",
    dataType: "json",
    success: function () {
        console.log("发送成功！！！");
        for(var i=0;i<type.length;i++)
        {
            $("#type").append("<option>"+type[i]+"</option>");
        }
        for(var j=0;j<position.length;j++)
        {
            $("#position").append("<option>"+position[j]+"</option>");
        }
        for (var k=0;k<size.length;k++)
        {
            $("#size").append("<option>"+size[k]+"</option>");
        }
        for(var m=0;m<affiliation.length;m++)
        {
            $("#affiliation").append("<option>"+affiliation[m]+"</option>");
        }
        for(var n=0;n<idFowlery.length;n++)
        {
            $("#idFowlery").append("<option>"+idFowlery[n]+"</option>");
        }

    }
})


    //点击查询按钮发送数据
    $('#btn').click(function () {
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
        });

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
        });

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
        });

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


    });


    //点击修改按钮发送数据
    $('.edit').click(function () {
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
        });

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
        });

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
        });

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
        success:succFunction(data)
    })
    var html='';
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
            html="<tr>" +
                "<td><input type='checkbox'></td>"+
                "<td><input type='text' value='"+idPoultry+"'></td>" +
                "<td><input type='text' value='"+type+"'></td>" +
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