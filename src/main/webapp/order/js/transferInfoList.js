/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 20:06:12 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-30 19:45:29
 */

(function(){
    
        /**
         * oURL 对象
         */
        const oURL = {
            PRONAME:'/waterfowl',
            GETLIST:'/dict/list?pid=',
            GETINFOLIST:'/outpoultry/list',
            DEL:'/transportation/delete/',
            FINISHTRAN:'/transportation/finishTrans'
        };

    /**
     * 实例化一个分页控制者
     */
    var pageController = new PageController({

        url:oURL.PRONAME+oURL.GETINFOLIST,

        view:{
            container : $('#content')[0],
            tpl:'outPoultry_for_transferInfos',
            nowView:$('#now')[0],
            allView:$('#all')[0],
        },
        pageBean:{
            pageDescription:'pageNum',
            countDescription:'pageSize',
            dataDescription:'list',
            totalDescription:'pages',
            count:'10',
        },
        dataFilter:{
            tpl:'filterTimeAndNull_curDate'
        },
        dom:{
            nextBtn :$('#next')[0],
            preBtn:$('#pre')[0],
            jumpBtn:$('#jumpTo')[0],
            jumpVal:$('#jumpText')[0],
        },

    });

    /**
     * 依据罗列出的批次的状态，来呈现物流信息
     */
    $.get(oURL.PRONAME+oURL.GETLIST+30000+'&pageSize=1000&pageNum=1',function(res){
        if(res.list.length>0){
            var data = res.list.filter(function(item){
                return (+item.id === 30014 ||  +item.id >= 30007 && +item.id <= 30012)
            });
            viewCommand({
                command:'display',
                param:[$('select')[0],data,'id_name']
            });
            pageController.other = '&status='+$('select')[0].value;
            pageController.init();
        }
    })

    /**
     *监听下来选线框的变化
     */
    $('select')[0].onchange = function(){
        pageController.other = '&status='+this.value;
        pageController.init();

    }

    /**
     * 查询功能
     * 点击了就序列化表单
     * 更改视图控制器的other属性
     * 初始化页面
     */
    $('#search').click(function () {
        var q = queryParse.call($('#searchForm'));
        var qStr = [];
        for(var key in q) {
            if (!q[key]) {
                delete q[key];
                continue;
            }
            qStr.push(key+'='+q[key]);
        }
        $('#back').show();
        pageController.other = '&'+qStr.join('&');
        pageController.init();
    });

    /**
     * 返回键
     * 每当成功查找出一项时 此按钮显示
     * 此按钮被按下时
     *      清空查询表单的字
     *      并初始化页面
     */
    $('#back').click(function () {
        $('#searchForm input').val('');
        $(this).hide();
        pageController.other = '';
        pageController.init();
    });

    
    /**
     * 提交的id值
     1、成功后，跳转到对应id的所有物流记录
     */
    $('#content').on('click',"[data-id*='look']",function(){
        var id = $(this).attr('data-id').substr(4);
        window.location.href = './transferInfoDetail.html?idPatch='+id;

    });


    /**
     * 提交的id值
     1、成功后，跳转到对应id的所有物流记录
     */
    $('#content').on('click',"[data-ok*='ok']",function(){
        if(confirm('溯源提示:\n\n确认完成配送吗？')){
            var id = $(this).attr('data-ok').substr(2);
            new Image().src = oURL.PRONAME+oURL.FINISHTRAN+'?idPatch='+id;
            pageController.init();
        }
    });

})();