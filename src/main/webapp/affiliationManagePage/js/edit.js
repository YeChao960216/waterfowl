var data=[{
    type:"鸭子",
    position:"东",
    size:100,
    status:"可用",
    idRecorder:"wenzhi",
    idCharge:"zhuowenzhi"
}];


//先从数据字典获取所有的数据生成下拉框
$.ajax({
    url:"",
    datatype:"post",
    success:function (data) {
        $("#type").each(function (i,n) {
            $("#type").append("<option>"+type.n+"</option>");
        })
    }
})
//先从数据字典获取所有的数据生成下拉框
$.ajax({
    url:"",
    datatype:"post",
    success:function (data) {
        $("#size").each(function (i,n) {
            $("#size").append("<option>"+size.n+"</option>");
        })
    }
})
//先从数据字典获取所有的数据生成下拉框
$.ajax({
    url:"",
    datatype:"post",
    success:function (data) {
        $("#position").each(function (i,n) {
            $("#position").append("<option>"+position.n+"</option>");
        })
    }
})

$.ajax({
    url:"",
    datatype:"post",
    success:function (data) {
        $("#status").each(function (i,n) {
            $("#status").append("<option>"+status.n+"</option>");
        })
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
