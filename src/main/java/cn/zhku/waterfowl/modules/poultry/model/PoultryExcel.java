package cn.zhku.waterfowl.modules.poultry.model;

import cn.zhku.waterfowl.util.excel.EntiName;

import java.util.Date;

/**
 * @author:叶超 yc755909707@foxmail.com
 * @version:create in 17:42 2017/12/2
 * @description:
 */
public class PoultryExcel {
    @EntiName(id = true)
    private Integer id_poultry;

    @EntiName(RName = "记录时间")
    private Date record_date;

    @EntiName(RName = "家禽类型")
    private String type;

    @EntiName(RName = "数量")
    private String quantity;

    @EntiName(RName = "单位")
    private String unit;

    @EntiName(RName = "关联厂商")
    private String associated_firm;

    @EntiName(RName = "联系电话")
    private String phone;

    @EntiName(RName = "备注")
    private String remark;

    @EntiName(RName = "登录者者编号")
    private String id_recorder;

    @EntiName(RName = "负责人编号")
    private String id_charge;

    public Integer getId_poultry() {
        return id_poultry;
    }

    public void setId_poultry(Integer id_poultry) {
        this.id_poultry = id_poultry;
    }

    public Date getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Date record_date) {
        this.record_date = record_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAssociated_firm() {
        return associated_firm;
    }

    public void setAssociated_firm(String associated_firm) {
        this.associated_firm = associated_firm;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getId_recorder() {
        return id_recorder;
    }

    public void setId_recorder(String id_recorder) {
        this.id_recorder = id_recorder;
    }

    public String getId_charge() {
        return id_charge;
    }

    public void setId_charge(String id_charge) {
        this.id_charge = id_charge;
    }

    @Override
    public String toString() {
        return "PoultryExcel{" +
                "id_poultry=" + id_poultry +
                ", record_date=" + record_date +
                ", type='" + type + '\'' +
                ", quantity='" + quantity + '\'' +
                ", unit='" + unit + '\'' +
                ", associated_firm='" + associated_firm + '\'' +
                ", phone='" + phone + '\'' +
                ", remark='" + remark + '\'' +
                ", id_recorder='" + id_recorder + '\'' +
                ", id_charge='" + id_charge + '\'' +
                '}';
    }
}
