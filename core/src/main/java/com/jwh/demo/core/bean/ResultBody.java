package com.jwh.demo.core.bean;

/**
 * Created by Administrator on 2017/5/31 0031.
 */
public class ResultBody {
    private int code;
    private Object data;
    public ResultBody(Object data){
        this.code = 0;
        this.data = data;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
