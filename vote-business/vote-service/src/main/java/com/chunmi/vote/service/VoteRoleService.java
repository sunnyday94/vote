package com.chunmi.vote.service;

import java.util.List;

import com.chunmi.vote.po.VoteRole;

public interface VoteRoleService {
	
	/**
	 * 查询所有角色
	 * @return
	 */
	List<VoteRole> selectVoteRoleList();
}
