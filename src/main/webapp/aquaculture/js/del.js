﻿/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 19:47:25 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-19 20:01:54
 */

 (function(global){

    /**
     * oURL 对象
     */
    const oURL = {
        PRONAME:'',
        GETAQUACULTURELIST:'',
        DEL:'',
    };

    /**
     * 渲染禽舍列表视图
     * 1、初始化视图
     */
    var initView = function(){

        $.get(oURL.PRONAME+oURL.GETAQUACULTURELIST,function(res){
            if(res.status){
                viewCommand({
                    command:'display',
                    param:[$('#content')[0],res.list,'del_aquaculture']
                });
            }else{
                alert('获取禽舍信息失败');
            }
         });
    }
    initView();
    
     /**
      * 提交删除的id值
        1、删除成功后，初始化视图
      */
      $('#content').on('click',"[data-id*='del']",function(){
         var id = $(this).arrt('data-id').strsub(3);
         $.get(oURL.PRONAME+oURL.DEL,function(res){
            if(res.status){
                initView();
            }else{
                alert('删除对象条目失败');
            }
         });
      });
      
 })(this);