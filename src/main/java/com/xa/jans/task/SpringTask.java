package com.xa.jans.task;

import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zyl
 * @date 2018年7月12日
 * @desc Spring自带的定时任务。只需要这几个注解即可。
 */
@Component
@Configurable
@EnableScheduling
public class SpringTask {
	
	public final static long SECOND = 1 * 1000;
	FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
	private Logger logger = LoggerFactory.getLogger(SpringTask.class);

	/**
	 * 固定间隔时间
	 */
	@Scheduled(fixedRate = 1000 * 10)
	public void reportCurrentTime() {
		logger.info("Spring Scheduling Tasks Examples 30秒一次: The time is " + fdf.format(new Date()));
	}
	
	/**
	 * 固定等待时间
	 * @throws InterruptedException
	 */
	@Scheduled(fixedDelay = SECOND * 10)
    public void fixedDelayJob() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(2);
        logger.info("[FixedDelayJob Execute]"+fdf.format(new Date()));
    }

	/**
	 * Corn表达式
	 * 每1分钟执行一次
	 */
	@Scheduled(cron = "0 */1 * * * ?")
	public void reportCurrentByCron() {
		logger.info("Spring Scheduling Tasks Examples By Cron 1分钟一次: The time is " + fdf.format(new Date()));
	}
}
