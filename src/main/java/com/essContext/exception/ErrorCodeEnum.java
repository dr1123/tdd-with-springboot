package com.essContext.exception;

/**
 * @ClassName: ErrorCodeEnum
 * @Description: 基础枚举code码
 * @author dingrui
 * @date 2020/7/25
 * @version V1.0
 */
public enum ErrorCodeEnum {

    DR10001("10001", "当前企业已注册"),
    DR10002("10002", "统一社会信用代码与企业名称不匹配"),
    DR10003("10003", "统一社会信用代码与企业名称不匹配"),

    ;

    private String code;
    private String msg;

    /**
     * Msg string.
     *
     * @return the string
     */
    public String msg() {
        return msg;
    }
    /**
     * Code String.
     *
     * @return the String
     */
    public String code() {
        return code;
    }

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Gets enum.
     *
     * @param code the code
     *
     * @return the enum
     */
    public static ErrorCodeEnum getEnum(int code) {
        for (ErrorCodeEnum ele : ErrorCodeEnum.values()) {
            if (ele.code() .equals(code) ) {
                return ele;
            }
        }
        return null;
    }
}
