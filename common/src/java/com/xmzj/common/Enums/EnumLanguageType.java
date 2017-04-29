package com.xmzj.common.Enums;

/**
 * Created by RayMa on 2017/4/26.
 */
public enum EnumLanguageType {

    china("zh","汉语"),//
    china_zh_CN("zh_CN","汉语"),//
    english("en","英文");//

    private String  value;
    private String desc;


    private EnumLanguageType(String value,String desc) {
        this.value = value;
        this.desc=desc;
    }
    public String  getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static EnumLanguageType setValue(String  str) {
        for (EnumLanguageType e:EnumLanguageType.values()) {
            if(e.getValue().equals(str)){
                return e;
            }
        }
        return china;

    }


}
