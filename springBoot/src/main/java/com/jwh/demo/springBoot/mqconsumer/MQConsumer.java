package com.jwh.demo.springBoot.mqconsumer;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.jwh.demo.core.utils.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
public class MQConsumer extends DefaultMQPushConsumer{

    public MQConsumer(String customerName){
        super(customerName);
    }
    /**
     * 启动consumer
     */
    @Override
    public void start() throws MQClientException{

        setNamesrvAddr("127.0.0.1:9876");

        List<Object[]> config = new ArrayList<>();
        config.add(new Object[]{"PushTopic1","Tag1",MQTestJob1.class});
        config.add(new Object[]{"PushTopic2","Tag2",MQTestJob2.class});

        final Map<String, MQExecuteJob> subscribers = new HashMap<>();

        for(Object[] item : config){
            //订阅不同的topic和tag
            subscribe((String)item[0],(String) item[1]);
            //不同topic的处理事件
            subscribers.put((String)item[0], BeanUtils.getBean((Class<? extends MQExecuteJob>) item[2]));
        }
        //注册MessageListener
        registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                MessageExt messageExt = list.get(0);
                MQExecuteJob job = subscribers.get(messageExt.getTopic());
                return job.execute(messageExt,consumeConcurrentlyContext);
            }
        });
        super.start();
        System.out.println("RocketMQ consumer boot success !");
    }
}
