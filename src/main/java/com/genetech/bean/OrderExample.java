package com.genetech.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public OrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
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
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
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

        public Criteria andAddress_idIsNull() {
            addCriterion("address_id is null");
            return (Criteria) this;
        }

        public Criteria andAddress_idIsNotNull() {
            addCriterion("address_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddress_idEqualTo(Integer value) {
            addCriterion("address_id =", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idNotEqualTo(Integer value) {
            addCriterion("address_id <>", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idGreaterThan(Integer value) {
            addCriterion("address_id >", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("address_id >=", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idLessThan(Integer value) {
            addCriterion("address_id <", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idLessThanOrEqualTo(Integer value) {
            addCriterion("address_id <=", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idIn(List<Integer> values) {
            addCriterion("address_id in", values, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idNotIn(List<Integer> values) {
            addCriterion("address_id not in", values, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idBetween(Integer value1, Integer value2) {
            addCriterion("address_id between", value1, value2, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idNotBetween(Integer value1, Integer value2) {
            addCriterion("address_id not between", value1, value2, "address_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Integer value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Integer value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Integer value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Integer> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOrder_numberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrder_numberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_numberEqualTo(String value) {
            addCriterion("order_number =", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberGreaterThan(String value) {
            addCriterion("order_number >", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberLessThan(String value) {
            addCriterion("order_number <", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberLike(String value) {
            addCriterion("order_number like", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberNotLike(String value) {
            addCriterion("order_number not like", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberIn(List<String> values) {
            addCriterion("order_number in", values, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "order_number");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andInvoice_idIsNull() {
            addCriterion("invoice_id is null");
            return (Criteria) this;
        }

        public Criteria andInvoice_idIsNotNull() {
            addCriterion("invoice_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvoice_idEqualTo(Integer value) {
            addCriterion("invoice_id =", value, "invoice_id");
            return (Criteria) this;
        }

        public Criteria andInvoice_idNotEqualTo(Integer value) {
            addCriterion("invoice_id <>", value, "invoice_id");
            return (Criteria) this;
        }

        public Criteria andInvoice_idGreaterThan(Integer value) {
            addCriterion("invoice_id >", value, "invoice_id");
            return (Criteria) this;
        }

        public Criteria andInvoice_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoice_id >=", value, "invoice_id");
            return (Criteria) this;
        }

        public Criteria andInvoice_idLessThan(Integer value) {
            addCriterion("invoice_id <", value, "invoice_id");
            return (Criteria) this;
        }

        public Criteria andInvoice_idLessThanOrEqualTo(Integer value) {
            addCriterion("invoice_id <=", value, "invoice_id");
            return (Criteria) this;
        }

        public Criteria andInvoice_idIn(List<Integer> values) {
            addCriterion("invoice_id in", values, "invoice_id");
            return (Criteria) this;
        }

        public Criteria andInvoice_idNotIn(List<Integer> values) {
            addCriterion("invoice_id not in", values, "invoice_id");
            return (Criteria) this;
        }

        public Criteria andInvoice_idBetween(Integer value1, Integer value2) {
            addCriterion("invoice_id between", value1, value2, "invoice_id");
            return (Criteria) this;
        }

        public Criteria andInvoice_idNotBetween(Integer value1, Integer value2) {
            addCriterion("invoice_id not between", value1, value2, "invoice_id");
            return (Criteria) this;
        }

        public Criteria andPay_typeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPay_typeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPay_typeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPay_typeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPay_typeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPay_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPay_typeLessThan(Integer value) {
            addCriterion("pay_type <", value, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPay_typeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPay_typeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPay_typeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPay_typeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPay_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "pay_type");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_order
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 16 17:08:34 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_order
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
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