﻿var setting = {
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
/**
 * 用户个人信息模块
 * @type {[*]}
 */
var zNodes_userInfoM = [
    {   //列出所有的信息
        name:"个人信息", open:true, tid:'./userPage/showInfo.html',children:
        [   //除了入职，与状态之外，其他的是可以修改的
            {name:"完善/修改",tid:'./userPage/update.html',pName:"个人信息",pUrl:'./userPage/showInfo.html'},
            {name:"修改密码",tid:'./userPage/resetPassw.html',pName:"个人信息",pUrl:'./userPage/showInfo.html'}
        ]
    },
];
/**
 * 养殖管理信息模块
 * @type {[*]}
 */
var zNodes_aquaInfoM = [
    {
        name:"家禽养殖流程管理", open:true, tid:'./poultryManagePage_v2/find.html',children:
        [
            {name:"新增入厂记录",tid:'./poultryManagePage_v2/aqua_add.html',pName:"家禽养殖流程管理",pUrl:'./poultryManagePage_v2/find.html'},

            {name:"删除入厂记录",tid:'./poultryManagePage_v2/del.html',pName:"家禽养殖流程管理",pUrl:'./poultryManagePage_v2/find.html'},

        ]
    },
    {
        name:"养殖管理", open:true, tid:'./aquaculture/find.html',children:
        [
            // {name:"增加",tid:'./aquaculture/aqua_add.html',pName:"养殖管理",pUrl:'./aquaculture/find.html'},

            {name:"删除",tid:'./aquaculture/del.html',pName:"养殖管理",pUrl:'./aquaculture/find.html'},

        ]
    },
    {
        name:"死淘管理", open:true, tid:'./ddl_v2/find.html',children:
        [
            {name:"删除",tid:'./ddl_v2/del.html',pName:"死淘管理",pUrl:'./ddl_v2/find.html'},
        ]
    },
    {
        name:"免疫/疾病管理", open:true, tid:'./epi_v2/find.html',children:
        [
            {name:"删除",tid:'./epi_v2/add.html',pName:"免疫隔离管理",pUrl:'./epi_v2/find.html'},

        ]
    },
    {
        name:"禽舍管理", open:true, tid:'./fowleryManagePage_v2/find.html',children:
        [
            {name:"增加",tid:'./fowleryManagePage_v2/aqua_add.html',pName:"禽舍管理管理",pUrl:'./fowleryManagePage_v2/find.html'},


        ]
    },
    {
        name:"出厂管理", open:true, tid:'./outPoultry/find.html',children:
        [
            // {name:"增加",tid:'./outPoultry/add.html',pName:"出库管理",pUrl:'./outPoultry/find.html'},
            {name:"删除",tid:'./outPoultry/del.html',pName:"出库管理",pUrl:'./outPoultry/find.html'},

        ]
    }

];
/**
 * 物资管理模块
 * @type {[*]}
 */
var zNodes_storageInfoM = [
    {
        name:"物资管理", open:true, tid:'./outStorage_v2/find.html',children:
        [

            {name:"增加",tid:'./outStorage_v2/aqua_add.html',pName:"物资管理",pUrl:'./outStorage_v2/find.html'},

        ]
    },
];

var zNodes_empInfoM = [
    {   //列出所有员工，但是，员工的密码是没办法看到的
        name:"员工信息管理", open:true, tid:'./empManagePage/showEmp.html',children:
        [   //办理入职的时候，主要罗列出处于离职状态的员工，为其办理入职手续
            {name:"办理入职",tid:'./empManagePage/addEmp.html',pName:"员工信息管理",pUrl:'./empManagePage/showEmp.html'},
            //解雇/删除，主要罗列出处于入职状态的员工，办理离职手续手续
            {name:"解雇/删除员工信息",tid:'./empManagePage/del_fireEmp.html',pName:"员工信息管理",pUrl:'./empManagePage/showEmp.html'}
        ]
    },
];

var zNodes_dictM = [
    {
        name:"字典管理", open:true, tid:'./dic/find.html',children:
        [
            {name:"增加栏目",tid:'./dic/add.html',pName:"字典管理",pUrl:'./dic/find.html'},
            {name:"增加栏目子字段",tid:'./dic/sub_add.html',pName:"字典管理",pUrl:'./dic/find.html'},

        ]
    },
]
var zTree = '';
// setPath(1,'./employeeManagePage/add.html','增加员工')

/**
 * 1\初始化事默认是管理模块呈现
 * 2\然后是模块的切换
 */
$(document).ready(function(){
    zTree = $.fn.zTree.init($("#menu"), setting, zNodes_aquaInfoM);
    $('#aquaInfoM span').addClass('active');
    $('.all-option li').click(function () {
        $('.all-option li span').removeClass('active');
        $(this).find('span').addClass('active');
        var id = $(this).find('label').attr('id');
        switch (id){
            case 'userInfoM':zTree = $.fn.zTree.init($("#menu"), setting, zNodes_userInfoM);
                setPath(1,zNodes_userInfoM[0].tid,zNodes_userInfoM[0].name);
                displayPath(1);
                break;
            case 'aquaInfoM':zTree = $.fn.zTree.init($("#menu"), setting, zNodes_aquaInfoM);
                setPath(1,zNodes_aquaInfoM[0].tid,zNodes_aquaInfoM[0].name);
                displayPath(1);
            break;
            case 'storageInfoM':zTree = $.fn.zTree.init($("#menu"), setting, zNodes_storageInfoM);
                setPath(1,zNodes_storageInfoM[0].tid,zNodes_storageInfoM[0].name);
                displayPath(1);
            break;
            case 'empInfoM':zTree = $.fn.zTree.init($("#menu"), setting, zNodes_empInfoM);
                setPath(1,zNodes_empInfoM[0].tid,zNodes_empInfoM[0].name);
                displayPath(1);
            break;
            case 'dicM':zTree = $.fn.zTree.init($("#menu"), setting, zNodes_dictM);
                setPath(1,zNodes_dictM[0].tid,zNodes_dictM[0].name);
                displayPath(1);
                break;
            default:break;
        }
    });
});
function zTreeOnclick(e,pid,treeNodes){
    emptyPath(2);
    emptyPath(1);
    if(!treeNodes.children){//没子节点的设置路径2
        setPath(1,treeNodes.pUrl,treeNodes.pName);
        setPath(2,treeNodes.tid,treeNodes.name);
        displayPath(2);
    }else{                 //否则就设置路径1
        setPath(1,treeNodes.tid,treeNodes.name);
        displayPath(1);
        //findxx()根据xx返回所有人员信息 这里要用ajax 获取人员数据
    }
}

