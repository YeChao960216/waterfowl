/**
 * Created by 30293 on 2017/11/28.
 */
$(function () {
    function getSel() {
        //获取unit、type下拉框，并取val()值
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

    function Insert(){//插入数据
        getSel();
        $('body').on("click","#submit",submitInfo);
        function submitInfo(){
            var date=$("#date").val();var type=$("#typeSel").val();var quantity=$("#quantity").val();var unit=$("#unitSel").val();
            var assFirm=$("#assFirm").val();var phone=$("#phone").val();var idRecoder=$("#idReco").val();var idCharge=$("#idChar").val();
            var remark=$("#remark").val();
            if(isNaN(quantity)){
                alert("材料数量含非数字，请更正");
            }else if(date==""||type==""||quantity==""||unit==""||assFirm==""/*||idReco=""||idChar=""*/){
                alert("表单填写不完整不能提交");
            }
            else{
                $.post("/waterfowl/poultry/add",
                    {
                        "recordDate" : date,
                        "type" : type,//字典下拉选框获取
                        "quantity" : quantity,
                        "unit" : unit,//字典下拉选框获取
                        "associatedFirm" : assFirm,
                        "phone" : phone,
                        "idRecorder" : idRecoder,//用户表下拉选框获取
                        "idCharge" : idCharge,//用户表下拉选框获取
                        "remark" : remark
                    }, function (obj) {
                        alert(obj.msg);
                    },
                    "json"
                )
            }
        }
    }
    Insert();
})