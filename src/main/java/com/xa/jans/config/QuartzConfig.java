package com.xa.jans.config;

import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author zyl
 * @date 2018年7月12日
 * @desc 如果是SpringBoot 1.*.*则需要以下配置。
 * 如果是SpringBoot 2（默认自动配置）则不需要，如果有特殊配置再需要如下配置。
 */
@Configuration
public class QuartzConfig {

	@Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setStartupDelay(10);//延时10秒启动
        return schedulerFactoryBean;
    }

    @Bean
    public Scheduler scheduler() {
        return schedulerFactoryBean().getScheduler();
    }
}
