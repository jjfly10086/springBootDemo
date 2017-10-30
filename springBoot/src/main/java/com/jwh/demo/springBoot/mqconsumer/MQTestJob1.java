package com.jwh.demo.springBoot.mqconsumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.jwh.demo.core.bean.MQMessageBody;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/18 0018.
 */
@Component
public class MQTestJob1 implements MQExecuteJob {

    @Override
    public ConsumeConcurrentlyStatus execute(MessageExt msg, ConsumeConcurrentlyContext context) {
        MQMessageBody body = JSON.parseObject(StringUtils.newStringUtf8(msg.getBody()),MQMessageBody.class);
        System.out.println("Job1:"+body.getMsg());
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
