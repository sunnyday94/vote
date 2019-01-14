/**
 * FileName: UserQueryVo
 * Author:   sunny
 * Date:     2019/1/14 22:21
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chunmi.vote.vo;


import java.io.Serializable;

/**
 * 〈一句话功能简述〉
 * @author sunny
 * @create 2019/1/14
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class UserQueryVo implements Serializable{

    /**
     * 用户名
     */
    private String userName;

    /**
     * 所属分组id
     */
    private Long groupId;

    /**
     * 用户角色id
     */
    private Long roleId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}