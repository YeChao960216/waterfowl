(function(){
    const oURL = {
        PRONAME:'/waterfowl',
        resetPassw:'/user/resetPassw',
    }
    $.post(oURL.PRONAME+oURL.resetPassw,{"password":$('#password2').val()},function(data){
        if(data){
            alert(data.msg);
        }
    });

})();