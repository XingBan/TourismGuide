package com.guide.bean;

import java.util.ArrayList;
import java.util.List;

public class GuideAwardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuideAwardExample() {
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

        public Criteria andGuideAwardIdIsNull() {
            addCriterion("guide_award_id is null");
            return (Criteria) this;
        }

        public Criteria andGuideAwardIdIsNotNull() {
            addCriterion("guide_award_id is not null");
            return (Criteria) this;
        }

        public Criteria andGuideAwardIdEqualTo(Integer value) {
            addCriterion("guide_award_id =", value, "guideAwardId");
            return (Criteria) this;
        }

        public Criteria andGuideAwardIdNotEqualTo(Integer value) {
            addCriterion("guide_award_id <>", value, "guideAwardId");
            return (Criteria) this;
        }

        public Criteria andGuideAwardIdGreaterThan(Integer value) {
            addCriterion("guide_award_id >", value, "guideAwardId");
            return (Criteria) this;
        }

        public Criteria andGuideAwardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("guide_award_id >=", value, "guideAwardId");
            return (Criteria) this;
        }

        public Criteria andGuideAwardIdLessThan(Integer value) {
            addCriterion("guide_award_id <", value, "guideAwardId");
            return (Criteria) this;
        }

        public Criteria andGuideAwardIdLessThanOrEqualTo(Integer value) {
            addCriterion("guide_award_id <=", value, "guideAwardId");
            return (Criteria) this;
        }

        public Criteria andGuideAwardIdIn(List<Integer> values) {
            addCriterion("guide_award_id in", values, "guideAwardId");
            return (Criteria) this;
        }

        public Criteria andGuideAwardIdNotIn(List<Integer> values) {
            addCriterion("guide_award_id not in", values, "guideAwardId");
            return (Criteria) this;
        }

        public Criteria andGuideAwardIdBetween(Integer value1, Integer value2) {
            addCriterion("guide_award_id between", value1, value2, "guideAwardId");
            return (Criteria) this;
        }

        public Criteria andGuideAwardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("guide_award_id not between", value1, value2, "guideAwardId");
            return (Criteria) this;
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

        public Criteria andGuideAwardYearIsNull() {
            addCriterion("guide_award_year is null");
            return (Criteria) this;
        }

        public Criteria andGuideAwardYearIsNotNull() {
            addCriterion("guide_award_year is not null");
            return (Criteria) this;
        }

        public Criteria andGuideAwardYearEqualTo(String value) {
            addCriterion("guide_award_year =", value, "guideAwardYear");
            return (Criteria) this;
        }

        public Criteria andGuideAwardYearNotEqualTo(String value) {
            addCriterion("guide_award_year <>", value, "guideAwardYear");
            return (Criteria) this;
        }

        public Criteria andGuideAwardYearGreaterThan(String value) {
            addCriterion("guide_award_year >", value, "guideAwardYear");
            return (Criteria) this;
        }

        public Criteria andGuideAwardYearGreaterThanOrEqualTo(String value) {
            addCriterion("guide_award_year >=", value, "guideAwardYear");
            return (Criteria) this;
        }

        public Criteria andGuideAwardYearLessThan(String value) {
            addCriterion("guide_award_year <", value, "guideAwardYear");
            return (Criteria) this;
        }

        public Criteria andGuideAwardYearLessThanOrEqualTo(String value) {
            addCriterion("guide_award_year <=", value, "guideAwardYear");
            return (Criteria) this;
        }

        public Criteria andGuideAwardYearLike(String value) {
            addCriterion("guide_award_year like", value, "guideAwardYear");
            return (Criteria) this;
        }

        public Criteria andGuideAwardYearNotLike(String value) {
            addCriterion("guide_award_year not like", value, "guideAwardYear");
            return (Criteria) this;
        }

        public Criteria andGuideAwardYearIn(List<String> values) {
            addCriterion("guide_award_year in", values, "guideAwardYear");
            return (Criteria) this;
        }

        public Criteria andGuideAwardYearNotIn(List<String> values) {
            addCriterion("guide_award_year not in", values, "guideAwardYear");
            return (Criteria) this;
        }

        public Criteria andGuideAwardYearBetween(String value1, String value2) {
            addCriterion("guide_award_year between", value1, value2, "guideAwardYear");
            return (Criteria) this;
        }

        public Criteria andGuideAwardYearNotBetween(String value1, String value2) {
            addCriterion("guide_award_year not between", value1, value2, "guideAwardYear");
            return (Criteria) this;
        }

        public Criteria andGuideAwardNameIsNull() {
            addCriterion("guide_award_name is null");
            return (Criteria) this;
        }

        public Criteria andGuideAwardNameIsNotNull() {
            addCriterion("guide_award_name is not null");
            return (Criteria) this;
        }

        public Criteria andGuideAwardNameEqualTo(String value) {
            addCriterion("guide_award_name =", value, "guideAwardName");
            return (Criteria) this;
        }

        public Criteria andGuideAwardNameNotEqualTo(String value) {
            addCriterion("guide_award_name <>", value, "guideAwardName");
            return (Criteria) this;
        }

        public Criteria andGuideAwardNameGreaterThan(String value) {
            addCriterion("guide_award_name >", value, "guideAwardName");
            return (Criteria) this;
        }

        public Criteria andGuideAwardNameGreaterThanOrEqualTo(String value) {
            addCriterion("guide_award_name >=", value, "guideAwardName");
            return (Criteria) this;
        }

        public Criteria andGuideAwardNameLessThan(String value) {
            addCriterion("guide_award_name <", value, "guideAwardName");
            return (Criteria) this;
        }

        public Criteria andGuideAwardNameLessThanOrEqualTo(String value) {
            addCriterion("guide_award_name <=", value, "guideAwardName");
            return (Criteria) this;
        }

        public Criteria andGuideAwardNameLike(String value) {
            addCriterion("guide_award_name like", value, "guideAwardName");
            return (Criteria) this;
        }

        public Criteria andGuideAwardNameNotLike(String value) {
            addCriterion("guide_award_name not like", value, "guideAwardName");
            return (Criteria) this;
        }

        public Criteria andGuideAwardNameIn(List<String> values) {
            addCriterion("guide_award_name in", values, "guideAwardName");
            return (Criteria) this;
        }

        public Criteria andGuideAwardNameNotIn(List<String> values) {
            addCriterion("guide_award_name not in", values, "guideAwardName");
            return (Criteria) this;
        }

        public Criteria andGuideAwardNameBetween(String value1, String value2) {
            addCriterion("guide_award_name between", value1, value2, "guideAwardName");
            return (Criteria) this;
        }

        public Criteria andGuideAwardNameNotBetween(String value1, String value2) {
            addCriterion("guide_award_name not between", value1, value2, "guideAwardName");
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