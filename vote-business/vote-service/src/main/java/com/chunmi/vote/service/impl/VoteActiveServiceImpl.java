package com.chunmi.vote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chunmi.vote.dao.VoteActiveMapper;
import com.chunmi.vote.po.VoteActive;
import com.chunmi.vote.service.VoteActiveService;
import com.chunmi.vote.utils.PageBean;
import com.chunmi.vote.utils.PageRequest;

@Service
@Transactional
public class VoteActiveServiceImpl implements VoteActiveService {
	
	@Autowired
	private VoteActiveMapper activeMapper;

	@Override
	public Integer saveActive(VoteActive active) {
		return activeMapper.insertSelective(active);
	}

	@Override
	public PageBean<VoteActive> selectActiveListByPage(Integer pageCurrent, Integer pageSize, Integer pageCount) {
		PageBean<VoteActive> pb = new PageBean<VoteActive>();
		//判断
		if(pageSize == 0) pageSize = 10;         //每页数据条目数
		if(pageCurrent == 0) pageCurrent = 1;    //当前页
		int rows = activeMapper.selectVoteActiveCounts().intValue();  //总条目数
		if(pageCount == 0) pageCount = rows%pageSize == 0 ? (rows/pageSize) : (rows/pageSize) + 1;
		//如果当前页>=最大页,则设置当前页为最大页
		if(pageCurrent>=pageCount) {
			pb.setPageCurrent(pageCount);
		}
		PageRequest pageRequest = new PageRequest((pageCurrent-1) * pageSize,pageSize);
		pb.setPageCurrent(pageCurrent);  //当前页
		pb.setPageSize(pageSize);       //每页显示条目
		pb.setPageCount(pageCount);     //总页数
		List<VoteActive> voteActiveList = activeMapper.selectActiveListByPage(pageRequest);
		pb.setList(voteActiveList);
		return pb;
	}

	
	@Override
	@Cacheable(value="voteActiveList")
	public List<VoteActive> selectVoteActiveList() {
		return activeMapper.selectVoteActiveList();
	}

	@Override
	public VoteActive selectVoteActiveById(Long id) {
		return activeMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer updateActiveStatus(VoteActive active) {
		return activeMapper.updateActiveStatus(active);
	}

	@Override
	public List<VoteActive> selectVoteActiveListWithStart() {
		return activeMapper.selectVoteActiveListWithStart();
	}

	@Override
	public Integer delActiveById(Long activeId) {
		return activeMapper.delActiveById(activeId);
	}
	
}
