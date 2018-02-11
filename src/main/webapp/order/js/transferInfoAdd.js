/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2018-01-29 20:22:48 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-29 20:36:36
 */

(function () {

    const oURL = {
        PRONAME:'/waterfowl',
        POST:'/transportation/add',
        CHECK:'/transportation/listtransportation?cid=',  //检查是否为发货状态
        GETPATCH:'/admin/patch/listPatch?status=',
        GETTRANSFIRM:'/transcompany/listtranscompany',//运输公司
    }

    /**
     * 存放经纬度
     */
    var address = {
        lng:'',
        lat:''
    }

    /**
     * 上一个页面过来的信息
     */
    var nav = getRequest();

    /**
     * 保存批次信息
     */
    var patchMap =new Map();

    $.get(oURL.PRONAME + oURL.CHECK + nav.cid, function (res) {
        if (res.list.length > 0) {  //更新
            /**
             * 渲染模板
             */
            viewCommand({
                command:'display',
                param:[$('.transferInfoAdd')[0],[],'transferInfoUpdate']
            });

            $('input')[2].value = res.list[0].idPatch;

            $('span').text(res.list[0].curquantity);

            /**
             * 添加物流信息
             */
            $('button')[0].onclick = function () {

                var json = queryParse.call($('form'));

                json.curquantity = res.list[0].curquantity;

                json.idPatch = res.list[0].idPatch;

                json.cid = nav.cid;

                json.curlng = address.lng;

                json.curlat = address.lat;

                $.post(oURL.PRONAME+oURL.POST,json,function (res) {
                    if(res.status){
                        alert('溯源提示:\n\n'+res.msg);  //更新物流信息
                    }else{
                        alert('溯源提示:\n\n'+res.msg);
                    }
                });
            }

        } else {                 //发货
            viewCommand({
                command:'display',
                param:[$('.transferInfoAdd')[0],[],"transferInfoAdd"]
            });
            /**
             * 渲染批次
             */
            $.get(oURL.PRONAME+oURL.GETPATCH+'30004',function (res) {
                if(res.list.length>0){
                    viewCommand({
                        command:'display',
                        param:[$('select')[0],res.list,'id']
                    });

                    $('span').text(res.list[0].size);

                    res.list.forEach(function (ele) {
                        patchMap.set(ele.id,ele.size);
                    });

                }else{
                    $('select')[0].empty();
                }
            });

            /**
             * 渲染运输公司
             */
            $.get(oURL.PRONAME+oURL.GETTRANSFIRM,function (res) {
                if(res.list.length>0){
                    viewCommand({
                        command:'display',
                        param:[$('select')[1],res.list,'tid_name']
                    });
                }

            });

            /**
             * 监听radio数据变化   这里可以做一个缓存以免反复请求相同的数据   我就懒得写了因为要赶时间
             */
            $('[type=radio]').click(function () {
                $.get(oURL.PRONAME+oURL.GETPATCH+$(this).val(),function (res) {
                    if(res.list.length>0){
                        viewCommand({
                            command:'display',
                            param:[$('select')[0],res.list,'id']
                        });
                        $('span').text(res.list[0].size);
                        res.list.forEach(function (ele) {
                            patchMap.set(ele.id,ele.size);
                        });
                    }else{
                        $('select')[0].empty();
                    }
                });
            });

            /**
             * 批次号的变化更新数量的信息
             */
            $('select')[0].onchange = function () {
                $('span').text(patchMap.get(this.value));
            }

            /**
             * 添加物流信息
             */
            $('button')[0].onclick = function () {

                var json = queryParse.call($('form'));

                json.curquantity = patchMap.get($('select')[0].value);

                json.cid = nav.cid;

                json.curlng = address.lng;

                json.curlat = address.lat;

                delete json.status;

                $.post(oURL.PRONAME+oURL.POST,json,function (res) {
                    if(res.status){
                        alert('溯源提示:\n\n'+res.msg);  //更新物流信息
                    }else{
                        alert('溯源提示:\n\n'+res.msg);
                    }
                });
            }

        }

        $('input')[0].value = nav.name;

        $('input')[1].value = nav.phone;
    });




    /**
     * 地图API 这个来不及封装了 后期在优化  请勿模仿这种没有良好复用性的东西
     */


    function G(id) {
        return document.getElementById(id);
    }

    var map = new BMap.Map('l-map');

    // 初始化地图，设置城市和地图级别。
    map.centerAndZoom("广州市海珠区",12);

    //建立一个自动完成的对象
    var ac = new BMap.Autocomplete({
        "input" :'suggestId',
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
        G('searchResultPanel').innerHTML = str;

    });

    var myValue;

    ac.addEventListener ("onconfirm",function(e) { //鼠标点击下拉表后的事件

        var _value = e.item.value;

        myValue =_value.province +_value.city +_value.district +_value.street +
            _value.business;

        console.log(myValue);

        G('searchResultPanel').innerHTML = "onconfirm<br />index =" + e.item.index +"<br/>myValue = " + myValue;

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