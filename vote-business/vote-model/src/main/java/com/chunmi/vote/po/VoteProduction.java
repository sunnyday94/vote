package com.chunmi.vote.po;

import java.util.Date;

public class VoteProduction {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_production.id
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_production.production_name
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    private String productionName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_production.production_intro
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    private String productionIntro;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_production.production_address
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    private String productionAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_production.group_id
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    private Long groupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_production.active_id
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    private Long activeId;
    
    
    /**
     * 作品获得票数
     */
    private Long voteGetNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_production.create_time
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_production.update_time
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_production.del_time
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    private Date delTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_production.del_flag
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    private String delFlag;
    
    
    /**
     * 活动(该作品属于哪个活动)
     */
    private VoteActive voteActive;
    
    
    /**
     * 分组(该作品属于哪个分组)
     */
    private VoteGroup voteGroup;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_production.id
     *
     * @return the value of cm_vote_production.id
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_production.id
     *
     * @param id the value for cm_vote_production.id
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_production.production_name
     *
     * @return the value of cm_vote_production.production_name
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public String getProductionName() {
        return productionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_production.production_name
     *
     * @param productionName the value for cm_vote_production.production_name
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_production.production_intro
     *
     * @return the value of cm_vote_production.production_intro
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public String getProductionIntro() {
        return productionIntro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_production.production_intro
     *
     * @param productionIntro the value for cm_vote_production.production_intro
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public void setProductionIntro(String productionIntro) {
        this.productionIntro = productionIntro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_production.production_address
     *
     * @return the value of cm_vote_production.production_address
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public String getProductionAddress() {
        return productionAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_production.production_address
     *
     * @param productionAddress the value for cm_vote_production.production_address
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public void setProductionAddress(String productionAddress) {
        this.productionAddress = productionAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_production.group_id
     *
     * @return the value of cm_vote_production.group_id
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_production.group_id
     *
     * @param groupId the value for cm_vote_production.group_id
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_production.active_id
     *
     * @return the value of cm_vote_production.active_id
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public Long getActiveId() {
        return activeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_production.active_id
     *
     * @param activeId the value for cm_vote_production.active_id
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public void setActiveId(Long activeId) {
        this.activeId = activeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_production.create_time
     *
     * @return the value of cm_vote_production.create_time
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_production.create_time
     *
     * @param createTime the value for cm_vote_production.create_time
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_production.update_time
     *
     * @return the value of cm_vote_production.update_time
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_production.update_time
     *
     * @param updateTime the value for cm_vote_production.update_time
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_production.del_time
     *
     * @return the value of cm_vote_production.del_time
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public Date getDelTime() {
        return delTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_production.del_time
     *
     * @param delTime the value for cm_vote_production.del_time
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public void setDelTime(Date delTime) {
        this.delTime = delTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_production.del_flag
     *
     * @return the value of cm_vote_production.del_flag
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_production.del_flag
     *
     * @param delFlag the value for cm_vote_production.del_flag
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

	public VoteActive getVoteActive() {
		return voteActive;
	}

	public void setVoteActive(VoteActive voteActive) {
		this.voteActive = voteActive;
	}

	public VoteGroup getVoteGroup() {
		return voteGroup;
	}

	public void setVoteGroup(VoteGroup voteGroup) {
		this.voteGroup = voteGroup;
	}

	public Long getVoteGetNum() {
		return voteGetNum;
	}

	public void setVoteGetNum(Long voteGetNum) {
		this.voteGetNum = voteGetNum;
	}
    
    
}