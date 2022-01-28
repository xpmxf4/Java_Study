package ch12;

import java.lang.annotation.*;

enum TestType {FIRST, FINAL,}

@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo {
    int count() default 1;

    String testedBy();

    String[] testTools() default "JUnit";    // default {"JUnit", "JProgram"}

    TestType testType() default TestType.FIRST;

    DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
    String yymmdd();

    String hhmmss();
}



@Deprecated
@TestInfo(testedBy = "aaa", testDate = @DateTime(yymmdd = "160101", hhmmss = "235959"))
@SuppressWarnings("aaaa")
public class Ex12_8 {
    public static void main(String[] args) {
        Class<Ex12_8> cls = Ex12_8.class;
        System.out.println("cls = " + cls);

        TestInfo anno = cls.getAnnotation(TestInfo.class);
        System.out.println("anno = " + anno);
        System.out.println("anno.count() = " + anno.count());
        System.out.println("anno.testedBy() = " + anno.testedBy());
        System.out.println("anno.testTools()[0] = " + anno.testTools()[0]);
        System.out.println("anno.testDate().yymmdd() = " + anno.testDate().yymmdd());
        System.out.println("anno.testType() = " + anno.testType());

        for (String i : anno.testTools())
            System.out.println("TestTools = " + i);

        System.out.println();

        Annotation[] annoArr = cls.getAnnotations();

        System.out.println("annoArr = " + annoArr);

        for (Annotation i : annoArr)
            System.out.println("affecting annotations : " + i);
    }
}