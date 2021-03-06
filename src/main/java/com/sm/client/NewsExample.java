package com.sm.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewsExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title_ is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title_ is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title_ =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title_ <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title_ >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title_ >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title_ <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title_ <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title_ like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title_ not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title_ in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title_ not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title_ between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title_ not between", value1, value2, "title");
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

        public Criteria andClicksIsNull() {
            addCriterion("clicks_ is null");
            return (Criteria) this;
        }

        public Criteria andClicksIsNotNull() {
            addCriterion("clicks_ is not null");
            return (Criteria) this;
        }

        public Criteria andClicksEqualTo(Integer value) {
            addCriterion("clicks_ =", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotEqualTo(Integer value) {
            addCriterion("clicks_ <>", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksGreaterThan(Integer value) {
            addCriterion("clicks_ >", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksGreaterThanOrEqualTo(Integer value) {
            addCriterion("clicks_ >=", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksLessThan(Integer value) {
            addCriterion("clicks_ <", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksLessThanOrEqualTo(Integer value) {
            addCriterion("clicks_ <=", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksIn(List<Integer> values) {
            addCriterion("clicks_ in", values, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotIn(List<Integer> values) {
            addCriterion("clicks_ not in", values, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksBetween(Integer value1, Integer value2) {
            addCriterion("clicks_ between", value1, value2, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotBetween(Integer value1, Integer value2) {
            addCriterion("clicks_ not between", value1, value2, "clicks");
            return (Criteria) this;
        }

        public Criteria andImportantIsNull() {
            addCriterion("important_ is null");
            return (Criteria) this;
        }

        public Criteria andImportantIsNotNull() {
            addCriterion("important_ is not null");
            return (Criteria) this;
        }

        public Criteria andImportantEqualTo(Integer value) {
            addCriterion("important_ =", value, "important");
            return (Criteria) this;
        }

        public Criteria andImportantNotEqualTo(Integer value) {
            addCriterion("important_ <>", value, "important");
            return (Criteria) this;
        }

        public Criteria andImportantGreaterThan(Integer value) {
            addCriterion("important_ >", value, "important");
            return (Criteria) this;
        }

        public Criteria andImportantGreaterThanOrEqualTo(Integer value) {
            addCriterion("important_ >=", value, "important");
            return (Criteria) this;
        }

        public Criteria andImportantLessThan(Integer value) {
            addCriterion("important_ <", value, "important");
            return (Criteria) this;
        }

        public Criteria andImportantLessThanOrEqualTo(Integer value) {
            addCriterion("important_ <=", value, "important");
            return (Criteria) this;
        }

        public Criteria andImportantIn(List<Integer> values) {
            addCriterion("important_ in", values, "important");
            return (Criteria) this;
        }

        public Criteria andImportantNotIn(List<Integer> values) {
            addCriterion("important_ not in", values, "important");
            return (Criteria) this;
        }

        public Criteria andImportantBetween(Integer value1, Integer value2) {
            addCriterion("important_ between", value1, value2, "important");
            return (Criteria) this;
        }

        public Criteria andImportantNotBetween(Integer value1, Integer value2) {
            addCriterion("important_ not between", value1, value2, "important");
            return (Criteria) this;
        }

        public Criteria andImportantImgPathIsNull() {
            addCriterion("important_img_path_ is null");
            return (Criteria) this;
        }

        public Criteria andImportantImgPathIsNotNull() {
            addCriterion("important_img_path_ is not null");
            return (Criteria) this;
        }

        public Criteria andImportantImgPathEqualTo(String value) {
            addCriterion("important_img_path_ =", value, "importantImgPath");
            return (Criteria) this;
        }

        public Criteria andImportantImgPathNotEqualTo(String value) {
            addCriterion("important_img_path_ <>", value, "importantImgPath");
            return (Criteria) this;
        }

        public Criteria andImportantImgPathGreaterThan(String value) {
            addCriterion("important_img_path_ >", value, "importantImgPath");
            return (Criteria) this;
        }

        public Criteria andImportantImgPathGreaterThanOrEqualTo(String value) {
            addCriterion("important_img_path_ >=", value, "importantImgPath");
            return (Criteria) this;
        }

        public Criteria andImportantImgPathLessThan(String value) {
            addCriterion("important_img_path_ <", value, "importantImgPath");
            return (Criteria) this;
        }

        public Criteria andImportantImgPathLessThanOrEqualTo(String value) {
            addCriterion("important_img_path_ <=", value, "importantImgPath");
            return (Criteria) this;
        }

        public Criteria andImportantImgPathLike(String value) {
            addCriterion("important_img_path_ like", value, "importantImgPath");
            return (Criteria) this;
        }

        public Criteria andImportantImgPathNotLike(String value) {
            addCriterion("important_img_path_ not like", value, "importantImgPath");
            return (Criteria) this;
        }

        public Criteria andImportantImgPathIn(List<String> values) {
            addCriterion("important_img_path_ in", values, "importantImgPath");
            return (Criteria) this;
        }

        public Criteria andImportantImgPathNotIn(List<String> values) {
            addCriterion("important_img_path_ not in", values, "importantImgPath");
            return (Criteria) this;
        }

        public Criteria andImportantImgPathBetween(String value1, String value2) {
            addCriterion("important_img_path_ between", value1, value2, "importantImgPath");
            return (Criteria) this;
        }

        public Criteria andImportantImgPathNotBetween(String value1, String value2) {
            addCriterion("important_img_path_ not between", value1, value2, "importantImgPath");
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