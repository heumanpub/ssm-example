package com.heuman.vo;

import com.heuman.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * Created by heuman on 2017/12/20.
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String CODE_SUCCESS = "success";
    public static final String CODE_ERROR = "error";

    private String code;
    private String msg;
    private T data;

    public static Result newSuccessResult() {
        Result result = new Result();
        result.setCode(CODE_SUCCESS);
        return result;
    }

    public static Result newErrorResult() {
        Result result = new Result();
        result.setCode(CODE_ERROR);
        return result;
    }

    public String toJson() {
        return JsonUtil.toJson(this);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
