package com.genetech.dao;

import com.genetech.bean.VoteRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface VoteRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote_record
     *
     * @mbggenerated Wed Oct 16 14:22:12 CST 2019
     */
    int insert(VoteRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote_record
     *
     * @mbggenerated Wed Oct 16 14:22:12 CST 2019
     */
    List<VoteRecord> selectAll();


    /**
     * 查询是否投过票
     */
    Integer selectVoteRecord(Integer loginId);
}