(function() {
    const oURL = {
        PRONAME:'/waterfowl',
        GETINFOBYID:PRONAME+' ?id='+sessionStorage.getItem(willon_id),
    }
    // var get = function (id) {
    //     return document.getElementById(id);
    // }
    $.get(oURL.GETINFOBYID,function (data) {
        if(data){
            $('#cellphone')[0].innerHTML = data.cellphone;
            $('#username')[0].innerHTML = data.username;
            $('#name')[0].innerHTML = data.name;
            $('#gender')[0].innerHTML = data.gender;
            $('#entry')[0].innerHTML = data.entry;
            $('#sign')[0].innerHTML = data.sign;
            $('#remark')[0].innerHTML = data.remark;
        }
    })
})();