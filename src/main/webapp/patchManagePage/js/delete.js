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



    //点击查询按钮
    $('#btn').click(function () {
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
        });


    });
    //加载整个页面
    $.ajax({
        url:"",
        type:"post",
        dataType:"json",
        success: succFunction(data)
    })
    succFunction(data);
    function succFunction(data1) {
        var json = data1;

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
           html="<tr><td><input type='checkbox' class='selectArr'></td><td>"+idPoultry+"</td><td>"+type+"</td><td>"+position+"</td><td>"+size+"</td><td>"+affiliation+"</td><td>"+idFowlery+"</td><td>"+idCharge+"</td><td>"+idRecorder+"</td><td><input type='button' value='删除' class='btn delete' onclick='deleteBtn(this)'></td></tr>";
        });
        $('#tbody').html(html);
    }
    $('.delete').click(function () {
        $('#tbody').innerHTML='';
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


//批量删除
$('#deleteChecked').click(function () {

    //判断是否选择一项
    var checks = $("input[name='check[]']:checked").length;
    if(checks.length == 0)
    {
        alert('未选择任何项!');
        return false;
    }

    if (confirm('确定要删除选择项吗?'))
    {
        //批量选择
        var checkedList = new Array();
        $("input[name='check[]']:checked").each(function () {
            checkedList.push($(this).val());
        });
    }

    $.ajax({
        type:"POST",
        url:"",
        data:{'item':checkedList},
        success:function (result) {
            alert(result);
            window.location.reload();
        }
    })
});