package com.jc.util;

import java.util.HashMap;

public enum Gender{
    管理类("管理类","管理类"),文职类("文职类","文职类"),技术类("技术类","技术类");
    Gender(String value,String key){
        this.key = key;
        this.value = value;
    }
    private String key;
    private String value;

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

}