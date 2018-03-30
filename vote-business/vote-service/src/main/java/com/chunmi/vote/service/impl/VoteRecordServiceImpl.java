package com.chunmi.vote.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chunmi.vote.dao.VoteRecordMapper;
import com.chunmi.vote.po.VoteRecord;
import com.chunmi.vote.service.VoteRecordService;

@Service
public class VoteRecordServiceImpl implements VoteRecordService {
	
	@Autowired
	private VoteRecordMapper voteRecordMapper;

	@Override
	public Long selectLimitVoteCounts(VoteRecord voteRecord) {
		return voteRecordMapper.selectLimitVoteCounts(voteRecord);
	}

	@Override
	public Integer saveVoteRecord(VoteRecord voteRecord) {
		return voteRecordMapper.insertSelective(voteRecord);
	}

}
