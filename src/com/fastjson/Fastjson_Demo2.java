package com.fastjson;

import com.alibaba.fastjson.JSON;
import com.entity.Score;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Fastjson_Demo2 {

    @Test
    public void test1(){
        //1，普通的对象转成字符串
        Score score = new Score(23,45);
        String str = JSON.toJSONString(score);
        System.out.println(str);

        //3,将集合转换成json字符串
        List<Score> list = new ArrayList<>();
        Score score1 = new Score(34,65);
        Score score2 = new Score(34,65);
        list.add(score1);
        list.add(score2);
        System.out.println(list);//重写了Score的toString方法
        //如果没有重写toString方法会使用fastjson中的重写方法
        //其格式可以直接传输到网页
        String str2 = JSON.toJSONString(list);
        System.out.println(str2);
    }
}
