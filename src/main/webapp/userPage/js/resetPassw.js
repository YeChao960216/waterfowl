(function(){
    const oURL = {
        PRONAME:'/waterfowl',
        //GETINFOBYID:PRONAME+' ?id='+sessionStorage.getItem(willon_id),
        //resetPassw:PRONAME+'',
    }
    $.post(oURL.resetPassw,{"password":$('#password2').val()},function(data){
        if(data){
            alert(data.msg);
        }
    });
    

})();