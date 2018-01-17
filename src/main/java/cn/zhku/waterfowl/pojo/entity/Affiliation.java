package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;

public class Affiliation implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column affiliation.id
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column affiliation.type
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column affiliation.position
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    private String position;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column affiliation.size
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    private String size;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column affiliation.status
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column affiliation.id_record
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    private String idRecord;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column affiliation.id_charge
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    private String idCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table affiliation
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column affiliation.id
     *
     * @return the value of affiliation.id
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column affiliation.id
     *
     * @param id the value for affiliation.id
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column affiliation.type
     *
     * @return the value of affiliation.type
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column affiliation.type
     *
     * @param type the value for affiliation.type
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column affiliation.position
     *
     * @return the value of affiliation.position
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    public String getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column affiliation.position
     *
     * @param position the value for affiliation.position
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column affiliation.size
     *
     * @return the value of affiliation.size
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    public String getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column affiliation.size
     *
     * @param size the value for affiliation.size
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column affiliation.status
     *
     * @return the value of affiliation.status
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column affiliation.status
     *
     * @param status the value for affiliation.status
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column affiliation.id_record
     *
     * @return the value of affiliation.id_record
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    public String getIdRecord() {
        return idRecord;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column affiliation.id_record
     *
     * @param idRecord the value for affiliation.id_record
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    public void setIdRecord(String idRecord) {
        this.idRecord = idRecord == null ? null : idRecord.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column affiliation.id_charge
     *
     * @return the value of affiliation.id_charge
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    public String getIdCharge() {
        return idCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column affiliation.id_charge
     *
     * @param idCharge the value for affiliation.id_charge
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    public void setIdCharge(String idCharge) {
        this.idCharge = idCharge == null ? null : idCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Wed Jan 17 16:41:27 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", position=").append(position);
        sb.append(", size=").append(size);
        sb.append(", status=").append(status);
        sb.append(", idRecord=").append(idRecord);
        sb.append(", idCharge=").append(idCharge);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}