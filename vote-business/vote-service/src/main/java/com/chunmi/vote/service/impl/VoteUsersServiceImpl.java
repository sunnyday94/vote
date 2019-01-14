package com.chunmi.vote.service.impl;

import java.util.List;

import com.chunmi.vote.vo.UserQueryVo;
import com.chunmi.vote.vo.VoteUsersResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chunmi.vote.dao.VoteUsersMapper;
import com.chunmi.vote.po.VoteUsers;
import com.chunmi.vote.service.VoteUsersService;
import com.chunmi.vote.utils.PageBean;
import com.chunmi.vote.utils.PageRequest;

@Service
@Transactional
public class VoteUsersServiceImpl implements VoteUsersService{
	
	@Autowired
	private VoteUsersMapper voteUsersMapper;

	@Override
	public VoteUsers selectVoteUsersByName(String userName) {
		return voteUsersMapper.selectVoteByName(userName);
	}

	@Override
	public Integer addVoteUser(VoteUsers voteUser) {
		return voteUsersMapper.insertSelective(voteUser);
	}

	@Override
	public PageBean<VoteUsersResp> selectVoteUsers(Integer pageCurrent, Integer pageSize, Integer pageCount,
												   UserQueryVo userQueryVo) {
		PageBean<VoteUsersResp> pb = new PageBean<>();
		//判断
		if(pageSize == 0) pageSize = 10;
		if(pageCurrent == 0) pageCurrent = 1;
		int rows = voteUsersMapper.selectVoteUsersCount(userQueryVo).intValue();
		if(pageCount == 0) pageCount = rows%pageSize == 0 ? (rows/pageSize) : (rows/pageSize) + 1;
		//如果当前页>=最大页,则设置当前页为最大页
		if(pageCurrent>=pageCount) {
			pb.setPageCurrent(pageCount);
		}
		PageRequest pageRequest = new PageRequest((pageCurrent-1) * pageSize,pageSize);
		
		pb.setPageCurrent(pageCurrent);
		pb.setPageSize(pageSize);
		pb.setPageCount(pageCount);
		pb.setObjectBean(userQueryVo);
		pb.setRows(rows);
		List<VoteUsersResp> voteUserList = voteUsersMapper.selectVoteUserList(pageRequest,userQueryVo);
		pb.setList(voteUserList);
		return pb;
		
		
	}

	@Override
	public Integer updateUserStatus(VoteUsers voteUser) {
		return voteUsersMapper.updateUserStatus(voteUser);
	}

	@Override
	public Integer updateRole(VoteUsers voteUser) {
		return voteUsersMapper.updateRole(voteUser);
	}

	@Override
	public Integer updateGroup(VoteUsers voteUser) {
		return voteUsersMapper.updateGroup(voteUser);
	}

	@Override
	public VoteUsers selectVoteUsersById(Long id) {
		return voteUsersMapper.selectByPrimaryKey(id);
	}

}
