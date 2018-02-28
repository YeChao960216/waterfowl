$(function(){
    const oUrl = {
        PRONAME:'/waterfowl',
        READYUPDATEINFO:'/user/nowUserInfo',
        UPDATEINFO:'/admin/user/edit/'
    };
    var oPerson = {
        _id:'',
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
            if(gender==1){
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
            oPerson._id = data.id;
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
    $(":radio").change(function(){
        oPerson.gender =  $(":checked").val();
        console.log(oPerson.gender);
    });
    $('#submit').click(function () {
        console.log('post');
        $.post(oUrl.PRONAME+oUrl.UPDATEINFO+oPerson._id,{
            phone:$('#phone')[0].value,
            username:$('#username')[0].value,
            gender:oPerson.gender,
            name:$('#name')[0].value,
            remark:$('#remark')[0].value,
        },function(data){
            if(data){
                alert(data.msg);
            }else{
                alert("抱歉！修改失败");
            }
        });
    })
});