package com.chunmi.vote.service;

import java.util.List;

import com.chunmi.vote.po.VoteProduction;
import com.chunmi.vote.utils.PageBean;
import com.chunmi.vote.vo.VoteEchartsVo;

public interface VoteProductionService {
	
	/**
	 * 保存作品
	 * @param product
	 * @return
	 */
	Integer saveVoteProduction(VoteProduction product);

	/**
	 * 作品列表(分页显示)
	 * @param pageCurrent
	 * @param pageSize
	 * @param pageCount
	 * @return
	 */
	PageBean<VoteProduction> selectProductionListByPage(Integer pageCurrent, Integer pageSize, Integer pageCount);

	
	/**
	 * 根据活动id和分组id查询作品
	 * @param production
	 * @return
	 */
	List<VoteProduction> selectProdutionByActiveIdAndGroupId(VoteProduction production);

	
	/**
	 * 根据活动id查询作品信息
	 * @param activeId
	 * @return
	 */
	List<VoteProduction> selectProductionListByActiveId(Long activeId);

	/**
	 * 根据活动id获取投票统计表信息
	 * @param activeId
	 * @return
	 */
	List<VoteEchartsVo> getVoteEchartsInfo(Long activeId);

	
	/**
	 * 删除作品
	 * @param productionId
	 */
	void delProduction(Long productionId);
}
