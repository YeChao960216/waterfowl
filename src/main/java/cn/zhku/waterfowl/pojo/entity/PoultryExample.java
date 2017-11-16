package cn.zhku.waterfowl.pojo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PoultryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
     */
    public PoultryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
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
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
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

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(String value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(String value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(String value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(String value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(String value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLike(String value) {
            addCriterion("quantity like", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotLike(String value) {
            addCriterion("quantity not like", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<String> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<String> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(String value1, String value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(String value1, String value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andAssociatedFirmIsNull() {
            addCriterion("associated_firm is null");
            return (Criteria) this;
        }

        public Criteria andAssociatedFirmIsNotNull() {
            addCriterion("associated_firm is not null");
            return (Criteria) this;
        }

        public Criteria andAssociatedFirmEqualTo(String value) {
            addCriterion("associated_firm =", value, "associatedFirm");
            return (Criteria) this;
        }

        public Criteria andAssociatedFirmNotEqualTo(String value) {
            addCriterion("associated_firm <>", value, "associatedFirm");
            return (Criteria) this;
        }

        public Criteria andAssociatedFirmGreaterThan(String value) {
            addCriterion("associated_firm >", value, "associatedFirm");
            return (Criteria) this;
        }

        public Criteria andAssociatedFirmGreaterThanOrEqualTo(String value) {
            addCriterion("associated_firm >=", value, "associatedFirm");
            return (Criteria) this;
        }

        public Criteria andAssociatedFirmLessThan(String value) {
            addCriterion("associated_firm <", value, "associatedFirm");
            return (Criteria) this;
        }

        public Criteria andAssociatedFirmLessThanOrEqualTo(String value) {
            addCriterion("associated_firm <=", value, "associatedFirm");
            return (Criteria) this;
        }

        public Criteria andAssociatedFirmLike(String value) {
            addCriterion("associated_firm like", value, "associatedFirm");
            return (Criteria) this;
        }

        public Criteria andAssociatedFirmNotLike(String value) {
            addCriterion("associated_firm not like", value, "associatedFirm");
            return (Criteria) this;
        }

        public Criteria andAssociatedFirmIn(List<String> values) {
            addCriterion("associated_firm in", values, "associatedFirm");
            return (Criteria) this;
        }

        public Criteria andAssociatedFirmNotIn(List<String> values) {
            addCriterion("associated_firm not in", values, "associatedFirm");
            return (Criteria) this;
        }

        public Criteria andAssociatedFirmBetween(String value1, String value2) {
            addCriterion("associated_firm between", value1, value2, "associatedFirm");
            return (Criteria) this;
        }

        public Criteria andAssociatedFirmNotBetween(String value1, String value2) {
            addCriterion("associated_firm not between", value1, value2, "associatedFirm");
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
     * This class corresponds to the database table poultry
     *
     * @mbggenerated do_not_delete_during_merge Thu Nov 16 18:51:24 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 18:51:24 CST 2017
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