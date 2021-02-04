package com.asiainfo.dh.main.mapper;

import com.asiainfo.dh.main.bean.Captcha;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CaptchaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Captcha record);

    int insertSelective(Captcha record);

    Captcha selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Captcha record);

    int updateByPrimaryKey(Captcha record);

    List<Captcha> getPageCaptcha(Captcha record);

}