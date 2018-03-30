package com.chunmi.vote.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chunmi.vote.po.VoteActive;
import com.chunmi.vote.po.VoteRecord;
import com.chunmi.vote.service.VoteActiveService;
import com.chunmi.vote.service.VoteRecordService;
import com.chunmi.vote.utils.MessageExceptionEnum;
import com.chunmi.vote.utils.Response;

@Controller
@RequestMapping(value="/admin")
public class VoteRecordController {
	
	@Autowired
	private VoteActiveService activeService;
	
	@Autowired
	private VoteRecordService voteRecordService;

	/**
	 * 日志
	 */
	private Logger logger = LoggerFactory.getLogger(VoteRecordController.class);
	
	/**
	 * 投票
	 * @param voteRecord
	 * @return
	 */
	@PostMapping(value="vote")
	@ResponseBody
	public Response voteProduction(VoteRecord voteRecord) {
		try {
			VoteActive active = activeService.selectVoteActiveById(voteRecord.getActiveId());
			//如果活动关闭了，则不能参与投票
			if(active.getIsStart().equals("0"))
				return Response.getError(MessageExceptionEnum.ACTIVE_IS_CLOSED);
			synchronized (this) {
				Long counts = voteRecordService.selectLimitVoteCounts(voteRecord);
				//上限每个组每次活动只能投5票
				if(counts>=5)
					return Response.getError(MessageExceptionEnum.VOTE_NUM_IS_MAX);
				voteRecordService.saveVoteRecord(voteRecord);
				return Response.getSuccess();
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return Response.getError(MessageExceptionEnum.ERROR_HANDLE);
		}
	}
}
