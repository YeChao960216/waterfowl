(function(){
    const oURL = {
        PRONAME:'/waterfowl',
        resetPassw:'/admin/user/edit/',
    }
    $('#submit').click(function () {
        $.post(oURL.PRONAME+oURL.resetPassw+localStorage.getItem('uId'),{"password":md5($('#password2').val())},function(data){
            if(data){
                alert(data.msg);
            }else{
                alert('修改失败！');
            }
        });
    });
})();