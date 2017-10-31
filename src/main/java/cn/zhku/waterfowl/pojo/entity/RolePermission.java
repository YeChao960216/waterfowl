package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;

public class RolePermission implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permission.role_id
     *
     * @mbggenerated Thu Oct 26 20:43:45 CST 2017
     */
    private String roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permission.permission_id
     *
     * @mbggenerated Thu Oct 26 20:43:45 CST 2017
     */
    private String permissionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table role_permission
     *
     * @mbggenerated Thu Oct 26 20:43:45 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permission.role_id
     *
     * @return the value of role_permission.role_id
     *
     * @mbggenerated Thu Oct 26 20:43:45 CST 2017
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permission.role_id
     *
     * @param roleId the value for role_permission.role_id
     *
     * @mbggenerated Thu Oct 26 20:43:45 CST 2017
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permission.permission_id
     *
     * @return the value of role_permission.permission_id
     *
     * @mbggenerated Thu Oct 26 20:43:45 CST 2017
     */
    public String getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permission.permission_id
     *
     * @param permissionId the value for role_permission.permission_id
     *
     * @mbggenerated Thu Oct 26 20:43:45 CST 2017
     */
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated Thu Oct 26 20:43:45 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}