/**
 * Created by 30293 on 2017/11/28.
 */
$(function () {
    function getSel() {
        //获取unit、mode下拉框，并取val()值
        function Sel() {
            $.getJSON("/waterfowl/dict/list", {pid: "20000"}, function (json) {
                var innerUnitSel = "";
                for (var key in json) {
                    innerUnitSel += "<option value='"+ json[key].id+"'>"+ json[key].name + "</option>";
                }
                $("#outunit").html(innerUnitSel);
            });
        }
        Sel();
    }
    function getDic(dicIdunit,dicIdmode){//根据unit，mode的Id查字典表获得name
        $.getJSON("/waterfowl/dict/show/"+dicIdunit,{}, function (json) {
            $("#unit").html(json.name);
        })
        $.getJSON("/waterfowl/dict/show/"+dicIdmode,{}, function (json) {
            $("#mode").html(json.name);
        })
    }
    function New(){//新增记录
        getSel();
        $.getJSON("/waterfowl/material/select/4DA1674825D14C33A14FB441A9698A5A"/*+ sessionStorage.idselect*/,{}, function (json) {
            function thisPage(){//展示页面
                function exTimeStamp(dateTimestamp){//timestamp秒数转换成2017-10-10格式
                    Date.prototype.toLocaleString = function() {
                        return this.getFullYear() + "-" + (this.getMonth() + 1) + "-" + this.getDate();
                    };
                    var unixTimestamp = new Date(dateTimestamp);
                    commonTime = unixTimestamp.toLocaleString();
                    return commonTime;
                }
                $("#idStor").html(json.idStorage);$("#mname").html(json.name);$("#expDate").html(exTimeStamp(json.expirationDate));$("#assFirm").html(json.associatedFirm);
                $("#phone").html(json.phone);$("#quantity").html(json.quantity);$("#stoSite").html(json.storageSite);
                $("#idReco").html(json.idRecorder);$("#idChar").html(json.idCharge);$("#remark").html(json.remark);
                getDic(json.unit,json.mode);
            }
            thisPage();
        });
        $('body').on("click","#submit",submitNew);
        function submitNew(){
            var date=$("#date").val();var idstorage=$("#idStor").html();var mname=$("#mname").html();
            var quantity=$("#outquantity").val();var unit=$("#outunit").val();
            var idReco=$("#outidReco").val();var idChar=$("#outidChar").val();var remark=$("#outremark").val();
            if(isNaN(quantity)){
                alert("材料数量含非数字，请更正");
            }else if(date==""||mname==""||quantity==""||unit==""/*||idReco=""||idChar=""*/){
                alert("表单填写不完整不能提交");
            }
            else{
                $.post("/waterfowl/outstorage/add"/*+sessionStorage.idselect*/,
                    {
                        "recordDate" : "2017-12-12",
                        "idStorage" : idstorage,
                        "name" : mname,
                        "quantity" : quantity,
                        "unit" : unit,//字典下拉选框获取
                        //"idRecorder" : idReco,//用户表下拉选框获取
                        //"idCharge" : idchar,//用户表下拉选框获取
                        "remark" : remark
                    }, function (obj) {
                        alert(obj.msg);
                        location.href="show.html";
                    },
                    "json"
                )
            }
        }
    }
    New();
})