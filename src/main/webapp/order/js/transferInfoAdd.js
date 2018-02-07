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
        CHECK:'/transportation/listtransportation',  //检查是否为发货状态
        GETPATCH:'/outpoultry/list?status=',         //选中批次
        GETTRANSFIRM:'/transcompany/listtranscompany?type=17002',//运输公司,
        GETGONGYINGSHANG:'/transcompany/listtranscompany?type=17003',//批发商,
        GETEND:'/transcompany/show/',//得到该批发商的位置也就是物流的终点信息
        CHECKF:'/outpoultry/show/'//查看批次状态是否完成了？
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
    console.log(nav);
    /**
     * 保存批次信息->数量的映射
     */
    var patchMap =new Map();

    $.get(oURL.PRONAME + oURL.CHECK + '?idPatch='+ nav.idPatch, function (res) {
        if (res.list.length > 0) {  //更新
            var length = res.list.length;
            /**
             * 渲染模板
             */
            viewCommand({
                command:'display',
                param:[$('.transferInfoAdd')[0],[],'transferInfoUpdate']
            });

            $('p:eq(0)').text( res.list[0].cid );

            $('p:eq(1)').text( res.list[0].idPatch );


            $('span').text(res.list[0].curquantity);

            $('p:eq(2)').text('运输公司:'+res.list[0].tid);

            /**
             * 找出终点经纬度，描绘图例，链接轨迹
             */
            var trackMap_init = function () {
                $.get(oURL.PRONAME+oURL.GETEND+nav.cid,function (cust_info) {
                    if(cust_info){
                        res.list.reverse();
                        // option.series[0].geoCoord.p1 = [res.list[0].curlng,res.list[0].curlat];//起点
                        res.list.forEach(function (ele,index) {
                            option.series[0].geoCoord['p'+index] = [ele.curlng,ele.curlat]
                        });
                        option.series[0].geoCoord['p'+length] = [cust_info.lng,cust_info.lat]////终点
                        res.list.forEach(function (item,index) {         //描点
                            if(index == 0){
                                option.series[0].markPoint.data[index] = {name:'p'+index,value:60,
                                    tooltip:{
                                        formatter:new Date(item.curdate).toLocaleString()+'<br/>出发地:'+item.remark
                                    },
                                }
                                option.series[0].markLine.data.push(       //连线
                                    [{name: 'p' + index}, {name: 'p' + (index + 1), value: {colorValue: 'green'}}]
                                );
                            }else{
                                if(index == length-1){
                                    option.series[0].markPoint.data[index] = {name:'p'+index,value:100,
                                        tooltip:{
                                            formatter:new Date(item.curdate).toLocaleString()+'<br/>现在到达:'+item.remark
                                        },
                                    }
                                }else{
                                    option.series[0].markPoint.data[index] = {name:'p'+index,value:30,
                                        tooltip:{
                                            formatter:new Date(item.curdate).toLocaleString()+'<br/>经过:'+item.remark
                                        },
                                    }
                                    option.series[0].markLine.data.push(       //连线
                                        [{name: 'p' + index}, {name: 'p' + (index + 1), value: {colorValue: 'green'}}]
                                    );
                                }
                            }
                        });
                        option.series[0].markPoint.data[length] = {name:'p'+length,value:60,   //终点
                            tooltip:{
                                formatter:'物流运输<br/>目的地:'+cust_info.name
                            },
                        }
                        // option.series[0].markLine.data.push(       //起点连终点
                        //     [{name: 'p0'}, {name: 'p'+length, value: {colorValue: 'gold'}}]
                        // );
                        willon_trackVue(res.list[0].curlng,res.list[0].curlat);
                    }
                });
            }

            trackMap_init();
            /**
             * 更新物流信息
             */
            $('button')[0].onclick = function () {
                $.get(oURL.PRONAME+oURL.CHECKF+nav.idPatch,function (resp) {

                    if(resp.status != '30008' && resp.status != '30010'){
                        alert('溯源提示:\n\n该批次状态有误，无法更新物流信息');
                        return
                    }
                    if(resp.status == '30014'){
                        alert('溯源提示:\n\n该批次已经送达目的地，无法更新物流信息');
                        return
                    }
                    if(resp.status != '30014'){   //不等于完成状态 可以提交表单

                        var json = queryParse.call($('form'));

                        json.curquantity = res.list[0].curquantity;

                        json.idPatch = res.list[0].idPatch;

                        json.tid = res.list[0].tid;

                        json.cid = nav.cid;

                        json.curlng = address.lng;

                        json.curlat = address.lat;

                        $.post(oURL.PRONAME+oURL.POST,json,function (respo) {
                            if(respo.status){
                                alert('溯源提示:\n\n'+respo.msg);  //更新物流信息
                                // trackMap_init();
                            }else{
                                alert('溯源提示:\n\n'+respo.msg);
                            }
                        });
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
            if(nav.idPatch && nav.quantity){
                $('select:eq(0)').html("<option value="+nav.idPatch+">"+nav.idPatch+"</option>");
                $('span').text(nav.quantity);
                $('#firmName').val(nav.firm);
                $('.status:eq(0)').addClass('none');
                $('.firmName-select').hide();
            }else{ //全新的发货状态
                $.get(oURL.PRONAME+oURL.GETPATCH+'30007',function (res) { //待运输阶段的出库记录
                    if(res.list.length>0){
                        $('.firmName-p').hide();
                        viewCommand({
                            command:'display',
                            param:[$('select')[1],res.list,'id']
                        });

                        $('span').text(res.list[0].quantity);

                        res.list.forEach(function (ele) {
                            patchMap.set(ele.id,ele.quantity);
                        });

                        /**
                         * 批次号的变化更新数量的信息
                         */
                        $('select')[1].onchange = function () {
                            $('span').text(patchMap.get(this.value));
                        }
                    }else{
                        $('select')[1].empty();
                    }
                });
            }


            /**
             * 渲染运输公司
             */
            $.get(oURL.PRONAME+oURL.GETTRANSFIRM,function (res) {
                if(res.list.length>0){
                    viewCommand({
                        command:'display',
                        param:[$('select')[2],res.list,'tid_name']
                    });
                }
            });
            /**
             * 渲染批发商公司
             */
            $.get(oURL.PRONAME+oURL.GETGONGYINGSHANG,function (res) {
                if(res.list.length>0){
                    viewCommand({
                        command:'display',
                        param:[$('select')[0],res.list,'tid_name']
                    });
                }

            });

            /**
             * 监听radio数据变化   这里可以做一个缓存以免反复请求相同的数据   我就懒得写了因为要赶时间
             */
            $('[type=radio]').click(function () {
                $.get(oURL.PRONAME+oURL.GETPATCH+$(this).attr('data-value'),function (res) {
                    if(res.list.length>0){
                        viewCommand({
                            command:'display',
                            param:[$('select')[1],res.list,'id']
                        });
                        $('span').text(res.list[0].quantity);
                        res.list.forEach(function (ele) {
                            patchMap.set(ele.id,ele.quantity);
                        });
                    }else{
                        $('select')[1].innerHTML = '';
                    }
                });
            });



            /**
             * 添加物流信息
             */
            $('button')[0].onclick = function () {

                var json = queryParse.call($('form'));

                json.curquantity = nav.quantity || patchMap.get($('select')[1].value);

                nav.cid?json.cid = nav.cid :'';

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