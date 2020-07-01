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
    public void scheduleExe() throws InterruptedException {
        System.out.println("");
        System.out.println("111111");
        System.out.println("211111");
        Thread.sleep(10000);
        System.out.println("311111");
    }

}
