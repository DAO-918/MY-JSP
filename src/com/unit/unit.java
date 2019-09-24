package com.unit;

import org.junit.Assert;
import org.junit.Test;

public class unit {
    @Test
    public void test1(){
        int sum = 3+4;
        //断言：拿期望值和实际的值比较
        //白盒测试
        //Assert.assertEquals(7,sum);
        Assert.assertEquals(8,sum);
    }
}
