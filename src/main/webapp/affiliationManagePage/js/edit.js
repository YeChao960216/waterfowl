var data=[{
    type:"鸭子",
    position:"东",
    size:100,
    status:"可用",
    idRecorder:"wenzhi",
    idCharge:"zhuowenzhi"
}];

var type=[{
    type:["鸭子1","鸭子2","鸭子3"]

}];
var size=[{
    size:[99,100,101]

}];
var position=[{
    position:["东","西","南"]
}]
var status=[{
    status:["满员","不满员"]
}]
var data3=[{
    type:"鸭子1",
    size:99,
    position:"东"
}]


//先从数据字典获取所有的数据生成下拉框
$.ajax({
    url:"",
    datatype:"post",
    success:function (data3) {
        for(var i=0;i<type.length;i++)
        {
            $("#type").append("<option>"+type[i]+"</option>");
        }
        for (var j=0;j<size.length;j++)
        {
            $("#size").append("<option>"+size[j]+"</option>");
        }
        for(var m=0;m<status;m++)
        {
            $("#status").append("<option>"+status[m]+"</option>");
        }
        for(var n=0;n<position;n++)
        {
            $("#position").append("<option>"+position[n]+"</option>");
        }
    }
})



    //查询按钮发送的数据
    $('#btn').click(function () {
        //发送到字典的
        $.ajax({
            url:"",
            type:"post",
            dataType:"json",
            data: {
                "type":$('#type').val(),//养殖类型
                "position":$('#position').val(),//方位
                "size":$('#size').val(),//规格
                "status":$('#status').val()//使用状态
            },
            success:function () {
                console.log("发送成功");
            }
        })

        //发送到user的
        $.ajax({
            url:"",
            type:"post",
            dataType:"json",
            data: {
                "idCharge": $('#idCharge').val(),//负责人编号
                "idRecorder":$('#idRecorder').val(),//记录者编号
            },
            success:function () {
                console.log("发送成功");
            }
        });

    // 加载整个页面的
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
            var  type=item.type;
            var  position=item.position;
            var  size=item.size;
            var  status=item.status;
            var  idCharge=item.idCharge;
            var  idRecorder=item.idRecorder;
              html="<tr>" +
                "<td><input type='text' value='"+type+"' class='type'></td>" +
                "<td><input type='text' value='"+position+"' class='position'></td>" +
                "<td><input type='text' value='"+size+"' class='size'></td>" +
                "<td><input type='text' value='"+status+"' class='status'></td>" +
                "<td><input type='text' value='"+idCharge+"' class='idCharge'></td>" +
                "<td><input type='text' value='"+idRecorder+"' class='idRecorder'></td>" +
                "<td><input type='button' value='修改' class='btn edit'></td></tr>";
        });
        $('#tbody').html(html);
    }
});

//修改按钮发送的数据
$('.edit').click(function () {
    //发送到字典的
    $.ajax({
        url:"",
        type:"post",
        dataType:"json",
        data: {
            "type":$('#type').val(),//养殖类型
            "position":$('#position').val(),//方位
            "size":$('#size').val(),//规格
            "status":$('#status').val()//使用状态
        },
        success:function () {
            console.log("发送成功");
        }
    })

    //发送到user的
    $.ajax({
        url:"",
        type:"post",
        dataType:"json",
        data: {
            "idCharge": $('#idCharge').val(),//负责人编号
            "idRecorder":$('#idRecorder').val(),//记录者编号
        },
        success:function () {
            console.log("发送成功");
        }
    });

});
