
var option = {

    color: ['gold','aqua','lime'],
    title : {
        text: '',
        subtext: '',
        x:'center',
        textStyle : {
            color: '#fff',
            fontSize:20,
            fontWeight:'bold',
        }
    },
    tooltip : {
        show: true,
        trigger:'item',
        hideDelay:4000,
        formatter: function(d) {
            var jw= '经度：'+d.value[0]+'<br/>'
                jw += '纬度：'+d.value[1]
            return jw       
        }
    },
    color:['gold','red'],
    legend:{
        data:['物流路线'],
        x:'left',
        orient:'vertical',
        padding:[30,15,15,30],
        textStyle:{
            fontSize:17,
            color:'rgb(204,204,204)',
        },
        selected:{
            '物流路线':true,
        },
        selectedMode:'single',
    },
    /*
    toolbox: {
        show : true,
        orient : 'vertical',
        x: 'right',
        y: 'center',
        feature : {
           mark : {show: true},
           dataView : {show: true, readOnly: false},
           restore : {show: true},
           saveAsImage : {show: true}
        }
    },*/
  series : [
{
      name:'物流路线',
      type:'map',
      mapType: 'none',
      data:[],

      markLine : {
        Symbol:['none', 'arrow'],
        symbolSize:['0', '0.1'],
        smooth:true,
        smooth:0,
        effect : {
            show: true,
            scaleSize: 1,
            period: 30,
            color: '#fff',
            shadowBlur: 10
        },
        itemStyle : {
            color: 'red',
            normal: {
                color:function(param){
                return(param.data[0].value.colorValue);
                },
                borderWidth:3,
                lineStyle: {
                    type: 'solid',
                    width: 3,
                    shadowBlur: 10
                },
                //   label:{show:true,value:'天河城'}
            }
        },

        data : [       //起点与终点的连线
                    // [{name:'p1'}, {name:'p15',value:{colorValue:'gold'}}],
            ]
     },
      markPoint:{
            symbol:'image://./image/location.svg',  //悬浮物
            symbolSize:function(v){
                return v/5
            },
            effect:{
                show:true,
                type:'bounce',
                period:3,               
            },
            itemStyle:{
                normal:{
                    label:{
                        show:false,
                    },
                },
                emphasis:{
                    label:{
                        show:false,
                    },
                },
            },
            data:[
               // {name:'p1',value:80,
               //     tooltip:{
               //         formatter:'时间:8:30am<br/>出发地:'
               //     },
               // },
               // {name:'p6',value:200,
               //     tooltip:{
               //         formatter:'天河城<br/>经度:113.328755<br/>纬度:23.137588'
               //     },
               // },
            ],
        },
      geoCoord:{
                 // 'p1':[113.317568,23.135959],
                 // 'p2':[113.317783,23.135278],
                 // 'p3':[113.321489,23.135432],
                 // 'p4':[113.321525,23.135282],
                 // 'p5':[113.321592,23.13517],
                 // 'p6':[113.321799,23.135083],
                 // 'p7':[113.322158,23.135141],
                 // 'p8':[113.322374,23.135378],
                 // 'p9':[113.321992,23.135847],
                 // 'p10':[113.322243,23.13949],
                 // 'p11':[113.322396,23.1397],
                 // 'p12':[113.328163,23.13943],
                 // 'p13':[113.334945,23.139033],
                 // 'p14':[113.334658,23.133217],
                 // 'p15':[113.33313,23.13222],
                 // 'p16':[113.328755, 23.137588]
    }
},

    ]
};