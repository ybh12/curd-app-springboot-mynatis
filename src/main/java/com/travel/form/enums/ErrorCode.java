package com.travel.form.enums;

/**
 * @author by 李泽阳 2021/12/8 17:10
 * @description：文件错误码
 */
public enum ErrorCode implements KeyVal {
    /**
     * 失败
     */
    FAIL(-1, "失败！"),
    /**
     * 成功
     */
    SUCCESS(200, "成功！"),

    ;

    ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private final Integer code;

    private final String msg;

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    public static String getMsg(Integer code) {
        for (ErrorCode status : ErrorCode.values()) {
            if (status.getCode().equals(code)) {
                return status.getMsg();
            }
        }
        return "";
    }


}
