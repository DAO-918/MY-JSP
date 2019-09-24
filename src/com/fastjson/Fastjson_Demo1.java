package com.fastjson;

import com.alibaba.fastjson.JSON;
import com.entity.Score;
import com.entity.Student;
import org.junit.Test;

import java.util.List;

public class Fastjson_Demo1 {

    @Test
    public void test1(){
        String obj1 = "{name:'小明',age:12}";
        Student student = JSON.parseObject(obj1, Student.class);
        System.out.println(student);
    }

    @Test
    public void test2(){
        String obj2 = "{name:'小明',age:12,score:{english:32,math:54}";
        Student student = JSON.parseObject(obj2, Student.class);
        System.out.println(student);
    }

    @Test
    public void test3(){
        String obj3 = "[{english:32,math:54},{english:66,math:79}]";
        List<Score> list = JSON.parseArray(obj3, Score.class);
        for (Score o :list){
            System.out.println(o);
        }
    }
}
