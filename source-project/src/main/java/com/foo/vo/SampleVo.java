package com.foo.vo;

public class SampleVo {
    /**
     * 이름
     */
    private String name;

    /**
     * 나이
     */
    private int age;

    public SampleVo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
