package com.sm.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityExample() {
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

        public Criteria andFilePathsIsNull() {
            addCriterion("file_paths_ is null");
            return (Criteria) this;
        }

        public Criteria andFilePathsIsNotNull() {
            addCriterion("file_paths_ is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathsEqualTo(String value) {
            addCriterion("file_paths_ =", value, "filePaths");
            return (Criteria) this;
        }

        public Criteria andFilePathsNotEqualTo(String value) {
            addCriterion("file_paths_ <>", value, "filePaths");
            return (Criteria) this;
        }

        public Criteria andFilePathsGreaterThan(String value) {
            addCriterion("file_paths_ >", value, "filePaths");
            return (Criteria) this;
        }

        public Criteria andFilePathsGreaterThanOrEqualTo(String value) {
            addCriterion("file_paths_ >=", value, "filePaths");
            return (Criteria) this;
        }

        public Criteria andFilePathsLessThan(String value) {
            addCriterion("file_paths_ <", value, "filePaths");
            return (Criteria) this;
        }

        public Criteria andFilePathsLessThanOrEqualTo(String value) {
            addCriterion("file_paths_ <=", value, "filePaths");
            return (Criteria) this;
        }

        public Criteria andFilePathsLike(String value) {
            addCriterion("file_paths_ like", value, "filePaths");
            return (Criteria) this;
        }

        public Criteria andFilePathsNotLike(String value) {
            addCriterion("file_paths_ not like", value, "filePaths");
            return (Criteria) this;
        }

        public Criteria andFilePathsIn(List<String> values) {
            addCriterion("file_paths_ in", values, "filePaths");
            return (Criteria) this;
        }

        public Criteria andFilePathsNotIn(List<String> values) {
            addCriterion("file_paths_ not in", values, "filePaths");
            return (Criteria) this;
        }

        public Criteria andFilePathsBetween(String value1, String value2) {
            addCriterion("file_paths_ between", value1, value2, "filePaths");
            return (Criteria) this;
        }

        public Criteria andFilePathsNotBetween(String value1, String value2) {
            addCriterion("file_paths_ not between", value1, value2, "filePaths");
            return (Criteria) this;
        }

        public Criteria andParticipantorsIsNull() {
            addCriterion("participantors_ is null");
            return (Criteria) this;
        }

        public Criteria andParticipantorsIsNotNull() {
            addCriterion("participantors_ is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantorsEqualTo(String value) {
            addCriterion("participantors_ =", value, "participantors");
            return (Criteria) this;
        }

        public Criteria andParticipantorsNotEqualTo(String value) {
            addCriterion("participantors_ <>", value, "participantors");
            return (Criteria) this;
        }

        public Criteria andParticipantorsGreaterThan(String value) {
            addCriterion("participantors_ >", value, "participantors");
            return (Criteria) this;
        }

        public Criteria andParticipantorsGreaterThanOrEqualTo(String value) {
            addCriterion("participantors_ >=", value, "participantors");
            return (Criteria) this;
        }

        public Criteria andParticipantorsLessThan(String value) {
            addCriterion("participantors_ <", value, "participantors");
            return (Criteria) this;
        }

        public Criteria andParticipantorsLessThanOrEqualTo(String value) {
            addCriterion("participantors_ <=", value, "participantors");
            return (Criteria) this;
        }

        public Criteria andParticipantorsLike(String value) {
            addCriterion("participantors_ like", value, "participantors");
            return (Criteria) this;
        }

        public Criteria andParticipantorsNotLike(String value) {
            addCriterion("participantors_ not like", value, "participantors");
            return (Criteria) this;
        }

        public Criteria andParticipantorsIn(List<String> values) {
            addCriterion("participantors_ in", values, "participantors");
            return (Criteria) this;
        }

        public Criteria andParticipantorsNotIn(List<String> values) {
            addCriterion("participantors_ not in", values, "participantors");
            return (Criteria) this;
        }

        public Criteria andParticipantorsBetween(String value1, String value2) {
            addCriterion("participantors_ between", value1, value2, "participantors");
            return (Criteria) this;
        }

        public Criteria andParticipantorsNotBetween(String value1, String value2) {
            addCriterion("participantors_ not between", value1, value2, "participantors");
            return (Criteria) this;
        }

        public Criteria andApplyUpIsNull() {
            addCriterion("apply_up_ is null");
            return (Criteria) this;
        }

        public Criteria andApplyUpIsNotNull() {
            addCriterion("apply_up_ is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUpEqualTo(Integer value) {
            addCriterion("apply_up_ =", value, "applyUp");
            return (Criteria) this;
        }

        public Criteria andApplyUpNotEqualTo(Integer value) {
            addCriterion("apply_up_ <>", value, "applyUp");
            return (Criteria) this;
        }

        public Criteria andApplyUpGreaterThan(Integer value) {
            addCriterion("apply_up_ >", value, "applyUp");
            return (Criteria) this;
        }

        public Criteria andApplyUpGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_up_ >=", value, "applyUp");
            return (Criteria) this;
        }

        public Criteria andApplyUpLessThan(Integer value) {
            addCriterion("apply_up_ <", value, "applyUp");
            return (Criteria) this;
        }

        public Criteria andApplyUpLessThanOrEqualTo(Integer value) {
            addCriterion("apply_up_ <=", value, "applyUp");
            return (Criteria) this;
        }

        public Criteria andApplyUpIn(List<Integer> values) {
            addCriterion("apply_up_ in", values, "applyUp");
            return (Criteria) this;
        }

        public Criteria andApplyUpNotIn(List<Integer> values) {
            addCriterion("apply_up_ not in", values, "applyUp");
            return (Criteria) this;
        }

        public Criteria andApplyUpBetween(Integer value1, Integer value2) {
            addCriterion("apply_up_ between", value1, value2, "applyUp");
            return (Criteria) this;
        }

        public Criteria andApplyUpNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_up_ not between", value1, value2, "applyUp");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeIsNull() {
            addCriterion("apply_start_time_ is null");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeIsNotNull() {
            addCriterion("apply_start_time_ is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeEqualTo(Date value) {
            addCriterion("apply_start_time_ =", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeNotEqualTo(Date value) {
            addCriterion("apply_start_time_ <>", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeGreaterThan(Date value) {
            addCriterion("apply_start_time_ >", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_start_time_ >=", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeLessThan(Date value) {
            addCriterion("apply_start_time_ <", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_start_time_ <=", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeIn(List<Date> values) {
            addCriterion("apply_start_time_ in", values, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeNotIn(List<Date> values) {
            addCriterion("apply_start_time_ not in", values, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeBetween(Date value1, Date value2) {
            addCriterion("apply_start_time_ between", value1, value2, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_start_time_ not between", value1, value2, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeIsNull() {
            addCriterion("apply_end_time_ is null");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeIsNotNull() {
            addCriterion("apply_end_time_ is not null");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeEqualTo(Date value) {
            addCriterion("apply_end_time_ =", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeNotEqualTo(Date value) {
            addCriterion("apply_end_time_ <>", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeGreaterThan(Date value) {
            addCriterion("apply_end_time_ >", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_end_time_ >=", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeLessThan(Date value) {
            addCriterion("apply_end_time_ <", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_end_time_ <=", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeIn(List<Date> values) {
            addCriterion("apply_end_time_ in", values, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeNotIn(List<Date> values) {
            addCriterion("apply_end_time_ not in", values, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeBetween(Date value1, Date value2) {
            addCriterion("apply_end_time_ between", value1, value2, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_end_time_ not between", value1, value2, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andLabelsIsNull() {
            addCriterion("labels_ is null");
            return (Criteria) this;
        }

        public Criteria andLabelsIsNotNull() {
            addCriterion("labels_ is not null");
            return (Criteria) this;
        }

        public Criteria andLabelsEqualTo(String value) {
            addCriterion("labels_ =", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsNotEqualTo(String value) {
            addCriterion("labels_ <>", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsGreaterThan(String value) {
            addCriterion("labels_ >", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsGreaterThanOrEqualTo(String value) {
            addCriterion("labels_ >=", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsLessThan(String value) {
            addCriterion("labels_ <", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsLessThanOrEqualTo(String value) {
            addCriterion("labels_ <=", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsLike(String value) {
            addCriterion("labels_ like", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsNotLike(String value) {
            addCriterion("labels_ not like", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsIn(List<String> values) {
            addCriterion("labels_ in", values, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsNotIn(List<String> values) {
            addCriterion("labels_ not in", values, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsBetween(String value1, String value2) {
            addCriterion("labels_ between", value1, value2, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsNotBetween(String value1, String value2) {
            addCriterion("labels_ not between", value1, value2, "labels");
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