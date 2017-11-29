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
                $("#unitSel").html(innerUnitSel);
            });
            $.getJSON("/waterfowl/dict/list", {pid: "60000"}, function (json) {
                var innerUnitSel = "";
                for (var key in json) {
                    innerUnitSel += "<option value='"+ json[key].id+"'>"+ json[key].name + "</option>";
                }
                $("#typeSel").html(innerUnitSel);
            });
        }
        Sel();
    }
    function Edit(){//修改页面
        getSel();
        $.getJSON("/waterfowl/poultry/select/"+ sessionStorage.idedit,{}, function (json) {
            function thisPage(){//展示页面
                function exTimeStamp(dateTimestamp){//timestamp秒数转换成2017-10-10格式
                    Date.prototype.toLocaleString = function() {
                        return this.getFullYear() + "-" + (this.getMonth() + 1) + "-" + this.getDate();
                    };
                    var unixTimestamp = new Date(dateTimestamp);
                    commonTime = unixTimestamp.toLocaleString();
                    return commonTime;
                }
                $("#date").val(exTimeStamp(json.recordDate));$("#typeSel").val(json.type);$("#quantity").val(json.quantity);
                $("#unitSel").val(json.unit);$("#assFirm").val(json.associatedFirm);$("#phone").val(json.phone);
                $("#idReco").val(json.idRecorder);$("#idChar").val(json.idCharge);$("#remark").val(json.remark);
            }
            thisPage();
        });
        $('body').on("click","#submit",submitEdit);
        function submitEdit(){
            var date=$("#date").val();var type=$("#typeSel").val();var quantity=$("#quantity").val();var unit=$("#unitSel").val();
            var assFirm=$("#assFirm").val();var phone=$("#phone").val();var idReco=$("#idReco").val();var idChar=$("#idChar").val();
            var remark=$("#remark").val();
            if(isNaN(quantity)){
                alert("材料数量含非数字，请更正");
            }else if(date==""||type==""||quantity==""||unit==""||assFirm==""/*||idReco=""||idChar=""*/){
                alert("表单填写不完整不能提交");
            }
            else{
                $.post("/waterfowl/poultry/edit/"+sessionStorage.idedit,
                    {
                        "recordDate" : date,
                        "type" : type,//字典下拉选框获取
                        "quantity" : quantity,
                        "unit" : unit,//字典下拉选框获取
                        "associatedFirm" : assFirm,
                        "phone" : phone,
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