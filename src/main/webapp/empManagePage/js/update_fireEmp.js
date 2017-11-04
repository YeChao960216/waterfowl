/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-04 17:52:20 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-04 18:13:26
 */
(function(){
    /**
     * oUrl对象
     * 1、解雇职员
     * 2、完全删除职员信息
     */
    const oUrl = {
        WORKEMPINFO:'',
        FIREEMP : '',
        DELEMP:'',
    }
    /**
     * 马上渲染试图
     * 
     */
    var initUpdate_fireView = function(){
        $.get(oUrl.WORKEMPINFO,function(data){
            if(data){
                viewCommand({
                    command:'display',
                    param:[$('#content')[0],data,'update_fireEmp']
                })
            }
        });
    }();
    /**
     * 对应着两个option操作
     * @param {*} url 
     * @param {*} id 
     * @param {*} cb 
     */
    var option = function(url,id,cb){
        $.post(url,{'id':id},function(data){
            if(data.status==1){//成功
                cb&&cb();
            }
        });
    }
    /**
     * 触发两个事件委托
     */
    $('#content').on("click","[id*='fire']",function(){
        if(confirm('确认解雇该员工吗？')){
            var id = $(this).id.substr(3);
            option(oUrl.FIREEMP,id,initUpdate_fireView);
        }
    });

    $('#content').on("click","[id*='del']",function(){
        if(confirm('确认删除该员工的所有信息吗？')){
            var id = $(this).id.substr(2);
            option(oUrl.DELEMP,id,initUpdate_fireView);
        }
    });
    
    
})();