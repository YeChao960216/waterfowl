package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class Inventory implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inventory.id
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inventory.expiration_date
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private Date expirationDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inventory.name
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inventory.quantity
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private Float quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inventory.unit
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String unit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inventory.storage_site
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String storageSite;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inventory.storage_mode
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String storageMode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inventory.remark
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inventory.id_recorder
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String idRecorder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inventory.id_charge
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String idCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inventory.id
     *
     * @return the value of inventory.id
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inventory.id
     *
     * @param id the value for inventory.id
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inventory.expiration_date
     *
     * @return the value of inventory.expiration_date
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inventory.expiration_date
     *
     * @param expirationDate the value for inventory.expiration_date
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inventory.name
     *
     * @return the value of inventory.name
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inventory.name
     *
     * @param name the value for inventory.name
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inventory.quantity
     *
     * @return the value of inventory.quantity
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public Float getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inventory.quantity
     *
     * @param quantity the value for inventory.quantity
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inventory.unit
     *
     * @return the value of inventory.unit
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inventory.unit
     *
     * @param unit the value for inventory.unit
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inventory.storage_site
     *
     * @return the value of inventory.storage_site
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getStorageSite() {
        return storageSite;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inventory.storage_site
     *
     * @param storageSite the value for inventory.storage_site
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setStorageSite(String storageSite) {
        this.storageSite = storageSite == null ? null : storageSite.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inventory.storage_mode
     *
     * @return the value of inventory.storage_mode
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getStorageMode() {
        return storageMode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inventory.storage_mode
     *
     * @param storageMode the value for inventory.storage_mode
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setStorageMode(String storageMode) {
        this.storageMode = storageMode == null ? null : storageMode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inventory.remark
     *
     * @return the value of inventory.remark
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inventory.remark
     *
     * @param remark the value for inventory.remark
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inventory.id_recorder
     *
     * @return the value of inventory.id_recorder
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getIdRecorder() {
        return idRecorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inventory.id_recorder
     *
     * @param idRecorder the value for inventory.id_recorder
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setIdRecorder(String idRecorder) {
        this.idRecorder = idRecorder == null ? null : idRecorder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inventory.id_charge
     *
     * @return the value of inventory.id_charge
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getIdCharge() {
        return idCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inventory.id_charge
     *
     * @param idCharge the value for inventory.id_charge
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setIdCharge(String idCharge) {
        this.idCharge = idCharge == null ? null : idCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", expirationDate=").append(expirationDate);
        sb.append(", name=").append(name);
        sb.append(", quantity=").append(quantity);
        sb.append(", unit=").append(unit);
        sb.append(", storageSite=").append(storageSite);
        sb.append(", storageMode=").append(storageMode);
        sb.append(", remark=").append(remark);
        sb.append(", idRecorder=").append(idRecorder);
        sb.append(", idCharge=").append(idCharge);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}