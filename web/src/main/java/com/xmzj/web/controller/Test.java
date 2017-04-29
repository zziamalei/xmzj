package com.xmzj.web.controller;

import com.xmzj.auth.service.IAdminService;
import com.xmzj.common.ReturnBean;

import com.xmzj.common.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by RayMa on 2017/4/26.
 */

@Controller("test")
public class Test {

    @Autowired
    IAdminService testService;


    @RequestMapping("/test")
    @ResponseBody
    public ReturnBean test() {
        List list = testService.findAll();
        return ReturnBean.getSuccessListInstance(list);

    }

}
