package com.jwh.demo.core.bean;




import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/18 0018.
 */
public class MQMessageBody implements Serializable{
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
