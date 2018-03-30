package com.chunmi.vote.service;

import java.util.List;

import com.chunmi.vote.po.VoteActive;
import com.chunmi.vote.utils.PageBean;

public interface VoteActiveService {

	/**
	 * 保存活动
	 * @param active
	 * @return
	 */
	Integer saveActive(VoteActive active);

	/**
	 * 查询活动列表(分页查询)
	 * @param pageCurrent
	 * @param pageSize
	 * @param pageCount
	 * @return
	 */
	PageBean<VoteActive> selectActiveListByPage(Integer pageCurrent, Integer pageSize, Integer pageCount);
	
	
	/**
	 * 查询所有活动
	 * @return
	 */
	List<VoteActive> selectVoteActiveList();
	
	
	/**
	 * 根据id查询活动信息
	 * @param id
	 * @return
	 */
	VoteActive selectVoteActiveById(Long id);
	

	/**
	 * 修改活动状态
	 * @param active
	 * @return
	 */
	Integer updateActiveStatus(VoteActive active);

	
	/**
	 * 查询所有已开启的活动
	 * @return
	 */
	List<VoteActive> selectVoteActiveListWithStart();

	
	/**
	 * 根据活动id删除活动
	 * @param activeId
	 * @return
	 */
	Integer delActiveById(Long activeId);
}
