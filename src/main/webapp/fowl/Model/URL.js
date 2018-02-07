/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2018-02-05 17:34:47 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-02-06 20:49:09
 *
 */

/**
 * URL模块
 */

const URL = {

    project_name:{name:'/waterfowl'},

    dict_list:{name:'/dict/list?pageSize=1000&pageNum=1',dataDescription:'list'},              //字典翻译

    firm:{name:'/transcompany/listtranscompany?pageSize=1000&pageNum=1',dataDescription:'list'},          //公司信息

    company_list_findById:{name:'/transcompany/show/'},                      //根据id查找公司信息

    outpoultry_findById:{name:'/outpoultry/show/'},   //出库表,通过溯源码来找

    patch_findById:{name:'/admin/patch/showPatch/'},    //通过批次号找到入库记录

    poultry_list:{name:'/poultry/list',dataDescription:'list'},      //查找入库信息
    
    germchit_findById:{name:'/germchit/show/'},                     //查找种苗信息

    aqua_list_findByIdPatch:{name:'/aquaculture/list',dataDescription:'list'},  //查找养殖记录

    ddl_list_findByIdPatch:{name:'/ddl/findList',dataDescription:'list'},      //查找死淘记录

    epi_list_findByIdPatch:{name:'/epidemic/findList',dataDescription:'list'},    //查找免疫疾病记录

    manu_list_findByIdPatch:{name:'/manufacture/list',dataDescription:'list'},     //查找加工记录

    transferInfo_list_findByIdPatch:{name:'/transportation/listtransportation',dataDescription:'list'},              //查找运输记录

    aqua_vue_findByIdPatch:{name:'/aquaculture/showWeight?idPatch='},//养殖视图的呈现

    ddl_vue_findByIdPatch:{name:'/ddl/deathMethod?idPatch='},//死淘信息视图呈现

    epi_vue_findByIdPatch:{name:'/epidemic/diseaesMethod?idPatch='},//免疫表的呈现

    transfer_end:{name:'/transcompany/show/'},//得到该批发商的位置也就是物流的终点信息
}
