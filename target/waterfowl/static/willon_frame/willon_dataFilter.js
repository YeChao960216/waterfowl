/**
 * Created by Willon on 2017/11/9.
 */
/**
 *使用方法
 * var data = dataFilter({
 *              data:arr,
 *              type:type
 *          })
 * @param arr
 */
var DataFilter = function (obj) {
    if(this instanceof DataFilter){
        var instance = new this[obj.type](obj.data);
        return instance;
    }else{
        return new DataFilter(obj);
    }
}

DataFilter.prototype = { 
    userInfo:function (data) {
        this.data = data;
        this.data.forEach(function (val){
            val.gender = (  parseInt(val.gender) === 1) ?  '男':  '女';
            val.entry = val.entry ? new Date(val.entry).toLocaleString():'未办理入职 ';
            val.sign = ( parseInt(val.sign) === 1) ? "<span style='color:#21ce21'>在职</span>":'离职';
            val.rode_id = val.rode_id ? val.rode_id : "<span style='color:#800000'>暂无</span>";
        });
        return this.data;
    },
    filterTimeAndNull:function (data) {
        data.forEach(function (val){
            for(var item in val) {
                if (item === 'recordDate'&& val[item]) {
                    val[item] = new Date(val[item]).toLocaleString();
                } else if (!val[item]) {
                    val[item] = "<span style='color:#800000'>空</span>";
                }
            }
        });
        return data;
    },
    filterTimeAndNull_curDate:function (data) {
        data.forEach(function (val){
            for(var item in val) {
                if (item === 'curdate'&& val[item]) {
                    val[item] = new Date(val[item]).toLocaleString();
                } else if (!val[item]) {
                    val[item] = "<span style='color:#800000'>空</span>";
                }
            }
        });
        return data;
    },
    ddlHomeTypeChange:function (data) {  //{map:HOME_TYPE,source:res}    map , arr
        data.source.forEach(function (ele) {
           ele.name = data.map.get(ele.type);
        });
        return data.source;
    },

}