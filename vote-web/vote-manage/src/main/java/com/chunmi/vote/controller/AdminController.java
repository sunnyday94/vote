package com.chunmi.vote.controller;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chunmi.vote.controller.filter.MySessionListener;
import com.chunmi.vote.po.VoteUsers;
import com.chunmi.vote.service.VoteUsersService;
import com.chunmi.vote.utils.Constant;
import com.chunmi.vote.utils.MD5Util;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	private Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private VoteUsers voteUsers;
	
	@Autowired
	private VoteUsersService voteUsersService;
	
	/**
	 * 跳转登录页面
	 * @return
	 */
	@GetMapping(value="login")
	public String goToLoginIndex() {
		return "login";
	}
	
	/**
	 * 登录验证
	 * @return
	 */
	@PostMapping(value="checkLogin")
	public String checkLogin(HttpServletRequest request,
			@RequestParam("userName")String userName,
			@RequestParam("userPassword")String userPassword,
			Model model) {
		VoteUsers voteUser = voteUsersService.selectVoteUsersByName(userName);
		if(voteUser==null) {
			model.addAttribute("error", "User does not exist, please register first");  //用户不存在
		}else {
			if(voteUser.getUserPassword().equals(MD5Util.MD5Encryption(userPassword).toLowerCase())) {
				if(voteUser.getDelFlag().equals("1")) {
					model.addAttribute("error","User disabled");   //用户被禁用
				}else {
					request.getSession().setAttribute(Constant.LOGIN_MANAGER, voteUser);
					//新增在线人数
					MySessionListener.setActiveSession(MySessionListener.getActiveSession()+1);
					return "redirect:dashboard";                  //通过登录验证，跳转首页页面
				}
			}else {
				model.addAttribute("error","User name and password do not match");     //密码错误
			}
		}
		return "login";
	}
	
	
	
	/**
	 * 首页页面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value="dashboard")
	public String dashboard(Model model,HttpServletRequest request) {
		model.addAttribute(Constant.LOGIN_MANAGER,request.getSession().getAttribute(Constant.LOGIN_MANAGER));
		model.addAttribute(Constant.ACTIVE_SESSION, MySessionListener.getActiveSession());
		return "dashboard";
	}
	
	
	/**
	 * 注册
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value="register")
	public String register(Model model) {
		return "register";
	}
	
	
	/**
	 * 检测注册信息
	 */
	@PostMapping(value="checkRegister")
	public String checkRegister(@RequestParam("userName") String userName,
			@RequestParam("userPassword")String userPassword,
			@RequestParam("userNickname")String userNickname,
			@RequestParam("confirmPassword")String confirmPassword, Model model) {
		if(!userPassword.equals(confirmPassword)) {
			model.addAttribute("error", "The password for the two input is inconsistent");
			return "register";
		}
		VoteUsers user = voteUsersService.selectVoteUsersByName(userName);
		if(user!=null) {
			model.addAttribute("error","The user already exists");
			return "register";
		}
		try {
			voteUsers.setUserName(userName);
			voteUsers.setUserNickname(userNickname);
			voteUsers.setUserPassword(userPassword);
			voteUsersService.addVoteUser(voteUsers);
			return "redirect:login";
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return null;
	}
	
	
	
	/**
	 * 用户退出
	 * @return
	 */
	@GetMapping(value="signOut")
	public String signOut(HttpServletRequest request) {
		request.getSession().removeAttribute(Constant.LOGIN_MANAGER);
		//减少在线人数
		if(MySessionListener.getActiveSession()>0)
			MySessionListener.setActiveSession(MySessionListener.getActiveSession()-1);
		//返回登录页
		return "redirect:login";
	}
}
