package com.sm.vo;

/**
 * @author guoqing.zhao
 * <p>
 * restful返回消息体
 */
public class ResultEntry<T> {
    public static final int SUCCESSFUL = 1;//成功
    public static final int EXCEPTION = 2;//异常
    public static final int NO_AUTHENTICATION = 3;//没有认证
    public static final int NO_AUTHORIZATION = 4;//没有授权
    public static final int UNLOGIN = 5;//未登陆
    public static final int LOGIN_ERROR = 6;//登陆错误

    private int code = SUCCESSFUL;
    private String msg;
    private T data;
    private long total = 0;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
