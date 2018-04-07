/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2018-02-05 22:02:45 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-02-06 02:48:15
 */
(function(){

    const G = function (id) {
        return document.getElementById(id);
    }

    var NAV = getRequest();       //上一页传过来的数据对象

    /**
     * 添加组件
     * MVP(组件名，function(M,V){});
     */

    /**
     * 字典翻译
     */
    MVP('dict',function (M,V) {

        if(localStorage.getItem('waterfowl'+10000)){  //如果已经有了字典翻译就不用再次获取了
            return
        }
        M.getData('dict_list',function (data) {
            data.forEach(function (item) {
                localStorage.setItem('waterfowl'+item.id,item.name);
            });
        });

    });

    /**
     *本公司的信息
     */
    MVP('firm',function (M,V) {

        M.getData('firm',function (data) {

            data.forEach(function (item) {

                localStorage.setItem('waterfowl'+item.tid,item.name);
            })

        });

    });

    /**
     * 根据NAV.id
     * 缓存一系列的信息
     */
    MVP('serial_data',function (M,V) {

        /**
         * 下个版本要摆脱这种callback hell
         * 实在恶心
         * 这里从溯源码-》出库数据->idPatch
         */
        M.getDataDIY('this_outPoultry',M.getURL('project_name').name+M.getURL('outpoultry_findById').name+NAV.fowlCode,function (data) {
            if(!NAV.idPatch){
                alert('溯源系统提示:\n\n 关于该溯源码的信息不存在')
                return
            }
            render(V.getTPL('outPoultry'),data,G('outPoultry'));
            NAV.idPatch = data.idPatch;

            /**
             * 该批次信息 idPatch-》idPoultry
             */
            M.getDataDIY('this_patch',M.getURL('project_name').name+M.getURL('patch_findById').name+NAV.idPatch,function (data) {
                render(V.getTPL('patch'),data,G('patch'));
                NAV.idPoultry = data.idPoultry;
                /**
                 *找到入库信息
                 * idPoultry->种苗id
                 */
                M.getDataDIY('this_poultry',M.getURL('project_name').name+M.getURL('poultry_list').name+'?id='+NAV.idPoultry,function (data) {
                    render(V.getTPL('poultry'),data[0],G('poultry'));
                    NAV.idGermchit = data[0].idGermchit;

                    /**
                     *种苗id->种苗信息
                     */
                    M.getDataDIY('this_germchit',M.getURL('project_name').name+M.getURL('germchit_findById').name+NAV.idGermchit,function (data) {
                        render(V.getTPL('germchit'),data,G('germchit'));
                    });

                },'list');
            });

            if(data.nextProcess == '16001'){ //本厂加工
                /**
                 * 出库编号-》加工信息
                 */
                M.getDataDIY('this_manu',M.getURL('project_name').name+M.getURL('manu_list_findByIdPatch').name+'?idPatch='+NAV.fowlCode,function (data) {
                    if(data.length<=0){
                        G('manu').classList.add('none');
                        return
                    }
                    G('manu').classList.remove('none');
                    render(V.getTPL('manu'),data[0],G('manu'));
                },'list');
            }

            /**
             * 出库编号-》运输信息
             * 懒得优化以下的变量搜索链了
             */
            M.getDataDIY('this_transfer',M.getURL('project_name').name+M.getURL('transferInfo_list_findByIdPatch').name+'?idPatch='+NAV.fowlCode,function (res) {

                if(res.list.length<=0){
                    G('transfer').classList.add('none');
                    return
                }
                G('transfer').classList.remove('none');
                render(V.getTPL('transfer'),res.list[res.list.length-1],G('transfer'));//因为数据按时间的降序来排   最后一条是出发地

                /**
                 *获取终点信息
                 */

                M.getDataDIY('this_transfer_end',M.getURL('project_name').name+M.getURL('transfer_end').name+res.list[res.list.length-1].cid,function (cust_info) {
                    /**
                     * 找出终点经纬度，描绘图例，链接轨迹
                     */

                    var trackMap_init = function () {
                            if(cust_info){
                                res.list.reverse();
                                var length = res.list.length;
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

                    }

                    trackMap_init();
                });


            });


            /**
             *养殖视图
             */
            M.getDataDIY('this_aqua_vue',M.getURL('project_name').name+M.getURL('aqua_vue_findByIdPatch').name+ NAV.idPatch+'&name=10000',function (data) {
                // if(data.length<=0){
                //     return
                //     G('transfer').classList.add('none');
                // }
                // G('transfer').classList.remove('none');
                console.log(data);
                var viewdata = {feedWeight:[],weight:[],days:[]};
                data.forEach(function (ele,index) {
                    viewdata.feedWeight.push(ele.feedWeight);
                    viewdata.weight.push(ele.weight);
                    viewdata.days.push('第'+(index+1)+'天');
                });
                willon_option.series[0].data = viewdata.feedWeight;  //饲料量
                willon_option.series[1].data = viewdata.weight;     //重量
                willon_option.xAxis[0].data = viewdata.days;  //天数
                echarts.init(G('aqua_vue')).setOption(willon_option);  //养殖情况的echarts的渲染

            });

            /**
             *死淘视图
             */
            M.getDataDIY('this_ddl_vue',M.getURL('project_name').name+M.getURL('ddl_vue_findByIdPatch').name+ NAV.idPatch,function (data) {
                // if(data.length<=0){
                //     return
                //     G('transfer').classList.add('none');
                // }
                // G('transfer').classList.remove('none');
                if(data.length === 0){
                    G('ddl_vue').classList.add('none');
                    return
                }
                var view_ddl_data = {name:[],data:[]};
                data.forEach(function (ele) {
                    view_ddl_data.name.push(localStorage.getItem('waterfowl'+ele.name));
                    view_ddl_data.data.push({name:localStorage.getItem('waterfowl'+ele.name),value:ele.value});
                });
                willon_option_pie.legend.data = view_ddl_data.name;
                willon_option_pie.series[0].data = view_ddl_data.data;
                echarts.init(G('ddl_vue')).setOption(willon_option_pie);  //DDL情况的echarts的渲染

            });

            /**
             *免疫视图
             */
            M.getDataDIY('this_epi_vue',M.getURL('project_name').name+M.getURL('epi_vue_findByIdPatch').name+ NAV.idPatch,function (data) {
                // if(data.length<=0){
                //     return
                //     G('transfer').classList.add('none');
                // }
                // G('transfer').classList.remove('none');
                if(data.length === 0){
                    G('epi_vue').classList.add('none');
                    return
                }
                var view_epi_data = {name:[],data:[]};
                data.forEach(function (ele) {
                    view_epi_data.name.push(localStorage.getItem('waterfowl'+ele.name));
                    view_epi_data.data.push({name:localStorage.getItem('waterfowl'+ele.name),value:ele.value});
                });
                willon_option_bar.xAxis[0].data = view_epi_data.name;
                willon_option_bar.series[0].data = view_epi_data.data;
                echarts.init(G('epi_vue')).setOption(willon_option_bar);  //免疫情况的echarts的渲染

            });

        });

    });


    /**渲染MVP框架里的所有组件*/
    MVP.init();

})();




