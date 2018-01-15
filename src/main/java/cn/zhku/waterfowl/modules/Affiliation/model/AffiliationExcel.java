package cn.zhku.waterfowl.modules.Affiliation.model;

import cn.zhku.waterfowl.util.excel.EntiName;

/**
 * Created by jin on 2017/11/30.
 */
public class AffiliationExcel {
    @EntiName(id = true)
    private String id;

    @EntiName(RName = "类型")
    private String type;

    @EntiName(RName = "位置")
    private String position;

    @EntiName(RName = "规格")
    private String size;

    @EntiName(RName = "状态")
    private String status;

    @EntiName(RName = "记录人员编号")
    private String id_record;

    @EntiName(RName = "管理人员编号")
    private String id_charge;

    public String getId() {
        return id;
    }
    public void setId(){
        this.id=id;
    }
    public  String getType(){
        return type;
    }
    public void setType(){
        this.type=type;
    }
    public String getPosition(){
        return position;
    }
    public void setPosition(){
        this.position=position;
    }
    public String getStatus(){
        return status ;
    }
    public void setStatus(){
        this.status=status;
    }
    public String getId_record(){
        return id_record;
    }
    public void setId_record(){
        this.id_record=id_record;
    }
    public String getId_charge(){
        return id_charge;
    }
    public void setId_charge(){
        this.id_charge=id_charge;
    }

    @Override
    public String toString() {
        return "AffiliationExcel{"+
                "id='"+id+'\''+
                ",type='"+type+'\''+
                ",position='"+position+'\''+
                ",status='"+status+'\''+
                ",id_record='"+id_record+'\''+
                ",id_charge='"+id_charge+'\''+
                "}";
    }
}
