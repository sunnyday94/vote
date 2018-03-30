package com.chunmi.vote.service;

import com.chunmi.vote.po.VoteRecord;

public interface VoteRecordService {
	/**
	 * 查找投票的限制次数
	 * @param voteRecord
	 * @return
	 */
	Long selectLimitVoteCounts(VoteRecord voteRecord);

	/**
	 * 新增投票记录
	 * @param voteRecord
	 * @return
	 */
	Integer saveVoteRecord(VoteRecord voteRecord);
}
