package com.xa.jans.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xa.jans.vo.TaskVo;


public class QuartzJobFactory implements Job{

	private Logger logger = LoggerFactory.getLogger(QuartzJobFactory.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		TaskVo taskVo = (TaskVo) context.getMergedJobDataMap().get("taskVo");
		logger.info(taskVo.toString());
		
		
	}

}
