package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class Manufacture implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.id
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.firm
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    private String firm;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.site
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    private String site;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.method
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    private String method;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.phone
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.record_date
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    private Date recordDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.id_charge
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    private String idCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.id_patch
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    private String idPatch;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.quantity
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    private Integer quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.remark
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manufacture
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.id
     *
     * @return the value of manufacture.id
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.id
     *
     * @param id the value for manufacture.id
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.firm
     *
     * @return the value of manufacture.firm
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public String getFirm() {
        return firm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.firm
     *
     * @param firm the value for manufacture.firm
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public void setFirm(String firm) {
        this.firm = firm == null ? null : firm.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.site
     *
     * @return the value of manufacture.site
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public String getSite() {
        return site;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.site
     *
     * @param site the value for manufacture.site
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.method
     *
     * @return the value of manufacture.method
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public String getMethod() {
        return method;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.method
     *
     * @param method the value for manufacture.method
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.phone
     *
     * @return the value of manufacture.phone
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.phone
     *
     * @param phone the value for manufacture.phone
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.record_date
     *
     * @return the value of manufacture.record_date
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public Date getRecordDate() {
        return recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.record_date
     *
     * @param recordDate the value for manufacture.record_date
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.id_charge
     *
     * @return the value of manufacture.id_charge
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public String getIdCharge() {
        return idCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.id_charge
     *
     * @param idCharge the value for manufacture.id_charge
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public void setIdCharge(String idCharge) {
        this.idCharge = idCharge == null ? null : idCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.id_patch
     *
     * @return the value of manufacture.id_patch
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public String getIdPatch() {
        return idPatch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.id_patch
     *
     * @param idPatch the value for manufacture.id_patch
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public void setIdPatch(String idPatch) {
        this.idPatch = idPatch == null ? null : idPatch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.quantity
     *
     * @return the value of manufacture.quantity
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.quantity
     *
     * @param quantity the value for manufacture.quantity
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.remark
     *
     * @return the value of manufacture.remark
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.remark
     *
     * @param remark the value for manufacture.remark
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbggenerated Tue Jan 23 21:48:06 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", firm=").append(firm);
        sb.append(", site=").append(site);
        sb.append(", method=").append(method);
        sb.append(", phone=").append(phone);
        sb.append(", recordDate=").append(recordDate);
        sb.append(", idCharge=").append(idCharge);
        sb.append(", idPatch=").append(idPatch);
        sb.append(", quantity=").append(quantity);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}