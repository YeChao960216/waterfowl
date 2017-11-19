var data=[{
    type:"鸭子",
    size:100,
    position:"东",
    size:100,
    status:"满员",
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
                "type":$('#type').val(),//养殖类型
                "position":$('#position'),//方位
                "size":$('#size').val(),//规格
                "status":$('#status').val(),//使用状态
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
            var  type=item.type;
            var  position=item.position;
            var  size=item.size;
            var  status=item.status;
            var  idCharge=item.idCharge;
            var  idRecorder=item.idRecorder;
            html+="<tr><td><input type='checkbox' class='selectArr'></td><td>"+type+"</td><td>"+position+"</td><td>"+size+"</td><td>"+status +"</td><td>"+idCharge+"</td><td>"+idRecorder+"</td><td><input type='button' value='删除' class='btn delete'></td></tr>";
        });
        console.log($('#tboby')[0]);
        $('#tbody')[0].innerHTML = html;
    }
    $('.delete').click(function () {
        $('#tbody').innerHTML='';
    });
});

/*
*点击删除按钮
*/
//处理全选/不选
document.getElementById('checkAll').onclick=function () {
    //获取所有的复选框
    var checkElements = document.querySelectorAll('[type=checkbox]');
    console.log(checkElements,checkElements.length);
    if (this.checked)
    {
        for (var i=1;i<checkElements.length;i++)
        {
            var checkElement=checkElements[i];
            //方法一
            // chenkElement.setAttribute('checked','checked');
            //方法二
            checkElement.checked=true;
        }
    }
    else
    {

        for (var i=1;i<checkElements.length;i++)
        {
            var checkElement=checkElements[i];
            //方法一
            // chenkElement.setAttribute('checked','checked');
            //方法二
            checkElement.checked=false;
        }
    }
}

$('#deleteAll').onclick=function () {
    $('#tbody td').innerHTML="";
}