var data=[{
    type:"鸭子",
    position:"东",
    size:100,
    status:"可用",
    idRecorder:"wenzhi",
    idCharge:"zhuowenzhi"
}];


$(function () {
    $('#btn').click(function () {
        //发送到字典的
        $.ajax({
            url:"",
            type:"post",
            dataType:"json",
            data: {
                "type":$('#type').val(),//养殖类型
                "position":$('#position'),//方位
                "size":$('#size').val(),//规格
                "status":$('#status').val(),//使用状态
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
            data: {
                "type":$('#type').val(),//养殖类型
                "position":$('#position'),//方位
                "size":$('#size').val(),//规格
                "status":$('#status').val(),//使用状态
                " idCharge": $('#idCharge').val(),//负责人编号
                "idRecorder":$('#idRecorder').val(),//记录者编号
            },
        })
    });
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
                "<td><input type='text' value='"+type+"'></td>" +
                "<td><input type='text' value='"+position+"'></td>" +
                "<td><input type='text' value='"+size+"'></td>" +
                "<td><input type='text' value='"+status+"'></td>" +
                "<td><input type='text' value='"+idCharge+"'></td>" +
                "<td><input type='text' value='"+idRecorder+"'></td>" +
                "<td><input type='button' value='修改' class='btn edit'></td></tr>";
        });
        $('#tbody').html(html);
    }
});

console.log($('#tbody')[0]);