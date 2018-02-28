package cn.zhku.waterfowl.modules.outStorage.model;

import cn.zhku.waterfowl.util.excel.EntiName;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/15 0015.
 */
public class OutStorageExcel {
    @EntiName(id = true)
    private String idOutstorage;

    @EntiName(RName = "物资名称")
    private String name;

    @EntiName(RName = "供应商")
    private String remark;

    @EntiName(RName = "记录时间")
    private Date record_date;

    @EntiName(RName = "数量")
    private float quantity;

    @EntiName(RName = "单位")
    private String unit;

    @EntiName(RName = "生产厂家")
    private String firm;

    @EntiName(RName = "物资类型")
    private String type;

    @EntiName(RName = "有效期")
    private Date expiration_date;

    @EntiName(RName = "剩余量")
    private float rest;

    @EntiName(RName = "联系电话")
    private String phone;

    @EntiName(RName = "是否有效")
    private String valid;

    @EntiName(RName = "备注1")
    private String site;

    @EntiName(RName = "备注2")
    private String mode;

    @EntiName(RName = "备注3")
    private String provide;

    @EntiName(RName = "录入人")
    private String id_recorder;

    @EntiName(RName = "负责人")
    private String id_charge;

    public String getIdOutstorage() {
        return idOutstorage;
    }

    public void setIdOutstorage(String idOutstorage) {
        this.idOutstorage = idOutstorage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Date record_date) {
        this.record_date = record_date;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public float getRest() {
        return rest;
    }

    public void setRest(float rest) {
        this.rest = rest;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getProvide() {
        return provide;
    }

    public void setProvide(String provide) {
        this.provide = provide;
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
        return "OutStorageExcel{" +
                "idOutstorage='" + idOutstorage + '\'' +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", record_date=" + record_date +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", firm='" + firm + '\'' +
                ", type='" + type + '\'' +
                ", expiration_date=" + expiration_date +
                ", rest=" + rest +
                ", phone='" + phone + '\'' +
                ", valid='" + valid + '\'' +
                ", site='" + site + '\'' +
                ", mode='" + mode + '\'' +
                ", provide='" + provide + '\'' +
                ", id_recorder='" + id_recorder + '\'' +
                ", id_charge='" + id_charge + '\'' +
                '}';
    }
}
