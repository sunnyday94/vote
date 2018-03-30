package com.chunmi.vote.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.chunmi.vote.dao.VoteActiveMapper;

@Component
public class TimedTask {
	
	@Autowired
	private VoteActiveMapper activeMapper;
	
	private final String DATE = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 定时任务(每分钟执行一次)
	 * @return
	 */
	@Scheduled(cron="0 0/1 *  * * ? ")
	public Integer timingDetection() {
		String nowTime = new SimpleDateFormat(DATE).format(new Date());
		return activeMapper.updateActiveStatusByNowTime(nowTime);
	}
}
