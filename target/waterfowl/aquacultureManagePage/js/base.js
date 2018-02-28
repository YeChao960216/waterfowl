// 加载整个页面

var data=[{
    recordDate:2017-01-10,
    idPoultry:111,
    fowleryId:2222,
    type:"鸭子",
    numTotal:100,
    feedType:"饲料",
    feedWeight:100,
    status:"幼雏",
    idRecorder:"wenzhi",
    idCharge:"zhuowenzhi",
    remark:"代码代码🐶",
}];



console.log(data);
$(function () {
    //点击查询按钮
    $('#btn').click(function () {
        alert("kkkk")
        $.ajax({
            url:"",/*/waterfowl/test/data*/
            type:"get",
            data:{
                "recordDate":$('#recordDate').val(),
                "type":$('#type').val(),
                "status":$('#status').val(),
                "idRecorder":$('#idRecorder').val(),
                "idCharge":$('#idCharge').val()
            },

            success:function(data){
                var item = eval('('+data+')');
                // var item = JSON.parse(data);
                var recordDate=item.recordDate;
                var numTotal=item.numTotal;
                var feedType=item.feedType;
                var feedWeight=item.feedWeight;
                var idPoultry=item.idPoultry;
                var fowleryId=item.fowleryId;
                var status =item.status;
                var idRecorder=item.idRecorder;
                var idCharge=item.idCharge;
                var remark=item.remark;
                var type=item.type;
                var html="<tr><td><input type='checkbox'></td>td><td>"+recordDate+"</td><td>"+idPoultry+"</td><td>"+fowleryId+"</td><td>"+type+"</td><td>"+numTotal+"</td><td>"+feedType+"</td><td>"+feedWeight+"</td><td>"+status+"</td><td>"+idCharge+"</td><td>"+idRecorder+"</td><td>"+remark+"<input type='button' class='btn' class='delete' value='删除'></td></tr>";
                $("#tbody").html(html);
            }
        })
    })

    //点击删除按钮

        $("#delete").click(function () {
            this.td.innerHTML="";
        });


    /*$.ajax({
            /!*请求的HTML页的URL地址*!/
            url: "",
            /!*data发送至服务器的key/value数据*!/
            data: {
                "dateEstablish":$('#dateEstablish').val(),
                "address":$('#address').val(),
                "numMax":$('#numMax').val(),
                "type":$('#type').val(),
                "idRecorder":$('#idRecorder').val(),
                "idCharge": $('#idCharge').val(),
                "remark":$('#remark').val()
            },
            /!*客户端请求的类型*!/
            type: "post",
            dataType: "json",
            /!*请求完成时的回调函数*!/
            success:succFunction(data1)//成功执行函数
        }),*/

    //加载整个页面的
    succFunction(data);
    function succFunction(data1) {



        //eval将字符转化为对象数组 eval('1'+'2') //3
        var json = data1;
        //alert("fowerly:dateEstablish"+json.dateEstablish+",address"+json.address+",numMax"+json.numMax+json.idCharge+json.type+json.remark+json.idRecorder);

        //日期处理函数
        var date = new Date(parseInt(json.date));
        function getDateTime() {
            var year = date.getFullYear();
            var month = date.getMonth();
            var day = date.getDate();
            var hh = date.getHours();
            var mm = date.getMinutes();
            var ss = date.getSeconds();
            return year+"-"+month+"-"+day+"-"+hh+"-"+mm+"-"+ss;
        };
        json.dateEstablish=getDateTime;

        //eval将字符转化为对象数组
        //var json = eval(data)//数组
        var html= '';
        $.each(json,function (index,item) {
            //循坏数据
            alert(item);
            var id=item.id;
            var dateEstablish=item.dateEstablish;
            var address=item.address;
            var numMax=item.numMax;
            var type=item.type;
            var idRecorder=item.idRecorder;
            var idCharge=item.idCharge;
            var remark=item.remark;
            html+="<tr><td><input type='checkbox'></td><td>"+id+"</td><td>"+dateEstablish+"</td><td>"+address+"</td><td>"+numMax+"</td><td>"+type+"</td><td>"+idCharge+"</td><td>"+idRecorder+"</td><td>"+remark+"</td></tr>";

        });
        $("#tbody").html(html);
    }


});

console.log($('#tbody')[0]);