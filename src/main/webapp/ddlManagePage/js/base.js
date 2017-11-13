
    var zhanjia ={
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
        selectAll:function () {
            //获取元素
            var selectAll =document.querySelector("#selectAll");
            var selectArr =document.querySelectorAll(".record_form td input");
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

