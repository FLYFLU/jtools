package com.yyou.tools;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FieldTest {

    int _x;
    Integer _y;
    //成员变量和局部变量测试
    //成员变量默认会进行初始化
    //局部变量不会
    @Test
    public void testField(){
        int i ;
        Integer j;
        System.out.println(_y);
        System.out.println(_x);
//        System.out.println(i);
//        System.out.println(j);
    }

//    字符串操作类
    public void stringDefine(){
        StringBuilder stringBuilder;
        StringBuffer stringBuffer;
        String string;
    }

    @Test
    public void returnFinal(){
        int i = returnFinalInternal();
        System.out.println(i);
        assertEquals(i,2);
    }

    private int returnFinalInternal(){
        try{
            return 1;
        }finally {
            return 2;
        }
    }

    @Test
    public void testInnser(){
        Inner inner = new Inner();
        inner.setInner(10);
        assertEquals(this._x,1);
    }

    private static int t = 0;
    protected static class InnerStatic{
        public void setInner(int y){
            t = y;
        }
    }

    protected class Inner{
        public void setInner(int y){
            t = y;
            _x ++;
        }
    }
}
