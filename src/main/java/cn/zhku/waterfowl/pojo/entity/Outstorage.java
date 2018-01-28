package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class Outstorage implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.id_outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private String idOutstorage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.name
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.remark
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.record_date
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private Date recordDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.quantity
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private Float quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.unit
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private String unit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.id_recorder
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private String idRecorder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.id_charge
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private String idCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.firm
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private String firm;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.type
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.expiration_date
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private Date expirationDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.rest
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private Float rest;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.phone
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.valid
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private String valid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.site
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private String site;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.mode
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private String mode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.provide
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private String provide;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.id_outstorage
     *
     * @return the value of outstorage.id_outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public String getIdOutstorage() {
        return idOutstorage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.id_outstorage
     *
     * @param idOutstorage the value for outstorage.id_outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setIdOutstorage(String idOutstorage) {
        this.idOutstorage = idOutstorage == null ? null : idOutstorage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.name
     *
     * @return the value of outstorage.name
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.name
     *
     * @param name the value for outstorage.name
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.remark
     *
     * @return the value of outstorage.remark
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.remark
     *
     * @param remark the value for outstorage.remark
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.record_date
     *
     * @return the value of outstorage.record_date
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public Date getRecordDate() {
        return recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.record_date
     *
     * @param recordDate the value for outstorage.record_date
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.quantity
     *
     * @return the value of outstorage.quantity
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public Float getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.quantity
     *
     * @param quantity the value for outstorage.quantity
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.unit
     *
     * @return the value of outstorage.unit
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.unit
     *
     * @param unit the value for outstorage.unit
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.id_recorder
     *
     * @return the value of outstorage.id_recorder
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public String getIdRecorder() {
        return idRecorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.id_recorder
     *
     * @param idRecorder the value for outstorage.id_recorder
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setIdRecorder(String idRecorder) {
        this.idRecorder = idRecorder == null ? null : idRecorder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.id_charge
     *
     * @return the value of outstorage.id_charge
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public String getIdCharge() {
        return idCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.id_charge
     *
     * @param idCharge the value for outstorage.id_charge
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setIdCharge(String idCharge) {
        this.idCharge = idCharge == null ? null : idCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.firm
     *
     * @return the value of outstorage.firm
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public String getFirm() {
        return firm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.firm
     *
     * @param firm the value for outstorage.firm
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setFirm(String firm) {
        this.firm = firm == null ? null : firm.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.type
     *
     * @return the value of outstorage.type
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.type
     *
     * @param type the value for outstorage.type
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.expiration_date
     *
     * @return the value of outstorage.expiration_date
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.expiration_date
     *
     * @param expirationDate the value for outstorage.expiration_date
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.rest
     *
     * @return the value of outstorage.rest
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public Float getRest() {
        return rest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.rest
     *
     * @param rest the value for outstorage.rest
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setRest(Float rest) {
        this.rest = rest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.phone
     *
     * @return the value of outstorage.phone
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.phone
     *
     * @param phone the value for outstorage.phone
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.valid
     *
     * @return the value of outstorage.valid
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public String getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.valid
     *
     * @param valid the value for outstorage.valid
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setValid(String valid) {
        this.valid = valid == null ? null : valid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.site
     *
     * @return the value of outstorage.site
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public String getSite() {
        return site;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.site
     *
     * @param site the value for outstorage.site
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.mode
     *
     * @return the value of outstorage.mode
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public String getMode() {
        return mode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.mode
     *
     * @param mode the value for outstorage.mode
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.provide
     *
     * @return the value of outstorage.provide
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public String getProvide() {
        return provide;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.provide
     *
     * @param provide the value for outstorage.provide
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    public void setProvide(String provide) {
        this.provide = provide == null ? null : provide.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idOutstorage=").append(idOutstorage);
        sb.append(", name=").append(name);
        sb.append(", remark=").append(remark);
        sb.append(", recordDate=").append(recordDate);
        sb.append(", quantity=").append(quantity);
        sb.append(", unit=").append(unit);
        sb.append(", idRecorder=").append(idRecorder);
        sb.append(", idCharge=").append(idCharge);
        sb.append(", firm=").append(firm);
        sb.append(", type=").append(type);
        sb.append(", expirationDate=").append(expirationDate);
        sb.append(", rest=").append(rest);
        sb.append(", phone=").append(phone);
        sb.append(", valid=").append(valid);
        sb.append(", site=").append(site);
        sb.append(", mode=").append(mode);
        sb.append(", provide=").append(provide);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}