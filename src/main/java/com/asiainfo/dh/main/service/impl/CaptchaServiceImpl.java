package com.asiainfo.dh.main.service.impl;

import com.asiainfo.dh.core.exceptions.BusinessException;
import com.asiainfo.dh.main.bean.Captcha;
import com.asiainfo.dh.main.bean.PageBean;
import com.asiainfo.dh.main.mapper.CaptchaMapper;
import com.asiainfo.dh.main.service.CaptchaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Resource
    private CaptchaMapper captchaMapper;

    @Override
    public PageInfo<Captcha> getPageCaptcha(PageBean<Captcha> pageBean) throws Exception {
        int pageNum = pageBean.getPageNum();
        int pageSize = pageBean.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Captcha> captchaList = captchaMapper.getPageCaptcha(pageBean.getBean());
        return new PageInfo<>(captchaList);
    }

    @Override
    public void insertCaptcha(Captcha captcha) throws Exception {
        captcha.setCreateDate(new Date());
        String content = captcha.getContent();

        int result = captchaMapper.insertSelective(captcha);
        if (result == 0) {
            throw new BusinessException(5000, "保存验证码失败！");
        }
    }

}
