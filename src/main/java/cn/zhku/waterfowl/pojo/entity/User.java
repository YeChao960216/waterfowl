package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.username
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.duty
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String duty;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.gender
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private Byte gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.entry
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private Date entry;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.sign
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String sign;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.turnover
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private Date turnover;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.remark
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.phone
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.username
     *
     * @return the value of user.username
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.username
     *
     * @param username the value for user.username
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.duty
     *
     * @return the value of user.duty
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getDuty() {
        return duty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.duty
     *
     * @param duty the value for user.duty
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name
     *
     * @return the value of user.name
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name
     *
     * @param name the value for user.name
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.gender
     *
     * @return the value of user.gender
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.gender
     *
     * @param gender the value for user.gender
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.entry
     *
     * @return the value of user.entry
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public Date getEntry() {
        return entry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.entry
     *
     * @param entry the value for user.entry
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setEntry(Date entry) {
        this.entry = entry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.sign
     *
     * @return the value of user.sign
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getSign() {
        return sign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.sign
     *
     * @param sign the value for user.sign
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.turnover
     *
     * @return the value of user.turnover
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public Date getTurnover() {
        return turnover;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.turnover
     *
     * @param turnover the value for user.turnover
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setTurnover(Date turnover) {
        this.turnover = turnover;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.remark
     *
     * @return the value of user.remark
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.remark
     *
     * @param remark the value for user.remark
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.phone
     *
     * @return the value of user.phone
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.phone
     *
     * @param phone the value for user.phone
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email
     *
     * @return the value of user.email
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.email
     *
     * @param email the value for user.email
     *
     * @mbggenerated Fri Feb 02 20:52:30 CST 2018
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
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
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", duty=").append(duty);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", entry=").append(entry);
        sb.append(", sign=").append(sign);
        sb.append(", turnover=").append(turnover);
        sb.append(", remark=").append(remark);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}