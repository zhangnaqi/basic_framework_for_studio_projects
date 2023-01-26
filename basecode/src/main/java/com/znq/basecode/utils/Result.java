package com.znq.basecode.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    Integer code;

    String message;

    T data;

    public Result(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public Result(String message) {
        this.message = message;
    }

    public static Result<?> SUCCESS() {
        return new Result<>(ResultCode.SUCCESS);
    }

    public static <T> Result<T> SUCCESS(T data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(ResultCode.SUCCESS.code(), message, data);
    }

    public static Result<?> FAIL() {
        return new Result<>(ResultCode.FAIL);
    }

    public static Result<?> FAIL(String message) {
        return new Result<>(ResultCode.FAIL.code(), message, null);
    }

    public static Result<?> FAIL(ResultCode resultCode) {
        return new Result<>(resultCode);
    }

    public static <T> Result<T> instance(Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

}
