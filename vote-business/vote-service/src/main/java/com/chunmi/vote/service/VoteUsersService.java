package com.chunmi.vote.service;

import com.chunmi.vote.po.VoteUsers;
import com.chunmi.vote.utils.PageBean;

public interface VoteUsersService {
	VoteUsers selectVoteUsersByName(String userName);

	Integer addVoteUser(VoteUsers voteUser);
	
	PageBean<VoteUsers> selectVoteUsers(Integer pageCurrent, Integer pageSize, Integer pageCount);

	Integer updateUserStatus(VoteUsers voteUser);

	Integer updateRole(VoteUsers voteUser);

	Integer updateGroup(VoteUsers voteUser);

	VoteUsers selectVoteUsersById(Long id);
}
