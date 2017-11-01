/*
 * @Author: 伟龙-Willon 
 * @Date: 2017-09-26 17:27:30 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-10-17 17:49:02
 * 表单验证
 */
/**
 * 这样的方法其实有一些缺陷的，
 * 1、添加时、万一有些人恶意的调用addMethod 的方法进行随便添加，有可能会导致原型链上的某个方法被重写
 * 2、调用时、万一是给其他人用的，也有可能存在，人家随意调用他说写的方法的情况，我这里的没有报错或者其他提示信息，代码的友好性不够
 * 
 * 解决方法。使用对象接口的引用，可以解决
 */
/**
 * It can 
 * checkUserName(obj,content);
 * checkPassword
 * checkEmail
 * checkCellPhone
 * checkIDCard
 * checkPostalCode
 * has 6 methods
 * has 6 methods
 */
/**
 * 链式增加验证方法
 */

 var checkForm = (function(){               //检验表单的单体
     var methods = {};//存储检验方法的库，内部静态私有变量
     var flag = true;
     return{
        check:function(attrName,obj,val){
            val = val || obj.value;
            if(methods[attrName]){
                try{
                    methods[attrName](obj,val);
                    flag = true;
                }catch(e){
                    console.error(e);
                    flag = false;
                }finally{
                    return this;
                }
            }else{
                throw new Error('调用的方法不存在');
            }
        },
        addMethod:function(attrName,fn){
            if(typeof(fn) === 'function'&& typeof(attrName)==='string'){
                if(methods[attrName]){
                    throw new Error('此类型检验的方法已经存在');
                }else{
                    methods[attrName] = fn;
                    return this ;
                }
            }else{
                throw new Error('添加验证方法失败！！！第一个参数的类型为普通字符串，第二个参数的类型应该为一个函数');
            }
        },
        showAll:function(){
           for(var attr in methods){
               console.log(methods[attr]);
           }
           return this;
        },
        reset:function(attrName,fn){
            methods[attrName] = fn;
            return this;
        },
        end:function(){
            return flag;
        }
     }
 })();
 checkForm.addMethod('userName',function(obj,content){//验证用户名
     var reg = /^[\u4E00-\u9FA5A-Za-z0-9_]+$/;
     var len = content.length;
     if(len==0){
        obj.innerHTML = '用户名不能为空';
        throw new Error('用户名不能为空');
     }else if(len>15){//长度约束
        obj.innerHTML = '用户名长度不能超过15个字符';
        throw new Error('用户名长度不能超过15个字符');
     }else if(!reg.test(content)){//验证账号的合法性 中文、英文、数字包括下划线：^[\u4E00-\u9FA5A-Za-z0-9_]+$
         obj.innerHTML = '您的输入具有非法字符';
         throw new Error('您的输入具有非法字符');
     }else{
        hideTips(obj);
        this.flag = true;
        return this;
    }

 }).addMethod('email',function(obj,content){     //验证邮箱
     var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
     if(!reg.test(content)){
         obj.innerHTML = '邮箱不合法';
         throw new Error('邮箱不合法');
     }else{
         hideTips(obj);
         this.flag = true;
         return this;
     }
 }).addMethod('cellphone',function(obj,content){ //验证手机号
     var reg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
     if(content.length != 0){
        if(!reg.test(content)){
            obj.innerHTML = '手机号不合法';
            throw new Error('手机号不合法');
        }else{
            hideTips(obj);
            this.flag = true;
            return this;
        }
    }else{
        obj.innerHTML = '手机号为空';
    }
 }).addMethod('IDCard',function(obj,content){  //验证身份证      (15位、18位数字)，最后一位是校验位，可能为数字或字符X
     var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
     if(!reg.test(content)){
        obj.innerHTML = '身份证号不合法';
        throw new Error('身份证号不合法');
     }else{
         hideTips(obj);
         this.flag = true;
         return this;
     }
 }).addMethod('postalCode',function(obj,content){//验证中国邮政编码：[1-9]\d{5}(?!\d) (中国邮政编码为6位数字)
     var reg = /[1-9]\d{5}(?!\d)/;
     if(!reg.test(content)){
        obj.innerHTML = '邮政编码不合法';
        throw new Error('邮政编码不合法');
     }else{
         hideTips(obj);
         this.flag = true;
         return this;
     }
 }).addMethod('password',function(obj,content){ //验证密码(以字母开头，长度在6~18之间，只能包含字母、数字和下划线)：
    var reg = /^[a-zA-Z]\w{5,17}$/;
    var len = content.length;
    if(len==0){
        obj.innerHTML='密码为空';
        throw new Error('密码为空');
    }else if(len<6||len>18){
        obj.innerHTML='密码长度应该在6-18之间';
        throw new Error('密码长度应该在6-18之间');
    }else if(!reg.test(content)){
        obj.innerHTML='请以字母开头，长度在6~18之间';
        throw new Error('密码格式错误，请以字母开头，长度在6~18之间');
    }else{
        hideTips(obj);
        this.flag = true;
        return this;
    }
 });
 /**.addMethod('verifyCode',function(url,obj,content))
  * 处理验证码的是时候可以传入url return ...
    $.ajax({
			 //xhrFields:{withCredentials:true},
			 type:"get",
			 url:url+foreCheckImgCodePath,                                   //检查验证码路径；
			 dataType : "json",
			 data : {"imgCode":content},
			 success : function(data, textStatus) {
                var stat = eval(data).verbose;
                if(stat!=content)
                    return false;
			 	},
			 error : function(xhr, status, errMsg) {
				 $("#badTips").text("数据传输失败！！抱歉");
			    }
	});
  */

var hideTips = function(obj,delay){
     var t = delay || 0;
     var timer = setTimeout(function(){
        obj.innerHTML = '';
        clearTimeout(timer);
     },t);
 }
 