package com.wind.boot.config.message;

/**
 * 
 * @fileName HttpCode.java
 * @package com.ancda.palmbaby.ancda.common.constant
 * @description Ajax 请求时的自定义查询状态码，主要参考Http状态码，但并不完全对应
 * @author yujl@ancda.com
 * @date 2017年6月23日 上午10:58:31
 * @version V1.0
 */
public enum HttpCode implements BaseCode {

    /** 200请求成功 */
    OK(200, "请求成功"),
    /** 0操作失败 */
    FAIL(0, "操作失败"),
    /** 100 数据为空 */
    DATA_IS_EMPTY(100, "数据为空"),
    /** 207频繁操作 */
    MULTI_STATUS(207, "频繁操作"),
    /** 400请求参数出错 */
    BAD_REQUEST(400, "请求参数出错"),
    /** 401没有权限访问 */
    UNAUTHORIZED(401, "没有权限访问"),
    /** 403禁止访问 */
    FORBIDDEN(403, "禁止访问"),
    /** 404找不到页面 */
    NOT_FOUND(404, "找不到页面"),
    /** 408请求超时 */
    REQUEST_TIMEOUT(408, "请求超时"),
    /** 410请求资源不可用 */
    GONE(410, "请求资源不可用"),
    /** 500服务器出错 */
    INTERNAL_SERVER_ERROR(500, "服务器出错"),


    /** ######## 用户相关 ######## */
    /** 100001登录失败 */
    USER_LOGIN_FAIL(100001, "登录失败"),
    /** 100002用户不存在 */
    USER_NOT_FOUND(100002, "用户不存在"),
    /** 100003密码错误 */
    USER_PASSWORD_ERROR(100003, "密码错误"),
    /** 100004账号被锁定 */
    USER_ACCOUNT_LOCK(100004, "账号被锁定"),
    /** 100005账号已被禁用 */
    USER_ACCOUNT_DISABLED(100005, "账号已被禁用"),
    /** 100006Token已过期 */
    USER_TOKEN_EXPIRED(100006, "Token已过期"),
    /** 100007账号以在其他地方登陆 */
    USER_LOG_IN_ELSEWHERE(100007, "账号以在其他地方登陆"),
    /** 100008手机号重复 **/
    USER_PHONE_REPEAT(100008, "手机号重复"),
    /** 100009当日短信发送次数超限 **/
    SMS_TIMES_LIMIT(100009, "当日短信发送次数超限"),
    /** 100010验证码过期 **/
    CAPTCHA_EXPIRED(100010, "验证码过期"),
    /** 100011验证码错误 **/
    CAPTCHA_ERROR(100011, "验证码错误"),
    /** 100012验证码发送失败 **/
    CAPTCHA_FAIL(100012, "验证码发送失败"),

    /** 100013请勿频繁发送验证码，稍后重试 **/
    CAPTCHA_FREQUENTLY_SEND(100013, "请勿频繁发送验证码，稍后重试"),

    /** 当前机构下该用户已存在*/
    ORGANIZATION_NAME_ALREADY_EXISTS(100014, "当前机构下该用户已存在"),

    /** 用户名已存在 */
    LOGIN_NAME_ALREADY_EXISTS(100015, "用户名已存在"),
    /** 用户名不存在 */
    LOGIN_NAME_NOT_EXISTS(100016, "用户名不存在"),

    /** 账号或密码错误 */
    ACCOUNT_OR_PWD_ERR(100017, "账号或密码错误"),
    ;

    private final Integer code;

    private final String msg;

    HttpCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    public static HttpCode valueOf(int code) {
        for (HttpCode status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }

    public boolean equalCode(Integer code) {
        return this.code.equals(code);
    }
}