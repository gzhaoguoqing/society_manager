package com.sm.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PostExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id_ is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id_ is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id_ =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id_ <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id_ >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id_ >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id_ <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id_ <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id_ like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id_ not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id_ in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id_ not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id_ between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id_ not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content_ is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content_ is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content_ =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content_ <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content_ >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content_ >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content_ <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content_ <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content_ like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content_ not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content_ in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content_ not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content_ between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content_ not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date_ is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date_ is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date_ =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date_ <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date_ >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date_ >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date_ <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date_ <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date_ in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date_ not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date_ between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date_ not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("author_id_ is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("author_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(String value) {
            addCriterion("author_id_ =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(String value) {
            addCriterion("author_id_ <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(String value) {
            addCriterion("author_id_ >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(String value) {
            addCriterion("author_id_ >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(String value) {
            addCriterion("author_id_ <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(String value) {
            addCriterion("author_id_ <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLike(String value) {
            addCriterion("author_id_ like", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotLike(String value) {
            addCriterion("author_id_ not like", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<String> values) {
            addCriterion("author_id_ in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<String> values) {
            addCriterion("author_id_ not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(String value1, String value2) {
            addCriterion("author_id_ between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(String value1, String value2) {
            addCriterion("author_id_ not between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andTopicIdsIsNull() {
            addCriterion("topic_ids_ is null");
            return (Criteria) this;
        }

        public Criteria andTopicIdsIsNotNull() {
            addCriterion("topic_ids_ is not null");
            return (Criteria) this;
        }

        public Criteria andTopicIdsEqualTo(String value) {
            addCriterion("topic_ids_ =", value, "topicIds");
            return (Criteria) this;
        }

        public Criteria andTopicIdsNotEqualTo(String value) {
            addCriterion("topic_ids_ <>", value, "topicIds");
            return (Criteria) this;
        }

        public Criteria andTopicIdsGreaterThan(String value) {
            addCriterion("topic_ids_ >", value, "topicIds");
            return (Criteria) this;
        }

        public Criteria andTopicIdsGreaterThanOrEqualTo(String value) {
            addCriterion("topic_ids_ >=", value, "topicIds");
            return (Criteria) this;
        }

        public Criteria andTopicIdsLessThan(String value) {
            addCriterion("topic_ids_ <", value, "topicIds");
            return (Criteria) this;
        }

        public Criteria andTopicIdsLessThanOrEqualTo(String value) {
            addCriterion("topic_ids_ <=", value, "topicIds");
            return (Criteria) this;
        }

        public Criteria andTopicIdsLike(String value) {
            addCriterion("topic_ids_ like", value, "topicIds");
            return (Criteria) this;
        }

        public Criteria andTopicIdsNotLike(String value) {
            addCriterion("topic_ids_ not like", value, "topicIds");
            return (Criteria) this;
        }

        public Criteria andTopicIdsIn(List<String> values) {
            addCriterion("topic_ids_ in", values, "topicIds");
            return (Criteria) this;
        }

        public Criteria andTopicIdsNotIn(List<String> values) {
            addCriterion("topic_ids_ not in", values, "topicIds");
            return (Criteria) this;
        }

        public Criteria andTopicIdsBetween(String value1, String value2) {
            addCriterion("topic_ids_ between", value1, value2, "topicIds");
            return (Criteria) this;
        }

        public Criteria andTopicIdsNotBetween(String value1, String value2) {
            addCriterion("topic_ids_ not between", value1, value2, "topicIds");
            return (Criteria) this;
        }

        public Criteria andImgPathsIsNull() {
            addCriterion("img_paths_ is null");
            return (Criteria) this;
        }

        public Criteria andImgPathsIsNotNull() {
            addCriterion("img_paths_ is not null");
            return (Criteria) this;
        }

        public Criteria andImgPathsEqualTo(String value) {
            addCriterion("img_paths_ =", value, "imgPaths");
            return (Criteria) this;
        }

        public Criteria andImgPathsNotEqualTo(String value) {
            addCriterion("img_paths_ <>", value, "imgPaths");
            return (Criteria) this;
        }

        public Criteria andImgPathsGreaterThan(String value) {
            addCriterion("img_paths_ >", value, "imgPaths");
            return (Criteria) this;
        }

        public Criteria andImgPathsGreaterThanOrEqualTo(String value) {
            addCriterion("img_paths_ >=", value, "imgPaths");
            return (Criteria) this;
        }

        public Criteria andImgPathsLessThan(String value) {
            addCriterion("img_paths_ <", value, "imgPaths");
            return (Criteria) this;
        }

        public Criteria andImgPathsLessThanOrEqualTo(String value) {
            addCriterion("img_paths_ <=", value, "imgPaths");
            return (Criteria) this;
        }

        public Criteria andImgPathsLike(String value) {
            addCriterion("img_paths_ like", value, "imgPaths");
            return (Criteria) this;
        }

        public Criteria andImgPathsNotLike(String value) {
            addCriterion("img_paths_ not like", value, "imgPaths");
            return (Criteria) this;
        }

        public Criteria andImgPathsIn(List<String> values) {
            addCriterion("img_paths_ in", values, "imgPaths");
            return (Criteria) this;
        }

        public Criteria andImgPathsNotIn(List<String> values) {
            addCriterion("img_paths_ not in", values, "imgPaths");
            return (Criteria) this;
        }

        public Criteria andImgPathsBetween(String value1, String value2) {
            addCriterion("img_paths_ between", value1, value2, "imgPaths");
            return (Criteria) this;
        }

        public Criteria andImgPathsNotBetween(String value1, String value2) {
            addCriterion("img_paths_ not between", value1, value2, "imgPaths");
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