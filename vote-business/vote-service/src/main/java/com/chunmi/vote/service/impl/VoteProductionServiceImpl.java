package com.chunmi.vote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chunmi.vote.dao.VoteProductionMapper;
import com.chunmi.vote.dao.VoteRecordMapper;
import com.chunmi.vote.po.VoteProduction;
import com.chunmi.vote.service.VoteProductionService;
import com.chunmi.vote.utils.PageBean;
import com.chunmi.vote.utils.PageRequest;
import com.chunmi.vote.vo.VoteEchartsVo;

@Service
@Transactional
public class VoteProductionServiceImpl implements VoteProductionService {
	
	@Autowired
	private VoteProductionMapper productionMapper;
	
	@Autowired
	private VoteRecordMapper recordMapper;

	@Override
	public Integer saveVoteProduction(VoteProduction product) {
		return productionMapper.insertSelective(product);
	}

	@Override
	public PageBean<VoteProduction> selectProductionListByPage(Integer pageCurrent, Integer pageSize,
			Integer pageCount) {
		PageBean<VoteProduction> pb = new PageBean<VoteProduction>();
		//判断
		if(pageSize == 0) pageSize = 10;         //每页数据条目数
		if(pageCurrent == 0) pageCurrent = 1;    //当前页
		int rows = productionMapper.selectVoteProductionCounts().intValue();  //总条目数
		if(pageCount == 0) pageCount = rows%pageSize == 0 ? (rows/pageSize) : (rows/pageSize) + 1;
		//如果当前页>=最大页,则设置当前页为最大页
		if(pageCurrent>=pageCount) {
			pb.setPageCurrent(pageCount);
		}
		PageRequest pageRequest = new PageRequest((pageCurrent-1) * pageSize,pageSize);
		pb.setPageCurrent(pageCurrent);  //当前页
		pb.setPageSize(pageSize);       //每页显示条目
		pb.setPageCount(pageCount);     //总页数
		List<VoteProduction> voteProductionList = productionMapper.selectProductionListByPage(pageRequest);
		pb.setList(voteProductionList);
		return pb;
	}

	@Override
	public List<VoteProduction> selectProdutionByActiveIdAndGroupId(VoteProduction production) {
		return productionMapper.selectProdutionByActiveIdAndGroupId(production);
	}

	@Override
	public List<VoteProduction> selectProductionListByActiveId(Long activeId) {
		return productionMapper.selectProductionListByActiveId(activeId);
	}

	@Override
	public List<VoteEchartsVo> getVoteEchartsInfo(Long activeId) {
		return productionMapper.getVoteEchartsInfo(activeId);
	}

	@Override
	public void delProduction(Long productionId) {
		//删除作品
		productionMapper.delProductionById(productionId);
		//删除该作品的投票记录
		recordMapper.delVoteRecordByProductionId(productionId);
	}


}
