package cn.zhku.waterfowl.modules.user.model;

import cn.zhku.waterfowl.util.excel.EntiName;

import java.util.Date;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/18 10:05.
 * 说明：用于接收EXCEL文件的数据
 */
public class UserExcel {
    @EntiName(id=true)
    private Integer id;

    @EntiName(RName="用户名")
    private String username;

    @EntiName(RName="密码")
    private String password;

    @EntiName(RName="职务")
    private String duty;

    @EntiName(RName="真实姓名")
    private String name;

//    @EntiName(RName="性别")
//    private Byte gender;

    @EntiName(RName="入职时间")
    private Date entry;

    @EntiName(RName="签名")
    private String sign;

    @EntiName(RName="人事变更")
    private Date turnover;

    @EntiName(RName="备注")
    private String remark;

    @EntiName(RName="手机号")
    private String phone;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Date getTurnover() {
        return turnover;
    }

    public void setTurnover(Date turnover) {
        this.turnover = turnover;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "UserExcel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", duty='" + duty + '\'' +
                ", name='" + name + '\'' +
                ", entry=" + entry +
                ", sign='" + sign + '\'' +
                ", turnover=" + turnover +
                ", remark='" + remark + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
