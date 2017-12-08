(function (w) {
    var zhanjia ={
        /**
         * 从url地址中截取参数
         * @param name：str 参数名
         */
        getQueryString:function () {
            var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if(r!=null){
                return  unescape(r[2]);
            }
            return null;
        },
        /**
         * 上传记录方法
         * @param ele:element 上传按钮
         * @param urlStr:修改上传记录的url
         */
        upLoadList:
            function (ele,urlStr) {
                ele.onclick =function () {
                var selectArr =document.getElementsByClassName("select");
                var idList =[];
                for(var i=0;i<selectArr.length;i++) {
                    //如果被选中
                    if(selectArr[i].checked ===true){
                        idList.push(selectArr[i].parentNode.lastChild.value);
                    }
                }
                $.post(urlStr,idList,function (data) {
                    if (data.status===1)
                        alert("上传数据成功!");
                    else
                        alert("上传数据失败！");
                })
                console.log(idList);
            }
        },
        /**
         * 展示分页函数
         * @param currentPage:int  当前页数
         * @param totalPage   总分页数
         * @param showList   展示列表页面函数
         */
        showPageCut:
            function(currentPage,totalPage,showList){
                $("#first").click(function () {
                    if(currentPage != 1){//如果当前页不是首页，则执行
                        showList(1);
                    }
                })
                $("#last").click(function () {
                    if(currentPage != totalPage){//如果当前页不是尾页，则执行
                        showList(totalPage);
                    }
                })
                $("#pre").click(function () {
                    if(currentPage != 1){ //如果当前页不是第一页
                        showList(currentPage-1);
                    }
                })
                $("#next").click(function () {
                    if(currentPage != totalPage){//如果当前页不是尾页
                        showList(currentPage+1);
                    }
                })
                $("#pageNum").val(currentPage)
                $("#pages").html("共"+totalPage+"页");
                $("#pageNum").blur(function () {
                    if($("#pageNum").val() !=currentPage){//失去焦点后，若判断为填入页数非当前页，则执行
                        showList($("#pageNum").val());
                    }
                })
            },
        /**
         * 详情弹出层方法
         * @description: 已弃用
         * @param length
         */
        popLayer:function (length) {
            //获取元素
            var remarkArr =document.querySelectorAll(".remark");
            for(var i=0;i<remarkArr.length;i++){
                //如果字符串长度超过25，则省略超过部分
                var content =remarkArr[i].innerText;
                if(content.length >=25){
                    remarkArr[i].innerText =content.slice(0,length)+"...";
                }

                //td:remark部分，绑定点击事件：点击remark所在的td，弹出备注的详细信息
                var box =null;
                var div =null;
                remarkArr[i].onclick =function (e) {
                    //取消事件冒泡
                    if(e && e.stopPropagation){
                        //W3C取消冒泡事件
                        e.stopPropagation();
                    }else{
                        //IE取消冒泡事件
                        window.event.cancelBubble = true;
                    }
                    //保存this
                    box =this;

                    //获取remark所在td的位置+偏移量
                    var remarkY=this.offsetTop+50;//向上偏移50px
                    var remarkX =this.offsetLeft-100;//向左偏移100px

                    if(div===null){
                        div =document.createElement("div");
                        div.innerText =this.innerText;
                        div.style ="width:200px; padding:10px;border:1px solid red; background-color:white; position:absolute; z-index:2; top:"+remarkY+"px; left:"+remarkX+"px;";
                        this.appendChild(div);
                    }
                }
                document.body.onclick =function () {
                    if(box !==null && div !==null){
                        box.removeChild(div);
                        div =null;
                    }
                }
            }
        },

        /**
         * 全选全不选方法
         * @param selectAll  全选dom元素
         * @param selectArr  子选框dom元素数组
         */
        selectAll:function (selectAll,selectArr) {
            //获取元素
            /*selectAll =document.getElementById("selectAll");
            selectArr =document.getElementsByClassName("select");*/
            //绑定事件
            selectAll.onclick =function () {
                if(true===selectAll.checked){
                    for(var i=0;i<selectArr.length;i++){
                        selectArr[i].checked =true;
                    }
                }else{
                    for(var i=0;i<selectArr.length;i++){//全不选
                        selectArr[i].checked =false;
                    }
                }
            }
            for(var i=0;i<selectArr.length;i++){
                //绑定单项选定事件
                selectArr[i].onclick =function () {
                    for(var j=0;j<selectArr.length;j++){
                        if(selectArr[j].checked ===false){//如果有其中一项单选项没选中，则取消全选
                            selectAll.checked =false;
                            return;
                        }
                    }
                    selectAll.checked =true;
                }
            }
        }
    }

    //暴露出去
    w.zhanjia =zhanjia;
}(window))


