/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-10-25 14:56:54 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-04 17:56:07
 */
/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-10-18 14:14:12 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-10-25 14:43:19
 * 
 * 介绍
 *      视图模板引擎的封装
 * 使用
 *      使用命令模式来使用 
 *      viewCommand({
 *          command:'display',
 *          param:[dom,objArr,'tplName']     试图显示位置（obj），对象数组[object Array]||[object]，使用的模板名称（String）
 *      })
 */
var viewCommand = (function(msg){
     var html  = '';                          //模板字符拼接缓冲区
     var tpl = {                              //模板集合
         list:[
             '<li>{#text#}</li>'
         ].join(''),
         option:[
             '<option value={#value#}>{#text#}</option>'
         ].join(''),
         empInfo:[
            '<tr>',
                '<td >{#phone#}</td>',
                '<td >{#name#}</td>',
                '<td >{#gender#}</td>',
                '<td >{#entry#}</td>',
                '<td >{#sign#}</td>',
                '<td >{#role_id#}</td>',
                '<td ><button id="show{#id#}" class="btn">详情</button></td>',
            '</tr>'
         ].join(''),
         addEmp:[
            '<tr>',
                '<td >{#phone#}</td>',
                '<td >{#name#}</td>',
                '<td >{#gender#}</td>',
                '<td >{#entry#}</td>',
                '<td >{#sign#}</td>',
                '<td ><button id="add{#id#}" class="btn">办理入职</button></td>',
            '</tr>'
         ].join(''),
         del_fireEmp:[
            '<tr>',
                '<td >{#phone#}</td>',
                '<td >{#name#}</td>',
                '<td >{#gender#}</td>',
                '<td >{#entry#}</td>',
                '<td >{#sign#}</td>',
                '<td >{#role_id#}</td>',
                '<td ><button id="fire{#id#}" class="btn">解雇</button></td>',
                '<td ><button id="del{#id#}" class="btn">删除信息</button></td>',
            '</tr>'
         ].join(''),
         powerForEmp:[
            '<tr>',
                '<td >{#phone#}</td>',
                '<td >{#name#}</td>',
                '<td >{#gender#}</td>',
                '<td >{#entry#}</td>',
                '<td >{#sign#}</td>',
                '<td >{#role_id#}</td>',//点击后弹窗赋予select角色
                '<td ><button id="powerFor{#id#}" class="btn">赋予角色</button></td>',
            '</tr>'
         ].join(''),
     };
     function formateString(str,obj){         //模板核心代码，替换{# #}之间的字符串
         return str.replace(/\{#(\w+)#\}/g,function(match,key){
            return obj[key];
         })
     }
     var Action = {                            //方法集合
         create : function(data,view){         //批量格式化字符串
            if(data.length){
                for(var i=0,len=data.length;i<len;i++){
                    html+=formateString(tpl[view],data[i]);
                }
            }else{
                html+=formateString(tpl[view],data); //直接格式化字符串缓存到html 中
            }
         },
         display : function(container,data,view){
             if(data){
                 this.create(data,view);//根据数据先格式化字符串后马上传入html 缓冲区 以便一会使用
             }
             if(typeof container !='object'){
                 throw new Error('第一个参数的类型应该为obj string')
             }else{
                 container.innerHTML = html;//展示
                 html = '';                 //展示后清空模板缓冲
             }
         }
     }
     return function excute(msg){                 //向外暴露一个命令接口，总指挥作用
        //msg.param 不是数组就强转为数组
        msg.param = Object.prototype.toString.call(msg.param) === '[object Array]'?msg.param:[msg.param];
        //保证Action内部的this,指向
        //console.log(this);此时是window，因为它暴露出去了；
        Action[msg.command].apply(Action,msg.param);
    }  
})();


 
