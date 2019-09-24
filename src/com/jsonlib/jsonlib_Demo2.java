package com.jsonlib;

import com.entity.Score;
import com.entity.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class jsonlib_Demo2 {

    @Test
    public void test1(){
        Student student = new Student("张三",12);
        JSONObject jsonObject = new JSONObject(student);
        System.out.println(jsonObject);
    }

    @Test
    public void test2(){
        Score score = new Score(32,54);
        Student student = new Student("张三",12,score);
        JSONObject jsonObject = new JSONObject(student);
        System.out.println(jsonObject);
    }

    @Test
    public void test3(){
        List<Score> list = new ArrayList<>();
        Score score1 = new Score(34,54);
        Score score2 = new Score(44,65);
        list.add(score1);
        list.add(score2);
        JSONArray jsonArray = new JSONArray(list);
        System.out.println(jsonArray.toString());
    }

}
