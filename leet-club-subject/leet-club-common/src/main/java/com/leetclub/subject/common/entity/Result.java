package com.leetclub.subject.common.entity;

import com.leetclub.subject.common.enums.ResultCodeEnum;
import lombok.Data;

/**
 * @author sinker
 * @date 2025/7/18 11:48
 */
@Data
public class Result<T> {
    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> ok(){
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return result;
    }

    public static <T> Result<T> fail(){
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMessage(ResultCodeEnum.FAIL.getMessage());
        return result;
    }

    public static <T> Result<T> ok(T data){
        Result<T> result = ok();
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(T data){
        Result<T> result = fail();
        result.setData(data);
        return result;
    }
}
