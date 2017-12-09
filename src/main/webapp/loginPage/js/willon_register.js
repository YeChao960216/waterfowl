(function(){
        var cellphone = W('#cellphone'),
            nickname = W('#nickname'),
            password1 = W('#password1'),
            password2 = W('#password2'),
            verifyCode = W('#verify'),
            sign_in = W('#sign_in'),
            imgC = document.getElementsByTagName('img')[1],
            flag = {};
        //console.log(imgC,sign_in);
        bindEvent(cellphone,'blur',function(){
            flag.cellphone = checkForm.check('cellphone',cellphone.nextElementSibling,cellphone.value).end();
            if(flag.cellphone){
                $.get('/waterfowl/user/CheckPhone?phone='+cellphone.value,function (data) {
                    if(data.status==1){
                        flag.cellphone = true;
                        hideTips(cellphone.nextElementSibling);
                    }else{
                        flag.cellphone = false;
                        cellphone.nextElementSibling.innerHTML = data.msg;
                    }
                })
            }
        });
        bindEvent(nickname,'blur',function(){
            flag.uername = checkForm.check('userName',nickname.nextElementSibling,nickname.value).end();
        });
        bindEvent(password1,'blur',function(){
            flag.password1 = checkForm.check('password',password1.nextElementSibling,password1.value).end();
        });
        bindEvent(password2,'blur',function(){
            if(password1.value!==password2.value){
                password2.nextElementSibling.innerHTML = '密码不一致';
                flag.password2 = false;
            }else{
                flag.password2 = true;
                hideTips(password2.nextElementSibling);
            }
        });
        // bindEvent(email,'blur',function(){
        //     flag.email = checkForm.check('email',email.nextElementSibling,email.value).end();
        // });
        bindEvent(imgC,'click',function(){
            imgC.src = '/waterfowl/images/imagecode?p='+new Date().getTime();
        });
        bindEvent(verifyCode,'keyup',function(){
            flag.verifyCode = false;
            if(verifyCode.value.length >= 4){
                $.get('/waterfowl/images/checkcode?checkCode='+verifyCode.value,function (data) {
                    if(data.status==1){
                        flag.verifyCode = true;
                        hideTips(verifyCode.nextElementSibling);
                        console.log(data.status);
                    }else{
                        flag.verifyCode = false;
                        console.log(data.status);
                        verifyCode.nextElementSibling.innerHTML = "验证码错误";
                    }

                })

            }
        });
        bindEvent(sign_in,'click',function(){//最后再检测一次是否有错
            var canSign = false;
            for(var attr in flag){
                if(!flag[attr]){
                    canSign = false;
                    break;
                }else{
                    canSign = true;
                }
            }
            if(canSign){
                $.post('/waterfowl/user/register',
                    {  'phone':cellphone.value,
                        'username':nickname.value,
                        'password':md5(password2.value),
                        'verifyCode':verifyCode.value,
//                        'name':'',
//                        'gender':1,
//                        'sign':0,
//                        'role_id':'null'
                    },function(data){
                    if(data.status==1){
                        window.location.href = './login.html';
                    }else{
                        alert('可能是系统的内部错误，注册失败');
                    }
                })
            }else{
                alert('注册失败,请正确填写相关信息');
            }
        });
    })();