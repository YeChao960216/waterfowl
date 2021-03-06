package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class Ddl implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ddl.id
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ddl.id_patch
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    private String idPatch;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ddl.record_date
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    private Date recordDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ddl.num_processed
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    private Integer numProcessed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ddl.processing_mode
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    private String processingMode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ddl.remark
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ddl.id_recorder
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    private String idRecorder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ddl.id_charge
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    private String idCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ddl
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ddl.id
     *
     * @return the value of ddl.id
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ddl.id
     *
     * @param id the value for ddl.id
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ddl.id_patch
     *
     * @return the value of ddl.id_patch
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public String getIdPatch() {
        return idPatch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ddl.id_patch
     *
     * @param idPatch the value for ddl.id_patch
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public void setIdPatch(String idPatch) {
        this.idPatch = idPatch == null ? null : idPatch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ddl.record_date
     *
     * @return the value of ddl.record_date
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public Date getRecordDate() {
        return recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ddl.record_date
     *
     * @param recordDate the value for ddl.record_date
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ddl.num_processed
     *
     * @return the value of ddl.num_processed
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public Integer getNumProcessed() {
        return numProcessed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ddl.num_processed
     *
     * @param numProcessed the value for ddl.num_processed
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public void setNumProcessed(Integer numProcessed) {
        this.numProcessed = numProcessed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ddl.processing_mode
     *
     * @return the value of ddl.processing_mode
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public String getProcessingMode() {
        return processingMode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ddl.processing_mode
     *
     * @param processingMode the value for ddl.processing_mode
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public void setProcessingMode(String processingMode) {
        this.processingMode = processingMode == null ? null : processingMode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ddl.remark
     *
     * @return the value of ddl.remark
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ddl.remark
     *
     * @param remark the value for ddl.remark
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ddl.id_recorder
     *
     * @return the value of ddl.id_recorder
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public String getIdRecorder() {
        return idRecorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ddl.id_recorder
     *
     * @param idRecorder the value for ddl.id_recorder
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public void setIdRecorder(String idRecorder) {
        this.idRecorder = idRecorder == null ? null : idRecorder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ddl.id_charge
     *
     * @return the value of ddl.id_charge
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public String getIdCharge() {
        return idCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ddl.id_charge
     *
     * @param idCharge the value for ddl.id_charge
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    public void setIdCharge(String idCharge) {
        this.idCharge = idCharge == null ? null : idCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idPatch=").append(idPatch);
        sb.append(", recordDate=").append(recordDate);
        sb.append(", numProcessed=").append(numProcessed);
        sb.append(", processingMode=").append(processingMode);
        sb.append(", remark=").append(remark);
        sb.append(", idRecorder=").append(idRecorder);
        sb.append(", idCharge=").append(idCharge);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}