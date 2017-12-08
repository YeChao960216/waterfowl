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

//增加按钮增加批次
$(function () {
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
        })

    })
});