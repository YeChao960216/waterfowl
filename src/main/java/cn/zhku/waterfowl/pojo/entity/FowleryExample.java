package cn.zhku.waterfowl.pojo.entity;

import java.util.ArrayList;
import java.util.List;

public class FowleryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    public FowleryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
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
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
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

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(String value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(String value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(String value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(String value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLike(String value) {
            addCriterion("size like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotLike(String value) {
            addCriterion("size not like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<String> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<String> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(String value1, String value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAffiliationIsNull() {
            addCriterion("affiliation is null");
            return (Criteria) this;
        }

        public Criteria andAffiliationIsNotNull() {
            addCriterion("affiliation is not null");
            return (Criteria) this;
        }

        public Criteria andAffiliationEqualTo(String value) {
            addCriterion("affiliation =", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationNotEqualTo(String value) {
            addCriterion("affiliation <>", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationGreaterThan(String value) {
            addCriterion("affiliation >", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationGreaterThanOrEqualTo(String value) {
            addCriterion("affiliation >=", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationLessThan(String value) {
            addCriterion("affiliation <", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationLessThanOrEqualTo(String value) {
            addCriterion("affiliation <=", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationLike(String value) {
            addCriterion("affiliation like", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationNotLike(String value) {
            addCriterion("affiliation not like", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationIn(List<String> values) {
            addCriterion("affiliation in", values, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationNotIn(List<String> values) {
            addCriterion("affiliation not in", values, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationBetween(String value1, String value2) {
            addCriterion("affiliation between", value1, value2, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationNotBetween(String value1, String value2) {
            addCriterion("affiliation not between", value1, value2, "affiliation");
            return (Criteria) this;
        }

        public Criteria andIdRecordIsNull() {
            addCriterion("id_record is null");
            return (Criteria) this;
        }

        public Criteria andIdRecordIsNotNull() {
            addCriterion("id_record is not null");
            return (Criteria) this;
        }

        public Criteria andIdRecordEqualTo(String value) {
            addCriterion("id_record =", value, "idRecord");
            return (Criteria) this;
        }

        public Criteria andIdRecordNotEqualTo(String value) {
            addCriterion("id_record <>", value, "idRecord");
            return (Criteria) this;
        }

        public Criteria andIdRecordGreaterThan(String value) {
            addCriterion("id_record >", value, "idRecord");
            return (Criteria) this;
        }

        public Criteria andIdRecordGreaterThanOrEqualTo(String value) {
            addCriterion("id_record >=", value, "idRecord");
            return (Criteria) this;
        }

        public Criteria andIdRecordLessThan(String value) {
            addCriterion("id_record <", value, "idRecord");
            return (Criteria) this;
        }

        public Criteria andIdRecordLessThanOrEqualTo(String value) {
            addCriterion("id_record <=", value, "idRecord");
            return (Criteria) this;
        }

        public Criteria andIdRecordLike(String value) {
            addCriterion("id_record like", value, "idRecord");
            return (Criteria) this;
        }

        public Criteria andIdRecordNotLike(String value) {
            addCriterion("id_record not like", value, "idRecord");
            return (Criteria) this;
        }

        public Criteria andIdRecordIn(List<String> values) {
            addCriterion("id_record in", values, "idRecord");
            return (Criteria) this;
        }

        public Criteria andIdRecordNotIn(List<String> values) {
            addCriterion("id_record not in", values, "idRecord");
            return (Criteria) this;
        }

        public Criteria andIdRecordBetween(String value1, String value2) {
            addCriterion("id_record between", value1, value2, "idRecord");
            return (Criteria) this;
        }

        public Criteria andIdRecordNotBetween(String value1, String value2) {
            addCriterion("id_record not between", value1, value2, "idRecord");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table fowlery
     *
     * @mbggenerated do_not_delete_during_merge Sat Jan 13 17:42:50 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table fowlery
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
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