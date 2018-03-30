package com.chunmi.vote.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chunmi.vote.controller.filter.MySessionListener;
import com.chunmi.vote.po.VoteGroup;
import com.chunmi.vote.po.VoteRole;
import com.chunmi.vote.po.VoteUsers;
import com.chunmi.vote.service.VoteGroupService;
import com.chunmi.vote.service.VoteRoleService;
import com.chunmi.vote.service.VoteUsersService;
import com.chunmi.vote.utils.Constant;
import com.chunmi.vote.utils.MessageExceptionEnum;
import com.chunmi.vote.utils.PageBean;
import com.chunmi.vote.utils.PageUtil;
import com.chunmi.vote.utils.Response;

@Controller
@RequestMapping(value="/admin")
public class VoteUsersController {
	
	private Logger logger = LoggerFactory.getLogger(VoteUsersController.class);
	
	@Autowired
	private VoteUsersService voteUsersService;
	
	@Autowired
	private VoteRoleService voteRoleService;
	
	@Autowired
	private VoteGroupService voteGroupService;
	
	/**
	 * 分页查询用户列表
	 * @param pageCurrent
	 * @param pageSize
	 * @param pageCount
	 * @param model
	 * @param request
	 * @return
	 */
	@GetMapping(value="userList_{pageCurrent}_{pageSize}_{pageCount}")
	public String voteUserList(@PathVariable Integer pageCurrent,@PathVariable Integer pageSize,@PathVariable Integer pageCount, Model model,
			HttpServletRequest request) {
		//输出
		PageBean<VoteUsers> pb = voteUsersService.selectVoteUsers(pageCurrent,pageSize,pageCount);
		String pageHTML = PageUtil.getPageContent("userList_{pageCurrent}_{pageSize}_{pageCount}", pb.getPageCurrent(), pb.getPageSize(), pb.getPageCount());
		List<VoteRole> voteRoleList = voteRoleService.selectVoteRoleList();
		List<VoteGroup> voteGroupList = voteGroupService.selectVoteGroupList();
		
		model.addAttribute("pb",pb);
		model.addAttribute("pageHTML",pageHTML);
		model.addAttribute("voteRoleList", voteRoleList);
		model.addAttribute("voteGroupList", voteGroupList);
		model.addAttribute(Constant.LOGIN_MANAGER,request.getSession().getAttribute(Constant.LOGIN_MANAGER));
		model.addAttribute(Constant.ACTIVE_SESSION,MySessionListener.getActiveSession());
		return "users/usersManage";
	}
	
	/**
	 * 更新用户状态
	 * @param voteUser
	 * @return
	 */
	@PostMapping(value="updateUserStatus")
	@ResponseBody
	public Response updateUserStatus(VoteUsers voteUser) {
		try {
			voteUsersService.updateUserStatus(voteUser);
			return Response.getSuccess();
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return Response.getError(MessageExceptionEnum.ERROR_HANDLE);
		}
	}
	
	
	/**
	 * 修改用户角色
	 * @param voteUser
	 * @return
	 */
	@PostMapping(value="updateRole")
	@ResponseBody
	public Response updateRole(VoteUsers voteUser,HttpServletRequest request) {
		try {
			VoteUsers users = (VoteUsers) request.getSession().getAttribute(Constant.LOGIN_MANAGER);
			voteUsersService.updateRole(voteUser);
			//更新session中的值
			if(voteUser.getId().equals(users.getId()))
				request.getSession().setAttribute(Constant.LOGIN_MANAGER, voteUsersService.selectVoteUsersById(voteUser.getId()));
			return Response.getSuccess();
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return Response.getError(MessageExceptionEnum.ERROR_HANDLE);
		}
	}
	

	/**
	 * 修改用户分组
	 * @param voteUser
	 * @return
	 */
	@PostMapping(value="updateGroup")
	@ResponseBody
	public Response updateGroup(VoteUsers voteUser,HttpServletRequest request) {
		try {
			VoteUsers users = (VoteUsers) request.getSession().getAttribute(Constant.LOGIN_MANAGER);
			voteUsersService.updateGroup(voteUser);
			//更新session中的值
			if(voteUser.getId().equals(users.getId()))
				request.getSession().setAttribute(Constant.LOGIN_MANAGER, voteUsersService.selectVoteUsersById(voteUser.getId()));
			return Response.getSuccess();
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return Response.getError(MessageExceptionEnum.ERROR_HANDLE);
		}
	}

}
