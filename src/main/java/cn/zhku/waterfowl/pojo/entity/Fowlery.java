package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;

public class Fowlery implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fowlery.id
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fowlery.size
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    private String size;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fowlery.status
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fowlery.affiliation
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    private String affiliation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fowlery.id_record
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    private String idRecord;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fowlery.id_charge
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    private String idCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fowlery.id
     *
     * @return the value of fowlery.id
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fowlery.id
     *
     * @param id the value for fowlery.id
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fowlery.size
     *
     * @return the value of fowlery.size
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    public String getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fowlery.size
     *
     * @param size the value for fowlery.size
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fowlery.status
     *
     * @return the value of fowlery.status
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fowlery.status
     *
     * @param status the value for fowlery.status
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fowlery.affiliation
     *
     * @return the value of fowlery.affiliation
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    public String getAffiliation() {
        return affiliation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fowlery.affiliation
     *
     * @param affiliation the value for fowlery.affiliation
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation == null ? null : affiliation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fowlery.id_record
     *
     * @return the value of fowlery.id_record
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    public String getIdRecord() {
        return idRecord;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fowlery.id_record
     *
     * @param idRecord the value for fowlery.id_record
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    public void setIdRecord(String idRecord) {
        this.idRecord = idRecord == null ? null : idRecord.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fowlery.id_charge
     *
     * @return the value of fowlery.id_charge
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    public String getIdCharge() {
        return idCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fowlery.id_charge
     *
     * @param idCharge the value for fowlery.id_charge
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    public void setIdCharge(String idCharge) {
        this.idCharge = idCharge == null ? null : idCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", size=").append(size);
        sb.append(", status=").append(status);
        sb.append(", affiliation=").append(affiliation);
        sb.append(", idRecord=").append(idRecord);
        sb.append(", idCharge=").append(idCharge);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}