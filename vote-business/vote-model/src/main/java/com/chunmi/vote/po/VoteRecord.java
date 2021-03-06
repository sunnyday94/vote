package com.chunmi.vote.po;

import java.util.Date;

public class VoteRecord {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_record.id
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_record.vote_user_id
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    private Long voteUserId;
    
    
    /**
     * 被投票作品id
     */
    private Long beVotedProductionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_record.vote_group_id
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    private Long voteGroupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_record.be_voted_group_id
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    private Long beVotedGroupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_record.active_id
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    private Long activeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_record.create_time
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_record.update_time
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_record.del_time
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    private Date delTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_vote_record.del_flag
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    private String delFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_record.id
     *
     * @return the value of cm_vote_record.id
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_record.id
     *
     * @param id the value for cm_vote_record.id
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_record.vote_user_id
     *
     * @return the value of cm_vote_record.vote_user_id
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public Long getVoteUserId() {
        return voteUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_record.vote_user_id
     *
     * @param voteUserId the value for cm_vote_record.vote_user_id
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public void setVoteUserId(Long voteUserId) {
        this.voteUserId = voteUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_record.vote_group_id
     *
     * @return the value of cm_vote_record.vote_group_id
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public Long getVoteGroupId() {
        return voteGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_record.vote_group_id
     *
     * @param voteGroupId the value for cm_vote_record.vote_group_id
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public void setVoteGroupId(Long voteGroupId) {
        this.voteGroupId = voteGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_record.be_voted_group_id
     *
     * @return the value of cm_vote_record.be_voted_group_id
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public Long getBeVotedGroupId() {
        return beVotedGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_record.be_voted_group_id
     *
     * @param beVotedGroupId the value for cm_vote_record.be_voted_group_id
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public void setBeVotedGroupId(Long beVotedGroupId) {
        this.beVotedGroupId = beVotedGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_record.active_id
     *
     * @return the value of cm_vote_record.active_id
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public Long getActiveId() {
        return activeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_record.active_id
     *
     * @param activeId the value for cm_vote_record.active_id
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public void setActiveId(Long activeId) {
        this.activeId = activeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_record.create_time
     *
     * @return the value of cm_vote_record.create_time
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_record.create_time
     *
     * @param createTime the value for cm_vote_record.create_time
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_record.update_time
     *
     * @return the value of cm_vote_record.update_time
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_record.update_time
     *
     * @param updateTime the value for cm_vote_record.update_time
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_record.del_time
     *
     * @return the value of cm_vote_record.del_time
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public Date getDelTime() {
        return delTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_record.del_time
     *
     * @param delTime the value for cm_vote_record.del_time
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public void setDelTime(Date delTime) {
        this.delTime = delTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_vote_record.del_flag
     *
     * @return the value of cm_vote_record.del_flag
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_vote_record.del_flag
     *
     * @param delFlag the value for cm_vote_record.del_flag
     *
     * @mbg.generated Tue Nov 21 15:55:04 CST 2017
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

	public Long getBeVotedProductionId() {
		return beVotedProductionId;
	}

	public void setBeVotedProductionId(Long beVotedProductionId) {
		this.beVotedProductionId = beVotedProductionId;
	}
    
    
    
}