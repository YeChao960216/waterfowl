/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-10-25 14:56:54 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-27 21:29:15
 */
/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-10-18 14:14:12 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-10-25 14:43:19
 * 
 * 介绍
 *      视图模板引擎的封装
 * 使用
 *      使用命令模式来使用 
 *      viewCommand({
 *          command:'display',
 *          param:[dom,objArr,'tplName']     试图显示位置（obj），对象数组[object Array]||[object]，使用的模板名称（String）
 *      })
 */
var viewCommand = (function(msg){
     var html  = '';                          //模板字符拼接缓冲区
     var tpl = {                              //模板集合
         list:[
             '<li>{#text#}</li>'
         ].join(''),
         idFowlery:[
             "<option value='{#idFowlery#}'>{#idFowlery#}</option>"
         ].join(''),
         option:[
             "<option value='{#name#}'>{#name#}</option>"
         ].join(''),
         id_name:[
             "<option value='{#id#}'>{#name#}</option>"
         ].join(''),
         firm_name:[
             "<option value='{#firm#}${#name#}'>{#firm#}-{#name#}</option>"
         ].join(''),
         type_name:[
             "<option value='{#type#}'>{#name#}</option>"
         ].join(''),
         id:[
             "<option value='{#id#}'>{#id#}</option>"
         ].join(''),
         tidAndname:[
             "<option value='{#tid#}${#name#}'>{#name#}</option>"
         ].join(''),
         tid_name:[
             "<option value='{#tid#}'>{#name#}</option>"
         ].join(''),
         cid_name:[
             "<option value='{#cid#}'>{#name#}</option>"
         ].join(''),
         idPatch:[
             "<option value='{#idPatch#}'>{#idPatch#}</option>"
         ].join(''),
         type:[
             "<option value='{#type#}'>{#type#}</option>"
         ].join(''),
         outStorage:[
             "<option value='{#idOutstorage#}'>{#idOutstorage#}</option>"
         ].join(''),
         outPatch:[
             "<option value='{#idPatch#}'>{#idPatch#}</option>"
         ].join(''),
         empInfo:[
            '<tr>',
                '<td >{#phone#}</td>',
                '<td >{#name#}</td>',
                '<td >{#gender#}</td>',
                '<td >{#entry#}</td>',
                '<td >{#sign#}</td>',
                '<td >{#duty#}</td>',
                '<td ><button id="show{#id#}" class="btn">详情</button></td>',
            '</tr>'
         ].join(''),
         addEmp:[
            '<tr>',
                '<td >{#phone#}</td>',
                '<td >{#name#}</td>',
                '<td >{#gender#}</td>',
                '<td >{#entry#}</td>',
                '<td >{#sign#}</td>',
                '<td >{#role_id#}</td>',
                '<td ><button data-id="add{#id#}" class="btn">办理入职</button></td>',
            '</tr>'
         ].join(''),
         del_fireEmp:[
            '<tr>',
                '<td >{#phone#}</td>',
                '<td >{#name#}</td>',
                '<td >{#gender#}</td>',
                '<td >{#entry#}</td>',
                '<td >{#sign#}</td>',
                '<td >{#role_id#}</td>',
                '<td ><button id="fire{#id#}" class="btn">解雇</button></td>',
                '<td ><button id="del{#id#}" class="btn">删除信息</button></td>',
            '</tr>'
         ].join(''),
         powerForEmp:[
            '<tr>',
                '<td >{#phone#}</td>',
                '<td >{#name#}</td>',
                '<td >{#gender#}</td>',
                '<td >{#entry#}</td>',
                '<td >{#sign#}</td>',
                '<td >{#role_id#}</td>',//点击后弹窗赋予select角色
                '<td ><button id="powerFor{#id#}" class="btn">赋予角色</button></td>',
            '</tr>'
         ].join(''),
         find_edit_aquaculture:[
             '<tr>',
             '<td >{#idPatch#}</td>',
             '<td >{#name#}</td>',
             '<td >{#idFowlery#}</td>',
             '<td >{#recordDate#}</td>',
             '<td >{#numTotal#}</td>',
             '<td >{#remark#}</td>',
             '<td >{#feedType#}</td>',
             '<td >{#feedWeight#}</td>',
             '<td >{#idRecorder#}</td>',
             '<td >{#idCharge#}</td>',
             '<td >{#idOutstorage#}</td>',
             '<td >{#status#}</td>',
             "<td ><a class='btn' href='./edit.html?id={#id#}'>修改</a></td>",
             '<td ><button class="btn" data-id="del{#id#}">删除</button></td>',
             '</tr>'
         ].join(''),
         patch_first:[
             '<tr>',
             '<td >{#recordDate#}</td>',
             '<td >{#type#}</td>',
             '<td >{#quantity#}</td>',
             '<td >{#associatedFirm#}</td>',
             '<td >{#phone#}</td>',
             '<td >{#idRecorder#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><a class="btn" data-id="P{#idPoultry#}" data-idR="{#idRecorder#}" ' +
             'data-idC="{#idCharge#}" data-recordeDate="{#recordDate#}" ' +
             'data-type="{#type#}" data-quantity="{#quantity#}" data-phone={#phone#} ' +
             'data-firm="{#associatedFirm#}"  >批次信息</a></td>',
         ].join(''),
        aqua_first:[
            '<tr>',
            '<td >{#recordDate#}</td>',
            '<td >{#type#}</td>',
            '<td >{#quantity#}</td>',
            '<td >{#associatedFirm#}</td>',
            '<td >{#phone#}</td>',
            '<td >{#idRecorder#}</td>',
            '<td >{#idCharge#}</td>',
            '<td ><a class="btn"  data-id="P{#idPoultry#}" data-firm="{#associatedFirm#}">批次信息</a></td>',
        ].join(''),
         del_out_poultry:[
            '<tr>',
            '<td >{#idPatch#}</td>',
            '<td >{#type#}</td>',
            '<td >{#quantity#}</td>',
            '<td >{#unit#}</td>',
            '<td >{#firm#}</td>',
            '<td >{#phone#}</td>',
            '<td >{#idRecord#}</td>',
            '<td >{#idCharge#}</td>',
            '<td ><button class="btn" data-id="del{#id#}">删除</button></td>',
            '</tr>'
         ].join(''),
         find_out_poultry:[
            '<tr>',
            '<td >{#idPatch#}</td>',
            '<td >{#type#}</td>',
            '<td >{#quantity#}</td>', 
            '<td >{#unit#}</td>',
            '<td >{#firm#}</td>',
            '<td >{#phone#}</td>',
            '<td >{#idRecord#}</td>',
            '<td >{#idCharge#}</td>',
             "<td ><a class='btn' href='./detail.html?id={#id#}' >详情</a></td>",
             "<td ><a class='btn' href='./edit.html?id={#id#}'>修改</a></td>",
            '</tr>'
        ].join(''),
         fowlery_find:[
             '<tr>',
             '<td >{#affiliation#}</td>',
             '<td >{#size#}</td>',
             '<td >{#status#}</td>',
             '<td >{#name#}</td>',
             '<td >{#idCharge#}</td>',
             "<td ><a class='btn' data-id='del{#id#}'>删除</a></td>",
             "<td ><a class='btn' href='./edit.html?id={#id#}'>修改</a></td>",
             '</tr>'
         ].join(''),
         poultry_find:[
             '<tr>',
             '<td >{#recordDate#}</td>',
             '<td >{#type#}</td>',
             '<td >{#quantity#}</td>',
             '<td >{#associatedFirm#}</td>',
             '<td >{#phone#}</td>',
             '<td >{#idRecorder#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><a class="btn" data-view="V{#idPoultry#}">详情</a></td>',
             '<td ><button class="btn" data-id="P{#idPoultry#}">划分批次</button></td>',
             '<td ><a class="btn" data-check="true" data-id="A{#idPoultry#}">养殖记录</a></td>',
             '<td ><a class="btn" data-check="true" data-id="D{#idPoultry#}">死淘记录</a></td>',
             '<td ><a class="btn" data-check="true" data-id="E{#idPoultry#}">免疫卫生</a></td>',
             '<td ><a class="btn" data-check="true" data-id="O{#idPoultry#}">出厂记录</a></td>',
             '<td ><a class="btn" data-id="del{#idPoultry#}">删除</a></td>',
             '</tr>'
         ].join(''),
         poultry_del:[
             '<tr>',
             '<td >{#type#}</td>',
             '<td >{#quantity#}</td>',
             '<td >{#associatedFirm#}</td>',
             '<td >{#phone#}</td>',
             '<td >{#idRecorder#}</td>',
             '<td >{#idCharge#}</td>',
             "<td ><a class='btn' href='./detail.html?id={#idPoultry#}' >详情</a></td>",
             '<td ><button class="btn" data-id="del{#idPoultry#}">删除</button></td>',
             '</tr>'
         ].join(''),
         poultry_show:[
             '<div class="detail-content">',
                 '<table>',
                    '<caption>入厂信息</caption>',
                     '<tr>',
                         '<th>条目</th>',
                         '<th>信息</th>',
                     '</tr>',
                     '<tr>',
                         '<td>禽舍种类</td>',
                         '<td>{#type#}</td>',
                     '</tr>',
                     '<tr>',
                            '<td>养殖数量</td>',
                         '<td>{#quantity#}</td>',
                     '</tr>',
                     '<tr>',
                        '<td>联系厂商</td>',
                        '<td>{#associatedFirm#}</td>',
                     '</tr>',
                     '<tr>',
                         '<td>联系电话</td>',
                         '<td>{#phone#}</td>',
                     '</tr>',
                     '<tr>',
                         '<td>记录人</td>',
                         '<td>{#idRecorder#}</td>',
                     '</tr>',
                     '<tr>',
                         '<td>负责人</td>',
                         '<td>{#idCharge#}</td>',
                     '</tr>',
                     '<tr>',
                         '<td>备注</td>',
                         '<td >{#remark#}</td>',
                     '</tr>',
                 '</table>',
             '</div>',
         ].join(''),
         patch_list:[
             '<tr>',
             '<td >{#id#}</td>',
             '<td >{#position#}</td>',
             '<td >{#idAffilation#}</td>',
             '<td >{#idFowlery#}</td>',
             '<td >{#type#}</td>',
             '<td >{#numTotal#}</td>',
             '<td >{#size#}</td>',
             '<td >{#date#}</td>',
             '<td >{#status#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><button class="btn" data-id="del{#id#}">删除</button></td>',
             '<td ><button class="btn" data-id="edit{#id#}">修改</button></td>',
             '</tr>'
         ].join(''),
         aqua_list:[
             '<tr>',
             '<td >{#id#}</td>',
             '<td >{#position#}</td>',
             '<td >{#idAffilation#}</td>',
             '<td >{#idFowlery#}</td>',
             '<td >{#type#}</td>',
             '<td >{#numTotal#}</td>',
             '<td >{#size#}</td>',
             '<td >{#date#}</td>',
             '<td >{#idRecorder#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><button class="btn" data-id="A{#id#}">养殖管理</button></td>',
             '</tr>'
         ].join(''),
         ddl_list:[
             '<tr>',
             '<td >{#id#}</td>',
             '<td >{#position#}</td>',
             '<td >{#idAffilation#}</td>',
             '<td >{#idFowlery#}</td>',
             '<td >{#type#}</td>',
             '<td >{#numTotal#}</td>',
             '<td >{#size#}</td>',
             '<td >{#date#}</td>',
             '<td >{#idRecorder#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><button class="btn" data-id="D{#id#}">死淘管理</button></td>',
             '</tr>'
         ].join(''),
         epi_list:[
             '<tr>',
             '<td >{#id#}</td>',
             '<td >{#position#}</td>',
             '<td >{#idAffilation#}</td>',
             '<td >{#idFowlery#}</td>',
             '<td >{#type#}</td>',
             '<td >{#numTotal#}</td>',
             '<td >{#size#}</td>',
             '<td >{#date#}</td>',
             '<td >{#idRecorder#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><button class="btn" data-id="E{#id#}">免疫管理</button></td>',
             '</tr>'
         ].join(''),
         outPoultry_list:[
             '<tr>',
             '<td >{#id#}</td>',
             '<td >{#position#}</td>',
             '<td >{#idAffilation#}</td>',
             '<td >{#idFowlery#}</td>',
             '<td >{#type#}</td>',
             '<td >{#numTotal#}</td>',
             '<td >{#size#}</td>',
             '<td >{#date#}</td>',
             '<td >{#idRecorder#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><button class="btn" data-id="O{#id#}">出厂信息管理</button></td>',
             '</tr>'
         ].join(''),
         patch_show:[
             '<div class="detail-content">',
             '<table style="text-align: center"><caption>批次信息</caption>',
             '<tr >',
             '<th>条目</th>',
             '<th>信息</th>',
             '</tr>',
             '<tr><td>批次号</td><td><select></select></td></tr>' +
             '</table>',
             '<div class="patch-data">',
             '<table>',
             '<tr>',
             '<td>位置</td>',
             '<td>{#position#}</td>',
             '</tr>',
             '<tr>',
             '<td>禽舍规格</td>',
             '<td>{#type#}</td>',
             '</tr>',
             '<tr>',
             '<td>大禽舍编号</td>',
             '<td>{#name#}</td>',
             '</tr>',
             '<tr>',
             '<td>禽舍编号</td>',
             '<td>{#idFowlery#}</td>',
             '</tr>',
             '<tr>',
             '<td>起初养殖的数量</td>',
             '<td>{#numTotal#}</td>',
             '</tr>',
             '<tr>',
             '<td>现在所养数量</td>',
             '<td>{#size#}</td>',
             '</tr>',
             '<tr>',
             '<td>记录人</td>',
             '<td>{#idRecorder#}</td>',
             '</tr>',
             '<tr>',
             '<td>负责人</td>',
             '<td>{#idCharge#}</td>',
             '</tr>',
             '<tr>',
             '<td>分批日期</td>',
             '<td>{#date#}</td>',
             '</tr>',
             '<tr>',
             '<td>备注</td>',
             '<td >{#remark#}</td>',
             '</tr>',
             '</table>',
             '</div>',
             '</div>',
         ].join(''),
         patch_show2:[
             '<div class="patch-data">',
             '<table>',
             '<tr>',
             '<td>位置</td>',
             '<td>{#position#}</td>',
             '</tr>',
             '<tr>',
             '<td>禽舍规格</td>',
             '<td>{#type#}</td>',
             '</tr>',
             '<tr>',
             '<td>大禽舍编号</td>',
             '<td>{#idAffilation#}</td>',
             '</tr>',
             '<tr>',
             '<td>禽舍编号</td>',
             '<td>{#idFowlery#}</td>',
             '</tr>',
             '<tr>',
             '<td>起初养殖的数量</td>',
             '<td>{#numTotal#}</td>',
             '</tr>',
             '<tr>',
             '<td>现在所养数量</td>',
             '<td>{#size#}</td>',
             '</tr>',
             '<tr>',
             '<td>记录人</td>',
             '<td>{#idRecorder#}</td>',
             '</tr>',
             '<tr>',
             '<td>负责人</td>',
             '<td>{#idCharge#}</td>',
             '</tr>',
             '<tr>',
             '<td>分批日期</td>',
             '<td>{#date#}</td>',
             '</tr>',
             '<tr>',
             '<td>备注</td>',
             '<td >{#remark#}</td>',
             '</tr>',
             '</table>',
             '</div>',
         ].join(''),
         patch_add:[
             '<div class="detail-content">',
             '<form onsubmit="return false">',
             '<table>',
             '<caption>批次信息</caption>',
             '<tr>',
             '<th>条目</th>',
             '<th>信息</th>',
             '</tr>',
             '<tr>',
             '<td>该批次起始养殖数量</td>',
             '<td><input type="number" min="0" name="size" ></td>',
             '</tr>',
             '<tr>',
             '<td>该批次位置</td>',
             '<td><select name="position" id="position" class="select-fix-input"></select></td>',
             '</tr>',
             '<tr>',
             '<td>选定规格</td>',
             '<td><select name="type" class="select-fix-input"></select></td>',
             '</tr>',
             '<tr>',
             '<td>大禽舍编号</td>',
             '<td><select name="idAffilation" id="idAffilation" class="select-fix-input"></select></td>',
             '</tr>',
             '<tr>',
             '<td>禽舍编号</td>',
             '<td><select name="idFowlery" id="idFowlery" class="select-fix-input"></select></td>',
             '</tr>',
             '<tr>',
             '<td>负责人</td>',
             '<td><select name="idCharge" id="idCharge" class="select-fix-input"></select></td>',
             '</tr>',
             '<tr>',
             '<td>备注</td>',
             '<td ><textarea name="remark" class="select-fix-input"></textarea></td>',
             '</tr>',
             '<tr>',
             '<td>操作</td>',
             '<td ><button type="submit" onclick="return false" class="btn select-fix-input">提交</button></td>',
             '</tr>',
             '</table>',
             '</form>',
             '</div>',
         ].join(''),
         aqua_add:[
             '<div class="detail-content">'+
                 '<form onsubmit="return false">'+
                 '<table>'+
                 '<caption>养殖记录</caption>'+
                 '<tr>'+
                 '<th>条目</th>'+
                 '<th>信息</th>'+
                 '</tr>'+
                 '<tr>'+
                 '<td>批次号</td>'+
                 '<td><select name="idPatch" id="idPatch" class="select-fix-input"></select></td>'+
                 '</tr>'+
                 '<tr>'+
                 '<td>禽舍编号</td>'+
                 '<td><select name="idFowlery" id="id_fowlery" class="select-fix-input"></select></td>'+
                 '</tr>'+
                 '<tr>'+
                 '<td>该批次在该禽舍养殖的天数</td>'+
                 '<td><input type="number" min="0" name="name" id="name"></td>'+
                 '</tr>'+
                 '<tr>'+
                 '<td>圈养个体数(右侧为预测值)</td>'+
                 '<td><input type="number" min="0" name="numTotal" id="numTotal" placeholder="圈养个体数"></td>'+
                 '</tr>'+
                 '<tr>'+
                 '<td>供应商-饲料名</td>'+
                 '<td><select name="feedType" id="feed_type" placeholder="饲料种类" class="select-fix-input"></select></td>'+
                 '</tr>'+
                 '<tr>'+
                 '<td>饲料投放量(kg)/最大投放量:<span class="maxTips" style="color:#800000"></span></td>'+
                 '<td><input type="number" name="feedWeight" id="feed_weight" min="0" placeholder="投放量(kg)"></td>'+
                 '</tr>'+
                 '<tr>'+
                 '<td>禽类养殖阶段标识</td>'+
                 '<td><select name="status" id="status" class="select-fix-input"></select></td>'+
                 '</tr>'+
                 '<tr>'+
                 '<td>该批鸡的总重量</td>'+
                 '<td><input type="number" min="0" name="weight"></td>'+
                 '</tr>'+
                 '<tr>'+
                 '<td>负责人</td>'+
                 '<td><select name="idCharge" id="idCharge" class="select-fix-input"></select></td>'+
                 '</tr>'+
                 '<tr>'+
                 '<td>操作</td>'+
                 '<td><button type="submit" class="btn select-fix-input" onclick="return false" >提交</button></td>'+
                 '</tr>'+
                 '</table>'+
                 '</form>'+
            '</div>'
         ].join(''),
         ddl_add:[
             '<div class="detail-content">'+
             '<form onsubmit="return false">'+
             '<table>'+
             '<caption>死淘记录</caption>'+
             '<tr>'+
             '<th>条目</th>'+
             '<th>信息</th>'+
             '</tr>'+
             '<tr>'+
             '<td>批次号</td>'+
             '<td id="idPatch">{#id#}</td>'+
             '</tr>'+
             '<tr class="none">'+
             '<td>减少的家禽数</td>'+
             '<td><input  type="number" min="1" name="numProcessed" ></td>'+
             '</tr>'+
             '<tr>'+
             '<td>减少的家禽数</td>'+
             '<td><input  type="number" disabled ></td>'+
             '</tr>'+
             '<tr>'+
             '<td>死亡原因</td>'+
             '<td><select name="remark" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>处理方式</td>'+
             '<td><select name="processingMode" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>负责人</td>'+
             '<td><select name="idCharge" id="idCharge" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>操作</td>'+
             '<td><button type="submit" class="btn select-fix-input" onclick="return false" >提交</button></td>'+
             '</tr>'+
             '</table>'+
             '</form>'+
             '</div>'
         ].join(''),
         ddl_own_add:[
             '<div class="detail-content">'+
             '<form onsubmit="return false">'+
             '<table>'+
             '<caption>死淘记录</caption>'+
             '<tr>'+
             '<th>条目</th>'+
             '<th>信息</th>'+
             '</tr>'+
             '<tr>'+
             '<td>批次号</td>'+
             '<td><select name="idPatch" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>减少的家禽数</td>'+
             '<td><input  type="number" min="1" name="numProcessed"></td>'+
             '</tr>'+
             '<tr>'+
             '<td>死亡原因</td>'+
             '<td><select name="remark" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>处理方式</td>'+
             '<td><select name="processingMode" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>负责人</td>'+
             '<td><select name="idCharge" id="idCharge" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>操作</td>'+
             '<td><button type="submit" class="btn select-fix-input" onclick="return false" >提交</button></td>'+
             '</tr>'+
             '</table>'+
             '</form>'+
             '</div>'
         ].join(''),
         outPoultry_add:[
             '<div class="detail-content">'+
            '<form onsubmit="return false">'+
             '<table>'+
             '<caption>出厂记录</caption>'+
             '<tr>'+
             '<th>条目</th>'+
             '<th>信息</th>'+
             '</tr>'+
             '<tr>'+
             '<td>批次号</td>'+
             '<td><select name="idPatch" id="id_patch" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>出库数量</td>'+
             '<td><input type="number" name="quantity" id="quantity" placeholder="本批次数量" ></td>'+
             '</tr>'+
             '<tr>'+
             '<td>下一阶段打算</td>'+
             '<td><select name="nextProcess" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr class="none">'+
             '<td>单位</td>'+
             '<td><input type="text" name="unit" id="unit" placeholder="单位" value="20002" ></td>'+
            '</tr>'+
            '<tr class="none firm">'+
            '<td >选择加工企业</td>'+
            '<td><select name="firm" class="select-fix-input"></select></td>'+
            '</tr>'+
             '<tr class="none firm">'+
             '<td>选择送往收货批发商/加工企业</td>'+
             '<td><select name="firm" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr class="firm">'+
             '<td >公司地址</td>'+
             '<td><select name="firm" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>负责人</td>'+
             '<td><select name="idCharge" id="idCharge" class="select-fix-input"></select></td>'+
             '</tr>'+
            '<tr>'+
            '<td>备注</td>'+
            '<td><textarea id="remark" name="remark" placeholder="备注" class="select-fix-input"></textarea></td>'+
            '</tr>'+
            '<tr>'+
            '<td>操作</td>'+
            '<td><button type="submit" class="btn select-fix-input" onclick="return false" >提交</button></td>'+
            '</tr>'+
            '</table>'+
            '</form>'+
            '</div>'
         ].join(''),
        view_aqua:[
            '<div class="detail-content">'+
                '<table>'+
                '<caption>家禽生长状态-投料量曲线图</caption>'+
                '<tr>'+
                    '<th>条目</th>'+
                    '<th>信息</th>'+
                '</tr>'+
                '<tr>'+
                    '<td>批次号</td>'+
                    '<td><select name="idPatch" class="select-fix-input"></select></td>'+
                '</tr>'+
                '<tr>'+
                    '<td>筛选前几天的数据</td>'+
                    '<td><select name="name" class="select-fix-input"></select></td>'+
                '</tr>'+
                '</table>'+
                '<div class="viewport"></div>'+
            '</div>'
        ].join(''),
         view_ddl:[
             '<div class="detail-content">'+
             '<table>'+
             '<caption>家禽死淘情况图</caption>'+
             '<tr>'+
             '<th>条目</th>'+
             '<th>信息</th>'+
             '</tr>'+
             '<tr>'+
             '<td>批次号</td>'+
             '<td><select name="idPatch" class="select-fix-input"></select></td>'+
             '</tr>'+
             '</table>'+
             '<div class="viewport"></div>'+
             '</div>'
         ].join(''),
         view_epi:[
             '<div class="detail-content view-epi">'+
             '<table>'+
             '<caption>家禽免疫/疾病情况图</caption>'+
             '<tr>'+
             '<th>条目</th>'+
             '<th>信息</th>'+
             '</tr>'+
             '<tr>'+
             '<td>批次号</td>'+
             '<td><select name="idPatch" class="select-fix-input"></select></td>'+
             '</tr>'+
             '</table>'+
             '<div class="viewport"></div>'+
             '</div>'
         ].join(''),
         epi_add:[
             '<div class="detail-content">'+
             '<form onsubmit="return false">'+
             '<table>'+
             '<caption>信息记录</caption>'+
             '<tr>'+
             '<th>条目</th>'+
             '<th>信息</th>'+
             '</tr>'+
             '<tr>'+
             '<td>批次号</td>'+
             '<td><select name="idPatch" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>疾病名</td>'+
             '<td><select name="diseaes" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>药品名称</td>'+
             '<td><select name="name" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>给药方式</td>'+
             '<td><select name="medicationMode" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>剂量/最大剂量为(<span></span>)</td>'+
             '<td><input type="number" name="dose" min="0"></td>'+
             '</tr>'+
             '<tr>'+
             '<td>剂量单位</td>'+
             '<td><select name="doseUnit" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>给药/处理个数</td>'+
             '<td><input type="number" name="numInfected" min="1" placeholder="给药/处理个数"></td>'+
             '</tr>'+
             '<tr>'+
             '<td>负责人</td>'+
             '<td><select name="idCharge" id="idCharge" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>备注</td>'+
             '<td><textarea  name="processingMode" placeholder="备注" class="select-fix-input"></textarea></td>'+
             '</tr>'+
             '<tr>'+
             '<td>操作</td>'+
             '<td><button type="submit" class="btn select-fix-input" onclick="return false" >提交</button></td>'+
             '</tr>'+
             '</table>'+
             '</form>'+
             '</div>'
         ].join(''),
         outStorage_show:[
             '<tr>',
             '<td >{#idOutstorage#}</td>',
             '<td >{#name#}</td>',
             '<td >{#remark#}</td>',
             '<td >{#firm#}</td>',
             '<td >{#phone#}</td>',
             '<td >{#type#}</td>',
             '<td >{#quantity#}</td>',
             '<td >{#rest#}</td>',
             '<td >{#unit#}</td>',
             '<td >{#recordDate#}</td>',
             '<td >{#expirationDate#}</td>',
             '<td >{#idRecorder#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><a class="btn" data-id="del{#idOutstorage#}">删除</a></td>',
             '<td ><a class="btn" href="./edit.html?id={#idOutstorage#}">修改</a></td>',
             '</tr>'
         ].join(''),
         dict:[
             '<tr>',
             '<td >{#name#}</td>',
             '<td >{#pid#}</td>',
             '<td >{#remark#}</td>',
             '<td ><a class="btn" data-id="del{#id#}">删除</a></td>',
             '<td ><a class="btn" href="./edit.html?id={#id#}">修改</a></td>',
             '</tr>'
         ].join(''),
         ddl_v2_show:[
             '<tr>',
             '<td >{#idPatch#}</td>',
             '<td >{#recordDate#}</td>',
             '<td >{#numProcessed#}</td>',
             '<td >{#processingMode#}</td>',
             '<td >{#remark#}</td>',
             '<td >{#idRecorder#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><a class="btn" data-id="del{#id#}">删除</a></td>',
             '<td ><a class="btn" href="./edit.html?id={#id#}">修改</a></td>',
             '</tr>'
         ].join(''),
         outPoultry_v3_show:[
             '<tr>',
             '<td >{#id#}</td>',
             '<td ><img src="http://qr.liantu.com/api.php?w=150&logo=http://120.77.40.82:3000/assets/waterfowl/logo.png&text=http://192.168.90.21/waterfowl/fowl/result.html?fowlCode={#id#}"></td>',
             '<td >{#idPatch#}</td>',
             '<td >{#recordDate#}</td>',
             '<td >{#firm#}</td>',
             '<td >{#quantity#}</td>',
             '<td >{#status#}</td>',
             '<td >{#remark#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><a class="btn" data-id="del{#id#}">删除</a></td>',
             '<td ><a class="btn" href="./edit.html?id={#id#}">修改</a></td>',
             '</tr>'
         ].join(''),
         epi_v2_show:[
             '<tr>',
             '<td >{#idPatch#}</td>',
             '<td >{#diseaes#}</td>',
             '<td >{#numInfected#}</td>',
             '<td >{#medicationMode#}</td>',
             '<td >{#dose#}</td>',
             '<td >{#doseUnit#}</td>',
             '<td >{#name#}</td>',
             '<td >{#remark#}</td>',
             '<td >{#processingMode#}</td>',
             '<td >{#idRecorder#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><a class="btn" data-id="del{#id#}">删除</a></td>',
             '<td ><a class="btn" href="./edit.html?id={#id#}">修改</a></td>',
             '</tr>'
         ].join(''),
         affi_v2_show:[
             '<tr>',
             '<td >{#name#}</td>',
             '<td >{#position#}</td>',
             '<td >{#type#}</td>',
             '<td >{#size#}</td>',
             '<td >{#status#}</td>',
             '<td >{#idRecord#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><a class="btn" data-id="del{#id#}">删除</a></td>',
             '<td ><a class="btn" href="./edit.html?id={#id#}">修改</a></td>',
             '</tr>'
         ].join(''),
         manu:[
             '<tr>',
             '<td >{#idPatch#}</td>',
             '<td ><img src="http://qr.liantu.com/api.php?w=150&logo=http://120.77.40.82:3000/assets/waterfowl/logo.png&text=http://192.168.90.21/waterfowl/fowl/result.html?fowlCode={#idPatch#}"></td>',
             '<td >{#recordDate#}</td>',
             '<td >{#firm#}</td>',
             '<td >{#site#}</td>',
             '<td >{#quantity#}</td>',
             '<td >{#method#}</td>',
             '<td >{#remark#}</td>',
             '<td >{#idRecord#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><a class="btn" data-id="ok{#idPatch#}" data-patch="{#idPatch#}">完成加工</a></td>',
             '<td ><a class="btn" data-id="del{#id#}">删除</a></td>',
             '<td ><a class="btn" href="./edit.html?id={#id#}">修改</a></td>',
             '</tr>'
         ].join(''),
         poultry_nav:[
             '<td><span>入厂时间:</span><span>{#recordeDate#}</span></td>'+
             '<td><span>家禽类型:</span><span>{#type#}</span></td>'+
             '<td><span>数量:</span><span>{#quantity#}</span></td>'+
             '<td><span>关联厂家:</span><span>{#associatedFirm#}</span></td>'+
             '<td><span>联系电话:</span><span>{#phone#}</span></td>'+
             '<td><span>记录人编号:</span><span>{#idRecorder#}</span></td>'+
             '<td><span>负责人编号:</span><span>{#idRecorder#}</span></td>'
         ].join(''),
         order:[
             '<tr>',
             '<td >{#name#}</td>',
             '<td >{#phone#}</td>',
             '<td >{#remark#}</td>',
             '<td ><a class="btn" >查看营业执照</a></td>',
             '<td ><a class="btn" href="./transferInfoAdd.html?cid={#cid#}&name={#name#}&phone={#phone#}">发货/更新物流</a></td>',
             '<td ><a class="btn" data-id="ok{#cid#}">完成配送</a></td>',
             '<td ><a class="btn" data-id="del{#cid#}">删除</a></td>',
             '<td ><a class="btn" href="./edit.html?id={#cid#}">修改</a></td>',
             '</tr>'
         ].join(''),
         transferFirm_find:[
             '<tr>',
             '<td >{#type#}</td>',
             '<td >{#name#}</td>',
             '<td >{#phone#}</td>',
             '<td >{#remark#}</td>',
             '<td ><a class="btn" >查看营业执照</a></td>',
             '<td ><a class="btn" data-id="del{#tid#}">删除</a></td>',
             '<td ><a class="btn" href="./edit.html?id={#tid#}">修改</a></td>',
             '</tr>'
         ].join(''),
         outPoultry_for_transferInfos:[
             '<tr>',
             '<td >{#id#}</td>',
             '<td ><img src="http://qr.liantu.com/api.php?w=150&logo=http://120.77.40.82:3000/assets/waterfowl/logo.png&text=http://120.77.250.250/waterfowl/fowl/result.html?fowlCode={#idPatch#}"></td>',
             '<td >{#idPatch#}</td>',
             '<td >{#firm#}</td>',
             '<td >{#quantity#}</td>',
             '<td >{#status#}</td>',
             '<td >{#recordDate#}</td>',
             '<td >{#remark#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><a class="btn" data-id="look{#id#}">查看物流</a></td>',
             '<td ><a class="btn" data-ok="ok{#id#}">完成配送</a></td>',
             '</tr>'
         ].join(''),
         transferInfoList_find:[
             '<tr>',
             '<td >{#idPatch#}</td>',
             '<td >{#cid#}</td>',
             '<td >{#tid#}</td>',
             '<td >{#remark#}</td>',
             '<td >{#curquantity#}</td>',
             '<td >{#curdate#}</td>',
             '<td >{#driver#}</td>',
             '<td >{#phone#}</td>',
             '<td ><a class="btn" data-id="del{#id#}">删除</a></td>',
             '<td ><a class="btn" href="./edit.html?id={#id#}">修改</a></td>',
             '</tr>'
         ].join(''),
         blank:[
             '<tr style="text-align: center">',
             '<td style="color:red">页面数据为空</td>',
             '</tr>'
         ].join(''),
         transferInfoAdd:[
             '<form onsubmit="return false">'+
             '<table>'+
             '<tr>'+
             '<th>条目</th>'+
             '<th>发货信息</th>'+
             '</tr>'+
             '<tr class="firmName-p">'+
             '<td>批发商地址(目的地)</td>'+
             '<td><p id="firmName"></p></td>'+
             '</tr>'+
             '<tr class="firmName-select">'+
             '<td>批发商地址(目的地)</td>'+
             '<td><select  name="cid" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr class="status">'+
             '<td >批次状态</td>'+
             '<td>' +
             '待运输:<input type="radio" name="status" data-value="30007"  checked>' +
             '待运输待加工<input type="radio" name="status" data-value="30009">' +
             '</td>'+
             '</tr>'+
             '<tr>'+
             '<td>选择需要被运输的批次号</td>'+
             '<td><select name="idPatch" class="select-fix-input"></select> 数量:<span style="color:#387"></span>只</td>'+
             '</tr>'+
             '<tr>'+
             '<td>选择运输公司</td>'+
             '<td><select name="tid" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>输入物流站点</td>'+
             '<td><input type="text" name="remark" id="suggestId" size="40" value="仲恺农业工程学院海珠校区" placeholder="站点位置"/>'+
             '<div id="searchResultPanel" style="border:1px solid #c0c0c0;width:173px;height:auto;display:none"></div>' +
             '</td>'+
             '</tr>'+
             '<tr>'+
             '<td>配送司机姓名</td>'+
             '<td><input type="text" name="driver"></td>'+
             '</tr>'+
             '<tr>'+
             '<td>配送司机电话</td>'+
             '<td><input type="text" name="phone"></td>'+
             '</tr>'+
             // '<tr>'+
             // '<td>备注</td>'+
             // '<td><textarea  name="remark" placeholder="备注" class="select-fix-input"></textarea></td>'+
             // '</tr>'+
             '<tr>'+
             '<td>操作</td>'+
             '<td><button type="submit" class="btn select-fix-input" onclick="return false" >提交</button></td>'+
             '</tr>'+
             '</table>'+
             '</form>'
         ].join(''),
         transferInfoUpdate:[
             '<div class="detail-content">'+
             '<form onsubmit="return false">'+
             '<table>'+
             '<caption class="none">更新物流信息</caption>'+
             '<tr>'+
             '<th>条目</th>'+
             '<th>更新物流信息</th>'+
             '</tr>'+
             '<tr>'+
             '<td>批发商地址(目的地)</td>'+
             '<td><p></p></td>'+
             '</tr>'+
             '<tr>'+
             '<td>正在被运输的批次号</td>'+
             '<td><p></p></td>'+
             '</tr>'+
             '<tr>'+
             '<td>数量(单位:只)</td>'+
             '<td><span style="color:#387"></span></td>'+
             '</tr>'+
             '<tr>'+
             '<td><p style="color:#387"></p>输入当前物流所达到的站点</td>'+
             '<td><input type="text" name="remark" id="suggestId" size="40" value="仲恺农业工程学院海珠校区" placeholder="站点位置"/>'+
             '<div id="searchResultPanel" style="border:1px solid #c0c0c0;width:173px;height:auto;display:none"></div>' +
             '</td>'+
             '</tr>'+
             '<tr>'+
             '<td>配送司机姓名</td>'+
             '<td><input type="text" name="driver"></td>'+
             '</tr>'+
             '<tr>'+
             '<td>配送司机电话</td>'+
             '<td><input type="text" name="phone"></td>'+
             '</tr>'+
             '<tr>'+
             '<td>操作</td>'+
             '<td><button type="submit" class="btn select-fix-input" onclick="return false" >提交</button></td>'+
             '</tr>'+
             '</table>'+
             '</form>'+
             '</div>'
         ].join(''),
     };
     function formateString(str,obj){         //模板核心代码，替换{# #}之间的字符串
         return str.replace(/\{#(\w+)#\}/g,function(matchArr,key){
             if(+obj[key] && key != 'id'){   //判断是不是数字
                 var word = localStorage.getItem('waterfowl'+obj[key]);     //字典过滤
                 if(word){          //利用强制类型转换 是数字的
                     return word;
                 }else{
                     return obj[key];
                 }
             }else{
                 return obj[key];
             }
         })
     }
    function noneformateString(str,obj){         //模板核心代码，替换{# #}之间的字符串
        return str.replace(/\{#(\w+)#\}/g,function(matchArr,key){
            return obj[key];
        })
    }
     var Action = {                            //方法集合
         create : function(data,view){         //批量格式化字符串
             if(view === 'id_name'){  //如果是字典渲染
                 if(data.length){
                     for(var i=0,len=data.length;i<len;i++){
                         html+=noneformateString(tpl[view],data[i]);
                     }
                 }else{
                     html+=noneformateString(tpl[view],data); //不是一个数组直接格式化字符串缓存到html 中
                 }
             }else{
                 if(data.length){
                     for(var i=0,len=data.length;i<len;i++){
                         html+=formateString(tpl[view],data[i]);
                     }
                 }else{
                     html+=formateString(tpl[view],data); //不是一个数组直接格式化字符串缓存到html 中
                 }
             }

         },
         append : function(container,data,view){
            if(data){
                this.create(data,view);
            }
            if(typeof container !='object'){
                throw new Error('第一个参数的类型应该为jq对象')
            }else{
                var df = document.createDocumentFragment();
                $(df).append(html);
                $(container).append($(df));//,此时container为jq 对象 拼接展示
                html = '';                 //展示后清空模板缓冲
            }
         },
         after : function(container,data,view){
             if(data){
                 this.create(data,view);
             }
             if(typeof container !='object'){
                 throw new Error('第一个参数的类型应该为jq对象')
             }else{
                 var df = document.createDocumentFragment();
                 $(df).append(html);
                 $(container).after($(df));//,此时container为jq 对象 拼接展示
                 html = '';                 //展示后清空模板缓冲
             }
         },
         display : function(container,data,view){
             if(data){
                 this.create(data,view);//根据数据先格式化字符串后马上传入html 缓冲区 以便一会使用
             }
             if(typeof container !='object'){
                 throw new Error('第一个参数的类型应该为obj string')
             }else{
                 var df = document.createDocumentFragment();
                 $(df).append(html);
                 $(container).html($(df));//展示
                 html = '';               //展示后清空模板缓冲
             }
         }
     }
     return function excute(msg){                 //向外暴露一个命令接口，总指挥作用
        //msg.param 不是数组就强转为数组
        msg.param = Object.prototype.toString.call(msg.param) === '[object Array]' ? msg.param : [msg.param];
        //保证Action内部的this,指向
        //console.log(this);此时是window，因为它暴露出去了；
        Action[msg.command].apply(Action,msg.param);
    }  
})();


 
