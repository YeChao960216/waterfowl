package cn.zhku.waterfowl.pojo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManufactureExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public ManufactureExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFirmIsNull() {
            addCriterion("firm is null");
            return (Criteria) this;
        }

        public Criteria andFirmIsNotNull() {
            addCriterion("firm is not null");
            return (Criteria) this;
        }

        public Criteria andFirmEqualTo(String value) {
            addCriterion("firm =", value, "firm");
            return (Criteria) this;
        }

        public Criteria andFirmNotEqualTo(String value) {
            addCriterion("firm <>", value, "firm");
            return (Criteria) this;
        }

        public Criteria andFirmGreaterThan(String value) {
            addCriterion("firm >", value, "firm");
            return (Criteria) this;
        }

        public Criteria andFirmGreaterThanOrEqualTo(String value) {
            addCriterion("firm >=", value, "firm");
            return (Criteria) this;
        }

        public Criteria andFirmLessThan(String value) {
            addCriterion("firm <", value, "firm");
            return (Criteria) this;
        }

        public Criteria andFirmLessThanOrEqualTo(String value) {
            addCriterion("firm <=", value, "firm");
            return (Criteria) this;
        }

        public Criteria andFirmLike(String value) {
            addCriterion("firm like", value, "firm");
            return (Criteria) this;
        }

        public Criteria andFirmNotLike(String value) {
            addCriterion("firm not like", value, "firm");
            return (Criteria) this;
        }

        public Criteria andFirmIn(List<String> values) {
            addCriterion("firm in", values, "firm");
            return (Criteria) this;
        }

        public Criteria andFirmNotIn(List<String> values) {
            addCriterion("firm not in", values, "firm");
            return (Criteria) this;
        }

        public Criteria andFirmBetween(String value1, String value2) {
            addCriterion("firm between", value1, value2, "firm");
            return (Criteria) this;
        }

        public Criteria andFirmNotBetween(String value1, String value2) {
            addCriterion("firm not between", value1, value2, "firm");
            return (Criteria) this;
        }

        public Criteria andSiteIsNull() {
            addCriterion("site is null");
            return (Criteria) this;
        }

        public Criteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (Criteria) this;
        }

        public Criteria andSiteEqualTo(String value) {
            addCriterion("site =", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotEqualTo(String value) {
            addCriterion("site <>", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThan(String value) {
            addCriterion("site >", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThanOrEqualTo(String value) {
            addCriterion("site >=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThan(String value) {
            addCriterion("site <", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThanOrEqualTo(String value) {
            addCriterion("site <=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLike(String value) {
            addCriterion("site like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotLike(String value) {
            addCriterion("site not like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteIn(List<String> values) {
            addCriterion("site in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotIn(List<String> values) {
            addCriterion("site not in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteBetween(String value1, String value2) {
            addCriterion("site between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotBetween(String value1, String value2) {
            addCriterion("site not between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andRecordDateIsNull() {
            addCriterion("record_date is null");
            return (Criteria) this;
        }

        public Criteria andRecordDateIsNotNull() {
            addCriterion("record_date is not null");
            return (Criteria) this;
        }

        public Criteria andRecordDateEqualTo(Date value) {
            addCriterion("record_date =", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotEqualTo(Date value) {
            addCriterion("record_date <>", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateGreaterThan(Date value) {
            addCriterion("record_date >", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateGreaterThanOrEqualTo(Date value) {
            addCriterion("record_date >=", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateLessThan(Date value) {
            addCriterion("record_date <", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateLessThanOrEqualTo(Date value) {
            addCriterion("record_date <=", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateIn(List<Date> values) {
            addCriterion("record_date in", values, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotIn(List<Date> values) {
            addCriterion("record_date not in", values, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateBetween(Date value1, Date value2) {
            addCriterion("record_date between", value1, value2, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotBetween(Date value1, Date value2) {
            addCriterion("record_date not between", value1, value2, "recordDate");
            return (Criteria) this;
        }

        public Criteria andIdChargeIsNull() {
            addCriterion("id_charge is null");
            return (Criteria) this;
        }

        public Criteria andIdChargeIsNotNull() {
            addCriterion("id_charge is not null");
            return (Criteria) this;
        }

        public Criteria andIdChargeEqualTo(String value) {
            addCriterion("id_charge =", value, "idCharge");
            return (Criteria) this;
        }

        public Criteria andIdChargeNotEqualTo(String value) {
            addCriterion("id_charge <>", value, "idCharge");
            return (Criteria) this;
        }

        public Criteria andIdChargeGreaterThan(String value) {
            addCriterion("id_charge >", value, "idCharge");
            return (Criteria) this;
        }

        public Criteria andIdChargeGreaterThanOrEqualTo(String value) {
            addCriterion("id_charge >=", value, "idCharge");
            return (Criteria) this;
        }

        public Criteria andIdChargeLessThan(String value) {
            addCriterion("id_charge <", value, "idCharge");
            return (Criteria) this;
        }

        public Criteria andIdChargeLessThanOrEqualTo(String value) {
            addCriterion("id_charge <=", value, "idCharge");
            return (Criteria) this;
        }

        public Criteria andIdChargeLike(String value) {
            addCriterion("id_charge like", value, "idCharge");
            return (Criteria) this;
        }

        public Criteria andIdChargeNotLike(String value) {
            addCriterion("id_charge not like", value, "idCharge");
            return (Criteria) this;
        }

        public Criteria andIdChargeIn(List<String> values) {
            addCriterion("id_charge in", values, "idCharge");
            return (Criteria) this;
        }

        public Criteria andIdChargeNotIn(List<String> values) {
            addCriterion("id_charge not in", values, "idCharge");
            return (Criteria) this;
        }

        public Criteria andIdChargeBetween(String value1, String value2) {
            addCriterion("id_charge between", value1, value2, "idCharge");
            return (Criteria) this;
        }

        public Criteria andIdChargeNotBetween(String value1, String value2) {
            addCriterion("id_charge not between", value1, value2, "idCharge");
            return (Criteria) this;
        }

        public Criteria andIdPatchIsNull() {
            addCriterion("id_patch is null");
            return (Criteria) this;
        }

        public Criteria andIdPatchIsNotNull() {
            addCriterion("id_patch is not null");
            return (Criteria) this;
        }

        public Criteria andIdPatchEqualTo(String value) {
            addCriterion("id_patch =", value, "idPatch");
            return (Criteria) this;
        }

        public Criteria andIdPatchNotEqualTo(String value) {
            addCriterion("id_patch <>", value, "idPatch");
            return (Criteria) this;
        }

        public Criteria andIdPatchGreaterThan(String value) {
            addCriterion("id_patch >", value, "idPatch");
            return (Criteria) this;
        }

        public Criteria andIdPatchGreaterThanOrEqualTo(String value) {
            addCriterion("id_patch >=", value, "idPatch");
            return (Criteria) this;
        }

        public Criteria andIdPatchLessThan(String value) {
            addCriterion("id_patch <", value, "idPatch");
            return (Criteria) this;
        }

        public Criteria andIdPatchLessThanOrEqualTo(String value) {
            addCriterion("id_patch <=", value, "idPatch");
            return (Criteria) this;
        }

        public Criteria andIdPatchLike(String value) {
            addCriterion("id_patch like", value, "idPatch");
            return (Criteria) this;
        }

        public Criteria andIdPatchNotLike(String value) {
            addCriterion("id_patch not like", value, "idPatch");
            return (Criteria) this;
        }

        public Criteria andIdPatchIn(List<String> values) {
            addCriterion("id_patch in", values, "idPatch");
            return (Criteria) this;
        }

        public Criteria andIdPatchNotIn(List<String> values) {
            addCriterion("id_patch not in", values, "idPatch");
            return (Criteria) this;
        }

        public Criteria andIdPatchBetween(String value1, String value2) {
            addCriterion("id_patch between", value1, value2, "idPatch");
            return (Criteria) this;
        }

        public Criteria andIdPatchNotBetween(String value1, String value2) {
            addCriterion("id_patch not between", value1, value2, "idPatch");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table manufacture
     *
     * @mbggenerated do_not_delete_during_merge Mon Jan 29 20:17:40 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table manufacture
     *
     * @mbggenerated Mon Jan 29 20:17:40 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}