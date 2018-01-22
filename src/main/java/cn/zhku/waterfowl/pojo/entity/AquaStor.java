package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;

public class AquaStor implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aqua_stor.aid
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    private String aid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aqua_stor.id_outstorage
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    private String idOutstorage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aqua_stor.id
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table aqua_stor
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aqua_stor.aid
     *
     * @return the value of aqua_stor.aid
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    public String getAid() {
        return aid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aqua_stor.aid
     *
     * @param aid the value for aqua_stor.aid
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    public void setAid(String aid) {
        this.aid = aid == null ? null : aid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aqua_stor.id_outstorage
     *
     * @return the value of aqua_stor.id_outstorage
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    public String getIdOutstorage() {
        return idOutstorage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aqua_stor.id_outstorage
     *
     * @param idOutstorage the value for aqua_stor.id_outstorage
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    public void setIdOutstorage(String idOutstorage) {
        this.idOutstorage = idOutstorage == null ? null : idOutstorage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aqua_stor.id
     *
     * @return the value of aqua_stor.id
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aqua_stor.id
     *
     * @param id the value for aqua_stor.id
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aid=").append(aid);
        sb.append(", idOutstorage=").append(idOutstorage);
        sb.append(", id=").append(id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}