package com.xmzj.auth.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xmzj.auth.model.TblAdmin;
import com.xmzj.frame.BaseServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by RayMa on 2017/4/29.
 */
public class IAdminServiceTest extends BaseServiceTest {

    @Autowired
    IAdminService serviceTest;

    @Test
    public void test() {
       List<TblAdmin> list= serviceTest.findAll();
        System.out.println("输出："+JSONObject.toJSONString(list));
    }

}
