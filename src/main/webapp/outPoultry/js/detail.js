/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 20:17:50 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-21 14:25:21
 */

(function (global) {
    /**
     * BOM 操作 获取url.query ,
     * 使用var val = GetRequest()[key];
     * @returns {Object}
     * @constructor
     */
    const oURL = (function () {
            var id = getRequest()['id'];
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
            return {
                ID : id,
                PORNAME:'/waterfowl',
                GETOUTPOULTRYLINFO:'../../../outpoultry/show/'
            }
    })();

    /**
     *呈现该禽舍详细信息
     */
    $.get(oURL.PRONAME+oURL.GETOUTPOULTRYLINFO+oURL.ID,function (res) {
        if(res){
            /**
             * 数据适配
             */
            // data = new DataFilter({
            //     data:[data],
            //     type:'userInfo'
            // })[0];
            
            var data = res;
            $('#type')[0].innerHTML = data.type;
            $('#id_patch')[0].innerHTML = data.idPatch;
            $('#quantity')[0].innerHTML = data.quantity;
            $('#unit')[0].innerHTML = data.unit;
            $('#firm')[0].innerHTML = data.firm;
            $('#phone')[0].innerHTML = data.phone;
            $('#id_recorde')[0].innerHTML = data.idRecorde;
            $('#id_charge')[0].innerHTML = data.idCharge;
            $('#remark')[0].value = data.remark;
            
        }else{
            console.error('获取出库详细信息失败');
        }
    })

})(this);