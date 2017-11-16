package cn.zhku.waterfowl.pojo.entity;

import java.util.ArrayList;
import java.util.List;

public class PatchExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    public PatchExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
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
     * This method corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
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

        public Criteria andIdPoultryIsNull() {
            addCriterion("id_poultry is null");
            return (Criteria) this;
        }

        public Criteria andIdPoultryIsNotNull() {
            addCriterion("id_poultry is not null");
            return (Criteria) this;
        }

        public Criteria andIdPoultryEqualTo(String value) {
            addCriterion("id_poultry =", value, "idPoultry");
            return (Criteria) this;
        }

        public Criteria andIdPoultryNotEqualTo(String value) {
            addCriterion("id_poultry <>", value, "idPoultry");
            return (Criteria) this;
        }

        public Criteria andIdPoultryGreaterThan(String value) {
            addCriterion("id_poultry >", value, "idPoultry");
            return (Criteria) this;
        }

        public Criteria andIdPoultryGreaterThanOrEqualTo(String value) {
            addCriterion("id_poultry >=", value, "idPoultry");
            return (Criteria) this;
        }

        public Criteria andIdPoultryLessThan(String value) {
            addCriterion("id_poultry <", value, "idPoultry");
            return (Criteria) this;
        }

        public Criteria andIdPoultryLessThanOrEqualTo(String value) {
            addCriterion("id_poultry <=", value, "idPoultry");
            return (Criteria) this;
        }

        public Criteria andIdPoultryLike(String value) {
            addCriterion("id_poultry like", value, "idPoultry");
            return (Criteria) this;
        }

        public Criteria andIdPoultryNotLike(String value) {
            addCriterion("id_poultry not like", value, "idPoultry");
            return (Criteria) this;
        }

        public Criteria andIdPoultryIn(List<String> values) {
            addCriterion("id_poultry in", values, "idPoultry");
            return (Criteria) this;
        }

        public Criteria andIdPoultryNotIn(List<String> values) {
            addCriterion("id_poultry not in", values, "idPoultry");
            return (Criteria) this;
        }

        public Criteria andIdPoultryBetween(String value1, String value2) {
            addCriterion("id_poultry between", value1, value2, "idPoultry");
            return (Criteria) this;
        }

        public Criteria andIdPoultryNotBetween(String value1, String value2) {
            addCriterion("id_poultry not between", value1, value2, "idPoultry");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
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

        public Criteria andIdAffilationIsNull() {
            addCriterion("id_affilation is null");
            return (Criteria) this;
        }

        public Criteria andIdAffilationIsNotNull() {
            addCriterion("id_affilation is not null");
            return (Criteria) this;
        }

        public Criteria andIdAffilationEqualTo(String value) {
            addCriterion("id_affilation =", value, "idAffilation");
            return (Criteria) this;
        }

        public Criteria andIdAffilationNotEqualTo(String value) {
            addCriterion("id_affilation <>", value, "idAffilation");
            return (Criteria) this;
        }

        public Criteria andIdAffilationGreaterThan(String value) {
            addCriterion("id_affilation >", value, "idAffilation");
            return (Criteria) this;
        }

        public Criteria andIdAffilationGreaterThanOrEqualTo(String value) {
            addCriterion("id_affilation >=", value, "idAffilation");
            return (Criteria) this;
        }

        public Criteria andIdAffilationLessThan(String value) {
            addCriterion("id_affilation <", value, "idAffilation");
            return (Criteria) this;
        }

        public Criteria andIdAffilationLessThanOrEqualTo(String value) {
            addCriterion("id_affilation <=", value, "idAffilation");
            return (Criteria) this;
        }

        public Criteria andIdAffilationLike(String value) {
            addCriterion("id_affilation like", value, "idAffilation");
            return (Criteria) this;
        }

        public Criteria andIdAffilationNotLike(String value) {
            addCriterion("id_affilation not like", value, "idAffilation");
            return (Criteria) this;
        }

        public Criteria andIdAffilationIn(List<String> values) {
            addCriterion("id_affilation in", values, "idAffilation");
            return (Criteria) this;
        }

        public Criteria andIdAffilationNotIn(List<String> values) {
            addCriterion("id_affilation not in", values, "idAffilation");
            return (Criteria) this;
        }

        public Criteria andIdAffilationBetween(String value1, String value2) {
            addCriterion("id_affilation between", value1, value2, "idAffilation");
            return (Criteria) this;
        }

        public Criteria andIdAffilationNotBetween(String value1, String value2) {
            addCriterion("id_affilation not between", value1, value2, "idAffilation");
            return (Criteria) this;
        }

        public Criteria andIdFowleryIsNull() {
            addCriterion("id_fowlery is null");
            return (Criteria) this;
        }

        public Criteria andIdFowleryIsNotNull() {
            addCriterion("id_fowlery is not null");
            return (Criteria) this;
        }

        public Criteria andIdFowleryEqualTo(String value) {
            addCriterion("id_fowlery =", value, "idFowlery");
            return (Criteria) this;
        }

        public Criteria andIdFowleryNotEqualTo(String value) {
            addCriterion("id_fowlery <>", value, "idFowlery");
            return (Criteria) this;
        }

        public Criteria andIdFowleryGreaterThan(String value) {
            addCriterion("id_fowlery >", value, "idFowlery");
            return (Criteria) this;
        }

        public Criteria andIdFowleryGreaterThanOrEqualTo(String value) {
            addCriterion("id_fowlery >=", value, "idFowlery");
            return (Criteria) this;
        }

        public Criteria andIdFowleryLessThan(String value) {
            addCriterion("id_fowlery <", value, "idFowlery");
            return (Criteria) this;
        }

        public Criteria andIdFowleryLessThanOrEqualTo(String value) {
            addCriterion("id_fowlery <=", value, "idFowlery");
            return (Criteria) this;
        }

        public Criteria andIdFowleryLike(String value) {
            addCriterion("id_fowlery like", value, "idFowlery");
            return (Criteria) this;
        }

        public Criteria andIdFowleryNotLike(String value) {
            addCriterion("id_fowlery not like", value, "idFowlery");
            return (Criteria) this;
        }

        public Criteria andIdFowleryIn(List<String> values) {
            addCriterion("id_fowlery in", values, "idFowlery");
            return (Criteria) this;
        }

        public Criteria andIdFowleryNotIn(List<String> values) {
            addCriterion("id_fowlery not in", values, "idFowlery");
            return (Criteria) this;
        }

        public Criteria andIdFowleryBetween(String value1, String value2) {
            addCriterion("id_fowlery between", value1, value2, "idFowlery");
            return (Criteria) this;
        }

        public Criteria andIdFowleryNotBetween(String value1, String value2) {
            addCriterion("id_fowlery not between", value1, value2, "idFowlery");
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

        public Criteria andIdRecorderIsNull() {
            addCriterion("id_recorder is null");
            return (Criteria) this;
        }

        public Criteria andIdRecorderIsNotNull() {
            addCriterion("id_recorder is not null");
            return (Criteria) this;
        }

        public Criteria andIdRecorderEqualTo(String value) {
            addCriterion("id_recorder =", value, "idRecorder");
            return (Criteria) this;
        }

        public Criteria andIdRecorderNotEqualTo(String value) {
            addCriterion("id_recorder <>", value, "idRecorder");
            return (Criteria) this;
        }

        public Criteria andIdRecorderGreaterThan(String value) {
            addCriterion("id_recorder >", value, "idRecorder");
            return (Criteria) this;
        }

        public Criteria andIdRecorderGreaterThanOrEqualTo(String value) {
            addCriterion("id_recorder >=", value, "idRecorder");
            return (Criteria) this;
        }

        public Criteria andIdRecorderLessThan(String value) {
            addCriterion("id_recorder <", value, "idRecorder");
            return (Criteria) this;
        }

        public Criteria andIdRecorderLessThanOrEqualTo(String value) {
            addCriterion("id_recorder <=", value, "idRecorder");
            return (Criteria) this;
        }

        public Criteria andIdRecorderLike(String value) {
            addCriterion("id_recorder like", value, "idRecorder");
            return (Criteria) this;
        }

        public Criteria andIdRecorderNotLike(String value) {
            addCriterion("id_recorder not like", value, "idRecorder");
            return (Criteria) this;
        }

        public Criteria andIdRecorderIn(List<String> values) {
            addCriterion("id_recorder in", values, "idRecorder");
            return (Criteria) this;
        }

        public Criteria andIdRecorderNotIn(List<String> values) {
            addCriterion("id_recorder not in", values, "idRecorder");
            return (Criteria) this;
        }

        public Criteria andIdRecorderBetween(String value1, String value2) {
            addCriterion("id_recorder between", value1, value2, "idRecorder");
            return (Criteria) this;
        }

        public Criteria andIdRecorderNotBetween(String value1, String value2) {
            addCriterion("id_recorder not between", value1, value2, "idRecorder");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table patch
     *
     * @mbggenerated do_not_delete_during_merge Thu Nov 16 16:51:03 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table patch
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
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