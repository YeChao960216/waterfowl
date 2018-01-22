package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class Patch implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patch.id
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patch.id_poultry
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    private String idPoultry;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patch.type
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patch.position
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    private String position;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patch.size
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    private Integer size;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patch.id_affilation
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    private String idAffilation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patch.id_fowlery
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    private String idFowlery;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patch.id_charge
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    private String idCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patch.id_recorder
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    private String idRecorder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patch.date
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    private Date date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patch.num_total
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    private Integer numTotal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patch.status
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table patch
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patch.id
     *
     * @return the value of patch.id
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patch.id
     *
     * @param id the value for patch.id
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patch.id_poultry
     *
     * @return the value of patch.id_poultry
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public String getIdPoultry() {
        return idPoultry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patch.id_poultry
     *
     * @param idPoultry the value for patch.id_poultry
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void setIdPoultry(String idPoultry) {
        this.idPoultry = idPoultry == null ? null : idPoultry.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patch.type
     *
     * @return the value of patch.type
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patch.type
     *
     * @param type the value for patch.type
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patch.position
     *
     * @return the value of patch.position
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public String getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patch.position
     *
     * @param position the value for patch.position
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patch.size
     *
     * @return the value of patch.size
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public Integer getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patch.size
     *
     * @param size the value for patch.size
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patch.id_affilation
     *
     * @return the value of patch.id_affilation
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public String getIdAffilation() {
        return idAffilation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patch.id_affilation
     *
     * @param idAffilation the value for patch.id_affilation
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void setIdAffilation(String idAffilation) {
        this.idAffilation = idAffilation == null ? null : idAffilation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patch.id_fowlery
     *
     * @return the value of patch.id_fowlery
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public String getIdFowlery() {
        return idFowlery;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patch.id_fowlery
     *
     * @param idFowlery the value for patch.id_fowlery
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void setIdFowlery(String idFowlery) {
        this.idFowlery = idFowlery == null ? null : idFowlery.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patch.id_charge
     *
     * @return the value of patch.id_charge
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public String getIdCharge() {
        return idCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patch.id_charge
     *
     * @param idCharge the value for patch.id_charge
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void setIdCharge(String idCharge) {
        this.idCharge = idCharge == null ? null : idCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patch.id_recorder
     *
     * @return the value of patch.id_recorder
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public String getIdRecorder() {
        return idRecorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patch.id_recorder
     *
     * @param idRecorder the value for patch.id_recorder
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void setIdRecorder(String idRecorder) {
        this.idRecorder = idRecorder == null ? null : idRecorder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patch.date
     *
     * @return the value of patch.date
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patch.date
     *
     * @param date the value for patch.date
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patch.num_total
     *
     * @return the value of patch.num_total
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public Integer getNumTotal() {
        return numTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patch.num_total
     *
     * @param numTotal the value for patch.num_total
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void setNumTotal(Integer numTotal) {
        this.numTotal = numTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patch.status
     *
     * @return the value of patch.status
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patch.status
     *
     * @param status the value for patch.status
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patch
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idPoultry=").append(idPoultry);
        sb.append(", type=").append(type);
        sb.append(", position=").append(position);
        sb.append(", size=").append(size);
        sb.append(", idAffilation=").append(idAffilation);
        sb.append(", idFowlery=").append(idFowlery);
        sb.append(", idCharge=").append(idCharge);
        sb.append(", idRecorder=").append(idRecorder);
        sb.append(", date=").append(date);
        sb.append(", numTotal=").append(numTotal);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}