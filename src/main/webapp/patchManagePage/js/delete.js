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
        ///生成下拉框的
        $.ajax({
            url: "",
            type: "post",
            dataType: "json",
            success: function () {
                console.log("发送成功！！！");
                $('#idpoultry').append("<input type='text' placeholder='输入养殖批次'>");
                $('#type').append("<option>"+type+"</option>");
                $('#position').append("<option>"+position+"</option>");
                $('#size').append("<option>"+size+"</option>");
                $('#affiliation').append("<option>"+affiliation+"</option>");
            }
        })
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

        //加载整个页面
        $.ajax({
            url:"",
            type:"post",
            dataType:"json",
            // data: {
            //     "idPoultry":$('#idPoultry').val(),//养殖批次
            //     "type":$('#type').val(),//类型
            //     "position":$('#position').val(),//方位
            //     "size":$('#size').val(),//规格
            //     "affiliation":$('#affiliation').val(),//归属的大禽舍
            //     "idFowlery":$('#idFowlery').val(),//使用状态
            //     " idCharge": $('#idCharge').val(),//负责人编号
            //     "idRecorder":$('#idRecorder').val(),//记录者编号
            // },
        })
    });

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