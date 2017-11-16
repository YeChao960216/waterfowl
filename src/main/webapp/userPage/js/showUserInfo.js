(function() {
    const oUrl = {
        PRONAME:'/waterfowl',
        GETINFO:'/user/nowUserInfo'
    }
    // var get = function (id) {
    //     return document.getElementById(id);
    // }
    $.get(oUrl.PRONAME+oUrl.GETINFO,function (data) {
        if(data){
            $('#cellphone')[0].innerHTML = data.phone || '信息未完善';
            $('#username')[0].innerHTML = data.username || '信息未完善';
            $('#name')[0].innerHTML = data.name || '信息未完善';
            $('#gender')[0].innerHTML = data.gender || '信息未完善';
            $('#entry')[0].innerHTML = new Date(data.entry).toLocaleString() || '信息未完善';
            $('#sign')[0].innerHTML = (data.sign)? '在职':'离职';
            $('#remark')[0].innerHTML = data.remark || '信息未完善' ;
        }
    })
})();