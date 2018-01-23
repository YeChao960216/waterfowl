package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;

public class Customer implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.cid
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    private String cid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.name
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.gender
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    private String gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.phone
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.address
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table customer
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.cid
     *
     * @return the value of customer.cid
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public String getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.cid
     *
     * @param cid the value for customer.cid
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.name
     *
     * @return the value of customer.name
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.name
     *
     * @param name the value for customer.name
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.gender
     *
     * @return the value of customer.gender
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.gender
     *
     * @param gender the value for customer.gender
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.phone
     *
     * @return the value of customer.phone
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.phone
     *
     * @param phone the value for customer.phone
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.address
     *
     * @return the value of customer.address
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.address
     *
     * @param address the value for customer.address
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated Tue Jan 23 15:47:34 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}