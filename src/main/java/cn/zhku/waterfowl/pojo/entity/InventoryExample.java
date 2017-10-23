package cn.zhku.waterfowl.pojo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InventoryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public InventoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
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
     * This method corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
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

        public Criteria andExpirationDateIsNull() {
            addCriterion("expiration_date is null");
            return (Criteria) this;
        }

        public Criteria andExpirationDateIsNotNull() {
            addCriterion("expiration_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationDateEqualTo(Date value) {
            addCriterion("expiration_date =", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotEqualTo(Date value) {
            addCriterion("expiration_date <>", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateGreaterThan(Date value) {
            addCriterion("expiration_date >", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("expiration_date >=", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateLessThan(Date value) {
            addCriterion("expiration_date <", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateLessThanOrEqualTo(Date value) {
            addCriterion("expiration_date <=", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateIn(List<Date> values) {
            addCriterion("expiration_date in", values, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotIn(List<Date> values) {
            addCriterion("expiration_date not in", values, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateBetween(Date value1, Date value2) {
            addCriterion("expiration_date between", value1, value2, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotBetween(Date value1, Date value2) {
            addCriterion("expiration_date not between", value1, value2, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andQuantityEqualTo(Float value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Float value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Float value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Float value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Float value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Float value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Float> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Float> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Float value1, Float value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Float value1, Float value2) {
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

        public Criteria andStorageSiteIsNull() {
            addCriterion("storage_site is null");
            return (Criteria) this;
        }

        public Criteria andStorageSiteIsNotNull() {
            addCriterion("storage_site is not null");
            return (Criteria) this;
        }

        public Criteria andStorageSiteEqualTo(String value) {
            addCriterion("storage_site =", value, "storageSite");
            return (Criteria) this;
        }

        public Criteria andStorageSiteNotEqualTo(String value) {
            addCriterion("storage_site <>", value, "storageSite");
            return (Criteria) this;
        }

        public Criteria andStorageSiteGreaterThan(String value) {
            addCriterion("storage_site >", value, "storageSite");
            return (Criteria) this;
        }

        public Criteria andStorageSiteGreaterThanOrEqualTo(String value) {
            addCriterion("storage_site >=", value, "storageSite");
            return (Criteria) this;
        }

        public Criteria andStorageSiteLessThan(String value) {
            addCriterion("storage_site <", value, "storageSite");
            return (Criteria) this;
        }

        public Criteria andStorageSiteLessThanOrEqualTo(String value) {
            addCriterion("storage_site <=", value, "storageSite");
            return (Criteria) this;
        }

        public Criteria andStorageSiteLike(String value) {
            addCriterion("storage_site like", value, "storageSite");
            return (Criteria) this;
        }

        public Criteria andStorageSiteNotLike(String value) {
            addCriterion("storage_site not like", value, "storageSite");
            return (Criteria) this;
        }

        public Criteria andStorageSiteIn(List<String> values) {
            addCriterion("storage_site in", values, "storageSite");
            return (Criteria) this;
        }

        public Criteria andStorageSiteNotIn(List<String> values) {
            addCriterion("storage_site not in", values, "storageSite");
            return (Criteria) this;
        }

        public Criteria andStorageSiteBetween(String value1, String value2) {
            addCriterion("storage_site between", value1, value2, "storageSite");
            return (Criteria) this;
        }

        public Criteria andStorageSiteNotBetween(String value1, String value2) {
            addCriterion("storage_site not between", value1, value2, "storageSite");
            return (Criteria) this;
        }

        public Criteria andStorageModeIsNull() {
            addCriterion("storage_mode is null");
            return (Criteria) this;
        }

        public Criteria andStorageModeIsNotNull() {
            addCriterion("storage_mode is not null");
            return (Criteria) this;
        }

        public Criteria andStorageModeEqualTo(String value) {
            addCriterion("storage_mode =", value, "storageMode");
            return (Criteria) this;
        }

        public Criteria andStorageModeNotEqualTo(String value) {
            addCriterion("storage_mode <>", value, "storageMode");
            return (Criteria) this;
        }

        public Criteria andStorageModeGreaterThan(String value) {
            addCriterion("storage_mode >", value, "storageMode");
            return (Criteria) this;
        }

        public Criteria andStorageModeGreaterThanOrEqualTo(String value) {
            addCriterion("storage_mode >=", value, "storageMode");
            return (Criteria) this;
        }

        public Criteria andStorageModeLessThan(String value) {
            addCriterion("storage_mode <", value, "storageMode");
            return (Criteria) this;
        }

        public Criteria andStorageModeLessThanOrEqualTo(String value) {
            addCriterion("storage_mode <=", value, "storageMode");
            return (Criteria) this;
        }

        public Criteria andStorageModeLike(String value) {
            addCriterion("storage_mode like", value, "storageMode");
            return (Criteria) this;
        }

        public Criteria andStorageModeNotLike(String value) {
            addCriterion("storage_mode not like", value, "storageMode");
            return (Criteria) this;
        }

        public Criteria andStorageModeIn(List<String> values) {
            addCriterion("storage_mode in", values, "storageMode");
            return (Criteria) this;
        }

        public Criteria andStorageModeNotIn(List<String> values) {
            addCriterion("storage_mode not in", values, "storageMode");
            return (Criteria) this;
        }

        public Criteria andStorageModeBetween(String value1, String value2) {
            addCriterion("storage_mode between", value1, value2, "storageMode");
            return (Criteria) this;
        }

        public Criteria andStorageModeNotBetween(String value1, String value2) {
            addCriterion("storage_mode not between", value1, value2, "storageMode");
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
     * This class corresponds to the database table inventory
     *
     * @mbggenerated do_not_delete_during_merge Mon Oct 23 19:52:23 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table inventory
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
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