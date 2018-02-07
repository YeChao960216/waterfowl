/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2018-02-05 17:34:16 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-02-06 09:53:03
 */

 /**
  *  MVP_Model层的模块封装
  */
var Model = (function(){

    var M = {};
    
    M.URL = URL;

    M.data = {};

    M.config = {};

    M.initData = function(name,cb){
        ajaxGet(name,cb);
    }
    function ajaxGet(name,cb) {
        var tpl = M.URL[name];
        if(tpl){                //该url存在
            if(M.data[name]){   //如果数据已经被缓存就马上返回，反之就重新缓存
                return M.data[name]
            }
            var xhr = '';
            if(window.XMLHttpRequest){
                xhr = new XMLHttpRequest();//标准浏览器
            }else{
                try{
                    xhr = new ActiveXObject('Msxml.XMLHTTP.6.0');
                }catch(e){
                    xhr = new ActiveXObject('Msxml.XMLHTTP.3.0');
                }
            }
            xhr.open('GET',M.URL.project_name.name+tpl.name,true);
            xhr.onreadystatechange = function(){
                if(xhr.readyState == 4 && xhr.status == 200){
                    var res = JSON.parse(xhr.responseText);
                    var newData  = tpl.dataDescription ? res[tpl.dataDescription] : res;  //这里有list数据描述的，都是一个对象数组所以我就取第一个了
                    M.data[name] = newData ;  //缓存新的数据
                    cb&&cb(newData);
                }
            }

            xhr.onerror = function (err) {
                if(err){
                    console.log(err);
                    return false;
                }
            }

            xhr.send(null);
        }else{
            console.log('该url不存在，请在URL.js文件中补充该url');
            return false;
        }
    }
     function ajaxDIY(tplName,url,cb,dataDescription) {

             var xhr = '';
             if(window.XMLHttpRequest){
                 xhr = new XMLHttpRequest();//标准浏览器
             }else{
                 try{
                     xhr = new ActiveXObject('Msxml.XMLHTTP.6.0');
                 }catch(e){
                     xhr = new ActiveXObject('Msxml.XMLHTTP.3.0');
                 }
             }
             xhr.open('GET',url,true);
             xhr.onreadystatechange = function(){
                 if(xhr.readyState == 4 && xhr.status == 200){
                     var res = JSON.parse(xhr.responseText);
                     var newData  = dataDescription ? res[dataDescription] : res;  //这里有list数据描述的，都是一个对象数组所以我就取第一个了
                     M.data[tplName] = newData ;  //缓存新的数据
                     cb&&cb(newData);
                 }
             }

             xhr.onerror = function (err) {
                 if(err){
                     console.log(err);
                     return false;
                 }
             }
             xhr.send(null);
     }
    return {

        /**
         * 暴露GET SET
         * 下面由于ASI机制我就不写分号了
         */
        getData:function(which,cb){

             if(M.data[which]){
                 cb && cb(M.data[which])
                 return;
             }
             M.initData(which,cb)  //数据没被记录，那么我就初始化数据了，总之presenter一定要得到回应

        },
        setData:function(which,data){

            M.data[which]?'':M.data[which] = data

        },
        getDataDIY:function (tplName,url,dataDescription,cb) {
            ajaxDIY(tplName,url,dataDescription,cb)
        },
        getConfig : function(name){

            return (M.config[name])?M.config[name]:false

        },
        setConfig : function(name,data){

            M.config[name]?'':M.config[name] = data

        },
        getURL : function(name){

            return (M.URL[name])?M.URL[name]:false

        },
        setURL:function(name,data){

            M.URL[name]?'':M.URL[name] = data

        },
    }

})();