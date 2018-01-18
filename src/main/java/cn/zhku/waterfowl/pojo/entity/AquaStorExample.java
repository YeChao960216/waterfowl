package cn.zhku.waterfowl.pojo.entity;

import java.util.ArrayList;
import java.util.List;

public class AquaStorExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public AquaStorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
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
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
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

        public Criteria andKeyIsNull() {
            addCriterion("key is null");
            return (Criteria) this;
        }

        public Criteria andKeyIsNotNull() {
            addCriterion("key is not null");
            return (Criteria) this;
        }

        public Criteria andKeyEqualTo(String value) {
            addCriterion("key =", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotEqualTo(String value) {
            addCriterion("key <>", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThan(String value) {
            addCriterion("key >", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThanOrEqualTo(String value) {
            addCriterion("key >=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThan(String value) {
            addCriterion("key <", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThanOrEqualTo(String value) {
            addCriterion("key <=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLike(String value) {
            addCriterion("key like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotLike(String value) {
            addCriterion("key not like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyIn(List<String> values) {
            addCriterion("key in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotIn(List<String> values) {
            addCriterion("key not in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyBetween(String value1, String value2) {
            addCriterion("key between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotBetween(String value1, String value2) {
            addCriterion("key not between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andIdOutstorageIsNull() {
            addCriterion("id_outstorage is null");
            return (Criteria) this;
        }

        public Criteria andIdOutstorageIsNotNull() {
            addCriterion("id_outstorage is not null");
            return (Criteria) this;
        }

        public Criteria andIdOutstorageEqualTo(String value) {
            addCriterion("id_outstorage =", value, "idOutstorage");
            return (Criteria) this;
        }

        public Criteria andIdOutstorageNotEqualTo(String value) {
            addCriterion("id_outstorage <>", value, "idOutstorage");
            return (Criteria) this;
        }

        public Criteria andIdOutstorageGreaterThan(String value) {
            addCriterion("id_outstorage >", value, "idOutstorage");
            return (Criteria) this;
        }

        public Criteria andIdOutstorageGreaterThanOrEqualTo(String value) {
            addCriterion("id_outstorage >=", value, "idOutstorage");
            return (Criteria) this;
        }

        public Criteria andIdOutstorageLessThan(String value) {
            addCriterion("id_outstorage <", value, "idOutstorage");
            return (Criteria) this;
        }

        public Criteria andIdOutstorageLessThanOrEqualTo(String value) {
            addCriterion("id_outstorage <=", value, "idOutstorage");
            return (Criteria) this;
        }

        public Criteria andIdOutstorageLike(String value) {
            addCriterion("id_outstorage like", value, "idOutstorage");
            return (Criteria) this;
        }

        public Criteria andIdOutstorageNotLike(String value) {
            addCriterion("id_outstorage not like", value, "idOutstorage");
            return (Criteria) this;
        }

        public Criteria andIdOutstorageIn(List<String> values) {
            addCriterion("id_outstorage in", values, "idOutstorage");
            return (Criteria) this;
        }

        public Criteria andIdOutstorageNotIn(List<String> values) {
            addCriterion("id_outstorage not in", values, "idOutstorage");
            return (Criteria) this;
        }

        public Criteria andIdOutstorageBetween(String value1, String value2) {
            addCriterion("id_outstorage between", value1, value2, "idOutstorage");
            return (Criteria) this;
        }

        public Criteria andIdOutstorageNotBetween(String value1, String value2) {
            addCriterion("id_outstorage not between", value1, value2, "idOutstorage");
            return (Criteria) this;
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table aqua_stor
     *
     * @mbggenerated do_not_delete_during_merge Thu Jan 18 20:36:51 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table aqua_stor
     *
     * @mbggenerated Thu Jan 18 20:36:51 CST 2018
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