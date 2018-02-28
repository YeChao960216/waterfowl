package cn.zhku.waterfowl.modules.fowlery.model;

import cn.zhku.waterfowl.util.excel.EntiName;

/**
 * Created by jin on 2017/11/30.
 */
public class FowleryExcel {
    @EntiName(id = true)
    private String id;

    @EntiName(RName = "规格")
    private String size;

    @EntiName(RName = "状态")
    private String status;

    @EntiName(RName = "归属禽舍")
    private String Affiliation;

    @EntiName(RName = "记录人员")
    private String id_record;

    @EntiName(RName = "管理人员")
    private String id_charge;

    public String getId(){
        return id;
    }
    public void setId(){
        this.id=id;
    }
    public String getSize(){
        return size;
    }
    public void setSize(){
        this.size=size;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(){
        this.status=status;
    }
    public String getAffiliation(){
        return Affiliation;
    }
    public void setAffiliation(){
        this.Affiliation=Affiliation;
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
        return "FowleryExcel{"+
                "id='"+id+'\''+
                ",size='"+size+'\''+
                ",status'"+status+'\''+
                ",Affiliation'"+Affiliation+'\''+
                ",id_record='"+id_record+'\''+
                ",id_charge='"+id_charge+'\''+
                "}";
    }
}
