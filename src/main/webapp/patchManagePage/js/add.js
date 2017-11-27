/*
    批次
 */
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

//先从数据字典获取所有的数据生成下拉框
$.ajax({
    url:"",
    datatype:"post",
    success:function (data) {
        $("#type").each(function (i,n) {
            $("#type").append("<option>"+type.n+"</option>");
        })
    }
});

//先从数据字典获取所有的数据生成下拉框
$.ajax({
    url:"",
    datatype:"post",
    success:function (data) {
        $("#position").each(function (i,n) {
            $("#position").append("<option>"+position.n+"</option>");
        })
    }
});
//先从数据字典获取所有的数据生成下拉框
$.ajax({
    url:"",
    datatype:"post",
    success:function (data) {
        $("#size").each(function (i,n) {
            $("#size").append("<option>"+size.n+"</option>");
        })
    }
});

//先从数据字典获取所有的数据生成下拉框
$.ajax({
    url:"",
    datatype:"post",
    success:function (data) {
        $("#affiliation").each(function (i,n) {
            $("#affiliation").append("<option>"+affiliation.n+"</option>");
        })
    }
});

//生成下拉框的
$.ajax({
    url: "",
    type: "post",
    dataType: "json",
    success: function () {
        $("#idFowlery").each(function (i,n) {
            $("#idFowlery").append("<option>"+idFowlery.n+"</option>");
        })
    }
});
//增加按钮增加批次

    $('#add').click(function () {

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
        })

    });
