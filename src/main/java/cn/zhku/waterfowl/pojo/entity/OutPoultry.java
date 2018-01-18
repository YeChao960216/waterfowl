package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class OutPoultry implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column out_poultry.id
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column out_poultry.record_date
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    private Date recordDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column out_poultry.type
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column out_poultry.quantity
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    private Float quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column out_poultry.unit
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    private String unit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column out_poultry.id_patch
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    private String idPatch;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column out_poultry.firm
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    private String firm;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column out_poultry.phone
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column out_poultry.remark
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column out_poultry.id_record
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    private String idRecord;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column out_poultry.id_charge
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    private String idCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table out_poultry
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column out_poultry.id
     *
     * @return the value of out_poultry.id
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column out_poultry.id
     *
     * @param id the value for out_poultry.id
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column out_poultry.record_date
     *
     * @return the value of out_poultry.record_date
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public Date getRecordDate() {
        return recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column out_poultry.record_date
     *
     * @param recordDate the value for out_poultry.record_date
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column out_poultry.type
     *
     * @return the value of out_poultry.type
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column out_poultry.type
     *
     * @param type the value for out_poultry.type
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column out_poultry.quantity
     *
     * @return the value of out_poultry.quantity
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public Float getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column out_poultry.quantity
     *
     * @param quantity the value for out_poultry.quantity
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column out_poultry.unit
     *
     * @return the value of out_poultry.unit
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column out_poultry.unit
     *
     * @param unit the value for out_poultry.unit
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column out_poultry.id_patch
     *
     * @return the value of out_poultry.id_patch
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public String getIdPatch() {
        return idPatch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column out_poultry.id_patch
     *
     * @param idPatch the value for out_poultry.id_patch
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public void setIdPatch(String idPatch) {
        this.idPatch = idPatch == null ? null : idPatch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column out_poultry.firm
     *
     * @return the value of out_poultry.firm
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public String getFirm() {
        return firm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column out_poultry.firm
     *
     * @param firm the value for out_poultry.firm
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public void setFirm(String firm) {
        this.firm = firm == null ? null : firm.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column out_poultry.phone
     *
     * @return the value of out_poultry.phone
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column out_poultry.phone
     *
     * @param phone the value for out_poultry.phone
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column out_poultry.remark
     *
     * @return the value of out_poultry.remark
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column out_poultry.remark
     *
     * @param remark the value for out_poultry.remark
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column out_poultry.id_record
     *
     * @return the value of out_poultry.id_record
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public String getIdRecord() {
        return idRecord;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column out_poultry.id_record
     *
     * @param idRecord the value for out_poultry.id_record
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public void setIdRecord(String idRecord) {
        this.idRecord = idRecord == null ? null : idRecord.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column out_poultry.id_charge
     *
     * @return the value of out_poultry.id_charge
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public String getIdCharge() {
        return idCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column out_poultry.id_charge
     *
     * @param idCharge the value for out_poultry.id_charge
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public void setIdCharge(String idCharge) {
        this.idCharge = idCharge == null ? null : idCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", recordDate=").append(recordDate);
        sb.append(", type=").append(type);
        sb.append(", quantity=").append(quantity);
        sb.append(", unit=").append(unit);
        sb.append(", idPatch=").append(idPatch);
        sb.append(", firm=").append(firm);
        sb.append(", phone=").append(phone);
        sb.append(", remark=").append(remark);
        sb.append(", idRecord=").append(idRecord);
        sb.append(", idCharge=").append(idCharge);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}