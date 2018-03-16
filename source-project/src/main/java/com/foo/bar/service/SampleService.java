package com.foo.bar.service;

import com.foo.bar.dao.SampleDao;
import com.foo.vo.SampleVo;

/**
 * Sample Service
 */
public class SampleService {

    private SampleDao dao;

    /**
     * 샘플 메소드
     * @param param
     * @return
     */
    public String method1(String param) {
        // TODO : implements
        return "Hello " + param;
    }

    public SampleVo getSample(String name) {
        //
        return dao.findSample(name, 30);
    }
}
