package com.chunmi.vote.service;

import java.util.List;

import com.chunmi.vote.po.VoteGroup;

public interface VoteGroupService {
	
	/**
	 * 查询所有分组
	 * @return
	 */
	List<VoteGroup> selectVoteGroupList();
}
