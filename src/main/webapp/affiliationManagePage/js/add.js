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
