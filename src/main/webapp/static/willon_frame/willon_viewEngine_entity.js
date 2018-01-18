/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-10-25 14:56:54 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-21 14:09:18
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
         del_aquaculture:[
             '<tr>',
             '<td >{#name#}</td>',
             '<td >{#idFowlery#}</td>',
             '<td >{#idPatch#}</td>',
             '<td >{#recordDate#}</td>',
             '<td >{#numTotal#}</td>',
             '<td >{#feedType#}</td>',
             '<td >{#feedWeight#}</td>',
             '<td >{#idRecorder#}</td>',
             '<td >{#idCharge#}</td>',
             '<td >{#idOutstorage#}</td>',
             '<td >{#status#}</td>',
             '<td ><button class="btn" data-id="del{#id#}">删除</button></td>',
             '</tr>'
         ].join(''),
         find_edit_aquaculture:[
             '<tr>',
             '<td >{#idPatch#}</td>',
             '<td >{#name#}</td>',
             '<td >{#idFowlery#}</td>',
             '<td >{#recordDate#}</td>',
             '<td >{#numTotal#}</td>',
             '<td >{#feedType#}</td>',
             '<td >{#feedWeight#}</td>',
             '<td >{#idRecorder#}</td>',
             '<td >{#idCharge#}</td>',
             '<td >{#idOutstorage#}</td>',
             '<td >{#status#}</td>',
             "<td ><a class='btn' href='./detail.html?id={#id#}' >详情</a></td>",
             "<td ><a class='btn' href='./edit.html?id={#id#}'>修改</a></td>",
             '</tr>'
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
         fowlery_del:[
             '<tr>',
             '<td >{#size#}</td>',
             '<td >{#status#}</td>',
             '<td >{#affiliation#}</td>',
             '<td >{#idRecord#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><button class="btn" data-id="del{#id#}">删除</button></td>',
             '</tr>'
         ].join(''),
         fowlery_find:[
             '<tr>',
             '<td >{#size#}</td>',
             '<td >{#status#}</td>',
             '<td >{#affiliation#}</td>',
             '<td >{#idRecord#}</td>',
             '<td >{#idCharge#}</td>',
             "<td ><a class='btn' href='./edit.html?id={#id#}'>修改</a></td>",
             '</tr>'
         ].join(''),
         poultry_find:[
             '<tr>',
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
             '<td>该批次状态</td>',
             '<td>',
             '<select name="status" class="select-fix-input">',
             '<option value="批次出厂">该批次已出厂</option>',
             '<option value="养殖中" selected>养殖中</option>',
             '</select>',
             '</td>',
             '</tr>',
             '<tr>',
             '<td>记录人</td>',
             '<td><select name="idRecorder" id="idRecorder" class="select-fix-input"></select></td>',
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
                 '<td>饲料名</td>'+
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
                 '<td>记录人</td>'+
                 '<td><select name="idRecorder" id="idRecorder" class="select-fix-input"></select></td>'+
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
             '<td>处理方式</td>'+
             '<td><select name="processingMode" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>备注</td>'+
             '<td><textarea id="remark" name="remark" placeholder="备注" class="select-fix-input"></textarea></td>'+
             '</tr>'+
             '<tr>'+
             '<td>记录人</td>'+
             '<td><select name="idRecorder" id="idRecorder" class="select-fix-input"></select></td>'+
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
             '<td>处理方式</td>'+
             '<td><select name="processingMode" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>记录人</td>'+
             '<td><select name="idRecorder" id="idRecorder" class="select-fix-input"></select></td>'+
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
             '<td>本批次数量</td>'+
             '<td><input type="text" name="quantity" id="quantity" placeholder="本批次数量" disabled></td>'+
             '</tr>'+
             '<tr class="none">'+
             '<td>单位</td>'+
             '<td><input type="text" name="unit" id="unit" placeholder="单位" value="只" ></td>'+
            '</tr>'+
            '<tr>'+
            '<td>出厂商</td>'+
            '<td><input type="text" name="firm" id="firm" class="select-fix-input"></td>'+
            '</tr>'+
            '<tr>'+
            '<td>联系电话</td>'+
            '<td><input type="phone" name="phone" id="phone" class="select-fix-input"></td>'+
            '</tr>'+
             '<tr>'+
             '<td>记录人</td>'+
             '<td><select name="idRecorder" id="idRecorder" class="select-fix-input"></select></td>'+
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
             '<td>记录人</td>'+
             '<td><select name="idRecorder" id="idRecorder" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>负责人</td>'+
             '<td><select name="idCharge" id="idCharge" class="select-fix-input"></select></td>'+
             '</tr>'+
             '<tr>'+
             '<td>备注</td>'+
             '<td><textarea  name="remark" placeholder="备注" class="select-fix-input"></textarea></td>'+
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
             '<td >{#unit#}</td>',
             '<td >{#recordDate#}</td>',
             '<td >{#expirationDate#}</td>',
             '<td >{#idRecorder#}</td>',
             '<td >{#idCharge#}</td>',
             '<td ><a class="btn" data-id="del{#idOutstorage#}">删除</a></td>',
             '<td ><a class="btn" href="./edit.html?id={#id#}">修改</a></td>',
             '</tr>'
         ].join(''),
     };
     function formateString(str,obj){         //模板核心代码，替换{# #}之间的字符串
         return str.replace(/\{#(\w+)#\}/g,function(matchArr,key){
            return obj[key];
         })
     }
     var Action = {                            //方法集合
         create : function(data,view){         //批量格式化字符串
            if(data.length){
                for(var i=0,len=data.length;i<len;i++){
                    html+=formateString(tpl[view],data[i]);
                }
            }else{
                html+=formateString(tpl[view],data); //不是一个数组直接格式化字符串缓存到html 中
            }
         },
         append : function(container,data,view){
            if(data){
                this.create(data,view);
            }
            if(typeof container !='object'){
                throw new Error('第一个参数的类型应该为jq对象')
            }else{
                container.append(html)//,此时container为jq 对象 拼接展示
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
                 container.after(html)//,此时container为jq 对象 拼接展示
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
                 container.innerHTML = html;//展示
                 html = '';                 //展示后清空模板缓冲
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


 
