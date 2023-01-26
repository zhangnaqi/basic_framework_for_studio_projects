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
    ERROR(500, "操作失败！"),

    // 操作代码
    int code;
    // 提示信息
    String msg;

    HttpStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

}
