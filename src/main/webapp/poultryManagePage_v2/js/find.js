﻿/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 20:06:12 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-19 20:07:52
 */

(function(){
    
        /**
         * oURL 对象
         */
        const oURL = {
            PRONAME:'/waterfowl',
            GETAQUACULTURELIST:'/poultry/list',
            GETINFOBYPID:'/poultry/selectBy/',
            GETPOSITON:'/dict/list?pid=70000',
            GETHOMETYPE:'/dict/list?pid=60000',
            GETBHOME:'/admin/affiliation/listAffiliation',
            GETSHOME:'/admin/fowlery/listFowlery',
            GETEMP:'/admin/user/list',//查找人元,
            PPOST:'/admin/patch/newPatch',//增加批次
            CHECKPACTH:'',//级联检查
            GETPATCHBYPOULTRYID:'',//获取该厂家的所有批次号
            GETSTATUSLIST:'/getDicName/getStatus',//获取禽类养殖标识
            GETMATERIL:'/outstorage/listName/65001',  //饲料名称
            GETLASTMATERILNUM:'/aquaculture/checkQuantity/',  //饲料剩余量
            APOST : '/aquaculture/add',//最终养殖提交路径
            OPOST:'/outpoultry/add',//出厂路径
            GETFINDPATCHBYPID:'/admin/patch/findPatchByPid/',//{id_p}通过PID查找所有已经划分的批次
            GETLASTNUM:'/admin/patch/isEqualSum/',//{id_p}通过PID查出我还能圈养多少只
            // GETTYPEBYPOSITION:'/admin/patch/listtype',//position -> type
            GETTYPEBYPOSITION:'/admin/affiliation/listAffiliation',//position  type -> id_affi
            GETPATHBYID:'/admin/patch/showPatch/',//id->ptachInfo
            GETPMODE:'/dict/list?pid=95000',//从字典里面获取丢失方式
            DDLPOST:'/ddl/save',
            GETMAXFOOD:'',//
            GETAQUABYPATCH:'/aquaculture/list?idPatch='//根据批次号返回养殖的记录 测试接口 后面会有一个更新的
            };
    /**
     * 实例化一个分页控制者
     */
    var pageController = new PageController({

        url:oURL.PRONAME+oURL.GETAQUACULTURELIST,

        view:{
            container : $('#content')[0],
            tpl:'poultry_find',
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
            tpl:'filterTimeAndNull',
        },
        dom:{
            nextBtn :$('#next')[0],
            preBtn:$('#pre')[0],
            jumpBtn:$('#jumpTo')[0],
            jumpVal:$('#jumpText')[0],
        },

    });

    /**
     * 初始化视图,绑定事件操作，分页功能完成
     */
    pageController.init();

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
        pageController.other = '&'+qStr.toString();
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
     *详情页弹出呈现
     *要获取他的入库信息，分批信息，养殖信息，出库信息
     * 并更新detail_view_ctrl.num 的值
     */

    /**
     *1、获取dom
     */
    var oShadow = window.top.document.getElementById('shadow'),
        oDetail = window.top.document.getElementById('detail'),
        oDDl = window.top.document.getElementById('ddl'),
        oClose = window.top.document.getElementById('close'),
        oAdd = window.top.document.getElementById('add'),
        oAddContent = window.top.document.getElementById('addContent'),
        oAddClose = window.top.document.getElementById('add-close'),
        btn_pre = window.top.document.getElementById('btn-pre'),
        btn_next = window.top.document.getElementById('btn-next'),
        unbind = false;

    /**
     *2、详细按钮监听打开
     */
    $('#content').on('click',"[data-view*='V']",function(){
        if(!unbind){
            var id = $(this).attr('data-view').substr(1);
            showVue.call(oShadow);
            showDetailData(id);
        }
        return;

    });

    /**
     *3、监听批次插入
     * 呈现隔壁的详细级联信息
     */
    $('#content').on('click',"[data-id*='P']",function(){
        if(!unbind){
            var id  = $(this).attr('data-id').substr(1);
            $.get(oURL.PRONAME+oURL.GETLASTNUM+id,function (res) {  //判断圈养数量
                if(res.object>0){
                    renderPatch(id);
                }else{
                    alert('溯源提示：\n\n该来自该厂家的家禽已经完成所有分批，不能再进行分批操作');
                }
            });
        }
        return;

    });

    /**
     * 字典翻译
     * @type {Map}
     */
    var HOME_TYPE = new Map(),PTACH_SIZE = '';

    /**
     * 批次表呈现
     */
    function renderPatch(id) {
        oURL.idPoultry = id;
        /**
         * 详细层弹出
         * @type {Element}
         */
        showVue.call(oShadow);
        showDetailData(id);
        showVue.call(oAdd);
        viewCommand({                //渲染插入的模板
            command:'display',
            param:[oAddContent,[],'patch_add']
        });
        var pNode = oAdd.getElementsByClassName('detail-content')[0];
        var selectNodes = pNode.getElementsByTagName('select'),
            sub_btn = pNode.getElementsByTagName('button')[0],
            form = pNode.getElementsByTagName('form')[0],
            numberNodes = pNode.getElementsByTagName('input');

        numberNodes[0].onblur = function () {
            var that = this;
            var val = ~~that.value;
            $.get(oURL.PRONAME+oURL.GETLASTNUM+id,function (res) {  //判断圈养数量
                if(res.object>0){
                    if(val>res.object || that.value<0 ){
                        // that.max = res.object;
                        alert('溯源提示：\n\n您插入的数据有误 最大选择数为'+res.object);
                        sub_btn.disabled = true;
                        that.value = '';
                    }else{
                        sub_btn.disabled = false;
                    }
                }
            });
        }

        // numberNodes[1].onblur = function () {
        //     var val = ~~this.value;
        //     console.log(val);
        //     if(~~numberNodes[0].value<val || this.value<0 ){
        //         alert('溯源提示：\n\n您插入的数据有误');
        //         sub_btn.disabled = true;
        //         this.value = ''
        //     }else{
        //         sub_btn.disabled = false;
        //     }
        // }
        /**
         * 增加批次
         */
        sub_btn.onclick = function () {
            if(selectNodes[3].value!='undefined' && selectNodes[3].value){
                var obj = queryParse.call($(form));
                obj.idPoultry = oURL.idPoultry;
                $.post(oURL.PRONAME+oURL.PPOST,obj,function (res) {
                    if(res){
                        alert(res.msg);
                    }else{
                        alert('划分批次失败');
                    }
                });
            }else{
                alert('溯源提示:\n\n禽舍编号没有安排得当，无法分批');
            }

        }

        // /**
        //  * 从字典里查出规格的中文名 暂存起来
        //  */
        // $.get(oURL.PRONAME+oURL.GETHOMETYPE,function (res) {
        //     if(res){
        //         viewCommand({
        //             command:'display',
        //             param:[,,]
        //         });
        //     }
        // });

        render({
            url:oURL.PRONAME+oURL.GETPOSITON,     //位置
            dom:selectNodes[0],
            tpl:'id_name',
            cb:function () {
                render({
                    url:oURL.PRONAME+oURL.GETHOMETYPE,  //类型
                    dom:selectNodes[1],
                    tpl:'id_name',
                    cb:function () {
                        render({
                            url:oURL.PRONAME+oURL.GETBHOME+'?position='+selectNodes[0].value+'&type='+selectNodes[1].value,  //类型->大宿舍
                            dom:selectNodes[2],
                            tpl:'id',
                            dataDescription:'list',
                            cb:function () {                                        //大宿舍->小宿舍
                                render({
                                    url:oURL.PRONAME+oURL.GETSHOME+'?affiliation='+selectNodes[2].value,
                                    dom:selectNodes[3],
                                    tpl:'id',
                                    dataDescription:'list'
                                });
                            }
                        });
                    }
                });
            }
        });

        /**
         * 位置的改变触发
         */
        selectNodes[0].onchange = function () {           //位置改变触发类型
            $.get(oURL.PRONAME+oURL.GETBHOME+'?position='+selectNodes[0].value+'&type='+selectNodes[1].value,function (res) {
                if(res.list){
                    viewCommand({
                        command:'display',
                        param:[selectNodes[2],res.list,'id']
                    });
                    $.get(oURL.PRONAME+oURL.GETSHOME+'?affiliation='+selectNodes[2].value,function (res){
                        if(res.list){         //只有小宿舍号被划分了才行
                            viewCommand({
                                command:'display',
                                param:[selectNodes[3],res.list,'id']
                            });
                            sub_btn.disabled = false;
                        }
                    });
                }else{
                    $(selectNodes[2]).html("<option value='无此编号'>无此编号</option>");
                    $(selectNodes[3]).html("<option value='无此编号'>无此编号</option>");
                    sub_btn.disabled = true;
                }
            });
        }
        selectNodes[1].onchange = function () {  //规格的触发
            $.get(oURL.PRONAME+oURL.GETBHOME+'?position='+selectNodes[0].value+'&type='+selectNodes[1].value,function (res) {
                if(res.list){
                    viewCommand({
                        command:'display',
                        param:[selectNodes[2],res.list,'id']
                    });
                    $.get(oURL.PRONAME+oURL.GETSHOME+'?affiliation='+selectNodes[2].value,function (res){
                        if(res.list){
                            viewCommand({
                                command:'display',
                                param:[selectNodes[3],res.list,'id']
                            });
                            sub_btn.disabled = false;
                        }
                    });
                }else{
                    $(selectNodes[2]).html('<option value="无此编号">无此编号</option>');
                    $(selectNodes[3]).html('<option value="无此编号">无此编号</option>');
                    sub_btn.disabled = true;
                }
            });
        }
        selectNodes[2].onchange = function () {            //大宿舍->小宿舍
            var that = this;
            if(that.value){
                $.get(oURL.PRONAME+oURL.GETSHOME+'?affiliation='+that.value,function(res){
                    if(res.list){   //大宿舍-》小宿舍
                        viewCommand({
                            command:'display',
                            param:[selectNodes[3],res.list,'id']
                        });
                        sub_btn.disabled = false;
                    }else{
                        $(selectNodes[3]).html('<option value="无此编号">无此编号</option>');
                        sub_btn.disabled = true;
                    }
                });
            }else{
                $(selectNodes[3]).html('<option value="无此编号">无此编号</option>');
                sub_btn.disabled = true;
            }

        }

        $.get(oURL.PRONAME+oURL.GETEMP,function(res){        //人员
            if(res){
                viewCommand({
                    command:'display',
                    param:[selectNodes[5],res.list,'id_name']
                });
                viewCommand({
                    command:'display',
                    param:[selectNodes[6],res.list,'id_name']
                });
            }else{
                alert('获取人员信息失败');
            }
        });
    }
    /**
     * 数据级联呈现
     */
    function showDetailData(id){

        /**
         * 呈现数据
         * 级联呈现
         */
        $.get(oURL.PRONAME+oURL.GETINFOBYPID+id,function(res){     //入厂信息
            if(res){
                viewCommand({
                    command:'append',
                    param:[$(oDetail),res,'poultry_show']
                });
                 //id_p->批次信息
                    $.get(oURL.PRONAME+oURL.GETFINDPATCHBYPID+id,function(resPatchList){
                        if(resPatchList.object.length){
                            viewCommand({                //id_p -> 批次
                                command:'append',
                                param:[$(oDetail),resPatchList.object,'patch_show']
                            });
                            try{
                                var pNode = oDetail.getElementsByClassName('detail-content')[1],
                                    selectNodes = pNode.getElementsByTagName('select'),
                                    patch_data = pNode.getElementsByClassName('patch-data');
                                viewCommand({
                                    command:'display',
                                    param:[selectNodes[0],resPatchList.object,'id']    //渲染第一条select批次号的值
                                });
                                render({                                         //渲染第一条select批次号选项->对应的批次信息
                                    url:oURL.PRONAME+oURL.GETPATHBYID+selectNodes[0].value,
                                    tpl:'patch_show2',
                                    dom:patch_data,
                                    cb:function () {
                                        selectNodes[0].onchange = function () {      //并作批次号的监听 变化渲染
                                            var that = this;
                                            render({
                                                url:oURL.PRONAME+oURL.GETPATHBYID+that.value,
                                                tpl:'patch_show2',
                                                dom:patch_data
                                            });
                                        }
                                        detail_view_ctrl.num = 2;           //如果批次信息成功渲染，那么我就要修改这个动画大小

                                        /**
                                         * 渲染养殖记录视图
                                         */
                                        viewCommand({
                                            command:'append',
                                            param:[$(oDetail),[],'view_aqua'],
                                        });
                                        detail_view_ctrl.num = 3;
                                        var aquaDetailView = oDetail.getElementsByClassName('detail-content')[2],
                                            viewPort = aquaDetailView.getElementsByClassName('viewport')[0],
                                            aquaSelectNodes = aquaDetailView.getElementsByTagName('select'),
                                            viewdata = {feedWeight:[],weight:[]};
                                            viewCommand({              //id_p -》patch
                                                command:'display',
                                                param:[aquaSelectNodes[0],resPatchList.object,'id'],
                                            });
                                        $.get(oURL.PRONAME+oURL.GETAQUABYPATCH+aquaSelectNodes[0].value,function (res) {
                                            if(res.list.length){      //渲染视图空白框
                                                    res.list.reverse();//数组倒置
                                                    res.list.forEach(function (ele) {
                                                        viewdata.feedWeight.push(ele.feedWeight);
                                                        viewdata.weight.push(ele.weight);
                                                    });
                                                    $(oDetail).animate({left:-(detail_view_ctrl.step*2)},function () {  //移动oDetail
                                                        detail_view_ctrl.left = -(detail_view_ctrl.step*2);
                                                        showVue.call(oShadow,true);
                                                    });

                                                    willon_option.series[0].data = viewdata.feedWeight;  //饲料量
                                                    willon_option.series[1].data = viewdata.weight;     //重量
                                                    echarts.init(viewPort).setOption(willon_option);  //养殖情况的echarts的渲染

                                                /**
                                                 * 养殖批次的监听 name + idpatch
                                                 */
                                                aquaSelectNodes[0].onchange = function () {

                                                    //重新渲染数据
                                                }
                                            }else{
                                                showVue.call(oShadow);
                                            }
                                        });
                                    }
                                });
                            }catch(err){
                                console.log('捕获到了异常：因为该没有分批次的问题导致获取元素失败，但不影响用户的操作');
                            }
                        }else{
                            detail_view_ctrl.num = 1;
                            showVue.call(oShadow);
                        }
                    });
            }else{
                alert('获取入厂信息失败');
            }
        });

    }

    /**render
     * 图层渲染选择
     */
    function render(obj) {
        obj.command = obj.command?obj.command : 'display';
        $.get(obj.url,function (res) {
            if(res[obj.dataDescription]){
                if(res[obj.dataDescription].length){
                    if(obj.filter){
                        var s = new DataFilter({
                            data:{
                                map:obj.filter.map,
                                source:res,
                            },
                            type:obj.filter.type
                        });
                        viewCommand({
                            command:obj.command,
                            param:[obj.dom,s,obj.tpl]
                        });
                    }else{
                        viewCommand({
                            command:obj.command,
                            param:[obj.dom,res[obj.dataDescription],obj.tpl]
                        });
                    }

                }
                obj.cb&&obj.cb(res);
            }else{
                if(res){
                    if(obj.filter){
                        var s = new DataFilter({
                            data:{
                                map:obj.filter.map,
                                source:res,
                            },
                            type:obj.filter.type
                        });
                        viewCommand({
                            command:obj.command,
                            param:[obj.dom,s,obj.tpl]
                        });
                    }else{
                        viewCommand({
                            command:obj.command,
                            param:[obj.dom,res,obj.tpl]
                        });
                    }
                    obj.cb&&obj.cb(res);
                }
            }

        });
    }


    /**
     *呈现该段的详细信息+滚动页
     * 1、
     */
    var detail_view_ctrl = {
        num:1,  //最大容纳量
        step:631, //每次滑动一次的移动步长
        left:0,  //初始位置
    };
    var move = function(){
        $(oDetail).animate({left:detail_view_ctrl.left+'px'});
    }

    /**
     * 监听前后按钮
     */
    btn_pre.onclick = function () {
        var that = detail_view_ctrl;
            that.left += that.step;
            if(that.left>=0){
                that.left = 0;
                $(btn_pre).hide();
            }
            $(btn_next).show();
            move();
    }
    btn_next.onclick = function () {
        $(btn_pre).show();
        var that = detail_view_ctrl;
        that.left -= that.step;
        if(that.left <= -that.step*(that.num-1)){
            that.left = -that.step*(that.num-1);
            $(btn_next).hide();
        }
        $(btn_pre).show();
        move();
    };
    /**
     *监听详细层关闭按钮
     */
    oClose.onclick = function () {
        var self = this;
        closeVue.call(self,function () {
            self.parentNode.style.cssText = 'width:700px;height:90%;';
            // var nodes = self.parentNode.getElementsByClassName('detail-content');
            //     for(var i = 0 ,len = nodes.length;i<len ;i++ ){
            //         nodes[i].parentNode.removeChild(nodes[i]);
            //     }
            oDetail.innerHTML = '';
        });
        unbind = false;
    }
    oAddClose.onclick = function () {
        var self = this;
        closeVue.call(self,function () {
            self.parentNode.style.cssText = 'width:600px;height:90%;';
        });
    }

    /**
     * 详细层弹出
     * @type {Element}
     */
    function showVue(scroll) {
        this.classList.remove('none');
        if(detail_view_ctrl.num >1){
            $(btn_next).show();
        }else{
            $(btn_next).hide();
        }
        if(!detail_view_ctrl.left){  //left 为 0
            $(btn_pre).hide();
        }
        if(scroll){          //滚动判断左键是否显示
            $(btn_pre).show();
            if(detail_view_ctrl.left/(detail_view_ctrl.num-1) == -detail_view_ctrl.step){
                $(btn_next).hide();
            }
        }

        unbind = true; //按钮事件不绑定
    }

    /**
     * 关闭层
     */
    function closeVue(cb) {
        var tar = this.parentNode;
        detail_view_ctrl.left = 0;
        oDetail.style.left = 0 + 'px';
        moveFrame.animation(tar,{width:0,height:0},300,function () {
            tar.classList.add('none');
            cb&&cb();
        });
    }

    /**
     * 拖动层开始监听
     */
    // dragByOther(oShadow);
    // dragByOther(oAdd);    // dragByOther(oShadow);
    // dragByOther(oAdd);

    /**
     * 养殖管理
     * 1、监听按钮事件
     * 2、判断该poultry有没有划分批次号
     * 3、yes:
     *         1）我就要把详情页显示出来
     *         2）并把插入养殖的信息渲染出来
     *    no:
     *          alert('请划分批次')；
     * 4、监听关闭按钮
     */
    var resetInput = {};
    var MAX_FOOD = 0;
    $('#content').on('click','[data-check*="true"]',function () {
        if(!unbind){
            var option = $(this).attr('data-id').substr(0,1),
                id  = $(this).attr('data-id').substr(1),
                flag = '';
                //flag = setCheck(id);//检查是否划分了批次
                $.get(oURL.PRONAME+oURL.GETFINDPATCHBYPID+id,function (res) { //根据idP返回已经被划分的批次号
                    if(res.object.length){
                        flag = true;
                    }else{
                        flag = false;
                    }
                    if(flag){
                        switch (option){
                            case 'A':renderTpl(id);break;
                            case 'O':renderTpl(id,'outPoultry_add');break;
                        }
                    }else{
                        if(confirm('溯源提示：\n\n 该厂家的家禽未划分任何批次，不能进行该操作，请先划分批次号')){
                            renderPatch(id);
                        }
                        return
                    }
                });
        }
    });

    function renderTpl(id,tpl) {
        tpl = tpl?tpl:'aqua_add';
        showVue.call(oShadow);
        showDetailData(id);
        showVue.call(oAdd);
        viewCommand({
            command:'display',
            param:[oAddContent,[],tpl]
        });
        var aPNode = oAdd.getElementsByClassName('detail-content')[0],
            selectNodes = aPNode.getElementsByTagName('select'),
            sub_btn = aPNode.getElementsByTagName('button')[0],
            form = aPNode.getElementsByTagName('form')[0],
            maxTips = aPNode.getElementsByClassName('maxTips')[0],
            inputs = aPNode.getElementsByTagName('input');
        switch (tpl){
            case 'aqua_add':render_other(id,'aqua_add');break;
            case 'outPoultry_add':render_other('outPoultry_add');break;
            default:break;
        }

        function render_other(id,tpl) {
            var post = '';
            switch (tpl){
                case 'aqua_add':post = oURL.APOST;render_a(id);break;
                case 'outPoultry_add':post = oURL.OPOST;render_o();break;
                default:break;
            }
            sub_btn.onclick = function () {
                var obj = queryParse.call($(form));
                if(post==oURL.APOST){
                    if(inputs[2]>MAX_FOOD){
                        alert('溯源提示:\n\n您输入的投料量有误,拒绝提交');
                        return
                    }else{
                        $.post(oURL.PRONAME+post,obj,function (res) {
                            if(res){
                                alert(res.msg);
                            }else{
                                alert('溯源提示:\n\n提交失败');
                            }
                        });
                    }
                }else{
                    $.post(oURL.PRONAME+post,obj,function (res) {
                        if(res){
                            alert(res.msg);
                        }else{
                            alert('溯源提示:\n\n提交失败');
                        }
                    });
                }

            }
            function render_a(id) {
                var feedTypeObj = {};
                render({
                    url:oURL.PRONAME+oURL.GETMATERIL,  //饲料
                    dom:selectNodes[2],
                    tpl:'firm_name',
                    dataDescription:'list',
                    cb:function (res) {
                        feedTypeObj.feedType = res[0].name;
                        feedTypeObj.remark = res[0].firm;
                        feedTypeObj.feedWeight = 10000000000;   //试触储存量
                        $.post(oURL.PRONAME+oURL.GETLASTMATERILNUM,feedTypeObj,function (res) {
                            if(res){
                                maxTips.innerText =  MAX_FOOD = ~~res.object.rest;
                            }else{
                                alert('溯源提示:\n\n获取该饲料的仓储量失败');
                            }
                        });
                    }
                });

                //选择的饲料一旦改变也要进行触发更新     最大数量  tip-p
                selectNodes[2].onchange = function () {
                    console.log(this.value);
                    var arr = this.value.split('$');
                    feedTypeObj.feedType = arr[1];
                    feedTypeObj.remark = arr[0];
                    feedTypeObj.feedWeight = inputs[2].value?inputs[2].value:10000000000;
                    console.log(feedTypeObj);
                    $.post(oURL.PRONAME+oURL.GETLASTMATERILNUM,feedTypeObj,function (res) {
                        if(res){
                            console.log(res);
                            maxTips.innerText =  MAX_FOOD = ~~res.object.rest;
                            sub_btn.disabled = false;
                        }else{
                            alert('溯源提示:\n\n获取该饲料的仓储量失败');
                        }
                    });

                }

                //投料校验
                inputs[2].onblur = function () {
                    if(this.value>MAX_FOOD){
                        alert('溯源提示:\n\n您输入的投料数据有误，最大预测值为'+MAX_FOOD+'(kg)');
                        sub_btn.disabled = true;
                    }else{
                        sub_btn.disabled = false;
                    }
                }

                render({
                    url:oURL.PRONAME+oURL.GETSTATUSLIST, //养殖状态
                    dom:selectNodes[3],
                    tpl:'option',
                });
                $.get(oURL.PRONAME+oURL.GETFINDPATCHBYPID+id,function (res) {    //渲染养殖的批次号
                    if(res.object.length){
                        viewCommand({
                           command:'display',
                            param:[selectNodes[0],res.object,'id']
                        });
                        $.get(oURL.PRONAME+oURL.GETPATHBYID+selectNodes[0].value,function (res) {     //获取第一值，然后呈现该批次的信息
                            if(res){
                                var inputNodes = oAdd.getElementsByClassName('detail-content')[0].getElementsByTagName('input');
                                inputNodes[1].value = PTACH_SIZE = ~~res.size;
                                viewCommand({     //更新小宿舍号
                                   command:'display',
                                    param:[selectNodes[1],res,'idFowlery']
                                });
                                selectNodes[0].onchange = function() {
                                    var that = this;
                                    $.get(oURL.PRONAME + oURL.GETPATHBYID + that.value,function (res) {
                                        if(res){
                                            inputNodes[1].value = PTACH_SIZE = ~~res.size;
                                            viewCommand({     //更新小宿舍号
                                                command:'display',
                                                param:[selectNodes[1],res,'idFowlery']
                                            });
                                        }
                                    });
                                }
                                inputNodes[1].onblur = function () {
                                    resetInput.dom = this;
                                    resetInput.value = this.value;
                                    if(this.value<PTACH_SIZE){      //养殖数少了，那么我就要知道为什么少了
                                        //弹出死逃表
                                        alert('溯源提示:\n\n您输入的数据少于预订值，将左侧为您提供死淘信息记录表');
                                        render_ddl(res.id);
                                        /**
                                         * 死淘表呈现
                                         * 1、oShadow上移，
                                         * 2、oDll上移、渲染死淘方式、按钮获取监听 成功提示后消失
                                         * 关闭时
                                         * 1、oShadow下移
                                         * 2、oDll下移动
                                         * 3、把原来的值设置回来
                                         * @type {boolean}
                                         */
                                        sub_btn.disabled = true;
                                    }else{
                                        sub_btn.disabled = false;
                                    }
                                }
                            }
                        });
                    }else{
                       alert('溯源提示:\n\n获取对应的批次号失败');
                    }
                });

            }
            function render_o() {
                $.get(oURL.PRONAME+oURL.GETEMP,function(res){
                    if(res){
                        viewCommand({
                            command:'display',
                            param:[selectNodes[1],res.list,'id_name']
                        });
                        viewCommand({
                            command:'display',
                            param:[selectNodes[2],res.list,'id_name']
                        });
                    }else{
                        alert('人员获取失败');
                    }
                });
            }
        }
    }

    /**
     *渲染DDl
     */
    function render_ddl(id) {

        var ddlContent = oDDl.getElementsByTagName('div');

        console.log(ddlContent);
        //空白框
        viewCommand({
            command:'display',
            param:[ddlContent[0],{id:id},'ddl_add']
        });

        //获取元素
        var ddlClose = oDDl.getElementsByTagName('a')[0],
            selectNodes = oDDl.getElementsByTagName('select');

        //渲染方式操作
        $.get(oURL.PRONAME+oURL.GETPMODE,function (res) {
            if(res){
                viewCommand({
                    command:'display',
                    param:[selectNodes[0],res,'option'],
                });
            }else{
                alert('溯源提示：\n\n获取丢弃方式失败');
            }
        });

        //动画
        var h = oShadow.offsetHeight;
        $(oShadow).animate({top:-h+'px'},function () {
            $(oDDl).removeClass('none').animate({top:0+'px'});
        });

        //关闭按钮的监听
        ddlClose.onclick = function () {

            //动画
            closeDDL();
        }

        function closeDDL() {
            $(oDDl).animate({top:h+'px'},function () {
                $(oShadow).animate({top:0+'px'},function(){
                    $(oDDl).addClass('none');

                    //中途关闭表 还原预测值
                    resetInput.dom.value = resetInput.value;

                    //清空oDDl里的东西
                    $(oDDl).find('.detail-content').empty();
                    console.log($(oDDl).find('.detail-content'));
                });
            });
        }
        var submitBtn = ddlContent[0].getElementsByTagName('button')[0],
            form = ddlContent[0].getElementsByTagName('form')[0],
            inputNode = ddlContent[0].getElementsByTagName('input');
            inputNode[0].value = PTACH_SIZE - resetInput.value;
            inputNode[1].value = PTACH_SIZE - resetInput.value;
            submitBtn.onclick = function () {
                var obj = queryParse.call($(form));
                    obj.idPatch = id;
                // var json = JSON.stringify();
               $.post(oURL.PRONAME+oURL.DDLPOST,obj,function (res) {
                    if(res){
                        alert('溯源提示:\n\n死淘信息提交成功');
                        closeDDL();
                    }else{
                        alert('溯源提示:\n\n死淘信息提交失败');
                    }
               });
            };
    }
    // /**
    //  * 步骤检验
    //  */
    // $('#content').on('click',"[data-check*='true']",function () {
    //     var option = $(this).attr('data-id').substr(0,1);
    //     var id = $(this).attr('data-id').substr(1);
    //         var flag = false;
    //         switch (option){
    //             case 'A':flag = setCheck(option,id);break;
    //             case 'O':flag = setCheck(option,id);break;
    //         }
    //         if(!flag){                     //前面的步骤完成之后那么我就可以弹出框图
    //             alert('请完善之前的溯源信息');
    //         }
    // });

    // function stepCheck(step,id) {
    //     switch (step){
    //         case 'A':function checkStepP(id) {
    //             $.get(url,id,function (res) {
    //                 if(res){
    //                     return true;
    //                 }
    //                 return false;
    //             });
    //         };break;
    //         case 'O':function checkStepA(id) {
    //             $.get(url,id,function (res) {
    //                 if(res){
    //                     return true;
    //                 }
    //                 return false;
    //             });
    //         };break;
    //         default:break;
    //     }
    // }

})();