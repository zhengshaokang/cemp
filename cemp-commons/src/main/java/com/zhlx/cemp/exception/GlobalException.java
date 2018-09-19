package com.zhlx.cemp.exception;

public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 8722378154776002760L;
    /**
     * 错误码，必须
     */
    private String errorCode;
    /**
     * 参数
     */
    private Object[] params;

    public GlobalException() {
    }

    public GlobalException(String errorCode) {
        this(errorCode, new Object[0]);
    }

    public GlobalException(String errorCode, Object[] params) {
        super(errorCode);
        this.errorCode = errorCode;
        this.params = params;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Object[] getParams() {
        return params;
    }
}
