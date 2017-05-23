package com.py.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/12/20.
 */
@Controller
@RequestMapping(value = "/v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    //跳转到jsp页面
    @RequestMapping("jspViewTest")
    public String jspViewTest() {
        return "index";
    }

    //返回数据对象
    @RequestMapping("dataTest")
    @ResponseBody
    public String dataTest() {
        return "index";
    }
}
