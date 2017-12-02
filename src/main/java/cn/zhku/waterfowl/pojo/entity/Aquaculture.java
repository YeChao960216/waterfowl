package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class Aquaculture implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aquaculture.id
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aquaculture.name
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aquaculture.id_fowlery
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    private String idFowlery;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aquaculture.id_patch
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    private String idPatch;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aquaculture.record_date
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    private Date recordDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aquaculture.num_total
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    private Integer numTotal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aquaculture.feed_type
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    private String feedType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aquaculture.feed_weight
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    private Float feedWeight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aquaculture.remark
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aquaculture.id_recorder
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    private String idRecorder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aquaculture.id_charge
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    private String idCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aquaculture.id_outstorage
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    private String idOutstorage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aquaculture.status
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table aquaculture
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aquaculture.id
     *
     * @return the value of aquaculture.id
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aquaculture.id
     *
     * @param id the value for aquaculture.id
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aquaculture.name
     *
     * @return the value of aquaculture.name
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aquaculture.name
     *
     * @param name the value for aquaculture.name
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aquaculture.id_fowlery
     *
     * @return the value of aquaculture.id_fowlery
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public String getIdFowlery() {
        return idFowlery;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aquaculture.id_fowlery
     *
     * @param idFowlery the value for aquaculture.id_fowlery
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public void setIdFowlery(String idFowlery) {
        this.idFowlery = idFowlery == null ? null : idFowlery.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aquaculture.id_patch
     *
     * @return the value of aquaculture.id_patch
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public String getIdPatch() {
        return idPatch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aquaculture.id_patch
     *
     * @param idPatch the value for aquaculture.id_patch
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public void setIdPatch(String idPatch) {
        this.idPatch = idPatch == null ? null : idPatch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aquaculture.record_date
     *
     * @return the value of aquaculture.record_date
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public Date getRecordDate() {
        return recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aquaculture.record_date
     *
     * @param recordDate the value for aquaculture.record_date
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aquaculture.num_total
     *
     * @return the value of aquaculture.num_total
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public Integer getNumTotal() {
        return numTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aquaculture.num_total
     *
     * @param numTotal the value for aquaculture.num_total
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public void setNumTotal(Integer numTotal) {
        this.numTotal = numTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aquaculture.feed_type
     *
     * @return the value of aquaculture.feed_type
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public String getFeedType() {
        return feedType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aquaculture.feed_type
     *
     * @param feedType the value for aquaculture.feed_type
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public void setFeedType(String feedType) {
        this.feedType = feedType == null ? null : feedType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aquaculture.feed_weight
     *
     * @return the value of aquaculture.feed_weight
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public Float getFeedWeight() {
        return feedWeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aquaculture.feed_weight
     *
     * @param feedWeight the value for aquaculture.feed_weight
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public void setFeedWeight(Float feedWeight) {
        this.feedWeight = feedWeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aquaculture.remark
     *
     * @return the value of aquaculture.remark
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aquaculture.remark
     *
     * @param remark the value for aquaculture.remark
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aquaculture.id_recorder
     *
     * @return the value of aquaculture.id_recorder
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public String getIdRecorder() {
        return idRecorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aquaculture.id_recorder
     *
     * @param idRecorder the value for aquaculture.id_recorder
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public void setIdRecorder(String idRecorder) {
        this.idRecorder = idRecorder == null ? null : idRecorder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aquaculture.id_charge
     *
     * @return the value of aquaculture.id_charge
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public String getIdCharge() {
        return idCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aquaculture.id_charge
     *
     * @param idCharge the value for aquaculture.id_charge
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public void setIdCharge(String idCharge) {
        this.idCharge = idCharge == null ? null : idCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aquaculture.id_outstorage
     *
     * @return the value of aquaculture.id_outstorage
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public String getIdOutstorage() {
        return idOutstorage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aquaculture.id_outstorage
     *
     * @param idOutstorage the value for aquaculture.id_outstorage
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public void setIdOutstorage(String idOutstorage) {
        this.idOutstorage = idOutstorage == null ? null : idOutstorage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aquaculture.status
     *
     * @return the value of aquaculture.status
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aquaculture.status
     *
     * @param status the value for aquaculture.status
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", idFowlery=").append(idFowlery);
        sb.append(", idPatch=").append(idPatch);
        sb.append(", recordDate=").append(recordDate);
        sb.append(", numTotal=").append(numTotal);
        sb.append(", feedType=").append(feedType);
        sb.append(", feedWeight=").append(feedWeight);
        sb.append(", remark=").append(remark);
        sb.append(", idRecorder=").append(idRecorder);
        sb.append(", idCharge=").append(idCharge);
        sb.append(", idOutstorage=").append(idOutstorage);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}