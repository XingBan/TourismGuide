package com.guide.bean;

import java.util.ArrayList;
import java.util.List;

public class GuideExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuideExample() {
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

        public Criteria andGuideIdIsNull() {
            addCriterion("guide_id is null");
            return (Criteria) this;
        }

        public Criteria andGuideIdIsNotNull() {
            addCriterion("guide_id is not null");
            return (Criteria) this;
        }

        public Criteria andGuideIdEqualTo(Integer value) {
            addCriterion("guide_id =", value, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdNotEqualTo(Integer value) {
            addCriterion("guide_id <>", value, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdGreaterThan(Integer value) {
            addCriterion("guide_id >", value, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("guide_id >=", value, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdLessThan(Integer value) {
            addCriterion("guide_id <", value, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdLessThanOrEqualTo(Integer value) {
            addCriterion("guide_id <=", value, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdIn(List<Integer> values) {
            addCriterion("guide_id in", values, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdNotIn(List<Integer> values) {
            addCriterion("guide_id not in", values, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdBetween(Integer value1, Integer value2) {
            addCriterion("guide_id between", value1, value2, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdNotBetween(Integer value1, Integer value2) {
            addCriterion("guide_id not between", value1, value2, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideNameIsNull() {
            addCriterion("guide_name is null");
            return (Criteria) this;
        }

        public Criteria andGuideNameIsNotNull() {
            addCriterion("guide_name is not null");
            return (Criteria) this;
        }

        public Criteria andGuideNameEqualTo(String value) {
            addCriterion("guide_name =", value, "guideName");
            return (Criteria) this;
        }

        public Criteria andGuideNameNotEqualTo(String value) {
            addCriterion("guide_name <>", value, "guideName");
            return (Criteria) this;
        }

        public Criteria andGuideNameGreaterThan(String value) {
            addCriterion("guide_name >", value, "guideName");
            return (Criteria) this;
        }

        public Criteria andGuideNameGreaterThanOrEqualTo(String value) {
            addCriterion("guide_name >=", value, "guideName");
            return (Criteria) this;
        }

        public Criteria andGuideNameLessThan(String value) {
            addCriterion("guide_name <", value, "guideName");
            return (Criteria) this;
        }

        public Criteria andGuideNameLessThanOrEqualTo(String value) {
            addCriterion("guide_name <=", value, "guideName");
            return (Criteria) this;
        }

        public Criteria andGuideNameLike(String value) {
            addCriterion("guide_name like", value, "guideName");
            return (Criteria) this;
        }

        public Criteria andGuideNameNotLike(String value) {
            addCriterion("guide_name not like", value, "guideName");
            return (Criteria) this;
        }

        public Criteria andGuideNameIn(List<String> values) {
            addCriterion("guide_name in", values, "guideName");
            return (Criteria) this;
        }

        public Criteria andGuideNameNotIn(List<String> values) {
            addCriterion("guide_name not in", values, "guideName");
            return (Criteria) this;
        }

        public Criteria andGuideNameBetween(String value1, String value2) {
            addCriterion("guide_name between", value1, value2, "guideName");
            return (Criteria) this;
        }

        public Criteria andGuideNameNotBetween(String value1, String value2) {
            addCriterion("guide_name not between", value1, value2, "guideName");
            return (Criteria) this;
        }

        public Criteria andGuideGenderIsNull() {
            addCriterion("guide_gender is null");
            return (Criteria) this;
        }

        public Criteria andGuideGenderIsNotNull() {
            addCriterion("guide_gender is not null");
            return (Criteria) this;
        }

        public Criteria andGuideGenderEqualTo(String value) {
            addCriterion("guide_gender =", value, "guideGender");
            return (Criteria) this;
        }

        public Criteria andGuideGenderNotEqualTo(String value) {
            addCriterion("guide_gender <>", value, "guideGender");
            return (Criteria) this;
        }

        public Criteria andGuideGenderGreaterThan(String value) {
            addCriterion("guide_gender >", value, "guideGender");
            return (Criteria) this;
        }

        public Criteria andGuideGenderGreaterThanOrEqualTo(String value) {
            addCriterion("guide_gender >=", value, "guideGender");
            return (Criteria) this;
        }

        public Criteria andGuideGenderLessThan(String value) {
            addCriterion("guide_gender <", value, "guideGender");
            return (Criteria) this;
        }

        public Criteria andGuideGenderLessThanOrEqualTo(String value) {
            addCriterion("guide_gender <=", value, "guideGender");
            return (Criteria) this;
        }

        public Criteria andGuideGenderLike(String value) {
            addCriterion("guide_gender like", value, "guideGender");
            return (Criteria) this;
        }

        public Criteria andGuideGenderNotLike(String value) {
            addCriterion("guide_gender not like", value, "guideGender");
            return (Criteria) this;
        }

        public Criteria andGuideGenderIn(List<String> values) {
            addCriterion("guide_gender in", values, "guideGender");
            return (Criteria) this;
        }

        public Criteria andGuideGenderNotIn(List<String> values) {
            addCriterion("guide_gender not in", values, "guideGender");
            return (Criteria) this;
        }

        public Criteria andGuideGenderBetween(String value1, String value2) {
            addCriterion("guide_gender between", value1, value2, "guideGender");
            return (Criteria) this;
        }

        public Criteria andGuideGenderNotBetween(String value1, String value2) {
            addCriterion("guide_gender not between", value1, value2, "guideGender");
            return (Criteria) this;
        }

        public Criteria andGuideAgeIsNull() {
            addCriterion("guide_age is null");
            return (Criteria) this;
        }

        public Criteria andGuideAgeIsNotNull() {
            addCriterion("guide_age is not null");
            return (Criteria) this;
        }

        public Criteria andGuideAgeEqualTo(Integer value) {
            addCriterion("guide_age =", value, "guideAge");
            return (Criteria) this;
        }

        public Criteria andGuideAgeNotEqualTo(Integer value) {
            addCriterion("guide_age <>", value, "guideAge");
            return (Criteria) this;
        }

        public Criteria andGuideAgeGreaterThan(Integer value) {
            addCriterion("guide_age >", value, "guideAge");
            return (Criteria) this;
        }

        public Criteria andGuideAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("guide_age >=", value, "guideAge");
            return (Criteria) this;
        }

        public Criteria andGuideAgeLessThan(Integer value) {
            addCriterion("guide_age <", value, "guideAge");
            return (Criteria) this;
        }

        public Criteria andGuideAgeLessThanOrEqualTo(Integer value) {
            addCriterion("guide_age <=", value, "guideAge");
            return (Criteria) this;
        }

        public Criteria andGuideAgeIn(List<Integer> values) {
            addCriterion("guide_age in", values, "guideAge");
            return (Criteria) this;
        }

        public Criteria andGuideAgeNotIn(List<Integer> values) {
            addCriterion("guide_age not in", values, "guideAge");
            return (Criteria) this;
        }

        public Criteria andGuideAgeBetween(Integer value1, Integer value2) {
            addCriterion("guide_age between", value1, value2, "guideAge");
            return (Criteria) this;
        }

        public Criteria andGuideAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("guide_age not between", value1, value2, "guideAge");
            return (Criteria) this;
        }

        public Criteria andGuideRecordIsNull() {
            addCriterion("guide_record is null");
            return (Criteria) this;
        }

        public Criteria andGuideRecordIsNotNull() {
            addCriterion("guide_record is not null");
            return (Criteria) this;
        }

        public Criteria andGuideRecordEqualTo(String value) {
            addCriterion("guide_record =", value, "guideRecord");
            return (Criteria) this;
        }

        public Criteria andGuideRecordNotEqualTo(String value) {
            addCriterion("guide_record <>", value, "guideRecord");
            return (Criteria) this;
        }

        public Criteria andGuideRecordGreaterThan(String value) {
            addCriterion("guide_record >", value, "guideRecord");
            return (Criteria) this;
        }

        public Criteria andGuideRecordGreaterThanOrEqualTo(String value) {
            addCriterion("guide_record >=", value, "guideRecord");
            return (Criteria) this;
        }

        public Criteria andGuideRecordLessThan(String value) {
            addCriterion("guide_record <", value, "guideRecord");
            return (Criteria) this;
        }

        public Criteria andGuideRecordLessThanOrEqualTo(String value) {
            addCriterion("guide_record <=", value, "guideRecord");
            return (Criteria) this;
        }

        public Criteria andGuideRecordLike(String value) {
            addCriterion("guide_record like", value, "guideRecord");
            return (Criteria) this;
        }

        public Criteria andGuideRecordNotLike(String value) {
            addCriterion("guide_record not like", value, "guideRecord");
            return (Criteria) this;
        }

        public Criteria andGuideRecordIn(List<String> values) {
            addCriterion("guide_record in", values, "guideRecord");
            return (Criteria) this;
        }

        public Criteria andGuideRecordNotIn(List<String> values) {
            addCriterion("guide_record not in", values, "guideRecord");
            return (Criteria) this;
        }

        public Criteria andGuideRecordBetween(String value1, String value2) {
            addCriterion("guide_record between", value1, value2, "guideRecord");
            return (Criteria) this;
        }

        public Criteria andGuideRecordNotBetween(String value1, String value2) {
            addCriterion("guide_record not between", value1, value2, "guideRecord");
            return (Criteria) this;
        }

        public Criteria andGuideEducationIsNull() {
            addCriterion("guide_education is null");
            return (Criteria) this;
        }

        public Criteria andGuideEducationIsNotNull() {
            addCriterion("guide_education is not null");
            return (Criteria) this;
        }

        public Criteria andGuideEducationEqualTo(String value) {
            addCriterion("guide_education =", value, "guideEducation");
            return (Criteria) this;
        }

        public Criteria andGuideEducationNotEqualTo(String value) {
            addCriterion("guide_education <>", value, "guideEducation");
            return (Criteria) this;
        }

        public Criteria andGuideEducationGreaterThan(String value) {
            addCriterion("guide_education >", value, "guideEducation");
            return (Criteria) this;
        }

        public Criteria andGuideEducationGreaterThanOrEqualTo(String value) {
            addCriterion("guide_education >=", value, "guideEducation");
            return (Criteria) this;
        }

        public Criteria andGuideEducationLessThan(String value) {
            addCriterion("guide_education <", value, "guideEducation");
            return (Criteria) this;
        }

        public Criteria andGuideEducationLessThanOrEqualTo(String value) {
            addCriterion("guide_education <=", value, "guideEducation");
            return (Criteria) this;
        }

        public Criteria andGuideEducationLike(String value) {
            addCriterion("guide_education like", value, "guideEducation");
            return (Criteria) this;
        }

        public Criteria andGuideEducationNotLike(String value) {
            addCriterion("guide_education not like", value, "guideEducation");
            return (Criteria) this;
        }

        public Criteria andGuideEducationIn(List<String> values) {
            addCriterion("guide_education in", values, "guideEducation");
            return (Criteria) this;
        }

        public Criteria andGuideEducationNotIn(List<String> values) {
            addCriterion("guide_education not in", values, "guideEducation");
            return (Criteria) this;
        }

        public Criteria andGuideEducationBetween(String value1, String value2) {
            addCriterion("guide_education between", value1, value2, "guideEducation");
            return (Criteria) this;
        }

        public Criteria andGuideEducationNotBetween(String value1, String value2) {
            addCriterion("guide_education not between", value1, value2, "guideEducation");
            return (Criteria) this;
        }

        public Criteria andGuideIdcardIsNull() {
            addCriterion("guide_idcard is null");
            return (Criteria) this;
        }

        public Criteria andGuideIdcardIsNotNull() {
            addCriterion("guide_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andGuideIdcardEqualTo(String value) {
            addCriterion("guide_idcard =", value, "guideIdcard");
            return (Criteria) this;
        }

        public Criteria andGuideIdcardNotEqualTo(String value) {
            addCriterion("guide_idcard <>", value, "guideIdcard");
            return (Criteria) this;
        }

        public Criteria andGuideIdcardGreaterThan(String value) {
            addCriterion("guide_idcard >", value, "guideIdcard");
            return (Criteria) this;
        }

        public Criteria andGuideIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("guide_idcard >=", value, "guideIdcard");
            return (Criteria) this;
        }

        public Criteria andGuideIdcardLessThan(String value) {
            addCriterion("guide_idcard <", value, "guideIdcard");
            return (Criteria) this;
        }

        public Criteria andGuideIdcardLessThanOrEqualTo(String value) {
            addCriterion("guide_idcard <=", value, "guideIdcard");
            return (Criteria) this;
        }

        public Criteria andGuideIdcardLike(String value) {
            addCriterion("guide_idcard like", value, "guideIdcard");
            return (Criteria) this;
        }

        public Criteria andGuideIdcardNotLike(String value) {
            addCriterion("guide_idcard not like", value, "guideIdcard");
            return (Criteria) this;
        }

        public Criteria andGuideIdcardIn(List<String> values) {
            addCriterion("guide_idcard in", values, "guideIdcard");
            return (Criteria) this;
        }

        public Criteria andGuideIdcardNotIn(List<String> values) {
            addCriterion("guide_idcard not in", values, "guideIdcard");
            return (Criteria) this;
        }

        public Criteria andGuideIdcardBetween(String value1, String value2) {
            addCriterion("guide_idcard between", value1, value2, "guideIdcard");
            return (Criteria) this;
        }

        public Criteria andGuideIdcardNotBetween(String value1, String value2) {
            addCriterion("guide_idcard not between", value1, value2, "guideIdcard");
            return (Criteria) this;
        }

        public Criteria andGuideProvinceIsNull() {
            addCriterion("guide_province is null");
            return (Criteria) this;
        }

        public Criteria andGuideProvinceIsNotNull() {
            addCriterion("guide_province is not null");
            return (Criteria) this;
        }

        public Criteria andGuideProvinceEqualTo(String value) {
            addCriterion("guide_province =", value, "guideProvince");
            return (Criteria) this;
        }

        public Criteria andGuideProvinceNotEqualTo(String value) {
            addCriterion("guide_province <>", value, "guideProvince");
            return (Criteria) this;
        }

        public Criteria andGuideProvinceGreaterThan(String value) {
            addCriterion("guide_province >", value, "guideProvince");
            return (Criteria) this;
        }

        public Criteria andGuideProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("guide_province >=", value, "guideProvince");
            return (Criteria) this;
        }

        public Criteria andGuideProvinceLessThan(String value) {
            addCriterion("guide_province <", value, "guideProvince");
            return (Criteria) this;
        }

        public Criteria andGuideProvinceLessThanOrEqualTo(String value) {
            addCriterion("guide_province <=", value, "guideProvince");
            return (Criteria) this;
        }

        public Criteria andGuideProvinceLike(String value) {
            addCriterion("guide_province like", value, "guideProvince");
            return (Criteria) this;
        }

        public Criteria andGuideProvinceNotLike(String value) {
            addCriterion("guide_province not like", value, "guideProvince");
            return (Criteria) this;
        }

        public Criteria andGuideProvinceIn(List<String> values) {
            addCriterion("guide_province in", values, "guideProvince");
            return (Criteria) this;
        }

        public Criteria andGuideProvinceNotIn(List<String> values) {
            addCriterion("guide_province not in", values, "guideProvince");
            return (Criteria) this;
        }

        public Criteria andGuideProvinceBetween(String value1, String value2) {
            addCriterion("guide_province between", value1, value2, "guideProvince");
            return (Criteria) this;
        }

        public Criteria andGuideProvinceNotBetween(String value1, String value2) {
            addCriterion("guide_province not between", value1, value2, "guideProvince");
            return (Criteria) this;
        }

        public Criteria andGuideCityIsNull() {
            addCriterion("guide_city is null");
            return (Criteria) this;
        }

        public Criteria andGuideCityIsNotNull() {
            addCriterion("guide_city is not null");
            return (Criteria) this;
        }

        public Criteria andGuideCityEqualTo(String value) {
            addCriterion("guide_city =", value, "guideCity");
            return (Criteria) this;
        }

        public Criteria andGuideCityNotEqualTo(String value) {
            addCriterion("guide_city <>", value, "guideCity");
            return (Criteria) this;
        }

        public Criteria andGuideCityGreaterThan(String value) {
            addCriterion("guide_city >", value, "guideCity");
            return (Criteria) this;
        }

        public Criteria andGuideCityGreaterThanOrEqualTo(String value) {
            addCriterion("guide_city >=", value, "guideCity");
            return (Criteria) this;
        }

        public Criteria andGuideCityLessThan(String value) {
            addCriterion("guide_city <", value, "guideCity");
            return (Criteria) this;
        }

        public Criteria andGuideCityLessThanOrEqualTo(String value) {
            addCriterion("guide_city <=", value, "guideCity");
            return (Criteria) this;
        }

        public Criteria andGuideCityLike(String value) {
            addCriterion("guide_city like", value, "guideCity");
            return (Criteria) this;
        }

        public Criteria andGuideCityNotLike(String value) {
            addCriterion("guide_city not like", value, "guideCity");
            return (Criteria) this;
        }

        public Criteria andGuideCityIn(List<String> values) {
            addCriterion("guide_city in", values, "guideCity");
            return (Criteria) this;
        }

        public Criteria andGuideCityNotIn(List<String> values) {
            addCriterion("guide_city not in", values, "guideCity");
            return (Criteria) this;
        }

        public Criteria andGuideCityBetween(String value1, String value2) {
            addCriterion("guide_city between", value1, value2, "guideCity");
            return (Criteria) this;
        }

        public Criteria andGuideCityNotBetween(String value1, String value2) {
            addCriterion("guide_city not between", value1, value2, "guideCity");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPlaceIsNull() {
            addCriterion("guide_work_place is null");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPlaceIsNotNull() {
            addCriterion("guide_work_place is not null");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPlaceEqualTo(String value) {
            addCriterion("guide_work_place =", value, "guideWorkPlace");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPlaceNotEqualTo(String value) {
            addCriterion("guide_work_place <>", value, "guideWorkPlace");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPlaceGreaterThan(String value) {
            addCriterion("guide_work_place >", value, "guideWorkPlace");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("guide_work_place >=", value, "guideWorkPlace");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPlaceLessThan(String value) {
            addCriterion("guide_work_place <", value, "guideWorkPlace");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPlaceLessThanOrEqualTo(String value) {
            addCriterion("guide_work_place <=", value, "guideWorkPlace");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPlaceLike(String value) {
            addCriterion("guide_work_place like", value, "guideWorkPlace");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPlaceNotLike(String value) {
            addCriterion("guide_work_place not like", value, "guideWorkPlace");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPlaceIn(List<String> values) {
            addCriterion("guide_work_place in", values, "guideWorkPlace");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPlaceNotIn(List<String> values) {
            addCriterion("guide_work_place not in", values, "guideWorkPlace");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPlaceBetween(String value1, String value2) {
            addCriterion("guide_work_place between", value1, value2, "guideWorkPlace");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPlaceNotBetween(String value1, String value2) {
            addCriterion("guide_work_place not between", value1, value2, "guideWorkPlace");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPositionIsNull() {
            addCriterion("guide_work_position is null");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPositionIsNotNull() {
            addCriterion("guide_work_position is not null");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPositionEqualTo(String value) {
            addCriterion("guide_work_position =", value, "guideWorkPosition");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPositionNotEqualTo(String value) {
            addCriterion("guide_work_position <>", value, "guideWorkPosition");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPositionGreaterThan(String value) {
            addCriterion("guide_work_position >", value, "guideWorkPosition");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPositionGreaterThanOrEqualTo(String value) {
            addCriterion("guide_work_position >=", value, "guideWorkPosition");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPositionLessThan(String value) {
            addCriterion("guide_work_position <", value, "guideWorkPosition");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPositionLessThanOrEqualTo(String value) {
            addCriterion("guide_work_position <=", value, "guideWorkPosition");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPositionLike(String value) {
            addCriterion("guide_work_position like", value, "guideWorkPosition");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPositionNotLike(String value) {
            addCriterion("guide_work_position not like", value, "guideWorkPosition");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPositionIn(List<String> values) {
            addCriterion("guide_work_position in", values, "guideWorkPosition");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPositionNotIn(List<String> values) {
            addCriterion("guide_work_position not in", values, "guideWorkPosition");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPositionBetween(String value1, String value2) {
            addCriterion("guide_work_position between", value1, value2, "guideWorkPosition");
            return (Criteria) this;
        }

        public Criteria andGuideWorkPositionNotBetween(String value1, String value2) {
            addCriterion("guide_work_position not between", value1, value2, "guideWorkPosition");
            return (Criteria) this;
        }

        public Criteria andGuideWorkYearIsNull() {
            addCriterion("guide_work_year is null");
            return (Criteria) this;
        }

        public Criteria andGuideWorkYearIsNotNull() {
            addCriterion("guide_work_year is not null");
            return (Criteria) this;
        }

        public Criteria andGuideWorkYearEqualTo(Integer value) {
            addCriterion("guide_work_year =", value, "guideWorkYear");
            return (Criteria) this;
        }

        public Criteria andGuideWorkYearNotEqualTo(Integer value) {
            addCriterion("guide_work_year <>", value, "guideWorkYear");
            return (Criteria) this;
        }

        public Criteria andGuideWorkYearGreaterThan(Integer value) {
            addCriterion("guide_work_year >", value, "guideWorkYear");
            return (Criteria) this;
        }

        public Criteria andGuideWorkYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("guide_work_year >=", value, "guideWorkYear");
            return (Criteria) this;
        }

        public Criteria andGuideWorkYearLessThan(Integer value) {
            addCriterion("guide_work_year <", value, "guideWorkYear");
            return (Criteria) this;
        }

        public Criteria andGuideWorkYearLessThanOrEqualTo(Integer value) {
            addCriterion("guide_work_year <=", value, "guideWorkYear");
            return (Criteria) this;
        }

        public Criteria andGuideWorkYearIn(List<Integer> values) {
            addCriterion("guide_work_year in", values, "guideWorkYear");
            return (Criteria) this;
        }

        public Criteria andGuideWorkYearNotIn(List<Integer> values) {
            addCriterion("guide_work_year not in", values, "guideWorkYear");
            return (Criteria) this;
        }

        public Criteria andGuideWorkYearBetween(Integer value1, Integer value2) {
            addCriterion("guide_work_year between", value1, value2, "guideWorkYear");
            return (Criteria) this;
        }

        public Criteria andGuideWorkYearNotBetween(Integer value1, Integer value2) {
            addCriterion("guide_work_year not between", value1, value2, "guideWorkYear");
            return (Criteria) this;
        }

        public Criteria andGuideImageUrlIsNull() {
            addCriterion("guide_image_url is null");
            return (Criteria) this;
        }

        public Criteria andGuideImageUrlIsNotNull() {
            addCriterion("guide_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andGuideImageUrlEqualTo(String value) {
            addCriterion("guide_image_url =", value, "guideImageUrl");
            return (Criteria) this;
        }

        public Criteria andGuideImageUrlNotEqualTo(String value) {
            addCriterion("guide_image_url <>", value, "guideImageUrl");
            return (Criteria) this;
        }

        public Criteria andGuideImageUrlGreaterThan(String value) {
            addCriterion("guide_image_url >", value, "guideImageUrl");
            return (Criteria) this;
        }

        public Criteria andGuideImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("guide_image_url >=", value, "guideImageUrl");
            return (Criteria) this;
        }

        public Criteria andGuideImageUrlLessThan(String value) {
            addCriterion("guide_image_url <", value, "guideImageUrl");
            return (Criteria) this;
        }

        public Criteria andGuideImageUrlLessThanOrEqualTo(String value) {
            addCriterion("guide_image_url <=", value, "guideImageUrl");
            return (Criteria) this;
        }

        public Criteria andGuideImageUrlLike(String value) {
            addCriterion("guide_image_url like", value, "guideImageUrl");
            return (Criteria) this;
        }

        public Criteria andGuideImageUrlNotLike(String value) {
            addCriterion("guide_image_url not like", value, "guideImageUrl");
            return (Criteria) this;
        }

        public Criteria andGuideImageUrlIn(List<String> values) {
            addCriterion("guide_image_url in", values, "guideImageUrl");
            return (Criteria) this;
        }

        public Criteria andGuideImageUrlNotIn(List<String> values) {
            addCriterion("guide_image_url not in", values, "guideImageUrl");
            return (Criteria) this;
        }

        public Criteria andGuideImageUrlBetween(String value1, String value2) {
            addCriterion("guide_image_url between", value1, value2, "guideImageUrl");
            return (Criteria) this;
        }

        public Criteria andGuideImageUrlNotBetween(String value1, String value2) {
            addCriterion("guide_image_url not between", value1, value2, "guideImageUrl");
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