/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-07 16:17:46 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-08 17:47:29
 * 借助jq表单序列化，其实就是截取了？号后的字符串
 */
/**
 * 使用方法
 * queryParse.call($('form'));
 */
var queryParse = function(){
    //username=13189679384&password=g&gender=男&habby=游泳&habby=唱歌
    var jsonString = decodeURIComponent(this.serialize()),
        queryObj = new Object(),
        jsonArr = jsonString.split('&');
        jsonArr.forEach(function(val,index,arr){
            var attr = val.split('=')[0],
                value = val.split('=')[1];
            if(!queryObj.hasOwnProperty(attr)){
                queryObj[attr] = value;
            }else{
                queryObj[attr] = new Array(queryObj[attr]);
                queryObj[attr].push(value);
            }
        });
        return queryObj;
}
/**
 * 原生js BOM操作处理url
 * 使用方法
 * var id = getRequest()[id];
 */
var getRequest = function(){
    var url = location.search,
        theRequest = new Object();

    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        var strs = str.split("&");
        //将key_value 转化成 theRequset的属性值
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);
        }
    }
    //暴露出去
    return theRequest; 
}



        