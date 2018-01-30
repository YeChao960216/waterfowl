package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;

public class EpiStor implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epi_stor.eid
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    private String eid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epi_stor.id_outstorage
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    private String idOutstorage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column epi_stor.id
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table epi_stor
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epi_stor.eid
     *
     * @return the value of epi_stor.eid
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public String getEid() {
        return eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epi_stor.eid
     *
     * @param eid the value for epi_stor.eid
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public void setEid(String eid) {
        this.eid = eid == null ? null : eid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epi_stor.id_outstorage
     *
     * @return the value of epi_stor.id_outstorage
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public String getIdOutstorage() {
        return idOutstorage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epi_stor.id_outstorage
     *
     * @param idOutstorage the value for epi_stor.id_outstorage
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public void setIdOutstorage(String idOutstorage) {
        this.idOutstorage = idOutstorage == null ? null : idOutstorage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column epi_stor.id
     *
     * @return the value of epi_stor.id
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column epi_stor.id
     *
     * @param id the value for epi_stor.id
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epi_stor
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eid=").append(eid);
        sb.append(", idOutstorage=").append(idOutstorage);
        sb.append(", id=").append(id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}