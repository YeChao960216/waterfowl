/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-10-23 20:32:42 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-10-24 13:18:58
 * ajax的简单封装
 */
/**
 * 使用方法ajax.get(url,cb);
 * 使用方法ajax.get(url,query,cb);
 */
var ajax = (function(){
    var xhr = null;
    if(window.XMLHttpRequest){
        xhr = new XMLHttpRequest();
    }else{
        xhr = new ActiveXObject() || new ActiveXObject('Msxml2.XMLHTTP.3.0')||new ActiveXObject('Msxml2.XMLHTTP.6.0');
    }
    return{
        get:function(url,cb){
            //xhr.withCredentials = true;
            xhr.open('GET',url,true);
            xhr.send(null);
            xhr.onreadystatechange = function(){
                if(xhr.readstate==4){ //数据发送
                    if(xhr.status==200){//服务器成功相应
                        if(typeof xhr.responseText == 'json'){
                            cb&&cb(xhr.responseText);
                        }else{
                            cb&&cb(JSON.parse(xhr.responseText));
                        }
                    }
                }
            }
        },
        post:function(url,query,cb){
            xhr.setRequestHeader('Content-Type','application/x-www-form-urlencode');
            xhr.open('POST',url,true);
            xhr.send(query);
            xhr.onreadystatechange = function(){
                if(xhr.readstate==4){ //数据发送
                    if(xhr.status==200){//服务器成功相应
                        if(typeof xhr.responseText == 'json'){
                            cb&&cb(xhr.responseText);
                        }else{
                            cb&&cb(JSON.parse(xhr.responseText));
                        }
                    }
                }
            }
        }
    }
})();


