package cn.zhku.waterfowl.pojo.entity;

import java.util.ArrayList;
import java.util.List;

public class ManOutpouExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public ManOutpouExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
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
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
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

        public Criteria andManIdIsNull() {
            addCriterion("man_id is null");
            return (Criteria) this;
        }

        public Criteria andManIdIsNotNull() {
            addCriterion("man_id is not null");
            return (Criteria) this;
        }

        public Criteria andManIdEqualTo(String value) {
            addCriterion("man_id =", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdNotEqualTo(String value) {
            addCriterion("man_id <>", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdGreaterThan(String value) {
            addCriterion("man_id >", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdGreaterThanOrEqualTo(String value) {
            addCriterion("man_id >=", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdLessThan(String value) {
            addCriterion("man_id <", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdLessThanOrEqualTo(String value) {
            addCriterion("man_id <=", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdLike(String value) {
            addCriterion("man_id like", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdNotLike(String value) {
            addCriterion("man_id not like", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdIn(List<String> values) {
            addCriterion("man_id in", values, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdNotIn(List<String> values) {
            addCriterion("man_id not in", values, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdBetween(String value1, String value2) {
            addCriterion("man_id between", value1, value2, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdNotBetween(String value1, String value2) {
            addCriterion("man_id not between", value1, value2, "manId");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table man_outpou
     *
     * @mbggenerated do_not_delete_during_merge Mon Jan 22 14:50:38 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 14:50:38 CST 2018
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