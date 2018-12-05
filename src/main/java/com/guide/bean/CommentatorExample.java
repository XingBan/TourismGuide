package com.guide.bean;

import java.util.ArrayList;
import java.util.List;

public class CommentatorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentatorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andCommentatorIdIsNull() {
            addCriterion("commentator_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdIsNotNull() {
            addCriterion("commentator_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdEqualTo(Integer value) {
            addCriterion("commentator_id =", value, "commentatorId");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdNotEqualTo(Integer value) {
            addCriterion("commentator_id <>", value, "commentatorId");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdGreaterThan(Integer value) {
            addCriterion("commentator_id >", value, "commentatorId");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentator_id >=", value, "commentatorId");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdLessThan(Integer value) {
            addCriterion("commentator_id <", value, "commentatorId");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("commentator_id <=", value, "commentatorId");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdIn(List<Integer> values) {
            addCriterion("commentator_id in", values, "commentatorId");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdNotIn(List<Integer> values) {
            addCriterion("commentator_id not in", values, "commentatorId");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdBetween(Integer value1, Integer value2) {
            addCriterion("commentator_id between", value1, value2, "commentatorId");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("commentator_id not between", value1, value2, "commentatorId");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameIsNull() {
            addCriterion("commentator_name is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameIsNotNull() {
            addCriterion("commentator_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameEqualTo(String value) {
            addCriterion("commentator_name =", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameNotEqualTo(String value) {
            addCriterion("commentator_name <>", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameGreaterThan(String value) {
            addCriterion("commentator_name >", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_name >=", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameLessThan(String value) {
            addCriterion("commentator_name <", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameLessThanOrEqualTo(String value) {
            addCriterion("commentator_name <=", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameLike(String value) {
            addCriterion("commentator_name like", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameNotLike(String value) {
            addCriterion("commentator_name not like", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameIn(List<String> values) {
            addCriterion("commentator_name in", values, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameNotIn(List<String> values) {
            addCriterion("commentator_name not in", values, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameBetween(String value1, String value2) {
            addCriterion("commentator_name between", value1, value2, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameNotBetween(String value1, String value2) {
            addCriterion("commentator_name not between", value1, value2, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorGenderIsNull() {
            addCriterion("commentator_gender is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorGenderIsNotNull() {
            addCriterion("commentator_gender is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorGenderEqualTo(String value) {
            addCriterion("commentator_gender =", value, "commentatorGender");
            return (Criteria) this;
        }

        public Criteria andCommentatorGenderNotEqualTo(String value) {
            addCriterion("commentator_gender <>", value, "commentatorGender");
            return (Criteria) this;
        }

        public Criteria andCommentatorGenderGreaterThan(String value) {
            addCriterion("commentator_gender >", value, "commentatorGender");
            return (Criteria) this;
        }

        public Criteria andCommentatorGenderGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_gender >=", value, "commentatorGender");
            return (Criteria) this;
        }

        public Criteria andCommentatorGenderLessThan(String value) {
            addCriterion("commentator_gender <", value, "commentatorGender");
            return (Criteria) this;
        }

        public Criteria andCommentatorGenderLessThanOrEqualTo(String value) {
            addCriterion("commentator_gender <=", value, "commentatorGender");
            return (Criteria) this;
        }

        public Criteria andCommentatorGenderLike(String value) {
            addCriterion("commentator_gender like", value, "commentatorGender");
            return (Criteria) this;
        }

        public Criteria andCommentatorGenderNotLike(String value) {
            addCriterion("commentator_gender not like", value, "commentatorGender");
            return (Criteria) this;
        }

        public Criteria andCommentatorGenderIn(List<String> values) {
            addCriterion("commentator_gender in", values, "commentatorGender");
            return (Criteria) this;
        }

        public Criteria andCommentatorGenderNotIn(List<String> values) {
            addCriterion("commentator_gender not in", values, "commentatorGender");
            return (Criteria) this;
        }

        public Criteria andCommentatorGenderBetween(String value1, String value2) {
            addCriterion("commentator_gender between", value1, value2, "commentatorGender");
            return (Criteria) this;
        }

        public Criteria andCommentatorGenderNotBetween(String value1, String value2) {
            addCriterion("commentator_gender not between", value1, value2, "commentatorGender");
            return (Criteria) this;
        }

        public Criteria andCommentatorAgeIsNull() {
            addCriterion("commentator_age is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorAgeIsNotNull() {
            addCriterion("commentator_age is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorAgeEqualTo(Integer value) {
            addCriterion("commentator_age =", value, "commentatorAge");
            return (Criteria) this;
        }

        public Criteria andCommentatorAgeNotEqualTo(Integer value) {
            addCriterion("commentator_age <>", value, "commentatorAge");
            return (Criteria) this;
        }

        public Criteria andCommentatorAgeGreaterThan(Integer value) {
            addCriterion("commentator_age >", value, "commentatorAge");
            return (Criteria) this;
        }

        public Criteria andCommentatorAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentator_age >=", value, "commentatorAge");
            return (Criteria) this;
        }

        public Criteria andCommentatorAgeLessThan(Integer value) {
            addCriterion("commentator_age <", value, "commentatorAge");
            return (Criteria) this;
        }

        public Criteria andCommentatorAgeLessThanOrEqualTo(Integer value) {
            addCriterion("commentator_age <=", value, "commentatorAge");
            return (Criteria) this;
        }

        public Criteria andCommentatorAgeIn(List<Integer> values) {
            addCriterion("commentator_age in", values, "commentatorAge");
            return (Criteria) this;
        }

        public Criteria andCommentatorAgeNotIn(List<Integer> values) {
            addCriterion("commentator_age not in", values, "commentatorAge");
            return (Criteria) this;
        }

        public Criteria andCommentatorAgeBetween(Integer value1, Integer value2) {
            addCriterion("commentator_age between", value1, value2, "commentatorAge");
            return (Criteria) this;
        }

        public Criteria andCommentatorAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("commentator_age not between", value1, value2, "commentatorAge");
            return (Criteria) this;
        }

        public Criteria andCommentatorRecordIsNull() {
            addCriterion("commentator_record is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorRecordIsNotNull() {
            addCriterion("commentator_record is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorRecordEqualTo(String value) {
            addCriterion("commentator_record =", value, "commentatorRecord");
            return (Criteria) this;
        }

        public Criteria andCommentatorRecordNotEqualTo(String value) {
            addCriterion("commentator_record <>", value, "commentatorRecord");
            return (Criteria) this;
        }

        public Criteria andCommentatorRecordGreaterThan(String value) {
            addCriterion("commentator_record >", value, "commentatorRecord");
            return (Criteria) this;
        }

        public Criteria andCommentatorRecordGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_record >=", value, "commentatorRecord");
            return (Criteria) this;
        }

        public Criteria andCommentatorRecordLessThan(String value) {
            addCriterion("commentator_record <", value, "commentatorRecord");
            return (Criteria) this;
        }

        public Criteria andCommentatorRecordLessThanOrEqualTo(String value) {
            addCriterion("commentator_record <=", value, "commentatorRecord");
            return (Criteria) this;
        }

        public Criteria andCommentatorRecordLike(String value) {
            addCriterion("commentator_record like", value, "commentatorRecord");
            return (Criteria) this;
        }

        public Criteria andCommentatorRecordNotLike(String value) {
            addCriterion("commentator_record not like", value, "commentatorRecord");
            return (Criteria) this;
        }

        public Criteria andCommentatorRecordIn(List<String> values) {
            addCriterion("commentator_record in", values, "commentatorRecord");
            return (Criteria) this;
        }

        public Criteria andCommentatorRecordNotIn(List<String> values) {
            addCriterion("commentator_record not in", values, "commentatorRecord");
            return (Criteria) this;
        }

        public Criteria andCommentatorRecordBetween(String value1, String value2) {
            addCriterion("commentator_record between", value1, value2, "commentatorRecord");
            return (Criteria) this;
        }

        public Criteria andCommentatorRecordNotBetween(String value1, String value2) {
            addCriterion("commentator_record not between", value1, value2, "commentatorRecord");
            return (Criteria) this;
        }

        public Criteria andCommentatorEducationIsNull() {
            addCriterion("commentator_education is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorEducationIsNotNull() {
            addCriterion("commentator_education is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorEducationEqualTo(String value) {
            addCriterion("commentator_education =", value, "commentatorEducation");
            return (Criteria) this;
        }

        public Criteria andCommentatorEducationNotEqualTo(String value) {
            addCriterion("commentator_education <>", value, "commentatorEducation");
            return (Criteria) this;
        }

        public Criteria andCommentatorEducationGreaterThan(String value) {
            addCriterion("commentator_education >", value, "commentatorEducation");
            return (Criteria) this;
        }

        public Criteria andCommentatorEducationGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_education >=", value, "commentatorEducation");
            return (Criteria) this;
        }

        public Criteria andCommentatorEducationLessThan(String value) {
            addCriterion("commentator_education <", value, "commentatorEducation");
            return (Criteria) this;
        }

        public Criteria andCommentatorEducationLessThanOrEqualTo(String value) {
            addCriterion("commentator_education <=", value, "commentatorEducation");
            return (Criteria) this;
        }

        public Criteria andCommentatorEducationLike(String value) {
            addCriterion("commentator_education like", value, "commentatorEducation");
            return (Criteria) this;
        }

        public Criteria andCommentatorEducationNotLike(String value) {
            addCriterion("commentator_education not like", value, "commentatorEducation");
            return (Criteria) this;
        }

        public Criteria andCommentatorEducationIn(List<String> values) {
            addCriterion("commentator_education in", values, "commentatorEducation");
            return (Criteria) this;
        }

        public Criteria andCommentatorEducationNotIn(List<String> values) {
            addCriterion("commentator_education not in", values, "commentatorEducation");
            return (Criteria) this;
        }

        public Criteria andCommentatorEducationBetween(String value1, String value2) {
            addCriterion("commentator_education between", value1, value2, "commentatorEducation");
            return (Criteria) this;
        }

        public Criteria andCommentatorEducationNotBetween(String value1, String value2) {
            addCriterion("commentator_education not between", value1, value2, "commentatorEducation");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdcardIsNull() {
            addCriterion("commentator_idcard is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdcardIsNotNull() {
            addCriterion("commentator_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdcardEqualTo(String value) {
            addCriterion("commentator_idcard =", value, "commentatorIdcard");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdcardNotEqualTo(String value) {
            addCriterion("commentator_idcard <>", value, "commentatorIdcard");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdcardGreaterThan(String value) {
            addCriterion("commentator_idcard >", value, "commentatorIdcard");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_idcard >=", value, "commentatorIdcard");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdcardLessThan(String value) {
            addCriterion("commentator_idcard <", value, "commentatorIdcard");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdcardLessThanOrEqualTo(String value) {
            addCriterion("commentator_idcard <=", value, "commentatorIdcard");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdcardLike(String value) {
            addCriterion("commentator_idcard like", value, "commentatorIdcard");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdcardNotLike(String value) {
            addCriterion("commentator_idcard not like", value, "commentatorIdcard");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdcardIn(List<String> values) {
            addCriterion("commentator_idcard in", values, "commentatorIdcard");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdcardNotIn(List<String> values) {
            addCriterion("commentator_idcard not in", values, "commentatorIdcard");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdcardBetween(String value1, String value2) {
            addCriterion("commentator_idcard between", value1, value2, "commentatorIdcard");
            return (Criteria) this;
        }

        public Criteria andCommentatorIdcardNotBetween(String value1, String value2) {
            addCriterion("commentator_idcard not between", value1, value2, "commentatorIdcard");
            return (Criteria) this;
        }

        public Criteria andCommentatorProvinceIsNull() {
            addCriterion("commentator_province is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorProvinceIsNotNull() {
            addCriterion("commentator_province is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorProvinceEqualTo(String value) {
            addCriterion("commentator_province =", value, "commentatorProvince");
            return (Criteria) this;
        }

        public Criteria andCommentatorProvinceNotEqualTo(String value) {
            addCriterion("commentator_province <>", value, "commentatorProvince");
            return (Criteria) this;
        }

        public Criteria andCommentatorProvinceGreaterThan(String value) {
            addCriterion("commentator_province >", value, "commentatorProvince");
            return (Criteria) this;
        }

        public Criteria andCommentatorProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_province >=", value, "commentatorProvince");
            return (Criteria) this;
        }

        public Criteria andCommentatorProvinceLessThan(String value) {
            addCriterion("commentator_province <", value, "commentatorProvince");
            return (Criteria) this;
        }

        public Criteria andCommentatorProvinceLessThanOrEqualTo(String value) {
            addCriterion("commentator_province <=", value, "commentatorProvince");
            return (Criteria) this;
        }

        public Criteria andCommentatorProvinceLike(String value) {
            addCriterion("commentator_province like", value, "commentatorProvince");
            return (Criteria) this;
        }

        public Criteria andCommentatorProvinceNotLike(String value) {
            addCriterion("commentator_province not like", value, "commentatorProvince");
            return (Criteria) this;
        }

        public Criteria andCommentatorProvinceIn(List<String> values) {
            addCriterion("commentator_province in", values, "commentatorProvince");
            return (Criteria) this;
        }

        public Criteria andCommentatorProvinceNotIn(List<String> values) {
            addCriterion("commentator_province not in", values, "commentatorProvince");
            return (Criteria) this;
        }

        public Criteria andCommentatorProvinceBetween(String value1, String value2) {
            addCriterion("commentator_province between", value1, value2, "commentatorProvince");
            return (Criteria) this;
        }

        public Criteria andCommentatorProvinceNotBetween(String value1, String value2) {
            addCriterion("commentator_province not between", value1, value2, "commentatorProvince");
            return (Criteria) this;
        }

        public Criteria andCommentatorCityIsNull() {
            addCriterion("commentator_city is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorCityIsNotNull() {
            addCriterion("commentator_city is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorCityEqualTo(String value) {
            addCriterion("commentator_city =", value, "commentatorCity");
            return (Criteria) this;
        }

        public Criteria andCommentatorCityNotEqualTo(String value) {
            addCriterion("commentator_city <>", value, "commentatorCity");
            return (Criteria) this;
        }

        public Criteria andCommentatorCityGreaterThan(String value) {
            addCriterion("commentator_city >", value, "commentatorCity");
            return (Criteria) this;
        }

        public Criteria andCommentatorCityGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_city >=", value, "commentatorCity");
            return (Criteria) this;
        }

        public Criteria andCommentatorCityLessThan(String value) {
            addCriterion("commentator_city <", value, "commentatorCity");
            return (Criteria) this;
        }

        public Criteria andCommentatorCityLessThanOrEqualTo(String value) {
            addCriterion("commentator_city <=", value, "commentatorCity");
            return (Criteria) this;
        }

        public Criteria andCommentatorCityLike(String value) {
            addCriterion("commentator_city like", value, "commentatorCity");
            return (Criteria) this;
        }

        public Criteria andCommentatorCityNotLike(String value) {
            addCriterion("commentator_city not like", value, "commentatorCity");
            return (Criteria) this;
        }

        public Criteria andCommentatorCityIn(List<String> values) {
            addCriterion("commentator_city in", values, "commentatorCity");
            return (Criteria) this;
        }

        public Criteria andCommentatorCityNotIn(List<String> values) {
            addCriterion("commentator_city not in", values, "commentatorCity");
            return (Criteria) this;
        }

        public Criteria andCommentatorCityBetween(String value1, String value2) {
            addCriterion("commentator_city between", value1, value2, "commentatorCity");
            return (Criteria) this;
        }

        public Criteria andCommentatorCityNotBetween(String value1, String value2) {
            addCriterion("commentator_city not between", value1, value2, "commentatorCity");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPlaceIsNull() {
            addCriterion("commentator_work_place is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPlaceIsNotNull() {
            addCriterion("commentator_work_place is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPlaceEqualTo(String value) {
            addCriterion("commentator_work_place =", value, "commentatorWorkPlace");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPlaceNotEqualTo(String value) {
            addCriterion("commentator_work_place <>", value, "commentatorWorkPlace");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPlaceGreaterThan(String value) {
            addCriterion("commentator_work_place >", value, "commentatorWorkPlace");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_work_place >=", value, "commentatorWorkPlace");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPlaceLessThan(String value) {
            addCriterion("commentator_work_place <", value, "commentatorWorkPlace");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPlaceLessThanOrEqualTo(String value) {
            addCriterion("commentator_work_place <=", value, "commentatorWorkPlace");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPlaceLike(String value) {
            addCriterion("commentator_work_place like", value, "commentatorWorkPlace");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPlaceNotLike(String value) {
            addCriterion("commentator_work_place not like", value, "commentatorWorkPlace");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPlaceIn(List<String> values) {
            addCriterion("commentator_work_place in", values, "commentatorWorkPlace");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPlaceNotIn(List<String> values) {
            addCriterion("commentator_work_place not in", values, "commentatorWorkPlace");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPlaceBetween(String value1, String value2) {
            addCriterion("commentator_work_place between", value1, value2, "commentatorWorkPlace");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPlaceNotBetween(String value1, String value2) {
            addCriterion("commentator_work_place not between", value1, value2, "commentatorWorkPlace");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPositionIsNull() {
            addCriterion("commentator_work_position is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPositionIsNotNull() {
            addCriterion("commentator_work_position is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPositionEqualTo(String value) {
            addCriterion("commentator_work_position =", value, "commentatorWorkPosition");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPositionNotEqualTo(String value) {
            addCriterion("commentator_work_position <>", value, "commentatorWorkPosition");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPositionGreaterThan(String value) {
            addCriterion("commentator_work_position >", value, "commentatorWorkPosition");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPositionGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_work_position >=", value, "commentatorWorkPosition");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPositionLessThan(String value) {
            addCriterion("commentator_work_position <", value, "commentatorWorkPosition");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPositionLessThanOrEqualTo(String value) {
            addCriterion("commentator_work_position <=", value, "commentatorWorkPosition");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPositionLike(String value) {
            addCriterion("commentator_work_position like", value, "commentatorWorkPosition");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPositionNotLike(String value) {
            addCriterion("commentator_work_position not like", value, "commentatorWorkPosition");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPositionIn(List<String> values) {
            addCriterion("commentator_work_position in", values, "commentatorWorkPosition");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPositionNotIn(List<String> values) {
            addCriterion("commentator_work_position not in", values, "commentatorWorkPosition");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPositionBetween(String value1, String value2) {
            addCriterion("commentator_work_position between", value1, value2, "commentatorWorkPosition");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkPositionNotBetween(String value1, String value2) {
            addCriterion("commentator_work_position not between", value1, value2, "commentatorWorkPosition");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkYearIsNull() {
            addCriterion("commentator_work_year is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkYearIsNotNull() {
            addCriterion("commentator_work_year is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkYearEqualTo(Integer value) {
            addCriterion("commentator_work_year =", value, "commentatorWorkYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkYearNotEqualTo(Integer value) {
            addCriterion("commentator_work_year <>", value, "commentatorWorkYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkYearGreaterThan(Integer value) {
            addCriterion("commentator_work_year >", value, "commentatorWorkYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentator_work_year >=", value, "commentatorWorkYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkYearLessThan(Integer value) {
            addCriterion("commentator_work_year <", value, "commentatorWorkYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkYearLessThanOrEqualTo(Integer value) {
            addCriterion("commentator_work_year <=", value, "commentatorWorkYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkYearIn(List<Integer> values) {
            addCriterion("commentator_work_year in", values, "commentatorWorkYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkYearNotIn(List<Integer> values) {
            addCriterion("commentator_work_year not in", values, "commentatorWorkYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkYearBetween(Integer value1, Integer value2) {
            addCriterion("commentator_work_year between", value1, value2, "commentatorWorkYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorWorkYearNotBetween(Integer value1, Integer value2) {
            addCriterion("commentator_work_year not between", value1, value2, "commentatorWorkYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorImageUrlIsNull() {
            addCriterion("commentator_image_url is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorImageUrlIsNotNull() {
            addCriterion("commentator_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorImageUrlEqualTo(String value) {
            addCriterion("commentator_image_url =", value, "commentatorImageUrl");
            return (Criteria) this;
        }

        public Criteria andCommentatorImageUrlNotEqualTo(String value) {
            addCriterion("commentator_image_url <>", value, "commentatorImageUrl");
            return (Criteria) this;
        }

        public Criteria andCommentatorImageUrlGreaterThan(String value) {
            addCriterion("commentator_image_url >", value, "commentatorImageUrl");
            return (Criteria) this;
        }

        public Criteria andCommentatorImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_image_url >=", value, "commentatorImageUrl");
            return (Criteria) this;
        }

        public Criteria andCommentatorImageUrlLessThan(String value) {
            addCriterion("commentator_image_url <", value, "commentatorImageUrl");
            return (Criteria) this;
        }

        public Criteria andCommentatorImageUrlLessThanOrEqualTo(String value) {
            addCriterion("commentator_image_url <=", value, "commentatorImageUrl");
            return (Criteria) this;
        }

        public Criteria andCommentatorImageUrlLike(String value) {
            addCriterion("commentator_image_url like", value, "commentatorImageUrl");
            return (Criteria) this;
        }

        public Criteria andCommentatorImageUrlNotLike(String value) {
            addCriterion("commentator_image_url not like", value, "commentatorImageUrl");
            return (Criteria) this;
        }

        public Criteria andCommentatorImageUrlIn(List<String> values) {
            addCriterion("commentator_image_url in", values, "commentatorImageUrl");
            return (Criteria) this;
        }

        public Criteria andCommentatorImageUrlNotIn(List<String> values) {
            addCriterion("commentator_image_url not in", values, "commentatorImageUrl");
            return (Criteria) this;
        }

        public Criteria andCommentatorImageUrlBetween(String value1, String value2) {
            addCriterion("commentator_image_url between", value1, value2, "commentatorImageUrl");
            return (Criteria) this;
        }

        public Criteria andCommentatorImageUrlNotBetween(String value1, String value2) {
            addCriterion("commentator_image_url not between", value1, value2, "commentatorImageUrl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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