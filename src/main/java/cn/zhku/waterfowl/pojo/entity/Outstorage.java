package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class Outstorage implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.id_outstorage
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    private String idOutstorage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.name
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.remark
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.id_storage
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    private String idStorage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.record_date
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    private Date recordDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.quantity
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    private String quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.unit
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    private String unit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.id_recorder
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    private String idRecorder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.id_charge
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    private String idCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table outstorage
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.id_outstorage
     *
     * @return the value of outstorage.id_outstorage
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
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
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
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
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
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
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
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
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
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
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.id_storage
     *
     * @return the value of outstorage.id_storage
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    public String getIdStorage() {
        return idStorage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.id_storage
     *
     * @param idStorage the value for outstorage.id_storage
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    public void setIdStorage(String idStorage) {
        this.idStorage = idStorage == null ? null : idStorage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.record_date
     *
     * @return the value of outstorage.record_date
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
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
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
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
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outstorage.quantity
     *
     * @param quantity the value for outstorage.quantity
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity == null ? null : quantity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.unit
     *
     * @return the value of outstorage.unit
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
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
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
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
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
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
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
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
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
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
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
     */
    public void setIdCharge(String idCharge) {
        this.idCharge = idCharge == null ? null : idCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outstorage
     *
     * @mbggenerated Tue Nov 28 19:33:38 CST 2017
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
        sb.append(", idStorage=").append(idStorage);
        sb.append(", recordDate=").append(recordDate);
        sb.append(", quantity=").append(quantity);
        sb.append(", unit=").append(unit);
        sb.append(", idRecorder=").append(idRecorder);
        sb.append(", idCharge=").append(idCharge);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}