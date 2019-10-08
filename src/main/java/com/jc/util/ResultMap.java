package com.jc.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultMap {
    private String msg;
    private Integer code;
    private Object data;
    private Integer count;
    public ResultMap() {
    }

    public ResultMap(String msg, Integer code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public ResultMap(String msg, Integer code, Object data, Integer count) {
        this.msg = msg;
        this.code = code;
        this.data = data;
        this.count = count;
    }

    public ResultMap(Integer code) {
        this.code = code;
    }

    public static ResultMap ok(){
        return  new ResultMap(0);
    }
    public static ResultMap ok(Object data){
        return  new ResultMap("成功",0,data);
    }
    public static ResultMap ok(Object data, Integer count){
        return  new ResultMap("成功",0,data,count);
    }

    public static ResultMap fail(Object data){
        return  new ResultMap("失败",500,data);
    }

}