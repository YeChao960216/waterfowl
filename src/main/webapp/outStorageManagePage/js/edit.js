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
    $.getJSON("/waterfowl/outstorage/select/"+sessionStorage.idOutstorageedit/*+ sessionStorage.idOutstorageedit,{}*/, function (json) {
        function thisPage(){//展示页面
            function exTimeStamp(dateTimestamp){//timestamp秒数转换成2017-10-10格式
                Date.prototype.toLocaleString = function() {
                    return this.getFullYear() + "-" + (this.getMonth() + 1) + "-" + this.getDate();
                };
                var unixTimestamp = new Date(dateTimestamp);
                commonTime = unixTimestamp.toLocaleString();
                return commonTime;
            }
            $("#idOutstor").html(json.idOutstorage);$("#idStor").html(json.idStorage);
            $("#date").html(exTimeStamp(json.recordDate));$("#mname").html(json.name);
            $("#quantity").val(json.quantity);$("#unitSel").val(json.unit);
            $("#idReco").val(json.idRecorder);$("#idChar").val(json.idCharge);$("#remark").val(json.remark);
        }
        thisPage();
    });
    $('body').on("click","#submit",submitEdit);
    function submitEdit(){
        var quantity=$("#quantity").val();var unit=$("#unitSel").val();
        var idReco=$("#idReco").val();var idChar=$("#idChar").val();var remark=$("#remark").val();
        if(isNaN(quantity)){
            alert("材料数量含非数字，请更正");
        }else if(quantity==""||unit==""/*||idReco=""||idChar=""*/){
            alert("表单填写不完整不能提交");
        }
        else{
            $.post("/waterfowl/outstorage/edit/"+sessionStorage.idOutstorageedit,
                {
                    "quantity" : quantity,
                    "unit" : unit,//字典下拉选框获取
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