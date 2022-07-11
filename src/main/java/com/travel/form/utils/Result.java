package com.travel.form.utils;

import com.travel.form.enums.ErrorCode;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author by 李泽阳 on 2022/1/3 0:28
 * @description：返回体
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public static Result ok() {
        return Objects.requireNonNull(new Result().put("code", ErrorCode.SUCCESS.getCode())).put("msg", "SUCCESS").put("success", true);
    }

    public static <T> Result ok(String msg, T data) {
        return Objects.requireNonNull(Objects.requireNonNull(new Result().put("code", ErrorCode.SUCCESS.getCode())).put("msg", msg).put("success", true)).put("data", data);
    }

    public static <T> Result ok(T data) {
        return Objects.requireNonNull(new Result().put("code", ErrorCode.SUCCESS.getCode())).put("msg", ErrorCode.SUCCESS.getMsg()).put("success", true).put("data", data);
    }

    public static Result error(String msg) {
        return Objects.requireNonNull(new Result().put("code", ErrorCode.FAIL.getCode())).put("msg", msg).put("success", false);
    }

    public static Result error(ErrorCode errorCode) {
        return Objects.requireNonNull(new Result().put("code", errorCode.getCode())).put("msg", errorCode.getMsg()).put("success", false);
    }

    public static Result error() {
        return Objects.requireNonNull(Objects.requireNonNull(new Result().put("code", ErrorCode.FAIL.getCode())).put("msg", ErrorCode.FAIL.getMsg())).put("success", false);
    }

    public static Result error(String msg, int code) {
        return Objects.requireNonNull(Objects.requireNonNull(new Result().put("code", code)).put("msg", msg)).put("success", false);
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
