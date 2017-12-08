var setting = {  
    callback:{
        onClick:zTreeOnclick
    },
    isSimpleData : true,              //数据是否采用简单 Array 格式，默认false  
    treeNodeKey : "id",               //在isSimpleData格式下，当前节点id属性  
    treeNodeParentKey : "pId",        //在isSimpleData格式下，当前节点的父节点id属性  
    showLine : true,                  //是否显示节点间的连线  
    checkable : true                  //每个节点上是否显示 CheckBox  
};  
/**
 * 这里需要向服务器端请求用户信息，渲染zTree,{zNodes:[{权限配置级别}，id:'',username:'']}
 * 
 */
// const url_getUseInfo = '';
// $.get(url_getUseInfo,function(data){
//     //zNodes = data.zNodes;
//     //$('#user').text(data.username);
// })

var zNodes = [
        {   //列出所有的信息
            name:"个人信息", open:true, tid:'./userPage/showInfo.html',children:
            [   //除了入职，与状态之外，其他的是可以修改的
                {name:"完善/修改",tid:'./userPage/update.html',pName:"个人信息",pUrl:'./userPage/showInfo.html'},
                {name:"修改密码",tid:'./userPage/resetPassw.html',pName:"个人信息",pUrl:'./userPage/showInfo.html'}
            ]
        },
        {   //列出所有员工，但是，员工的密码是没办法看到的
            name:"员工信息管理", open:true, tid:'./empManagePage/showEmp.html',children:
            [   //办理入职的时候，主要罗列出处于离职状态的员工，为其办理入职手续
                {name:"办理入职",tid:'./empManagePage/addEmp.html',pName:"员工信息管理",pUrl:'./empManagePage/showEmp.html'},
                //解雇/删除，主要罗列出处于入职状态的员工，办理离职手续手续
                {name:"解雇/删除员工信息",tid:'./empManagePage/del_fireEmp.html',pName:"员工信息管理",pUrl:'./empManagePage/showEmp.html'}
            ]
        },
        {
            name:"养殖管理", open:true, tid:'./aquaculture/find.html',children:
            [
                {name:"增加",tid:'./aquaculture/aqua_add.html',pName:"养殖管理",pUrl:'./aquaculture/find.html'},

                {name:"删除",tid:'./aquaculture/del.html',pName:"养殖管理",pUrl:'./aquaculture/find.html'},

            ]
        },
        {
            name:"死淘管理", open:true, tid:'./ddlManagePage/add.html',children:
            [
                {name:"增加",tid:'./ddlManagePage/add.html',pName:"死淘管理",pUrl:'./ddlManagePage/add.html'},

                {name:"修改",tid:'./ddlManagePage/edit.html',pName:"死淘管理",pUrl:'./ddlManagePage/add.html'},

                {name:"已上传的死逃信息",tid:'./ddlManagePage/hasUploadList.html',pName:"死淘管理",pUrl:'./ddlManagePage/add.html'},

                {name:"待上传的死逃信息",tid:'./ddlManagePage/waitUploadList.html',pName:"死淘管理",pUrl:'./ddlManagePage/add.html'},

            ]
        },
        {
            name:"免疫隔离管理", open:true, tid:'./epidemicManagePage/add.html',children:
            [
                {name:"增加",tid:'./epidemicManagePage/add.html',pName:"免疫隔离管理",pUrl:'./epidemicManagePage/add.html'},

                {name:"修改",tid:'./epidemicManagePage/edit.html',pName:"免疫隔离管理",pUrl:'./epidemicManagePage/add.html'},

                {name:"已上传的免疫隔离信息",tid:'./epidemicManagePage/hasUploadList.html',pName:"免疫隔离管理",pUrl:'./epidemicManagePage/add.html'},

                {name:"待上传的免疫隔离信息",tid:'./epidemicManagePage/waitUploadList.html',pName:"免疫隔离管理",pUrl:'./epidemicManagePage/add.html'},

            ]
        },
        {
            name:"禽舍管理", open:true, tid:'./fowleryManagePage/add.html',children:
            [
                {name:"增加",tid:'./fowleryManagePage/add.html',pName:"禽舍管理管理",pUrl:'./fowleryManagePage/add.html'},

                {name:"删除",tid:'./fowleryManagePage/delete.html',pName:"禽舍管理管理",pUrl:'./fowleryManagePage/add.html'},

                {name:"修改",tid:'./fowleryManagePage/edit.html',pName:"禽舍管理管理",pUrl:'./fowleryManagePage/add.html'},

            ]
        },
        {
            name:"出库管理", open:true, tid:'./outPoultry/find.html',children:
             [
                {name:"增加",tid:'./outPoultry/add.html',pName:"出库管理",pUrl:'./outPoultry/find.html'},

                {name:"删除",tid:'./outPoultry/del.html',pName:"出库管理",pUrl:'./outPoultry/find.html'},

            ]
        },
        
   ];
var zTree = '';
// setPath(1,'./employeeManagePage/add.html','增加员工')
$(document).ready(function(){
    zTree = $.fn.zTree.init($("#menu"), setting, zNodes);
 }); 
function zTreeOnclick(e,pid,treeNodes){
    console.log(treeNodes,e.target.className=='node_name');
    emptyPath(2);
    emptyPath(1);
    if(!treeNodes.children){//没子节点的设置路径2
        setPath(1,treeNodes.pUrl,treeNodes.pName);
        console.log(treeNodes.tid);
        setPath(2,treeNodes.tid,treeNodes.name);
        displayPath(2);
    }else{                 //否则就设置路径1
        setPath(1,treeNodes.tid,treeNodes.name);
        displayPath(1);
        //findxx()根据xx返回所有人员信息 这里要用ajax 获取人员数据
    }
}