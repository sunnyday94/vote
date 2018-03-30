
package com.chunmi.vote.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chunmi.vote.po.VoteUsers;
import com.chunmi.vote.utils.PageRequest;

@Mapper
public interface VoteUsersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_vote_users
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_vote_users
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    int insert(VoteUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_vote_users
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    int insertSelective(VoteUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_vote_users
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    VoteUsers selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_vote_users
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    int updateByPrimaryKeySelective(VoteUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_vote_users
     *
     * @mbg.generated Thu Nov 09 16:15:05 CST 2017
     */
    int updateByPrimaryKey(VoteUsers record);

    
    /**
     * 根据用户名称查询用户
     * @param userName
     * @return
     */
	VoteUsers selectVoteByName(@Param("userName") String userName);

    /**
     * 查询用户数量
     * @return
     */
    @Select("select count(1) from cm_vote_users")
	Long selectVoteUsersCount();

    /**
     * 分页查询用户列表
     * @param pageRequest
     * @return
     */
	List<VoteUsers> selectVoteUserList(@Param("pageRequest")PageRequest pageRequest);

	/**
	 * 更新用户状态
	 * @param voteUser
	 * @return
	 */
	@Update("update cm_vote_users set del_flag = #{delFlag},update_time = now() where id = #{id}")
	Integer updateUserStatus(VoteUsers voteUser);

	/**
	 * 更新用户角色
	 * @param voteUser
	 * @return
	 */
	@Update("update cm_vote_users set role_id = #{roleId},update_time = now() where id = #{id}")
	Integer updateRole(VoteUsers voteUser);

	/**
	 * 更新用户分组
	 * @param voteUser
	 * @return
	 */
	@Update("update cm_vote_users set group_id = #{groupId},update_time = now() where id = #{id}")
	Integer updateGroup(VoteUsers voteUser);
}