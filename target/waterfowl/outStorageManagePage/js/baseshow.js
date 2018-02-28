/**
 * Created by 30293 on 2017/11/28.
 */
$(function () {
    function showInfo(selectName){//显示数据
        $.getJSON("/waterfowl/material/selectBy", {name: selectName}, function (json) {
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
                var innerlist="<caption>材料入厂记录一览</caption><tr><th>入厂记录编号</th><th>记录日期</th><th>材料名称</th><th>有效日期</th>"
                    + "<th>来源厂商</th><th>材料数量</th><th>计数单位</th><th>存储地点</th>"
                    + "<th>存储方式</th><th>记录者编号</th><th>负责人编号</th><th>备注</th><th>操作</th></tr>";
                for(var key in json.list) {
                    innerlist += "<tr>";
                    innerlist += "<td>" + json.list[key].idStorage + "</td>";
                    innerlist += "<td>" + exTimeStamp(json.list[key].date) + "</td>";
                    innerlist += "<td>" + json.list[key].name + "</td>";
                    innerlist += "<td>" + exTimeStamp(json.list[key].expirationDate) + "</td>";
                    innerlist += "<td>" + json.list[key].associatedFirm + "</td>";
                    innerlist += "<td>" + json.list[key].quantity + "</td>";
                    innerlist += "<td>" + json.list[key].unit + "</td>";
                    innerlist += "<td>" + json.list[key].storageSite + "</td>";
                    innerlist += "<td>" + json.list[key].mode + "</td>";
                    innerlist += "<td>" + json.list[key].idRecorder + "</td>";
                    innerlist += "<td>" + json.list[key].idCharge + "</td>";
                    innerlist += "<td>" + json.list[key].remark + "</td>";
                    innerlist += "<td><input type='button' value='选择' id='iselect'/></td>"
                    innerlist += "</tr>";
                }
                $("#materialInfo").html(innerlist);

                $("body").off("click","#iselect");//移除所有的click事件句柄
                $('body').on("click","#iselect",ackSel);
                function ackSel(){//edit相应操作
                    var idselectId = $(this).parent().parent().children("td").html();//获取对应记录的id存入seesion给edit.html获取
                    if(confirm("前往记录出库"+idselectId)){
                        sessionStorage.idselect = idselectId;
                        location.href="new.html";
                    }
                }


            }
            thisPage();
        });
    }
    $('body').on("click","#btnNameAck",ackName);
    function ackName(){//edit相应操作
        var idselectName = $('#nameAck').val();//获取nameAck
            showInfo(idselectName);
    }
})