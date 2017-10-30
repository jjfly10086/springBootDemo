package com.jwh.demo.springBoot.mqconsumer;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * Created by Administrator on 2017/5/18 0018.
 */
public interface MQExecuteJob {

    ConsumeConcurrentlyStatus execute(MessageExt msg, ConsumeConcurrentlyContext context);
}
