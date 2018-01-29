/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-19 20:06:12 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-19 20:07:52
 */

(function(global){
    
        /**
         * oURL 对象
         */
        const oURL = {
            PRONAME:'/waterfowl',
            GETEPILIST:'/epidemic/findList',
            DEL:'/epidemic/delete/',
            GETFINDPATCHBYPID:'/admin/patch/findPatchByPid/'+getRequest()['id'],
        };

    /**
     * 填充入厂信息->展现所有的批次
     */
    var preDataObj = getRequest();
    viewCommand({
        command:'display',
        param:[$('#preContent')[0],preDataObj,'poultry_nav']
    });

    /**
     * 展现所有的批次->批次中管理按钮
     */
    $.get(oURL.PRONAME+oURL.GETFINDPATCHBYPID,function(res){
        if(res.object.length){
            var data = new DataFilter({
                data:res.object,
                type:'filterTimeAndNull'
            });
            viewCommand({
                command:'display',
                param:[$('#content')[0],data,'epi_list']
            });
        }
    });



    /**
     * 实例化一个分页控制者
     */
    var pageController = new PageController({

        url:oURL.PRONAME+oURL.GETEPILIST,

        view:{
            container : $('#content')[0],
            tpl:'epi_v2_show',
            nowView:$('#now')[0],
            allView:$('#all')[0],
        },
        pageBean:{
            pageDescription:'pageNum',
            countDescription:'pageSize',
            dataDescription:'list',
            totalDescription:'pages',
            count:'10',
        },
        dataFilter:{
            tpl:'filterTimeAndNull',
        },
        dom:{
            nextBtn :$('#next')[0],
            preBtn:$('#pre')[0],
            jumpBtn:$('#jumpTo')[0],
            jumpVal:$('#jumpText')[0],
        },

    });

    /**
     * 找出该批次号对应的养殖记录信息
     */
    $('#content').on('click',"[data-id*='E']",function(){
        var id = $(this).attr('data-id').substr(1);
        pageController.other = '&idPatch='+id;
        $('#patchInfo').addClass('none');
        $('#epiInfo').removeClass('none');
        // var $tar = $(this).parent().parent();
        // var child_length  = $tar.children().length;
        // $tar.find('td')[child_length-1].remove();
        // $('#nowpatchContent').html($tar);
        $('#content').empty();
        pageController.init();
    });

    /**
     *
     * 提交删除的id值
     1、删除成功后，初始化视图
     */
    $('#content').on('click',"[data-id*='del']",function(){
        var id = $(this).attr('data-id').substr(3);
        $.get(oURL.PRONAME+oURL.DEL+id,function(res){
            if(res.status){
                pageController.init();
            }else{
                alert('删除对象条目失败');
            }
        });
    });

})();