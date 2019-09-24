package com.gson;

import com.entity.Score;
import com.entity.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 谷歌提供的json解析器
* */
public class Gson_Demo1 {

    /**
     * 简单形式的json格式字符串
     */
    @Test
    public void test1(){
        String json_str1 = "{name:'小明',age:12}";
        Gson gson = new Gson();
        //通过字节码反射机制，Gson完成了字符串转对象的事情
        Student student = gson.fromJson(json_str1, Student.class);
        System.out.println(student.toString());
        System.out.println(student);//省略了toString()？？？
    }

    /**
     * 复杂形式的json格式字符串-嵌套对象
     */
    @Test
    public void test2(){
        String json_str2 = "{name:'小明',age:12,score:{english:32,math:54}}";
        Gson gson = new Gson();
        Student student = gson.fromJson(json_str2, Student.class);
        System.out.println(student);
    }

    /**
     * 数组形式的json格式字符串
     */
    @Test
    public void test3(){
        String json_str3 = "[{english:32,math:54},{english:66,math:79}]";
        Gson gson = new Gson();
        /*
        //可以输出，但很麻烦
        ArrayList arrayList = gson.fromJson(json_str3, ArrayList.class);
        for (Object o :arrayList){
            System.out.println(o);
        }*/
        /*
        //会报错，需向上转型才能输出结果
        ArrayList<Score> arrayList = gson.fromJson(json_str3, ArrayList.class);
        for (Score o :arrayList){
            System.out.println(o);
        }*/
        //解析有具体的类型的集合
        //实例化TypeToken,TypeToken的泛型为fromJson返回的对象类型
        //构造方法的访问修饰符为protected,需要new 类名<泛型>(){}
        //这里的空参构造方法权限修饰符是protected,那么只有其子类可访问，预示着要使用子类构造。
        //new TypeToken<List<Score>>(){}是一个匿名内部类，其等价MyTypeToken<List<Score>> extends TypeToken(){}
        TypeToken<ArrayList<Score>> typeToken = new TypeToken<ArrayList<Score>>(){};
        ArrayList<Score> list = gson.fromJson(json_str3, typeToken.getType());
        for (Score o: list){
            System.out.println(o);
            //list.add(o);//java.util.ConcurrentModificationException
            //遍历集合的同时对集合进行修改
        }
    }

    @Test
    public void test4(){
        String json_str4 = "[{name:'小明',age:12,score:{english:32,math:54},{name:'小兰',age:14,score:{english:65,math:44}]";
        Gson gson = new Gson();

    }
}
