/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 20:17:50 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-19 20:35:00
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
                GETAQUACULTUREDETAILINFO:'../../../aquaculture/show/'
            }
    })();

    /**
     *呈现该禽舍详细信息
     */
    $.get(oURL.PRONAME+oURL.GETAQUACULTUREDETAILINFO+oURL.ID,function (res) {
        if(res){
            /**
             * 数据适配
             */
            // data = new DataFilter({
            //     data:[data],
            //     type:'userInfo'
            // })[0];
            
            var data = res;
            $('#name')[0].innerHTML = data.name || "<span class='red'>空</span>";
            $('#id_fowlery')[0].innerHTML = data.idFowlery  || "<span class='red'>空</span>";
            $('#id_patch')[0].innerHTML = data.idPatch  || "<span class='red'>空</span>";
            $('#num_total')[0].innerHTML = data.numTotal  || "<span class='red'>空</span>";
            $('#feed_type')[0].innerHTML = data.feedType  || "<span class='red'>空</span>";
            $('#feed_weight')[0].innerHTML = data.feedWeight  || "<span class='red'>空</span>";
            $('#record_date')[0].innerHTML = new Date(data.recordDate).toLocaleString()  || "<span class='red'>空</span>";
            $('#id_recorder')[0].innerHTML = data.idRecorder  || "<span class='red'>空</span>";
            $('#id_charge')[0].innerHTML = data.idCharge  || "<span class='red'>空</span>";
            $('#id_outstorage')[0].innerHTML = data.idOutstorage  || "<span class='red'>空</span>";
            $('#status')[0].innerHTML = data.status  || "<span class='red'>空</span>";
            $('#remark')[0].value = data.remark || '';
            
        }else{
            console.error('获取禽舍详细信息失败');
        }
    })

})(this);