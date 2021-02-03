package com.asiainfo.dh.main.service;

import com.asiainfo.dh.main.bean.Captcha;
import com.asiainfo.dh.main.bean.PageBean;
import com.github.pagehelper.PageInfo;

public interface CaptchaService {

    PageInfo<Captcha> getPageCaptcha(PageBean<Captcha> pageBean) throws Exception;

}
