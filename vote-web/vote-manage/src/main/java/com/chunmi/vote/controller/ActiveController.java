package com.chunmi.vote.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.chunmi.vote.po.VoteActive;
import com.chunmi.vote.service.VoteActiveService;
import com.chunmi.vote.utils.Constant;
import com.chunmi.vote.utils.MessageExceptionEnum;
import com.chunmi.vote.utils.PageBean;
import com.chunmi.vote.utils.PageUtil;
import com.chunmi.vote.utils.Response;

@Controller
@RequestMapping(value="/admin")
public class ActiveController {
	
	private Logger logger = LoggerFactory.getLogger(ActiveController.class);
	
	public static final String DATE = "yyyy-MM-dd HH:mm:ss"; //日期格式
	
	@Autowired
	private VoteActiveService activeService;
	
	
	/**
	 * 创建活动页面
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping(value="createActive")
	public String createActive(HttpServletRequest request,Model model) {
		model.addAttribute(Constant.LOGIN_MANAGER,request.getSession().getAttribute(Constant.LOGIN_MANAGER));
		model.addAttribute(Constant.ACTIVE_SESSION,MySessionListener.getActiveSession());
		return "active/createActive";
	}
	
	/**
	 * 保存活动信息
	 * @param active
	 * @return
	 */
	@PostMapping(value="saveActive")
	@ResponseBody
	public Response saveActive(VoteActive active) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(DATE);
			//判断开始时间是否小于结束时间
			if(format.parse(active.getEndTimeStr()).getTime()-format.parse(active.getStartTimeStr()).getTime()<=0)
				return Response.getError(MessageExceptionEnum.TIMESETTINGISWRONG);
			//保存活动信息
			active.setStartTime(format.parse(active.getStartTimeStr()));
			active.setEndTime(format.parse(active.getEndTimeStr()));
			activeService.saveActive(active);
			return Response.getSuccess();
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return Response.getError(MessageExceptionEnum.ERROR_HANDLE);
		}
	}
	
	/**
	 * 活动列表
	 * @param request
	 * @param model
	 * @param pageCurrent
	 * @param pageSize
	 * @param pageCount
	 * @return
	 */
	@GetMapping(value="activeList_{pageCurrent}_{pageSize}_{pageCount}")
	public String activeList(HttpServletRequest request,Model model,@PathVariable("pageCurrent")Integer pageCurrent,
			@PathVariable("pageSize")Integer pageSize,@PathVariable("pageCount")Integer pageCount) {
		PageBean<VoteActive> pb = activeService.selectActiveListByPage(pageCurrent,pageSize,pageCount);
		String pageHTML = PageUtil.getPageContent("activeList_{pageCurrent}_{pageSize}_{pageCount}", pb.getPageCurrent(), pb.getPageSize(), pb.getPageCount());
		model.addAttribute("pb",pb);
		model.addAttribute("pageHTML",pageHTML);
		model.addAttribute(Constant.LOGIN_MANAGER,request.getSession().getAttribute(Constant.LOGIN_MANAGER));
		model.addAttribute(Constant.ACTIVE_SESSION,MySessionListener.getActiveSession());
		return "active/activeList";		
	}
	
	
	/**
	 * 修改活动状态(开启或关闭)
	 * @param active
	 * @return
	 */
	@PostMapping(value="updateActiveStatus")
	@ResponseBody
	public Response updateActiveStatus(VoteActive active) {
		try {
			if(active.getIsStart().equals("1")) {
				VoteActive voteActive = activeService.selectVoteActiveById(active.getId());
				if(new Date().getTime()-voteActive.getEndTime().getTime()>=0)
					return Response.getError(MessageExceptionEnum.ERROR_EXPIRED);    //活动时间已结束，开启失败
			}
			activeService.updateActiveStatus(active);
			return Response.getSuccess();
		} catch (Exception e) {
			return Response.getError(MessageExceptionEnum.ERROR_HANDLE);
		}
	}
	
	
	/**
	 * 根据活动id删除活动
	 * @param activeId
	 * @return
	 */
	@PostMapping(value="delActiveById")
	@ResponseBody
	public Response delActiveById(Long activeId) {
		try {
			activeService.delActiveById(activeId);
			return Response.getSuccess();
		} catch (Exception e) {
			return Response.getError(MessageExceptionEnum.ERROR_HANDLE);
		}
	}

}
