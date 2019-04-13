package com.xoxo.demo.task;

import com.xoxo.demo.common.exception.BuizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Package com.xoxo.demo.task
 * @Description
 * @Author xiehua@zhongshuheyi.com
 * @Date 2019-04-13 20:38
 */
@Component
@Slf4j
public class TestTask {
    @Scheduled(cron = "0 * * * * ? ")
    public void runTask(){
        throw new BuizException("xoxo","xoxo Exception");
    }
}
