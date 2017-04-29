package com.xmzj.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import com.xmzj.common.i18n.Language;
import  com.xmzj.common.Enums.EnumLanguageType;
import  com.xmzj.common.frame.SpringContextUtils;

public class GlobalizationUtils {

    private static List<Language> languageList = new ArrayList<Language>();

    /**
     * 获取国家化资源文件配置
     *
     * @param key
     * @return
     * @author lei.ma 2016年6月21日 下午1:36:09
     */
    public static String getMessage(String key) {
        if (StringUtils.isEmpty(key)) return "";
        RequestAttributes rAttributes = RequestContextHolder.getRequestAttributes();
        String something = null;
        HttpServletRequest request = null;
        if (null != rAttributes) {
            request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            RequestContext requestContext = new RequestContext(request);
            return requestContext.getMessage(key);
        }

        ApplicationContext applicationContext = SpringContextUtils.getApplicationContext();
        ResourceBundleMessageSource messageSource = (ResourceBundleMessageSource) applicationContext
                .getBean("messageSource");

        try {
            something = messageSource.getMessage(key, null, Locale.CHINA);
        } catch (NoSuchMessageException e) {
            something = "";
            e.printStackTrace();
        }

        return something;

    }

    public static String getMessage(EnumLanguageType language, String key) {

        ApplicationContext applicationContext = SpringContextUtils.getApplicationContext();
        ResourceBundleMessageSource messageSource = (ResourceBundleMessageSource) applicationContext
                .getBean("messageSource");
        String something = "";
        switch (language) {
            case english:
                something = messageSource.getMessage(key, null, Locale.ENGLISH);
                break;

            default:
                try {
                    something = messageSource.getMessage(key, null, Locale.CHINA);
                } catch (NoSuchMessageException e) {
                    something = "未知的key:" + key;
                }
                break;
        }

        return something;

    }

    public static String getLanguage() {

        RequestAttributes rAttributes = RequestContextHolder.getRequestAttributes();
        String something = null;
        HttpServletRequest request = null;
        if (null != rAttributes) {
            request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            RequestContext requestContext = new RequestContext(request);
            Locale locale = requestContext.getLocale();
            if (Locale.ENGLISH == locale) {
                return "en";
            }
        }
        return "zh";
    }

    public static List<Language> getLanguageList() {
        if (languageList == null || languageList.isEmpty()) {

            Language languageEn = new Language("en", "English");
            Language languageCh = new Language("zh", "中文");
            languageList.add(languageEn);
            languageList.add(languageCh);
        }
        return languageList;
    }

}
