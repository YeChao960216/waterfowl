package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class Epidemic implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.id
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.fowlery_id
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String fowleryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.inventory_id
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String inventoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.date
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private Date date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.sign
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String sign;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.diseaes
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String diseaes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.num_total
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private Integer numTotal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.num_infected
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private Integer numInfected;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.processing_mode
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String processingMode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.medication_mode
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String medicationMode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.dose
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private Float dose;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.dose_unit
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String doseUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.medication_amount
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private Float medicationAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.remark
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.id_recorder
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String idRecorder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.id_charge
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String idCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.id_batch
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private String idBatch;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table epidemic
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.id
     *
     * @return the value of epidemic.id
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.id
     *
     * @param id the value for epidemic.id
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.fowlery_id
     *
     * @return the value of epidemic.fowlery_id
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getFowleryId() {
        return fowleryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.fowlery_id
     *
     * @param fowleryId the value for epidemic.fowlery_id
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setFowleryId(String fowleryId) {
        this.fowleryId = fowleryId == null ? null : fowleryId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.inventory_id
     *
     * @return the value of epidemic.inventory_id
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getInventoryId() {
        return inventoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.inventory_id
     *
     * @param inventoryId the value for epidemic.inventory_id
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId == null ? null : inventoryId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.date
     *
     * @return the value of epidemic.date
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.date
     *
     * @param date the value for epidemic.date
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.sign
     *
     * @return the value of epidemic.sign
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getSign() {
        return sign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.sign
     *
     * @param sign the value for epidemic.sign
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.diseaes
     *
     * @return the value of epidemic.diseaes
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getDiseaes() {
        return diseaes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.diseaes
     *
     * @param diseaes the value for epidemic.diseaes
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setDiseaes(String diseaes) {
        this.diseaes = diseaes == null ? null : diseaes.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.num_total
     *
     * @return the value of epidemic.num_total
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public Integer getNumTotal() {
        return numTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.num_total
     *
     * @param numTotal the value for epidemic.num_total
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setNumTotal(Integer numTotal) {
        this.numTotal = numTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.num_infected
     *
     * @return the value of epidemic.num_infected
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public Integer getNumInfected() {
        return numInfected;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.num_infected
     *
     * @param numInfected the value for epidemic.num_infected
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setNumInfected(Integer numInfected) {
        this.numInfected = numInfected;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.processing_mode
     *
     * @return the value of epidemic.processing_mode
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getProcessingMode() {
        return processingMode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.processing_mode
     *
     * @param processingMode the value for epidemic.processing_mode
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setProcessingMode(String processingMode) {
        this.processingMode = processingMode == null ? null : processingMode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.medication_mode
     *
     * @return the value of epidemic.medication_mode
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getMedicationMode() {
        return medicationMode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.medication_mode
     *
     * @param medicationMode the value for epidemic.medication_mode
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setMedicationMode(String medicationMode) {
        this.medicationMode = medicationMode == null ? null : medicationMode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.dose
     *
     * @return the value of epidemic.dose
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public Float getDose() {
        return dose;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.dose
     *
     * @param dose the value for epidemic.dose
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setDose(Float dose) {
        this.dose = dose;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.dose_unit
     *
     * @return the value of epidemic.dose_unit
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getDoseUnit() {
        return doseUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.dose_unit
     *
     * @param doseUnit the value for epidemic.dose_unit
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setDoseUnit(String doseUnit) {
        this.doseUnit = doseUnit == null ? null : doseUnit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.medication_amount
     *
     * @return the value of epidemic.medication_amount
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public Float getMedicationAmount() {
        return medicationAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.medication_amount
     *
     * @param medicationAmount the value for epidemic.medication_amount
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setMedicationAmount(Float medicationAmount) {
        this.medicationAmount = medicationAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.remark
     *
     * @return the value of epidemic.remark
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.remark
     *
     * @param remark the value for epidemic.remark
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.id_recorder
     *
     * @return the value of epidemic.id_recorder
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getIdRecorder() {
        return idRecorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.id_recorder
     *
     * @param idRecorder the value for epidemic.id_recorder
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setIdRecorder(String idRecorder) {
        this.idRecorder = idRecorder == null ? null : idRecorder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.id_charge
     *
     * @return the value of epidemic.id_charge
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getIdCharge() {
        return idCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.id_charge
     *
     * @param idCharge the value for epidemic.id_charge
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setIdCharge(String idCharge) {
        this.idCharge = idCharge == null ? null : idCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.id_batch
     *
     * @return the value of epidemic.id_batch
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getIdBatch() {
        return idBatch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.id_batch
     *
     * @param idBatch the value for epidemic.id_batch
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setIdBatch(String idBatch) {
        this.idBatch = idBatch == null ? null : idBatch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
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
        sb.append(", fowleryId=").append(fowleryId);
        sb.append(", inventoryId=").append(inventoryId);
        sb.append(", date=").append(date);
        sb.append(", sign=").append(sign);
        sb.append(", diseaes=").append(diseaes);
        sb.append(", numTotal=").append(numTotal);
        sb.append(", numInfected=").append(numInfected);
        sb.append(", processingMode=").append(processingMode);
        sb.append(", medicationMode=").append(medicationMode);
        sb.append(", dose=").append(dose);
        sb.append(", doseUnit=").append(doseUnit);
        sb.append(", medicationAmount=").append(medicationAmount);
        sb.append(", remark=").append(remark);
        sb.append(", idRecorder=").append(idRecorder);
        sb.append(", idCharge=").append(idCharge);
        sb.append(", idBatch=").append(idBatch);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}