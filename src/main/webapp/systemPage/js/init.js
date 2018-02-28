(function(){
    if(navigator.userAgent.indexOf("iPhone") > 0 || navigator.userAgent.indexOf("Android") > 0 || navigator.userAgent.indexOf("iPod") > 0) {
        window.location.href = '../404.html';
    }else{
    /*
    *调整页面大小，铺满全屏
    */

    // $.get('/waterfowl/user/nowUserInfo',function (data) {
    //     if(data){
    //         get('user').innerHTML = data.username;
    //         //save('willon_user_id',data.id,'保存id值失败');//
    //     }
    // });
    var initF = function(){
        var W = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
        var H = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
        get('baseFrame').style.width = W + 'px';
        get('baseFrame').style.height = H + 'px';
    }
    initF();
    window.onresize = function(){
        initF();
    }

    $.get('/waterfowl/user/nowUserInfo',function (res) {
        if(res){
            $('#user').text(res.name);
            localStorage.setItem('uId',res.id);
        }else{
            window.location.href = './loginPage/login.html';
        }
    });
    /*
    *显示当前时间
    */
    get('nowTime').innerHTML = new Date().toLocaleString();
    var timer = setInterval(function(){
        get('nowTime').innerHTML = new Date().toLocaleString();
    },1000);
    /*
    *设置iframe的路由
    */
    get('paths').onclick = function(e){
        e = e || window.event;
        var target = e.target?e.target:e.srcElement;
        if(target.tagName=='SPAN'&&target.innerText!=''&&target.innerText!='#'){
            get('whichPage').src=target.getAttribute('data-href');
            var tid = parseInt(target.parentNode.id.substr(4));
            if(tid==1){
                emptyPath(tid+1);
            }
        }else{
            return;
        }
    }
    }

    /**
     * 注销
     */
    document.getElementById('login-out').onclick = function () {
        window.location.href = './loginPage/login.html';
    }

    /**
     * 缓存字典信息
     */
    $.get('/waterfowl/dict/list?pageSize=1000&pageNum=1',function (res) {
       if(res){
            res.list.forEach(function (ele) {
                if(ele.id){
                    localStorage.setItem('waterfowl'+ele.id,ele.name);
                }
            });
       }else{
           alert('溯源提示:\n\n获取栏目信息失败，可能会造成某些字段晦涩难懂');
       }
    });
})();
/*
*一定要用这个设置路径显示,路径目前最多三层
*/
function get(id){
    return document.getElementById(id);
}
function setPath(num,url,content){
    var path = document.getElementById('path'+num);
    path.innerHTML = "<span class='pointer' data-href='"+url+"' title='"+content+"'>"+content+"</span><i>&gt</i>";
    path.style.display = 'inline-block';
}
function emptyPath(num){
    num = Math.min(num,3);
    var path = document.getElementById('path'+num);
    (!document.getElementById('path'+(num+1)).innerText)?path.innerHTML = '':alert('移除路径失败，请你先移除路径'+num+'之后路径');
    path.style.display = 'none';
}

function displayPath(num){
    get('whichPage').src = get('path'+num).firstChild.getAttribute('data-href');

}

