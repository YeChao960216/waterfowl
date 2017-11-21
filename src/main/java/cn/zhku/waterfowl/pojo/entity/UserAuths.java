package cn.zhku.waterfowl.pojo.entity;

import java.io.Serializable;

public class UserAuths implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_auths.id
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_auths.user_id
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_auths.identity_type
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    private String identityType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_auths.identifier
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    private String identifier;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_auths.credential
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    private String credential;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_auths
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_auths.id
     *
     * @return the value of user_auths.id
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_auths.id
     *
     * @param id the value for user_auths.id
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_auths.user_id
     *
     * @return the value of user_auths.user_id
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_auths.user_id
     *
     * @param userId the value for user_auths.user_id
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_auths.identity_type
     *
     * @return the value of user_auths.identity_type
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    public String getIdentityType() {
        return identityType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_auths.identity_type
     *
     * @param identityType the value for user_auths.identity_type
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    public void setIdentityType(String identityType) {
        this.identityType = identityType == null ? null : identityType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_auths.identifier
     *
     * @return the value of user_auths.identifier
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_auths.identifier
     *
     * @param identifier the value for user_auths.identifier
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_auths.credential
     *
     * @return the value of user_auths.credential
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    public String getCredential() {
        return credential;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_auths.credential
     *
     * @param credential the value for user_auths.credential
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    public void setCredential(String credential) {
        this.credential = credential == null ? null : credential.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auths
     *
     * @mbggenerated Sun Nov 19 21:07:40 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", identityType=").append(identityType);
        sb.append(", identifier=").append(identifier);
        sb.append(", credential=").append(credential);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}