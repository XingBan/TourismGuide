package com.guide.bean;

import java.util.ArrayList;
import java.util.List;

public class CommentatorAwardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentatorAwardExample() {
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

        public Criteria andCommentatorAwardIdIsNull() {
            addCriterion("commentator_award_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardIdIsNotNull() {
            addCriterion("commentator_award_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardIdEqualTo(Integer value) {
            addCriterion("commentator_award_id =", value, "commentatorAwardId");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardIdNotEqualTo(Integer value) {
            addCriterion("commentator_award_id <>", value, "commentatorAwardId");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardIdGreaterThan(Integer value) {
            addCriterion("commentator_award_id >", value, "commentatorAwardId");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentator_award_id >=", value, "commentatorAwardId");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardIdLessThan(Integer value) {
            addCriterion("commentator_award_id <", value, "commentatorAwardId");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardIdLessThanOrEqualTo(Integer value) {
            addCriterion("commentator_award_id <=", value, "commentatorAwardId");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardIdIn(List<Integer> values) {
            addCriterion("commentator_award_id in", values, "commentatorAwardId");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardIdNotIn(List<Integer> values) {
            addCriterion("commentator_award_id not in", values, "commentatorAwardId");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardIdBetween(Integer value1, Integer value2) {
            addCriterion("commentator_award_id between", value1, value2, "commentatorAwardId");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("commentator_award_id not between", value1, value2, "commentatorAwardId");
            return (Criteria) this;
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

        public Criteria andCommentatorAwardYearIsNull() {
            addCriterion("commentator_award_year is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardYearIsNotNull() {
            addCriterion("commentator_award_year is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardYearEqualTo(String value) {
            addCriterion("commentator_award_year =", value, "commentatorAwardYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardYearNotEqualTo(String value) {
            addCriterion("commentator_award_year <>", value, "commentatorAwardYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardYearGreaterThan(String value) {
            addCriterion("commentator_award_year >", value, "commentatorAwardYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardYearGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_award_year >=", value, "commentatorAwardYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardYearLessThan(String value) {
            addCriterion("commentator_award_year <", value, "commentatorAwardYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardYearLessThanOrEqualTo(String value) {
            addCriterion("commentator_award_year <=", value, "commentatorAwardYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardYearLike(String value) {
            addCriterion("commentator_award_year like", value, "commentatorAwardYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardYearNotLike(String value) {
            addCriterion("commentator_award_year not like", value, "commentatorAwardYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardYearIn(List<String> values) {
            addCriterion("commentator_award_year in", values, "commentatorAwardYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardYearNotIn(List<String> values) {
            addCriterion("commentator_award_year not in", values, "commentatorAwardYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardYearBetween(String value1, String value2) {
            addCriterion("commentator_award_year between", value1, value2, "commentatorAwardYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardYearNotBetween(String value1, String value2) {
            addCriterion("commentator_award_year not between", value1, value2, "commentatorAwardYear");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardNameIsNull() {
            addCriterion("commentator_award_name is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardNameIsNotNull() {
            addCriterion("commentator_award_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardNameEqualTo(String value) {
            addCriterion("commentator_award_name =", value, "commentatorAwardName");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardNameNotEqualTo(String value) {
            addCriterion("commentator_award_name <>", value, "commentatorAwardName");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardNameGreaterThan(String value) {
            addCriterion("commentator_award_name >", value, "commentatorAwardName");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardNameGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_award_name >=", value, "commentatorAwardName");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardNameLessThan(String value) {
            addCriterion("commentator_award_name <", value, "commentatorAwardName");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardNameLessThanOrEqualTo(String value) {
            addCriterion("commentator_award_name <=", value, "commentatorAwardName");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardNameLike(String value) {
            addCriterion("commentator_award_name like", value, "commentatorAwardName");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardNameNotLike(String value) {
            addCriterion("commentator_award_name not like", value, "commentatorAwardName");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardNameIn(List<String> values) {
            addCriterion("commentator_award_name in", values, "commentatorAwardName");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardNameNotIn(List<String> values) {
            addCriterion("commentator_award_name not in", values, "commentatorAwardName");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardNameBetween(String value1, String value2) {
            addCriterion("commentator_award_name between", value1, value2, "commentatorAwardName");
            return (Criteria) this;
        }

        public Criteria andCommentatorAwardNameNotBetween(String value1, String value2) {
            addCriterion("commentator_award_name not between", value1, value2, "commentatorAwardName");
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