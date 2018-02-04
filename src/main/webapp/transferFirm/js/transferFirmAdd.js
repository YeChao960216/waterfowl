/*
 * @Author: 伟龙-Willon qq:1061258787
 * @Date: 2017-11-19 17:42:59
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-29 21:34:08
 */

(function(){

    /**
     * url 对象
     */
    const oURL = {
        PRONAME : '/waterfowl' ,
        GETCOMTYPE:'/dict/list?pid=17000',//获取公司类型
        POST : '/transcompany/add',//最终数据提交路径
    }

    /**
     * 存放经纬度
     */
    var address = {
        lng:'',
        lat:''
    }

    $.get(oURL.PRONAME+oURL.GETCOMTYPE,function (res) { //渲染公司类型
        if(res.list.length>0){
            viewCommand({
               command:'display',
                param:[$('#type'),res.list,'id_name']
            });
        }else{
            alert('溯源提示:\n\n公司类型这一栏目的资料为空，请前往栏目管理模块中添加');
        }
    });
    /**
     * 提交表单
     */
    $('#submit')[0].onclick = function(){
        var json = queryParse.call($('form'));
            if(address.lat){
                $.post(oURL.PRONAME+oURL.POST,json,function(res){
                    if(res.status){
                        alert('溯源提示:\n\n'+res.msg);
                    }else{
                        alert('溯源提示:\n\n'+res.msg);
                    }
                });
            }else{
                alert('溯源提示:\n\n运输公司地址没选中，请点击提示词条确认地址');
            }

    }

    function G(id) {
        return document.getElementById(id);
    }
    var map = new BMap.Map("l-map");

    // 初始化地图，设置城市和地图级别。
    map.centerAndZoom("广州市海珠区",12);

    //建立一个自动完成的对象
    var ac = new BMap.Autocomplete({
        "input" :"suggestId",
        "location": map
    })

    ac.addEventListener("onhighlight",function(e) {//鼠标放在T 拉列表上的事件
        var str = "";

        var _value = e.fromitem.value;

        var value = "";

        if (e.fromitem.index >-1) {
            value =_value.province +_value.city +_value.district +_value.street +
            _value.business ;
        }

        str = "FromItem<br />index = "+ e.fromitem.index + "<br/>value = " + value;

        value ="";

        if (e.toitem.index >-1) {
            _value = e.toitem.value;
            value =_value.province +_value.city +_value.district +_value.street +
            _value. business ;
        }

        str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = "+ value;
        G("searchResultPanel").innerHTML = str;

    });

    var myValue;
    G('suggestId').onblur = function () {

    }
    ac.addEventListener ("onconfirm",function(e) { //鼠标点击下拉表后的事件

        var _value = e.item.value;

        myValue =_value.province +_value.city +_value.district +_value.street +
        _value.business;

        console.log(myValue);

        G("searchResultPanel").innerHTML = "onconfirm<br />index =" + e.item.index +"<br/>myValue = " + myValue;

        setPlace();

    });
    
    function setPlace(){
    
        map.clearOverlays();//清除地图上所有覆盖物

        function myFun(){
            var pp = local.getResults().getPoi(0).point; //获取第一个智能搜索结果
            
            address.lng = pp.lng; //经

            address.lat = pp.lat; //纬
            console.log(address);
            map.centerAndZoom(pp,18);
            
            map.addOverlay(new BMap.Marker(pp));//添加标注
        }

        var local = new BMap.LocalSearch(map,{ //搜
            onSearchComplete:myFun
        });
        
        local.search(myValue);
    };

})();