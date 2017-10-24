(function(){
    var cellphone = W('#cellphone'),
         password = W('#password'),
         remeber = W('#remeber'),
         flag = {};
    var save = function(key,val){
        if(val&&remeber.checked){
            if(localStorage){
                localStorage.setItem(key,val);
            }else if(document.cookie){
                setCookie(key,val);
            }else{
                alert('您的浏览器已经落后，请更换浏览器,来获取更佳体现');
            }
        }else{
            alert('请您先填写相关信息');
            remeber.checked = false;
        }
        
    }
    cellphone.value = getLocalInfo('willon_phone');
    password.value = getLocalInfo('willon_passw');
    if(cellphone.value&&password.value){
        remeber.checked = true;
    }
    bindEvent(remeber,'click',function(){
        if(!remeber.checked){
            removeLocalInfo('willon_phone');
            removeLocalInfo('willon_passw');
        }else{
            var phone = cellphone.value;
            var passw = password.value;
            save('willon_phone',phone,'请填写手机号');
            save('willon_passw',passw,'请填写密码'); 
        }
    });
    bindEvent(cellphone,'blur',function(){
        flag.cellphone = checkForm.check('cellphone',cellphone.nextElementSibling,cellphone.value).end();
    });
    bindEvent(login,'click',function(){
        var canLogin = false;
        for(var attr in flag){
            if(!flag[attr]){
                canLogin = false;
                break;
            }else{
                canLogin = true;
            }
        }
        if(!canLogin){
            if(checkForm.check('cellphone',cellphone.nextElementSibling,cellphone.value).end()&&password.value){//二次登陆，再一次检验
                var phone = cellphone.value;
                var passw = password.value;
                if(remeber.checked){
                    save('willon_phone',phone,'请填写手机号');
                    save('willon_passw',passw,'请填写密码'); 
                }
                ajax.post('/user/login',{'phone':phone,'password':passw},function(data){
                    if(data.status==0){
                        sessionStorage.setItem('system_user',data.username);
                        window.location.href='/index.html';
                    }
                })
            }else{
                alert('填写格式有误，或为空');
            }
        }else{
            if(remeber.checked){
                var phone = cellphone.value;
                var passw = password.value;
                save('willon_phone',phone,'请填写手机号');
                save('willon_passw',passw,'请填写密码'); 
            }
            ajax.post('/user/login',{'phone':phone,'password':passw},function(data){
                if(data.status==0){
                    sessionStorage.setItem('user',data.username);
                    window.location.href='/index.html';
                }
            })
        }
    });
    })();
    