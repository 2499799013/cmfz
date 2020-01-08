package com.baizhi.controller;

import com.baizhi.entity.EchartsMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("echarts")
public class EchartsController {
    @RequestMapping("query")
    public List<Integer> query() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(new Random().nextInt(1000));
        list.add(new Random().nextInt(1000));
        list.add(new Random().nextInt(1000));
        list.add(new Random().nextInt(1000));
        list.add(new Random().nextInt(1000));
        list.add(new Random().nextInt(1000));
        return list;
    }

    @RequestMapping("queryMap")
    public List<EchartsMap> queryMap() {
        ArrayList<EchartsMap> maps = new ArrayList<>();
        EchartsMap echartsMap = new EchartsMap("北京", new Random().nextInt(1000));
        EchartsMap echartsMap1 = new EchartsMap("d", new Random().nextInt(1000));
        EchartsMap echartsMap2 = new EchartsMap("大同", new Random().nextInt(1000));
        EchartsMap echartsMap3 = new EchartsMap("上海", new Random().nextInt(1000));
        EchartsMap echartsMap4 = new EchartsMap("鄂尔多斯", new Random().nextInt(1000));
        EchartsMap echartsMap5 = new EchartsMap("赤峰", new Random().nextInt(1000));
        maps.add(echartsMap);
        maps.add(echartsMap1);
        maps.add(echartsMap2);
        maps.add(echartsMap3);
        maps.add(echartsMap4);
        maps.add(echartsMap5);
        return maps;


    }
}
