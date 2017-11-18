package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class Epidemic implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.id
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.id_patch
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private String idPatch;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.name
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.id_outstorage
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private String idOutstorage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.record_date
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private Date recordDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.sign
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private String sign;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.diseaes
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private String diseaes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.num_infected
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private Integer numInfected;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.processing_mode
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private String processingMode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.medication_mode
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private String medicationMode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.dose
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private Float dose;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.dose_unit
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private String doseUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.remark
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.id_recorder
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private String idRecorder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.id_charge
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private String idCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epidemic.flag
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private Integer flag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table epidemic
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.id
     *
     * @return the value of epidemic.id
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.id_patch
     *
     * @return the value of epidemic.id_patch
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    public String getIdPatch() {
        return idPatch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.id_patch
     *
     * @param idPatch the value for epidemic.id_patch
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    public void setIdPatch(String idPatch) {
        this.idPatch = idPatch == null ? null : idPatch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.name
     *
     * @return the value of epidemic.name
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.name
     *
     * @param name the value for epidemic.name
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.id_outstorage
     *
     * @return the value of epidemic.id_outstorage
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    public String getIdOutstorage() {
        return idOutstorage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.id_outstorage
     *
     * @param idOutstorage the value for epidemic.id_outstorage
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    public void setIdOutstorage(String idOutstorage) {
        this.idOutstorage = idOutstorage == null ? null : idOutstorage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.record_date
     *
     * @return the value of epidemic.record_date
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    public Date getRecordDate() {
        return recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.record_date
     *
     * @param recordDate the value for epidemic.record_date
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.sign
     *
     * @return the value of epidemic.sign
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    public void setDiseaes(String diseaes) {
        this.diseaes = diseaes == null ? null : diseaes.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.num_infected
     *
     * @return the value of epidemic.num_infected
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    public void setDoseUnit(String doseUnit) {
        this.doseUnit = doseUnit == null ? null : doseUnit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.remark
     *
     * @return the value of epidemic.remark
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
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
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    public void setIdCharge(String idCharge) {
        this.idCharge = idCharge == null ? null : idCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epidemic.flag
     *
     * @return the value of epidemic.flag
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epidemic.flag
     *
     * @param flag the value for epidemic.flag
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sat Nov 18 13:53:37 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idPatch=").append(idPatch);
        sb.append(", name=").append(name);
        sb.append(", idOutstorage=").append(idOutstorage);
        sb.append(", recordDate=").append(recordDate);
        sb.append(", sign=").append(sign);
        sb.append(", diseaes=").append(diseaes);
        sb.append(", numInfected=").append(numInfected);
        sb.append(", processingMode=").append(processingMode);
        sb.append(", medicationMode=").append(medicationMode);
        sb.append(", dose=").append(dose);
        sb.append(", doseUnit=").append(doseUnit);
        sb.append(", remark=").append(remark);
        sb.append(", idRecorder=").append(idRecorder);
        sb.append(", idCharge=").append(idCharge);
        sb.append(", flag=").append(flag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}