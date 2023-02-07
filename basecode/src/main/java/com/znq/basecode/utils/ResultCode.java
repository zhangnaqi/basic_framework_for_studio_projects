package com.znq.basecode.utils;

public enum ResultCode {
    /**
     * 成功状态码
     */
    SUCCESS(200, "操作成功！"),

    /**
     * 404未找到状态码
     */
    BAD_REQUEST(400, "404未找到状态码"),

    /**
     * 服务器错误
     */
    FAIL(500, "操作失败！");

    // 操作代码
    int code;
    // 提示信息
    String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
