﻿(function () {
    /**
     * BOM 操作 获取url.query ,
     * 使用var val = GetRequest()[key];
     * @returns {Object}
     * @constructor
     */
    function getRequest() {
        var url = location.search;
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
            var str = url.substr(1);
            var strs = str.split("&");
            for (var i = 0; i < strs.length; i++) {
                theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);//将key_value 转化成 theRequset的属性值
            }
        }
        return theRequest; //返回出去
    }

    const oURL = (function () {
            var emp_id = getRequest()[id];
            return {
                EMP_ID : emp_id,
                PORNAME:'/waterfowl',
                SHOWEMPDETAILINFO:'admin/user/show/'+this.EMP_ID
            }
    })();
    /**
     *呈现职员详细信息
     */
    $.get(oURL.PRONAME+oURL.SHOWEMPDETAILINFO,function (data) {
        if(data){
            $('#cellphone')[0].innerHTML = data.cellphone;
            $('#username')[0].innerHTML = data.username;
            $('#name')[0].innerHTML = data.name;
            $('#gender')[0].innerHTML = data.gender;
            $('#entry')[0].innerHTML = data.entry;
            $('#sign')[0].innerHTML = data.sign;
            $('#role_id')[0].innerHTML = data.role_id;
            $('#remark')[0].innerHTML = data.remark;
        }else{
            console.error('获取职员详细信息失败');
        }
    })

})();