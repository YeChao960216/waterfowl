/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 17:42:59 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-22 20:44:37
 */

 (function(){

    /**
     * url 对象
     */
    const oURL = {
        PRONAME : '/waterfowl' ,
        POST : '/outstorage/excel/pull',//最终数据提交路径
    }
    
    var filesObj = null ,progress = $('#progress')[0];

    $('#progressTr').hide();
    

    $('[type*=file]')[0].onchange = function(){
        filesObj = this.files[0];
        console.log(filesObj);
    }
    /** 
     * 提交表单
     */
    $('#submit')[0].onclick = function(){
        var fd = new FormData(),xhr = new XMLHttpRequest() || new ActiveXObject();
            fd.append('xls',filesObj);
            xhr.open('POST',oURL.PRONAME+oURL.POST,true);
            xhr.upload.onprogress = function(ev){
                var percent = (100*ev.loaded/ev.total).toFixed(2);
                progress.style.width = percent + '%';
                progress.innerText = percent + '%';
            }
            xhr.send(fd);
    }
    
 })();