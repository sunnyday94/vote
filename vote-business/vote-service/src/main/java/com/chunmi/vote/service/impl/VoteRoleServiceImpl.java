package com.chunmi.vote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chunmi.vote.dao.VoteRoleMapper;
import com.chunmi.vote.po.VoteRole;
import com.chunmi.vote.service.VoteRoleService;

@Service
@Transactional
public class VoteRoleServiceImpl implements VoteRoleService {
	
	@Autowired
	private VoteRoleMapper voteRoleMapper;

	@Override
	@Cacheable(value="voteRoleList")
	public List<VoteRole> selectVoteRoleList() {
		return voteRoleMapper.selectVoteRoleList();
	}

}
