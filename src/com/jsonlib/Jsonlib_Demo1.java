package com.jsonlib;

import com.entity.Score;
import com.entity.Student;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Jsonlib_Demo1 {
    /**
     * 简单形式的json格式字符串
     * @throws JSONException
     */
    @Test
    public void test1() throws JSONException {
        String json_str1 = "{name:'小明',age:12}";
        JSONObject jsonObject = new JSONObject(json_str1);
        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");
        System.out.println(name+":"+age);
        Student student = new Student(name,age);
        System.out.println(student.toString());
    }

    /**
     * 复杂形式的json格式字符串-嵌套对象
     * @throws JSONException
     */
    @Test
    public void test2() throws JSONException {
        //对象内嵌套了对象
        String json_str2 = "{name:'小明',age:12,score:{english:32,math:54}";
        JSONObject jsonObject = new JSONObject(json_str2);
        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");
        //获取对象内的对象
        JSONObject score_obj = jsonObject.getJSONObject("score");
        double english = score_obj.getDouble("english");
        double math = score_obj.getDouble("math");
        Score score = new Score(english,math);
        Student student = new Student(name,age,score);
    }

    /**
     * 数组形式的json格式字符串
     * @throws JSONException
     */
    @Test
    public void test3() throws JSONException {
        String json_str3 = "[{english:32,math:54},{english:66,math:79}]";
        JSONArray jsonArray = new JSONArray(json_str3);
        List<Score> list = new ArrayList<>();
        for (int i = 0;i<jsonArray.length();i++){
            //获取json格式字符串中的元素
            JSONObject score_obj = jsonArray.getJSONObject(i);
            double english = score_obj.getDouble("english");
            double math = score_obj.getDouble("math");
            Score score = new Score(english,math);
            list.add(score);
        }
    }

    /**
     * 数组形式的json格式字符串-嵌套对象
     * @throws JSONException
     */
    @Test
    public void test4() throws JSONException {
        String json_str4 = "[{name:'小明',age:12,score:{english:32,math:54},{name:'小兰',age:14,score:{english:65,math:44}]";
        JSONArray jsonArray = new JSONArray(json_str4);
        List<Student> list_stu = new ArrayList<>();
        for (int i = 0;i<jsonArray.length();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.getString("name");
            int age = jsonObject.getInt("age");
            JSONObject score_obj = jsonObject.getJSONObject("score");
            double english = score_obj.getDouble("english");
            double math = score_obj.getDouble("math");

            Score score = new Score(english,math);
            Student student = new Student(name,age,score);
            list_stu.add(student);
        }
    }
}
