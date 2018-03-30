package com.chunmi.vote.vo;

public class VoteEchartsVo {
	/**
	 * 作品名称
	 */
	private String productionName;
	
	/**
	 * 分组名称
	 */
	private String groupName;

	/**
	 * 活动名
	 */
	private String activeName;
	
	/**
	 * 作品获得投票数
	 */
	private Long voteGetNum;


	public String getActiveName() {
		return activeName;
	}


	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public String getProductionName() {
		return productionName;
	}


	public void setProductionName(String productionName) {
		this.productionName = productionName;
	}


	public Long getVoteGetNum() {
		return voteGetNum;
	}


	public void setVoteGetNum(Long voteGetNum) {
		this.voteGetNum = voteGetNum;
	}
	
	
	
}
