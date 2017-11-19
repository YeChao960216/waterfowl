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
            var emp_id = getRequest()['id'];
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
                EMP_ID : emp_id,
                PORNAME:'/waterfowl',
                GETAQUACULTUREDETAILINFO:'../../../aquaculture/getById'
            }
    })();

    /**
     *呈现该禽舍详细信息
     */
    $.get(oURL.PRONAME+oURL.GETAQUACULTUREDETAILINFO+oURL.EMP_ID,function (res) {
        if(res){
            /**
             * 数据适配
             */
            // data = new DataFilter({
            //     data:[data],
            //     type:'userInfo'
            // })[0];
            
            var data = res.data;
            $('#name')[0].innerHTML = data.name;
            $('#id_fowlery')[0].innerHTML = data.id_fowlery;
            $('#id_patch')[0].innerHTML = data.id_patch;
            $('#num_total')[0].innerHTML = data.num_total;
            $('#feed_type')[0].innerHTML = data.feed_type;
            $('#feed_weight')[0].innerHTML = data.feed_weight;
            $('#record_date')[0].innerHTML = data.record_date;
            $('#id_recorder')[0].innerHTML = data.id_recorder;
            $('#id_charge')[0].innerHTML = data.id_charge;
            $('#id_outstorage')[0].innerHTML = data.id_outstorage;
            $('#status')[0].innerHTML = data.status;
            $('#remark')[0].value = data.remark;
            
        }else{
            console.error('获取禽舍详细信息失败');
        }
    })

})(this);