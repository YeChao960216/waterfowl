package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;

public class Transcompany implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transcompany.tid
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    private String tid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transcompany.name
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transcompany.phone
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transcompany.address
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table transcompany
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transcompany.tid
     *
     * @return the value of transcompany.tid
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public String getTid() {
        return tid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transcompany.tid
     *
     * @param tid the value for transcompany.tid
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transcompany.name
     *
     * @return the value of transcompany.name
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transcompany.name
     *
     * @param name the value for transcompany.name
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transcompany.phone
     *
     * @return the value of transcompany.phone
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transcompany.phone
     *
     * @param phone the value for transcompany.phone
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transcompany.address
     *
     * @return the value of transcompany.address
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transcompany.address
     *
     * @param address the value for transcompany.address
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transcompany
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tid=").append(tid);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}