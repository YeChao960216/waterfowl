/*
*点击删除按钮
*/
function delete(id){
    if (confirm("确认删除吗？"))
    {
        window.event.returnValue = true;
    }
    else
    {
        window.event.returnValue=false;
    }
    if (window.event.returnValue==true)
    {
        $.ajax({
            url:'',
            type:'POST',
            data:{id:id},
            datatype:'text',
            success:success,
            error:error,
        });
    }
    else{

    }
}
function success(data){
    //局部刷新
    //window.parent.location.reload();
    $('body').html(data);
}
function error(){
    alert('删除失败!!!');
}