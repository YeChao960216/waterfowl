/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-10-26 16:27:25 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-10-26 18:08:43
 */

/**
 * 向后台发送数据，获取所有离职人员的信息
 */
/**
 * 常量url对象
 */
const URL_ADDEMP = {
    PAGE:1,
    COUNT:15,
    SHOWEMPINFO:'',
    ADDEMP:'',
};

var oContent = document.getElementById('content');
var data = [
    {phone:'123123123',name:'willon',gender:'男',entry:'2017-10-20',sign:'离职',id:'0887910'},
    {phone:'123123123',name:'willon',gender:'男',entry:'2017-10-20',sign:'离职',id:'0887910'}
];
viewCommand({
    command:'display',
    param:[oContent,data,'addEmp']
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
 * 办理入职操作
 * 
 */

// $('#content').on("click","[id*=add]",function(){
//     var emp_id = $(this).attr(id).substr(2);
//     $.post(URL_ADDEMP.ADDEMP,{id:emp_id},function(data){
//         if(data.status==1){//修改成功
//             initView();
//         }
//     });
// })

/**
 * 原生js
 * document.getElementById('content').addEvent('click',function(e){
 *      e = e?e||window.event;
 *      var tarId = e.target.id||e.srcElement.id;
 *      if(tarId.test(/^add/)){
 *          tarId = tarId.substr(2);
 *      }
 *      ajax.post(URL_ADDEMP.ADDEMP,{id:tarId},function(data){
//         if(data.status==0){//修改成功
//             initView();
//         }
//     });
 * });
 */