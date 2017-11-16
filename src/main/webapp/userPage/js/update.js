$(function(){
    const oUrl = {
        PRONAME:'/waterfowl',
        READYUPDATEINFO:'/user/nowUserInfo',
        UPDATEINFO:'/user/updateInfo'
    };
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
    };

    $.get(oUrl.PRONAME+oUrl.READYUPDATEINFO,function(data){
        //补全对象,显示
        if(data){
            $('#phone')[0].value = oPerson._phone = data.phone;
            $('#username')[0].value = oPerson._username = data.username;
            oPerson.gender = data.gender;
            $('#name')[0].value = oPerson._name = data.name;
            oPerson._remark = data.remark;
            $('#remark')[0].value = (oPerson._remark)? oPerson._remark : '';
        }else{
            throw new Error('获取用户信息失败');
        }
    });
    $('#submit').click(function () {
        console.log('post');
        $.post(oUrl.PRONAME+oUrl.UPDATEINFO,{
            phone:oPerson._phone,
            username:oPerson._username,
            gender:oPerson.gender,
            name:oPerson._name,
            remark:oPerson._remark,
        },function(data){
            if(data){
                alert(data.msg);
            }else{
                throw new Error('修改失败！！！');
            }
        });
    })
});