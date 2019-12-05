package com.example.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/12/5 4:38 下午
 * @Describe
 */
@Component
public class Timer {

    @Scheduled(fixedRate = 1000)
    public void scheduleExe(){
        System.out.println("21111");
    }

}
