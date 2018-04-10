package com.YunMuseum.model;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/29.
 */
public class ViewObject {
    private Map<String,Object> map=new HashedMap();
    public void set(String key,Object value){
        map.put(key,value);
    }
    public Object get(String key){
        return map.get(key);
    }
}
