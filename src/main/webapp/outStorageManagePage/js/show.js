/**
 * Created by 30293 on 2017/11/28.
 */
$(function () {
    function showInfo(pageNum){//显示数据
        $.getJSON("/waterfowl/outstorage/show", {pageNum: pageNum}, function (json) {
            function divPage(){
                var divPageStyle = '<div><span>共查得记录'+json.total+'条,'+json.pages+'页</span>';
                if(!json.isFirstPage)divPageStyle += '<button class="divPageBtn">1</button>' +
                    '<button class="divPageBtn">'+json.prePage+'</button>';//处于第一页时不显示
                divPageStyle += '<button class="divPageBtn">'+json.pageNum+'</button>';
                if(!json.isLastPage)divPageStyle += '<button class="divPageBtn">'+json.nextPage+'</button>' +
                    '<button class="divPageBtn">'+json.pages+'</button>';//处于最后一页时不显示
                divPageStyle += '<input type="text" id="divPageLift"><button id="divPageLiftBtn">GO</button></div>';
                $("body").append('<div id="divPage"></div>');
                $("#divPage").html(divPageStyle);//每次生成替换旧元素
                $("body").off("click",".divPageBtn");//移除所有的click事件句柄
                $("body").off("click","#divPageLiftBtn");
                $("body").on("click",".divPageBtn",ackBtn);//第三参数为函数名，绝不可加（）,也不能放入匿名函数，否则只会在绑定时调用一次
                $("body").on("click","#divPageLiftBtn",ackLift);
                function ackLift(){
                    showInfo($("#divPageLift").val());
                }
                function ackBtn(){
                    showInfo(this.innerHTML);
                }
            }
            divPage();
            //获取分页基本数据
            function exTimeStamp(dateTimestamp){//timestamp秒数转换成2017-10-10格式
                Date.prototype.toLocaleString = function() {
                    return this.getFullYear() + "-" + (this.getMonth() + 1) + "-" + this.getDate();
                };
                var unixTimestamp = new Date(dateTimestamp);
                commonTime = unixTimestamp.toLocaleString();
                return commonTime;
            }
            function thisPage(){//展示页面
                var innerlist="<caption>材料出库记录一览</caption><tr><th>出库记录编号</th><th>库存记录编号</th><th>记录日期</th>"
                    + "<th>材料名称</th><th>材料数量</th><th>计数单位</th><th>记录者编号</th><th>负责人编号</th><th>备注</th><th>操作</th></tr>";
                for(var key in json.list) {
                    innerlist += "<tr>";
                    innerlist += "<td>" + json.list[key].idOutstorage + "</td>";
                    innerlist += "<td>" + json.list[key].idStorage + "</td>";
                    innerlist += "<td>" + exTimeStamp(json.list[key].recordDate) + "</td>";
                    innerlist += "<td>" + json.list[key].name + "</td>";
                    innerlist += "<td>" + json.list[key].quantity + "</td>";
                    innerlist += "<td>" + json.list[key].unit + "</td>";
                    innerlist += "<td>" + json.list[key].idRecorder + "</td>";
                    innerlist += "<td>" + json.list[key].idCharge + "</td>";
                    innerlist += "<td>" + json.list[key].remark + "</td>";
                    innerlist += "<td><input type='button' value='修改' id='iedit'/>" +
                        "<input type='button' value='删除' id='idelete'/></td>"
                    innerlist += "</tr>";
                }
                $("#materialInfo").html(innerlist);

                $("body").off("click","#idelete");//移除所有的click事件句柄
                $('body').on("click","#idelete",ackDel);
                function ackDel(){//idelete相应操作
                    if(confirm("即将删除记录"+$(this).parent().parent().children("td").html())){//获取对应记录的id,并进行删除前确认
                        Del($(this).parent().parent().children("td").html());
                        $("#idelete").append($(this).parent().parent().children("td"));//把整行替换删除
                    }
                }
                function Del(ideleteId){//删除给定记录
                    $.getJSON("/waterfowl/outstorage/delete/"+ideleteId,function (json) {
                        alert(json.msg +":"+ ideleteId);
                    });
                }

                $("body").off("click","#iedit");//移除所有的click事件句柄
                $('body').on("click","#iedit",ackEdi);
                function ackEdi(){//edit相应操作
                    var ideditId = $(this).parent().parent().children("td").html();//获取对应记录的id存入seesion给edit.html获取
                    if(confirm("前往修改记录"+ideditId)){
                        sessionStorage.idOutstorageedit = ideditId;
                        location.href="edit.html";
                    }
                }
            }
            thisPage();
        });
    }
    showInfo(1);
})