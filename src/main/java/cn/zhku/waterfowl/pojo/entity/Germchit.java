package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class Germchit implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column germchit.id
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column germchit.incubation_date
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private Date incubationDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column germchit.collect_date
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private Date collectDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column germchit.incubation_plant
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String incubationPlant;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column germchit.incubator
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String incubator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column germchit.chick_discharger
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String chickDischarger;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column germchit.id_breeding
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String idBreeding;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column germchit.num_total
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private Integer numTotal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column germchit.id_record
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String idRecord;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column germchit.id_charge
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String idCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table germchit
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column germchit.id
     *
     * @return the value of germchit.id
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column germchit.id
     *
     * @param id the value for germchit.id
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column germchit.incubation_date
     *
     * @return the value of germchit.incubation_date
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public Date getIncubationDate() {
        return incubationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column germchit.incubation_date
     *
     * @param incubationDate the value for germchit.incubation_date
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setIncubationDate(Date incubationDate) {
        this.incubationDate = incubationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column germchit.collect_date
     *
     * @return the value of germchit.collect_date
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public Date getCollectDate() {
        return collectDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column germchit.collect_date
     *
     * @param collectDate the value for germchit.collect_date
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column germchit.incubation_plant
     *
     * @return the value of germchit.incubation_plant
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getIncubationPlant() {
        return incubationPlant;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column germchit.incubation_plant
     *
     * @param incubationPlant the value for germchit.incubation_plant
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setIncubationPlant(String incubationPlant) {
        this.incubationPlant = incubationPlant == null ? null : incubationPlant.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column germchit.incubator
     *
     * @return the value of germchit.incubator
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getIncubator() {
        return incubator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column germchit.incubator
     *
     * @param incubator the value for germchit.incubator
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setIncubator(String incubator) {
        this.incubator = incubator == null ? null : incubator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column germchit.chick_discharger
     *
     * @return the value of germchit.chick_discharger
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getChickDischarger() {
        return chickDischarger;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column germchit.chick_discharger
     *
     * @param chickDischarger the value for germchit.chick_discharger
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setChickDischarger(String chickDischarger) {
        this.chickDischarger = chickDischarger == null ? null : chickDischarger.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column germchit.id_breeding
     *
     * @return the value of germchit.id_breeding
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getIdBreeding() {
        return idBreeding;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column germchit.id_breeding
     *
     * @param idBreeding the value for germchit.id_breeding
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setIdBreeding(String idBreeding) {
        this.idBreeding = idBreeding == null ? null : idBreeding.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column germchit.num_total
     *
     * @return the value of germchit.num_total
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public Integer getNumTotal() {
        return numTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column germchit.num_total
     *
     * @param numTotal the value for germchit.num_total
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setNumTotal(Integer numTotal) {
        this.numTotal = numTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column germchit.id_record
     *
     * @return the value of germchit.id_record
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getIdRecord() {
        return idRecord;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column germchit.id_record
     *
     * @param idRecord the value for germchit.id_record
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setIdRecord(String idRecord) {
        this.idRecord = idRecord == null ? null : idRecord.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column germchit.id_charge
     *
     * @return the value of germchit.id_charge
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getIdCharge() {
        return idCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column germchit.id_charge
     *
     * @param idCharge the value for germchit.id_charge
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setIdCharge(String idCharge) {
        this.idCharge = idCharge == null ? null : idCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table germchit
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", incubationDate=").append(incubationDate);
        sb.append(", collectDate=").append(collectDate);
        sb.append(", incubationPlant=").append(incubationPlant);
        sb.append(", incubator=").append(incubator);
        sb.append(", chickDischarger=").append(chickDischarger);
        sb.append(", idBreeding=").append(idBreeding);
        sb.append(", numTotal=").append(numTotal);
        sb.append(", idRecord=").append(idRecord);
        sb.append(", idCharge=").append(idCharge);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}