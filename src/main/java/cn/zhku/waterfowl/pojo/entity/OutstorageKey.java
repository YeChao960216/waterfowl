package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class OutstorageKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.id_outstorage
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    private String idOutstorage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outstorage.record_date
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    private Date recordDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table outstorage
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.id_outstorage
     *
     * @return the value of outstorage.id_outstorage
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
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
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    public void setIdOutstorage(String idOutstorage) {
        this.idOutstorage = idOutstorage == null ? null : idOutstorage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outstorage.record_date
     *
     * @return the value of outstorage.record_date
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
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
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outstorage
     *
     * @mbggenerated Sat Jan 13 13:20:16 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idOutstorage=").append(idOutstorage);
        sb.append(", recordDate=").append(recordDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}