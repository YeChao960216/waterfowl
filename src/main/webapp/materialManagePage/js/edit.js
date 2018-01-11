/**
 * Created by 30293 on 2017/11/28.
 */
$(function () {
    alert("edit");
    function getSel() {
        //获取unit、mode下拉框，并取val()值
        function Sel() {
            $.getJSON("/waterfowl/dict/list", {pid: "20000"}, function (json) {
                var innerUnitSel = "";
                for (var key in json) {
                    innerUnitSel += "<option value='"+ json[key].id+"'>"+ json[key].name + "</option>";
                }
                $("#unitSel").html(innerUnitSel);
            });
            $.getJSON("/waterfowl/dict/list", {pid: "2000"}, function (json) {
                var innerUnitSel = "";
                for (var key in json) {
                    innerUnitSel += "<option value='"+ json[key].id+"'>"+ json[key].name + "</option>";
                }
                $("#modeSel").html(innerUnitSel);
            });
        }
        Sel();
    }
    function Edit(){//修改页面
        getSel();
        $.getJSON("/waterfowl/material/select/"+ sessionStorage.idedit,{}, function (json) {
            function thisPage(){//展示页面
                function exTimeStamp(dateTimestamp){//timestamp秒数转换成2017-10-10格式
                    Date.prototype.toLocaleString = function() {
                        return this.getFullYear() + "-" + (this.getMonth() + 1) + "-" + this.getDate();
                    };
                    var unixTimestamp = new Date(dateTimestamp);
                    commonTime = unixTimestamp.toLocaleString();
                    return commonTime;
                }
                $("#date").val(exTimeStamp(json.date));$("#mname").val(json.name);$("#expDate").val(exTimeStamp(json.expirationDate));$("#assFirm").val(json.associatedFirm);
                $("#phone").val(json.phone);$("#quantity").val(json.quantity);$("#unitSel").val(json.unit);$("#stoSite").val(json.storageSite);
                $("#modeSel").val(json.mode);$("#idReco").val(json.idRecorder);$("#idChar").val(json.idCharge);$("#remark").val(json.remark);
            }
            thisPage();
        });
        $('body').on("click","#submit",submitEdit);
        function submitEdit(){
            var date=$("#date").val();var mname=$("#mname").val();var expDate=$("#expDate").val();var assFirm=$("#assFirm").val();
            var phone=$("#phone").val();var quantity=$("#quantity").val();var unit=$("#unitSel").val();var stoSite=$("#stoSite").val();
            var mode=$("#modeSel").val();var idReco=$("#idReco").val();var idChar=$("#idChar").val();var remark=$("#remark").val();
            if(isNaN(quantity)){
                alert("材料数量含非数字，请更正");
            }else if(date==""||mname==""||expDate==""||assFirm==""||quantity==""||unit==""||stoSite==""||mode==""/*||idReco=""||idChar=""*/){
                alert("表单填写不完整不能提交");
            }
            else{
                $.post("/waterfowl/material/edit/"+sessionStorage.idedit,
                    {
                        "date" : date,
                        "name" : mname,
                        "expirationDate":expDate,//"2017-10-11",//该属性插入失败：后台为时间戳类型，expiration_date获取得到的是string类型。
                        "associatedFirm" : assFirm,//含有_的属性都插入失败
                        "phone" : phone,
                        //"type" : type,//不需用户输入：默认type为‘1’，表示‘可使用’；当当前日期>expiration_date时，修改type为’0’表示‘已过期’
                        "quantity" : quantity,
                        "unit" : unit,//字典下拉选框获取
                        "storageSite" : stoSite,//含有_的属性都插入失败
                        "mode" : mode,//字典下拉选框获取
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
    Edit();
})