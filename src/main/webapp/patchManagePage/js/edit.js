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
        alert("111");
        $.ajax({
            url:"",
            type:"post",
            dataType:"json",
            data: {
                "idPoultry":$('#idPoultry').val(),//养殖批次
                "type":$('#type').val(),//类型
                "position":$('#position').val(),//方位
                "size":$('#size').val(),//规格
                "affiliation":$('#affiliation').val(),//归属的大禽舍
                "idFowlery":$('#idFowlery').val(),//使用状态
                " idCharge": $('#idCharge').val(),//负责人编号
                "idRecorder":$('#idRecorder').val(),//记录者编号
            },
        })
    });
    /*$.ajax({
            /!*请求的HTML页的URL地址*!/
            url: "",
            /!*data发送至服务器的key/value数据*!/
            data: {
                "id":$('# id').val(),
                "dateEstablish":$('#dateEstablish').val(),
                "address":$('#address').val(),
                "numMax":$('#numMax').val(),
                "type":$('#type').val(),
                "idCharge": $('#idCharge').val(),
                "idRecorder":$('#idRecorder').val(),
                "remark":$('#remark').val()
            },
            /!*客户端请求的类型*!/
            type: "post",
            dataType: "json",
            /!*请求完成时的回调函数*!/
            success:succFunction(data1)//成功执行函数
        }),*/
    succFunction(data);
    function succFunction(data1) {



        //eval将字符转化为对象数组 eval('1'+'2') //3
        var json = data1;
        /*
         //日期处理函数
         var date = new Date(parseInt(json.date,14));
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
         */
        //eval将字符转化为对象数组
        //var json = eval(data)//数组
        var html = '';
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
            var  html="<tr><td><input type='text'>"+idPoultry+"</td><td><input type='text'>"+type+"</td><td><input type='text'>"+position+"</td><td><input type='text'>"+size+"</td><td><input type='text'>"+affiliation+"</td><td><input type='text'>"+idFowlery+"</td><td><input type='text'>"+idCharge+"</td><td><input type='text'>"+idRecorder+"</td><td><input type='button' value='修改' class='btn edit'></td></tr>";

        });
        $('#tbody').html(html);
    }
    $('.delete').click(function () {
        $('#tbody').innerHTML='';
    });
});
console.log($('#tbody')[0]);