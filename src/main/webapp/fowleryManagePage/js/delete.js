var data=[{
    size:100,
    status:"可用",
    affiliation:"归属的大禽舍1",
    idRecorder:"wenzhi",
    idCharge:"zhuowenzhi"
}];


var size=[{
    size:[99,100,101]

}];
var status=[{
    status:["满员","未满员"]

}];
var affiliation=[{
    affiliation:["东1","西2","南3"]
}]
var data3=[{
    size:99,
    affiliation:"东1"
}]


//先从数据字典获取所有的数据生成下拉框
$.ajax({
    url:"",
    datatype:"post",
    success:function (data3) {
        for (var j=0;j<size.length;j++)
        {
            $("#size").append("<option>"+size[j]+"</option>");
        }
        for (var j=0;j<status.length;j++)
        {
            $("#status").append("<option>"+status[j]+"</option>");
        }

        for(var n=0;n<affiliation;n++)
        {
            $("#affiliation").append("<option>"+affiliation[n]+"</option>");
        }
    }
})

$(function () {

    // $('#btn').click(function () {
    //     //Ajax先获取后台传来的size值生成下拉框，status生成显示的可用状态，归属的大禽舍的下拉框，负责人，记录人
    //     $.ajax({
    //         url:"",
    //         type:"POST",
    //         seccess:function (data) {
    //             console.log("Ajax先获取后台传来的size值生成下拉框，status生成显示的可用状态，归属的大禽舍的下拉框");
    //             console.log("-------success----");
    //             $('#size').append("<option value='"+size+"'>"+"规格"+size+"</option>");
    //             $('#status').append("<option value='"+status+"'>"+"使用状态"+size+"</option>");
    //             $('#affiliation').append("<option value='"+affiliation+"'>"+"大禽舍"+affiliation+"</option>");
    //             $('#idCharge').append("<option value='"+idCharge+"'>"+"负责人"+idCharge+"</option>");
    //             $('#idRecorder').append("<option value='"+idRecorder+"'>"+"记录者"+idRecorder+"</option>");
    //         }
    //     });


        //点击查询按钮发送数据
        //把size发送到字典，返回数据生成下拉框，status只允许显示，不能修改
        $('#btn').click(function () {
            $.ajax({
                url:"",
                type:"POST",
                datatype:"json",
                data:{
                    "size":$('#size').val(),//规格字典查
                    "status":$('#status').val()
                },
                success:function(data){
                    console.log("传送规格成功");
                    console.log("传送状态成功");
                }
            });

            //归属的大禽舍,大禽舍表查
            $.ajax({
                url:"",
                type:"POST",
                datatype:"json",
                data:{
                    "affiliation":$('#affiliation').val()//归属的大禽舍,大禽舍表查
                },
                success:function(data){
                    console.log("传送归属的大禽舍成功");
                    for(var i=0;i<affiliation.length;i++)
                    {
                        $('#affiliation').append("<option value='"+affiliation+"'>"+"大禽舍"+affiliation+"</option>");

                    }

                }
            });

            //负责人编号，user表查,记录者编号，user表查,返回所有表格的数据
            $.ajax({
                url:"",
                type:"POST",
                datatype:"json",
                data:{
                    "idCharge": $('#idCharge').val(),//负责人编号，user表查
                    "idRecorder":$('#idRecorder').val(),//记录者编号，user表查
                },
                success:function(data){
                    console.log("传送归属的负责人编号成功,记录者编号");
                },
            });
        });

        //显示页面的所有记录
        $.ajax({
            url:"",
            type:"post",
            dataType:"json",
            // data: {
            //     "size":$('#size').val(),
            //     "status":$('#status').val(),
            //     "affiliation":$("#affiliation"),
            //     "idRecorder":$('#idRecorder').val(),
            //     "idCharge": $('#idCharge').val()
            // }
        })
    var html = '';
    succFunction(data);
    function succFunction(obj) {
        var json = data;

        $.each(json,function (index,item) {
            //循坏数据
            alert(item);
            var  size=item.size;
            var  status=item.status;
            var  affiliation=item.affiliation;
            var  idCharge=item.idCharge;
            var  idRecorder=item.idRecorder;
                 html="<tr><td><input type='checkbox' class='checkArr'></td><td>"
                    +size+"</td><td>"
                    +status+"</td><td>"
                    +affiliation+"</td><td>"
                    +idCharge+"</td><td>"
                    +idRecorder+"</td><td>" +
                    "<input type='button' value='删除' class='btn delete' onclick='deleteBtn(this)'></td></tr>";
        });
        $('#tbody').html(html);
    };
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

//点击按钮删除
function deleteBtn(obj)
{
    var tr=obj.parentNode.parentNode;//得到按钮[obj]的父元素[td]的父元素[tr]
    tr.parentNode.removeChild(tr);//从tr的父元素[tbody]移除tr
}

//全部删除
