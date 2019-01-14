/**
 * FileName: VoteUsersResp
 * Author:   sunny
 * Date:     2019/1/14 22:29
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chunmi.vote.vo;

import com.chunmi.vote.po.VoteUsers;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉
 * @author sunny
 * @create 2019/1/14
 * @since 1.0.0
 */
public class VoteUsersResp extends VoteUsers implements Serializable {

    /**
     * 所属分组名
     */
    private String groupName;

    /**
     * 角色名称
     */
    private String roleName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}