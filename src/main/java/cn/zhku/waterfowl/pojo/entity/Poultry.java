package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class Poultry implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poultry.id_poultry
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    private String idPoultry;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poultry.record_date
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    private Date recordDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poultry.type
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poultry.quantity
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    private String quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poultry.unit
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    private String unit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poultry.associated_firm
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    private String associatedFirm;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poultry.phone
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poultry.remark
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poultry.id_recorder
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    private String idRecorder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poultry.id_charge
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    private String idCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table poultry
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poultry.id_poultry
     *
     * @return the value of poultry.id_poultry
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public String getIdPoultry() {
        return idPoultry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poultry.id_poultry
     *
     * @param idPoultry the value for poultry.id_poultry
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public void setIdPoultry(String idPoultry) {
        this.idPoultry = idPoultry == null ? null : idPoultry.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poultry.record_date
     *
     * @return the value of poultry.record_date
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public Date getRecordDate() {
        return recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poultry.record_date
     *
     * @param recordDate the value for poultry.record_date
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poultry.type
     *
     * @return the value of poultry.type
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poultry.type
     *
     * @param type the value for poultry.type
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poultry.quantity
     *
     * @return the value of poultry.quantity
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poultry.quantity
     *
     * @param quantity the value for poultry.quantity
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity == null ? null : quantity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poultry.unit
     *
     * @return the value of poultry.unit
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poultry.unit
     *
     * @param unit the value for poultry.unit
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poultry.associated_firm
     *
     * @return the value of poultry.associated_firm
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public String getAssociatedFirm() {
        return associatedFirm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poultry.associated_firm
     *
     * @param associatedFirm the value for poultry.associated_firm
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public void setAssociatedFirm(String associatedFirm) {
        this.associatedFirm = associatedFirm == null ? null : associatedFirm.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poultry.phone
     *
     * @return the value of poultry.phone
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poultry.phone
     *
     * @param phone the value for poultry.phone
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poultry.remark
     *
     * @return the value of poultry.remark
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poultry.remark
     *
     * @param remark the value for poultry.remark
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poultry.id_recorder
     *
     * @return the value of poultry.id_recorder
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public String getIdRecorder() {
        return idRecorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poultry.id_recorder
     *
     * @param idRecorder the value for poultry.id_recorder
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public void setIdRecorder(String idRecorder) {
        this.idRecorder = idRecorder == null ? null : idRecorder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poultry.id_charge
     *
     * @return the value of poultry.id_charge
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public String getIdCharge() {
        return idCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poultry.id_charge
     *
     * @param idCharge the value for poultry.id_charge
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    public void setIdCharge(String idCharge) {
        this.idCharge = idCharge == null ? null : idCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Sat Jan 13 18:53:21 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idPoultry=").append(idPoultry);
        sb.append(", recordDate=").append(recordDate);
        sb.append(", type=").append(type);
        sb.append(", quantity=").append(quantity);
        sb.append(", unit=").append(unit);
        sb.append(", associatedFirm=").append(associatedFirm);
        sb.append(", phone=").append(phone);
        sb.append(", remark=").append(remark);
        sb.append(", idRecorder=").append(idRecorder);
        sb.append(", idCharge=").append(idCharge);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}