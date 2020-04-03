package com.genetech.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GoodsExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
     */
    public GoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
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
     * This method corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andAttachment_urlsIsNull() {
            addCriterion("attachment_urls is null");
            return (Criteria) this;
        }

        public Criteria andAttachment_urlsIsNotNull() {
            addCriterion("attachment_urls is not null");
            return (Criteria) this;
        }

        public Criteria andAttachment_urlsEqualTo(String value) {
            addCriterion("attachment_urls =", value, "attachment_urls");
            return (Criteria) this;
        }

        public Criteria andAttachment_urlsNotEqualTo(String value) {
            addCriterion("attachment_urls <>", value, "attachment_urls");
            return (Criteria) this;
        }

        public Criteria andAttachment_urlsGreaterThan(String value) {
            addCriterion("attachment_urls >", value, "attachment_urls");
            return (Criteria) this;
        }

        public Criteria andAttachment_urlsGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_urls >=", value, "attachment_urls");
            return (Criteria) this;
        }

        public Criteria andAttachment_urlsLessThan(String value) {
            addCriterion("attachment_urls <", value, "attachment_urls");
            return (Criteria) this;
        }

        public Criteria andAttachment_urlsLessThanOrEqualTo(String value) {
            addCriterion("attachment_urls <=", value, "attachment_urls");
            return (Criteria) this;
        }

        public Criteria andAttachment_urlsLike(String value) {
            addCriterion("attachment_urls like", value, "attachment_urls");
            return (Criteria) this;
        }

        public Criteria andAttachment_urlsNotLike(String value) {
            addCriterion("attachment_urls not like", value, "attachment_urls");
            return (Criteria) this;
        }

        public Criteria andAttachment_urlsIn(List<String> values) {
            addCriterion("attachment_urls in", values, "attachment_urls");
            return (Criteria) this;
        }

        public Criteria andAttachment_urlsNotIn(List<String> values) {
            addCriterion("attachment_urls not in", values, "attachment_urls");
            return (Criteria) this;
        }

        public Criteria andAttachment_urlsBetween(String value1, String value2) {
            addCriterion("attachment_urls between", value1, value2, "attachment_urls");
            return (Criteria) this;
        }

        public Criteria andAttachment_urlsNotBetween(String value1, String value2) {
            addCriterion("attachment_urls not between", value1, value2, "attachment_urls");
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

        public Criteria andProduct_codeIsNull() {
            addCriterion("product_code is null");
            return (Criteria) this;
        }

        public Criteria andProduct_codeIsNotNull() {
            addCriterion("product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_codeEqualTo(String value) {
            addCriterion("product_code =", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeNotEqualTo(String value) {
            addCriterion("product_code <>", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeGreaterThan(String value) {
            addCriterion("product_code >", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeGreaterThanOrEqualTo(String value) {
            addCriterion("product_code >=", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeLessThan(String value) {
            addCriterion("product_code <", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeLessThanOrEqualTo(String value) {
            addCriterion("product_code <=", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeLike(String value) {
            addCriterion("product_code like", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeNotLike(String value) {
            addCriterion("product_code not like", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeIn(List<String> values) {
            addCriterion("product_code in", values, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeNotIn(List<String> values) {
            addCriterion("product_code not in", values, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeBetween(String value1, String value2) {
            addCriterion("product_code between", value1, value2, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeNotBetween(String value1, String value2) {
            addCriterion("product_code not between", value1, value2, "product_code");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andGoods_codeIsNull() {
            addCriterion("goods_code is null");
            return (Criteria) this;
        }

        public Criteria andGoods_codeIsNotNull() {
            addCriterion("goods_code is not null");
            return (Criteria) this;
        }

        public Criteria andGoods_codeEqualTo(String value) {
            addCriterion("goods_code =", value, "goods_code");
            return (Criteria) this;
        }

        public Criteria andGoods_codeNotEqualTo(String value) {
            addCriterion("goods_code <>", value, "goods_code");
            return (Criteria) this;
        }

        public Criteria andGoods_codeGreaterThan(String value) {
            addCriterion("goods_code >", value, "goods_code");
            return (Criteria) this;
        }

        public Criteria andGoods_codeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_code >=", value, "goods_code");
            return (Criteria) this;
        }

        public Criteria andGoods_codeLessThan(String value) {
            addCriterion("goods_code <", value, "goods_code");
            return (Criteria) this;
        }

        public Criteria andGoods_codeLessThanOrEqualTo(String value) {
            addCriterion("goods_code <=", value, "goods_code");
            return (Criteria) this;
        }

        public Criteria andGoods_codeLike(String value) {
            addCriterion("goods_code like", value, "goods_code");
            return (Criteria) this;
        }

        public Criteria andGoods_codeNotLike(String value) {
            addCriterion("goods_code not like", value, "goods_code");
            return (Criteria) this;
        }

        public Criteria andGoods_codeIn(List<String> values) {
            addCriterion("goods_code in", values, "goods_code");
            return (Criteria) this;
        }

        public Criteria andGoods_codeNotIn(List<String> values) {
            addCriterion("goods_code not in", values, "goods_code");
            return (Criteria) this;
        }

        public Criteria andGoods_codeBetween(String value1, String value2) {
            addCriterion("goods_code between", value1, value2, "goods_code");
            return (Criteria) this;
        }

        public Criteria andGoods_codeNotBetween(String value1, String value2) {
            addCriterion("goods_code not between", value1, value2, "goods_code");
            return (Criteria) this;
        }

        public Criteria andProduct_idIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProduct_idIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_idEqualTo(Integer value) {
            addCriterion("product_id =", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idGreaterThan(Integer value) {
            addCriterion("product_id >", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idLessThan(Integer value) {
            addCriterion("product_id <", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idIn(List<Integer> values) {
            addCriterion("product_id in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "product_id");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_goods
     *
     * @mbg.generated do_not_delete_during_merge Wed Jan 01 22:09:08 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_goods
     *
     * @mbg.generated Wed Jan 01 22:09:08 CST 2020
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