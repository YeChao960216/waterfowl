(function(){
    const oUrl = {
        PRONAME:'/waterfowl',
        READYUPDATEINFO:PRONAME+'',
        UPDATEINFO:PRONAME+''
    }
    var oPerson = { 
        _phone :'',
        _username : '',
        _gender : '',
        _name : '',
        _remark : '',
        get gender(){
            return this._gender;
        },
        set gender(gender){
            var $radio = $(':radio');
                $radio.prop('ckecked',false);
            if(gender=='男'){
                $radio[0].checked = true;
            }else{
                $radio[1].checked = true;
            }
            this._gender = gender;
        }
    }
    // oPerson.gender = '女';
    // $.get(oUrl.READYUPDATEINFO,function(data){
    //     if(data){  //补全对象,显示
    //         $('#phone')[0].innerHTML = oPerson._phone = data.phone;
    //         $('#username')[0].innHTML = oPerson._username = data.username;
    //         $('#gender')[0].innerHTML = oPerson.gender = data.gender;
    //         $('#name')[0].innerHTML = oPerson._name = data.name;
            // $('#remark')[0].innerHTML = oPerson._remark = data.remark;
    //         
    //     }else{
    //         throw new Error('获取用户信息失败');
    //     }
    // });
    //  $.post(oUrl.UPDATEINFO,{
    //      //     if(data){  //补全对象,显示
    //         phone:oPerson._phone,
    //         username:oPerson._username,
    //         gender:oPerson.gender,
    //         name:oPerson._name,
    //         remark:oPerson._remark,
    // },function(data){
    //     if(data){
    //         alert(data.msg);
    //     }else{
    //         throw new Error('修改失败！！！');
    //     }
    // });
    //         
    //     }else{
    //         throw new Error('获取用户信息失败');
    //     }
    // });
    
})();