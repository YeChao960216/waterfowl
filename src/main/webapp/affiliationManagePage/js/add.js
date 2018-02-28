/*
    增加禽舍
 */

var type=[{
    type:["鸭子1","鸭子2","鸭子3"]

}];
var size=[{
    size:[99,100,101]

}];
var position=[{
    position:["东","西","南"]
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
        for(var n=0;n<position;n++)
        {
            $("#position").append("<option>"+position[n]+"</option>");
        }
    }
})



    //先从数据字典获取所有的数据生成下拉框
    //数据字典查出type，position，size，status生成下拉框
    $.ajax({
        url:"",
        type:"POST",
        datatype:"json",
        success:function () {
            for(var i=0;i<type.length;i++)
            {
                $("#type").append("<option>"+type[i]+"</option>");
            }
            for (var j=0;j<size.length;j++)
            {
                $("#size").append("<option>"+size[j]+"</option>");
            }
            for(var n=0;n<position;n++)
            {
                $("#position").append("<option>"+position[n]+"</option>");
            }
        }
    })
    $('#add').click(function () {
        //发送到数据字典
        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "",
            /*data发送至服务器的key/value数据*/
            data: {
                "type":$('#type').val(),//养殖类型
                "position":$('#position').val(),//方位
                "size":$('#size').val(),//规格
            },
            /*客户端请求的类型*/
            type: "post",
            dataType: "json",
            /*请求完成时的回调函数*/
            success: function () {
                console.log("success");
            }
        })

        //发送到user
        $.ajax({
            /*请求的HTML页的URL地址*/
            url: "",
            /*data发送至服务器的key/value数据*/
            data: {

                "idCharge": $('#idCharge').val(),//负责人编号
                "idRecorder":$('#idRecorder').val()//记录者编号
            },
            /*客户端请求的类型*/
            type: "post",
            dataType: "json",
            /*请求完成时的回调函数*/
            success: function () {
                console.log("success");
            }
        })

    })
