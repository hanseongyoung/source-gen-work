package com.foo.bar.dao;


import com.foo.vo.SampleVo;

public class SampleDao {
    //
    public SampleVo findSample(String name, int age) {
        return new SampleVo(name, age);
    }
}
