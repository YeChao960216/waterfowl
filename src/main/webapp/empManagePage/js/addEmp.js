﻿/*
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
    const oURL = {
        PAGE:1,
        COUNT:15,
        PRONAME:'/waterfowl',
        GETNOTWORKER:'/admin/user/list',
        ADDEMP:'/admin/user/entry/',
    };

    var oContent = $('#content')[0];

    function initView(){
        $.get(oURL.PRONAME+oURL.GETNOTWORKER+'?sign=2',function(data){
            console.log(data);
            if(data.length!=0){
                data = new DataFilter({
                    data:data.list,
                    type:'userInfo'
                });

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
     * 办理入职操作
     *
     */
    $('#content').on("click","[data-id*=add]",function(){
        var emp_id = $(this).attr('data-id').substr(3);
        console.log(emp_id);
        $.post(oURL.PRONAME+oURL.ADDEMP+emp_id,function(data){
            if(data.status==1){//修改成功
                initView();
            }else{
                alert('本次操作失败');
            }
        });
    })

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