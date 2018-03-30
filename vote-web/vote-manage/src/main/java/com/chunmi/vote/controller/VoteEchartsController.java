package com.chunmi.vote.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chunmi.vote.controller.filter.MySessionListener;
import com.chunmi.vote.service.VoteProductionService;
import com.chunmi.vote.utils.Constant;
import com.chunmi.vote.vo.VoteEchartsVo;

import net.sf.json.JSONArray;

@Controller
@RequestMapping(value="/admin")
public class VoteEchartsController {
	
	/**
	 * 日志
	 */
	private Logger logger = LoggerFactory.getLogger(VoteEchartsController.class);
	
	@Autowired
	private VoteProductionService productionService;
	
	@GetMapping(value="/voteEcharts")
	public String voteEcharts(Long activeId,Model model,HttpServletRequest request) {
		try {
			List<String> groupNameList = new ArrayList<String>();   //组名
			List<Long> voteGetNum = new ArrayList<Long>();         //获得的投票数
			List<VoteEchartsVo> voteEchartsInfo = productionService.getVoteEchartsInfo(activeId);
			if(voteEchartsInfo!=null && voteEchartsInfo.size()>0) {
				voteEchartsInfo.forEach(voteEcharts -> {
					groupNameList.add(voteEcharts.getGroupName());
					voteGetNum.add(voteEcharts.getVoteGetNum());
				});
				//转json数组
				JSONArray groupNames = JSONArray.fromObject(groupNameList);
				JSONArray voteGetNums = JSONArray.fromObject(voteGetNum);
				model.addAttribute("groupNames", groupNames);
				model.addAttribute("voteGetNums",voteGetNums);
				model.addAttribute(Constant.LOGIN_MANAGER,request.getSession().getAttribute(Constant.LOGIN_MANAGER));
				model.addAttribute(Constant.ACTIVE_SESSION, MySessionListener.getActiveSession());
				return "echarts/voteEcharts";
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return null;
	}
}
