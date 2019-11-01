package com.example.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/11/1 3:14 下午
 * @Describe 订阅监听器
 */
@Component
public class RedisMsgListener implements MessageListener {

    private static final Logger log = LoggerFactory.getLogger(RedisMsgListener.class);

    @Override
    public void onMessage(Message message, byte[] bytes) {
        String msg = new String(message.getBody());
        String topic = new String(bytes);

        log.info("msg = {}", msg);
        log.info("topic = {}", topic);

    }
}
