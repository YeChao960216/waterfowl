package cn.zhku.waterfowl.modules.material.model;

import cn.zhku.waterfowl.util.excel.EntiName;

import java.util.Date;

public class MaterialExcel {

    @EntiName(id = true)
    private Integer id_storage;

    @EntiName(RName = "进厂时间")
    private Date date;

    @EntiName(RName = "物资名称")
    private String name;

    @EntiName(RName = "物资有效期")
    private Date expiration_date;

    @EntiName(RName = "关联厂商")
    private String associated_firm;

    @EntiName(RName = "联系电话")
    private String phone;

    @EntiName(RName = "是否过期")
    private String type;

    @EntiName(RName = "物资数量")
    private String quantity;

    @EntiName(RName = "计数单位")
    private String unit;

    @EntiName(RName = "存储地点")
    private String storage_site;

    @EntiName(RName = "存储方式")
    private String mode;

    @EntiName(RName = "备注")
    private String remark;

    @EntiName(RName = "登录者编号")
    private String id_recorder;

    @EntiName(RName = "负责人编号")
    private String id_charge;


    public Integer getId_storage() {
        return id_storage;
    }

    public void setId_storage(Integer id_storage) {
        this.id_storage = id_storage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
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

    public String getStorage_site() {
        return storage_site;
    }

    public void setStorage_site(String storage_site) {
        this.storage_site = storage_site;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
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
        return "MaterialExcel{" +
                "id_storage=" + id_storage +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", expiration_date=" + expiration_date +
                ", associated_firm='" + associated_firm + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                ", quantity='" + quantity + '\'' +
                ", unit='" + unit + '\'' +
                ", storage_site='" + storage_site + '\'' +
                ", mode='" + mode + '\'' +
                ", remark='" + remark + '\'' +
                ", id_recorder='" + id_recorder + '\'' +
                ", id_charge='" + id_charge + '\'' +
                '}';
    }
}
