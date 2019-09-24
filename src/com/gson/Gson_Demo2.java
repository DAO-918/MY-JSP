package com.gson;

import com.entity.Score;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Gson_Demo2 {
    @Test
    public void test1(){
        //1,普通的对象转换成json字符串
        Score score = new Score(34,23);
        Gson gson = new Gson();
        String json = gson.toJson(score);
        System.out.println(json);

    }

    /**
     * 集合转成json字符串
     */
    @Test
    public void test2(){
        List<Score> list = new ArrayList<>();
        Score score1 = new Score(34,65);
        Score score2 = new Score(34,65);
        list.add(score1);
        list.add(score2);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}
