package com.taotao.task.impl;

import com.taotao.task.TestTask;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by ibm on 2016/11/15.
 */
@Component
public class TestTaskImpl implements TestTask {
    private Logger logger = Logger.getLogger(TestTaskImpl.class);
    @Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
    @Override
    public void myTest() {
    }
}
