package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class Weather implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.id
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.id_fowlery
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private String idFowlery;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.record_date
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private Date recordDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.humidity_in
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private Float humidityIn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.humidity_out
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private String humidityOut;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.co2
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private Float co2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.temperature_out
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private String temperatureOut;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.temperature_in
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private Float temperatureIn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.illuminance
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private Float illuminance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.h2s
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private Float h2s;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.nh4
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private Float nh4;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.dust
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private Float dust;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.picture
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private String picture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.remark
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.id_recorder
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private String idRecorder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.id_charge
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private String idCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weather.unit
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private String unit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weather
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.id
     *
     * @return the value of weather.id
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.id
     *
     * @param id the value for weather.id
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.id_fowlery
     *
     * @return the value of weather.id_fowlery
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public String getIdFowlery() {
        return idFowlery;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.id_fowlery
     *
     * @param idFowlery the value for weather.id_fowlery
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setIdFowlery(String idFowlery) {
        this.idFowlery = idFowlery == null ? null : idFowlery.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.record_date
     *
     * @return the value of weather.record_date
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public Date getRecordDate() {
        return recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.record_date
     *
     * @param recordDate the value for weather.record_date
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.humidity_in
     *
     * @return the value of weather.humidity_in
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public Float getHumidityIn() {
        return humidityIn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.humidity_in
     *
     * @param humidityIn the value for weather.humidity_in
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setHumidityIn(Float humidityIn) {
        this.humidityIn = humidityIn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.humidity_out
     *
     * @return the value of weather.humidity_out
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public String getHumidityOut() {
        return humidityOut;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.humidity_out
     *
     * @param humidityOut the value for weather.humidity_out
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setHumidityOut(String humidityOut) {
        this.humidityOut = humidityOut == null ? null : humidityOut.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.co2
     *
     * @return the value of weather.co2
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public Float getCo2() {
        return co2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.co2
     *
     * @param co2 the value for weather.co2
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setCo2(Float co2) {
        this.co2 = co2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.temperature_out
     *
     * @return the value of weather.temperature_out
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public String getTemperatureOut() {
        return temperatureOut;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.temperature_out
     *
     * @param temperatureOut the value for weather.temperature_out
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setTemperatureOut(String temperatureOut) {
        this.temperatureOut = temperatureOut == null ? null : temperatureOut.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.temperature_in
     *
     * @return the value of weather.temperature_in
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public Float getTemperatureIn() {
        return temperatureIn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.temperature_in
     *
     * @param temperatureIn the value for weather.temperature_in
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setTemperatureIn(Float temperatureIn) {
        this.temperatureIn = temperatureIn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.illuminance
     *
     * @return the value of weather.illuminance
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public Float getIlluminance() {
        return illuminance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.illuminance
     *
     * @param illuminance the value for weather.illuminance
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setIlluminance(Float illuminance) {
        this.illuminance = illuminance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.h2s
     *
     * @return the value of weather.h2s
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public Float getH2s() {
        return h2s;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.h2s
     *
     * @param h2s the value for weather.h2s
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setH2s(Float h2s) {
        this.h2s = h2s;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.nh4
     *
     * @return the value of weather.nh4
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public Float getNh4() {
        return nh4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.nh4
     *
     * @param nh4 the value for weather.nh4
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setNh4(Float nh4) {
        this.nh4 = nh4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.dust
     *
     * @return the value of weather.dust
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public Float getDust() {
        return dust;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.dust
     *
     * @param dust the value for weather.dust
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setDust(Float dust) {
        this.dust = dust;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.picture
     *
     * @return the value of weather.picture
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public String getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.picture
     *
     * @param picture the value for weather.picture
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.remark
     *
     * @return the value of weather.remark
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.remark
     *
     * @param remark the value for weather.remark
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.id_recorder
     *
     * @return the value of weather.id_recorder
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public String getIdRecorder() {
        return idRecorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.id_recorder
     *
     * @param idRecorder the value for weather.id_recorder
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setIdRecorder(String idRecorder) {
        this.idRecorder = idRecorder == null ? null : idRecorder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.id_charge
     *
     * @return the value of weather.id_charge
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public String getIdCharge() {
        return idCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.id_charge
     *
     * @param idCharge the value for weather.id_charge
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setIdCharge(String idCharge) {
        this.idCharge = idCharge == null ? null : idCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weather.unit
     *
     * @return the value of weather.unit
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weather.unit
     *
     * @param unit the value for weather.unit
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather
     *
     * @mbggenerated Sat Nov 18 15:33:01 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idFowlery=").append(idFowlery);
        sb.append(", recordDate=").append(recordDate);
        sb.append(", humidityIn=").append(humidityIn);
        sb.append(", humidityOut=").append(humidityOut);
        sb.append(", co2=").append(co2);
        sb.append(", temperatureOut=").append(temperatureOut);
        sb.append(", temperatureIn=").append(temperatureIn);
        sb.append(", illuminance=").append(illuminance);
        sb.append(", h2s=").append(h2s);
        sb.append(", nh4=").append(nh4);
        sb.append(", dust=").append(dust);
        sb.append(", picture=").append(picture);
        sb.append(", remark=").append(remark);
        sb.append(", idRecorder=").append(idRecorder);
        sb.append(", idCharge=").append(idCharge);
        sb.append(", unit=").append(unit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}