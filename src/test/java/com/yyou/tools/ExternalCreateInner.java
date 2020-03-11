package com.yyou.tools;

import org.junit.Test;

public class ExternalCreateInner {

    @Test
    public void createInner(){
        //创建内部类时，必须先创建外部类
        //内部类和外部类存在关联
        FieldTest.Inner inner = new FieldTest().new Inner();
    }
//java值传递
//    https://juejin.im/post/5e18879e6fb9a02fc63602e2
//    需要包装解决交换问题
    @Test
    public void exchangeFail(){
        Student a = new Student(1,"a");
        Student b = new Student(2,"b");
        exchange(a,b);
        System.out.println(a.toString());
        System.out.println(b.toString());
        StudentWrap w1 = new StudentWrap(a);
        StudentWrap w2 = new StudentWrap(b);
        exchangeWrap(w1,w2);
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(w1.student.toString());
        System.out.println(w2.student.toString());
    }
    private void exchange(Student t1,Student t2){
        Student tmp = new Student();
        tmp = t1;
        t1 = t2;
        t2 =tmp;
    }

    private void exchangeWrap(StudentWrap t1,StudentWrap t2){
        Student tmp = new Student();
        tmp = t1.student;
        t1.student = t2.student;
        t2.student =tmp;
    }

    class StudentWrap{
        private Student student;

        public StudentWrap(Student student) {
            this.student = student;
        }
    }

    class Student{
        private int no;
        private String desc;

        public Student(int no, String desc) {
            this.no = no;
            this.desc = desc;
        }

        public Student() {
            super();
        }

        @Override
        public String toString() {
            return "Student{" +
                    "no=" + no +
                    ", desc='" + desc + '\'' +
                    '}';
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
