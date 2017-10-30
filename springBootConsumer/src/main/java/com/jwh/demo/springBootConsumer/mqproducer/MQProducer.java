package com.jwh.demo.springBootConsumer.mqproducer;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.jwh.demo.core.bean.MQMessageBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
public class MQProducer {

    public static void main(String[] args){
        DefaultMQProducer producer = new DefaultMQProducer("Producer");
        producer.setNamesrvAddr("127.0.0.1:9876");
        try{
            producer.start();
            for(int i=0;i<1000;i++){
                MQMessageBody body = new MQMessageBody();
                body.setMsg("测试发送:"+i+" "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                String msgBody = JSON.toJSONString(body);

                if(i%2 == 0){
                    Message message = new Message("PushTopic1","Tag1",msgBody.getBytes());
                    SendResult result = producer.send(message);
                    System.out.println("id:" + result.getMsgId() +
                            " result:" + result.getSendStatus());
                }else{
                    Message message = new Message("PushTopic2","Tag2",msgBody.getBytes());
                    SendResult result = producer.send(message);
                    System.out.println("id:" + result.getMsgId() +
                            " result:" + result.getSendStatus());
                }
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            producer.shutdown();
        }

    }
}
