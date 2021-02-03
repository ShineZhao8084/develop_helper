package com.asiainfo.dh.main.controller;

import com.alibaba.fastjson.JSON;
import com.asiainfo.dh.main.bean.APIResponse;
import com.asiainfo.dh.main.bean.Captcha;
import com.asiainfo.dh.main.bean.PageBean;
import com.asiainfo.dh.main.service.CaptchaService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CaptchaController {

    @Resource
    private CaptchaService captchaService;

    @RequestMapping(path = "/captcha", method = RequestMethod.POST)
    public String getPageCaptcha(@RequestBody PageBean<Captcha> pageBean) throws Exception {
        APIResponse<PageInfo<Captcha>> response = new APIResponse<>();
        PageInfo<Captcha> dhCaptchaList = captchaService.getPageCaptcha(pageBean);
        response.setResult(dhCaptchaList);
        return JSON.toJSONString(response);
    }

}
