package com.taoyuanx.dockerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dushitaoyuan
 * @desc demo api
 * @date 2019/12/9
 */
@RestController
public class DemoController {
    @GetMapping("hello")
    public Map hello(){
        Map map=new HashMap();
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS.SSS");
        map.put("hello","hello world");
        map.put("date", sdf.format(date));
        return map;
    }
}
