﻿/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2018-01-15 20:12:31 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-19 22:05:17
 */

/**
 * 折线图的配置
 * @type {{title: {left: string, color: string}, tooltip: {trigger: string, axisPointer: {type: string, label: {backgroundColor: string}}, textStyle: {color: string}}, legend: {data: [*], selected: {饲料投放量: boolean, 该批家禽的重量: boolean}}, toolbox: {feature: {saveAsImage: {}}}, grid: {left: string, right: string, bottom: string, containLabel: boolean}, xAxis: [*], yAxis: [*], series: [*]}}
 */

var willon_option = {
    title: {
        // text: '家禽生长状况图',
        left:'center',
        color:'#333'
    },
    tooltip : {
        trigger: 'axis',
        axisPointer: {
            type: 'cross',
            label: {
                backgroundColor: '#6a7985'
            }
        },
        textStyle:{
            color:'#fff'
        }
    },
    legend: {
        data:['该批家禽的重量','饲料投放量'],
        selected:{
            '饲料投放量':false,
            '该批家禽的重量':true,
        }
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : ['第1天','第2天','第3天','第4天','第5天','第6天','第7天'],
            // name:'天',
            axisLabel: {//x轴文字显示不全并将文字倾斜
                interval:0,
                // rotate:40,
                formatter:function(val){//垂直显示
                    return val.split("").join("\n");
                }
            }
        }
    ],
    yAxis : [
        {
            type : 'value',
            name:'(kg)'
        }
    ],
    series : [
        {
            name:'饲料投放量',
            type:'line',
            stack: '总量1',
            areaStyle: {normal: {color:'#99dc31'}},
            label: {
                normal: {
                    show: true,
                    color:'#333',   //线上点数值颜色
                    // formatter: '{c}(kg)' //点上的单位
                },
            },
            color:'#fff',//圆点颜色
            itemStyle:{          //折线上
                normal:{
                    lineStyle:{
                        color:'#f0f0f0',
                        width:3
                    }
                }
            }
        },
        {
            name:'该批家禽的重量',
            type:'line',
            stack: '总量2',
            areaStyle: {normal: {color:'#31cbdc'}},
            label: {
                normal: {
                    show: true,
                    position: 'top',
                    color:'#333',    //线上点数值颜色
                    // formatter: '{c}(kg)'
                }
            },
            color:'#fff',//圆点颜色
            itemStyle:{          //折线上
                normal:{
                    lineStyle:{
                        color:'#fff',
                        width:3
                    }
                }
            }
        },
        
    ]
};

/**
 * 柱状图的配置
 */


/**
 * 饼状图的配置
 * willon_option_pie.legend,
 * willon_option_pie.series[0].data
 */
var willon_option_pie = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            // data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎'],
            data:[]
        },
        series: [
            {
                name:'访问来源',
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[]
                // data:[
                //     // {value:335, name:'直接访问'},
                //     // {value:310, name:'邮件营销'},
                //     // {value:234, name:'联盟广告'},
                //     // {value:135, name:'视频广告'},
                //     // {value:1548, name:'搜索引擎'}
                // ]
            }
        ]
};
 
 // var Willon_echarts = function(obj){
//    this.dom = obj.dom;
//    this.option = obj.option;
// }
//
// Willon_echarts.prototype = {
//    init:function(){
//        echarts.init(this.dom).setOption(this.option);
//    }
// }
