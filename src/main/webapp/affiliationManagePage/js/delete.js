var data=[{
    type:"鸭子",
    position:"东",
    size:100,
    status:"满员",
    idRecorder:"wenzhi",
    idCharge:"zhuowenzhi"
}];

var data1=[{
    type:["鸭子1","鸭子2","鸭子3"],
    size:[99,100,101],
    position:["东","西","南"],
    status:["满员","不满员"]
}]
var type=[{
    type:["鸭子1","鸭子2","鸭子3"]

}];
var size=[{
    size:[99,100,101]

}];
var position=[{
    position:["东","西","南"]
}]
var status=[{
    status:["满员","不满员"]
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
    success:function (data1) {
        console.log(1);
        for(var i=0;i<type.length;i++)
        {
            $("#type").append("<option>"+type[i]+"</option>");
        }
        for (var j=0;j<size.length;j++)
        {
            $("#size").append("<option>"+size[j]+"</option>");
        }
        for(var m=0;m<status;m++)
        {
            $("#status").append("<option>"+status[m]+"</option>");
        }
        for(var n=0;n<position;n++)
        {
            $("#position").append("<option>"+position[n]+"</option>");
        }
    },
    error:function(){
        console.log(1);
    }
})



    //点击查询按钮的
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
        success:succFunction(data)
    })
    succFunction(data);
    function succFunction(data1) {

        var json = data1;
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
            html="<tr>" +
                "<td><input type='checkbox' class='selectArr'></td>" +
                "<td>"+type+"</td>" +
                "<td>"+position+"</td>" +
                "<td>"+size+"</td>" +
                "<td>"+status +"</td>" +
                "<td>"+idCharge+"</td>" +
                "<td>"+idRecorder+"</td>" +
                "<td><input type='button' value='' class='btn delete' onclick='deleteBtn(this)' name='delete'></td></tr>";
        });
        $('#tbody').html(html);
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

//点击删除按钮
function deleteBtn(obj)
{
    var tr=obj.parentNode.parentNode;//得到按钮[obj]的父元素[td]的父元素[tr]
    tr.parentNode.removeChild(tr);//从tr的父元素[tbody]移除tr
}

/*全部删除*/
/*
function batchDelete() {
    //判断至少选择一项
    var checkedNum = $("input[name='delete']:checked").length;
    if(checkedNum == 0)
    {
        alert("至少选择一项删除!");
        return;
    }
    if(confirm("确定删除数据？"))
    {
        var deleteList = new Array();
        $("input[name='delete']:checked").each(function () {
            deleteList.push($(this).val());
        })
    }
    $.ajax({
        type:"POST",
        url:"",
        data:{deleteList:deleteList.toString()},
        success:function ()
        {
            alert("删除成功");
            location.reload();
        },
        error:function () {
            alert("删除失败!");
        }
    })
}*/