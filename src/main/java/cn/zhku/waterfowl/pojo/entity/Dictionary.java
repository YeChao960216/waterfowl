package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;

public class Dictionary implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dictionary.id
     *
     * @mbggenerated Fri Nov 17 17:32:05 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dictionary.name
     *
     * @mbggenerated Fri Nov 17 17:32:05 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dictionary.pid
     *
     * @mbggenerated Fri Nov 17 17:32:05 CST 2017
     */
    private String pid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dictionary.remark
     *
     * @mbggenerated Fri Nov 17 17:32:05 CST 2017
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dictionary
     *
     * @mbggenerated Fri Nov 17 17:32:05 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dictionary.id
     *
     * @return the value of dictionary.id
     *
     * @mbggenerated Fri Nov 17 17:32:05 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dictionary.id
     *
     * @param id the value for dictionary.id
     *
     * @mbggenerated Fri Nov 17 17:32:05 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dictionary.name
     *
     * @return the value of dictionary.name
     *
     * @mbggenerated Fri Nov 17 17:32:05 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dictionary.name
     *
     * @param name the value for dictionary.name
     *
     * @mbggenerated Fri Nov 17 17:32:05 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dictionary.pid
     *
     * @return the value of dictionary.pid
     *
     * @mbggenerated Fri Nov 17 17:32:05 CST 2017
     */
    public String getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dictionary.pid
     *
     * @param pid the value for dictionary.pid
     *
     * @mbggenerated Fri Nov 17 17:32:05 CST 2017
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dictionary.remark
     *
     * @return the value of dictionary.remark
     *
     * @mbggenerated Fri Nov 17 17:32:05 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dictionary.remark
     *
     * @param remark the value for dictionary.remark
     *
     * @mbggenerated Fri Nov 17 17:32:05 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary
     *
     * @mbggenerated Fri Nov 17 17:32:05 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", pid=").append(pid);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}