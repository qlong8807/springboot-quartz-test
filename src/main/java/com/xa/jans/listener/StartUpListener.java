package com.xa.jans.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.xa.jans.task.TaskManager;
import com.xa.jans.vo.TaskVo;

@Component
@Order(2)
public class StartUpListener implements ApplicationRunner{
	
	@Autowired
	private TaskManager taskMnager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.err.println("StartUpListener");
		TaskVo taskVo = new TaskVo();
		taskVo.setId("1");
		taskVo.setTaskCode("beanName");
		taskVo.setTaskName("测试");
		taskVo.setCron("*/5 * * * * ?");
		taskMnager.startTask(taskVo);
	}

}
