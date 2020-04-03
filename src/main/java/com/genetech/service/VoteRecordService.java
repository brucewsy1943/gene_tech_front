package com.genetech.service;

import com.genetech.bean.VoteRecord;

public interface VoteRecordService {

        Integer insertRecord(VoteRecord voteRecord);

        /**
         * 判断是否投过投票
         */
        boolean isEmployeeVoted(Integer loginId);

}
