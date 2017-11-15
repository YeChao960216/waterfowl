/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-10-26 16:27:25 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-10-26 17:09:40
 */

/**
 * 向后台发送数据，获取所有在职人员的信息
 */
const URL_ADDEMP = {
    PAGE:1,
    COUNT:15,
    SHOWEMPINFO:'',
    ADDEMP:'',
};

var oContent = document.getElementById('content');
var data = [
    {phone:'123123123',name:'伟龙',gender:'男',entry:'2017-10-24',sign:'在职',id:'0887910',role_id:'战场统治者'},
];
viewCommand({
    command:'display',
    param:[oContent,data,'empInfo']
})
// function initView(){
//     ajax.get(URL_ADDEMP.SHOWEMPINFO?page=URL_ADDEMP.PAGE&count=URL_ADDEMP.COUNT,function(data){
//     console.log(data);
//     if(data.length!=0){
//         viewCommand({
//             command:'display',
//             param:[oContent,data,'addEmp']
//         })
//     }
// })
// }
// initView();



/**
 * jq
 * 跳转页面进行职员详细信息的查看操作
 * 
 */

// $('#content').on("click","[id*=show]",function(){
//     var emp_id = $(this).attr(id).substr(3);
//      console.log(emp_id);
//      window.location.href="showEmpDetail.html?id="+emp_id;
// })

