/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-10-26 16:27:25 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-10-26 17:09:40
 */
(function () {
    /**
     * 向后台发送URL，获取所有在职人员的信息
     */
    const oURL = {
        PAGE:1,
        COUNT:15,
        PRONAME:'/waterfowl/',
        SHOWEMPINFO:'admin/user/list',
    };
    /**
     *视图位置
     */
    var oContent = $('#content')[0];
    /**
     *渲染视图
     */
    function initView(){
        $.get(oURL.PRONAME+oURL.SHOWEMPINFO+'?sign=1',function(data){
            console.log(data);
            if(data.length!=0){
                /**
                 *处理一下数据
                 */
                data = new DataFilter({
                    data:data.list,
                    type:'userInfo'
                });
                /**
                 *渲染一下页面
                 */
                viewCommand({
                    command:'display',
                    param:[oContent,data,'addEmp']
                })
            }
        })
    }
    initView();
    /**
     * jq
     * 跳转页面进行职员详细信息的查看操作
     *
     */
    $('#content').on("click","[id*=show]",function(){
        var emp_id = $(this).attr(id).substr(3);
        console.log(emp_id);
        window.location.href="./showEmpDetail.html?id="+emp_id;
    });

})()

