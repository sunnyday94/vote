package com.chunmi.vote.service;

import com.chunmi.vote.po.VoteUsers;
import com.chunmi.vote.utils.PageBean;
import com.chunmi.vote.vo.UserQueryVo;
import com.chunmi.vote.vo.VoteUsersResp;

public interface VoteUsersService {
	VoteUsers selectVoteUsersByName(String userName);

	Integer addVoteUser(VoteUsers voteUser);
	
	PageBean<VoteUsersResp> selectVoteUsers(Integer pageCurrent, Integer pageSize, Integer pageCount, UserQueryVo userQueryVo);

	Integer updateUserStatus(VoteUsers voteUser);

	Integer updateRole(VoteUsers voteUser);

	Integer updateGroup(VoteUsers voteUser);

	VoteUsers selectVoteUsersById(Long id);
}
