package com.xa.jans.task;

import javax.annotation.Resource;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.xa.jans.vo.TaskVo;

@Component
public class TaskManager {

	@Resource
	private Scheduler scheduler;
	private Logger logger = LoggerFactory.getLogger(TaskManager.class);

	/**
	 * 启动task，正确启动返回0，异常返回-1.
	 * 
	 * @param taskVo
	 * @return
	 */
	public int startTask(TaskVo taskVo) {
		// String express = "0 0/2 * * * ?";
		// 创建触发器
		TriggerKey triggerKey = TriggerKey.triggerKey(taskVo.getTaskCode(), taskVo.getTaskCode());
		try {
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			if (null == trigger) {
				// 如果未能通过任务名称，分组获取到触发器则新创建一个触发器
				JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class)
						.withIdentity(taskVo.getTaskCode(), taskVo.getTaskCode()).build();
				jobDetail.getJobDataMap().put("taskVo", taskVo);

				// 表达式调度构建器 通过时间表达式
				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(taskVo.getCron());

				// 按新的cronExpression表达式构建一个新的trigger
				trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
				// 执行定时任务
				scheduler.scheduleJob(jobDetail, trigger);
			} else {
				// Trigger已存在，那么更新相应的定时设置
				// 表达式调度构建器
				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(taskVo.getCron());
				// 按新的cronExpression表达式重新构建trigger
				trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
				// 按新的trigger重新启动定时任务
				scheduler.rescheduleJob(triggerKey, trigger);
			}
			// resMg = taskInfoVo.getTask_name()+"启动成功!";
		} catch (Exception ex) {
			logger.error("job任务启动失败,失败原因:{}", ex.fillInStackTrace());
			return -1;
		}
		return 0;
	}

	public int stopTask(TaskVo taskVo) {
		// 获取触发器
		TriggerKey triggerKey = TriggerKey.triggerKey(taskVo.getTaskCode(), taskVo.getTaskCode());
		CronTrigger trigger = null;
		try {
			trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			// 如果有此任务
			if (null != triggerKey && null != trigger) {
				scheduler.pauseTrigger(triggerKey);// 停止触发器
				scheduler.unscheduleJob(triggerKey);// 移除触发器
				scheduler.deleteJob(trigger.getJobKey());// 删除任务
			}
		} catch (SchedulerException e) {
			logger.error("job任务启动失败,失败原因:{}", e.fillInStackTrace());
			return -1;
		}
		return 0;
	}
}
