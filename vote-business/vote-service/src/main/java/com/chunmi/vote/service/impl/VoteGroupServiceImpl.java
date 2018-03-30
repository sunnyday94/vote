package com.chunmi.vote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chunmi.vote.dao.VoteGroupMapper;
import com.chunmi.vote.po.VoteGroup;
import com.chunmi.vote.service.VoteGroupService;

@Service
@Transactional
public class VoteGroupServiceImpl implements VoteGroupService {
	
	@Autowired
	private VoteGroupMapper voteGroupMapper;

	@Override
	@Cacheable(value="voteGroupList")
	public List<VoteGroup> selectVoteGroupList() {
		return voteGroupMapper.selectVoteGroupList();
	}

}
