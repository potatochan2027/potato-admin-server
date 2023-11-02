package com.potato.commonpro.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtils {

    public static Map<String,Object> page(Object list, int currentPage, int pageSize, int total){
        Map<String,Object> map=new HashMap<>();
        map.put("list",list);
        map.put("currentPage",currentPage);
        map.put("pageSize",pageSize);
        map.put("total",total);
        return map;
    }

}
