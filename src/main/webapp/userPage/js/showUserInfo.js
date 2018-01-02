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
            $('#cellphone')[0].innerHTML = data.phone || "<span class='red'>信息未完善</span>";
            $('#username')[0].innerHTML = data.username || "<span class='red'>信息未完善</span>";
            $('#name')[0].innerHTML = data.name || "<span class='red'>信息未完善</span>";
            $('#gender')[0].innerHTML = data.gender==1? "男":"女";
            $('#entry')[0].innerHTML = new Date(data.entry).toLocaleString() || "<span class='red'>信息未完善</span>";
            $('#sign')[0].innerHTML = (data.sign)? '在职':'离职';
            $('#remark')[0].innerHTML = data.remark || "<span class='red'>信息未完善</span>" ;
        }
    })
})();