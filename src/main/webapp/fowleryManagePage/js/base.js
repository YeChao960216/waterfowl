/*
1.加载整个页面的数据（不用发送直接在获取数据渲染整个页面）
2.点击查询按钮查询
 */
var data=[{
    id:"0011",
    dateEstablish:"2017-11-13",
    address:"仲恺养鸡场",
    numMax:1000,
    type:"幼鸡",
    idRecorder:"wenzhi",
    idCharge:"zhuowenzhi",
    remark:"你最帅了"}];


console.log(data);
$(function () {
    $('#btn').click(function () {
        alert("111");
        $.ajax({
            url:"",
            type:"post",
            dataType:"json",
            data: {
                "dateEstablish":$('#dateEstablish').val(),
                "type":$('#type').val(),
                "idRecorder":$('#idRecorder').val(),
                "idCharge": $('#idCharge').val()
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
        //alert("fowerly:dateEstablish"+json.dateEstablish+",address"+json.address+",numMax"+json.numMax+json.idCharge+json.type+json.remark+json.idRecorder);

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

        //eval将字符转化为对象数组
        //var json = eval(data)//数组
        var html = '';
    $.each(json,function (index,item) {
            //循坏数据
            alert(item);
            var  id=item.id;
            var  dateEstablish=item.dateEstablish;
            var  address=item.address;
            var  numMax=item.numMax;
            var  type=item.type;
            var  idCharge=item.idCharge;
            var  idRecorder=item.idRecorder;
            var  remark=item.remark;
            html+="<tr><td><input type='checkbox'></td><td>"+id+"</td><td>"+ dateEstablish+"</td><td>"+address+"</td><td>"+ numMax+"</td><td>"+type+"</td><td>"+idCharge+"</td><td>"+idRecorder+"</td><td>"+remark+"</td><td><input type='button' value='删除' class='btn delete'></td></tr>";
        });
        console.log($('#tboby')[0]);
        $('#tbody')[0].innerHTML = html;
    }
    $('.delete').click(function () {
        $('#tbody').innerHTML='';
    });
});

console.log($('#tbody')[0]);