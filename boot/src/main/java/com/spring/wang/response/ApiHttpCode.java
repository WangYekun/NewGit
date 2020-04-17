package com.spring.wang.response;

/**
 * @author niunafei
 * @function
 * @email niunafei0315@163.com
 * @date 2019/6/28  下午2:02
 */
public enum ApiHttpCode {
    /**
     * 响应成功
     */
    SUCCESS(200, "OK"),
    /**
     * 服务器异常
     */
    ERROR(500, "ERROR"),
    /**
     * 未授权访问
     */
    UNAUTHORIZED(401, "访问未授权");

    private int code;
    private String desc;

    ApiHttpCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static ApiHttpCode valueOf(int value) {
        for (ApiHttpCode role : ApiHttpCode.values()) {
            if (role.code == value) {
                return role;
            }
        }
        return null;
    }
}