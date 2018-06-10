package com.nyeong.util;

/**
 * Title: BaseJson
 * Description: 各层次间传输数据的工具
 *
 * @date: 2017/9/5 下午7:33
 * @author: quinn_norris
 * @version: 1.0
 */
public class BaseJson {

    private String errorCode;
    private Object object;

    public BaseJson() {
    }

    public BaseJson(Object object) {
        this.object = object;
    }

    public BaseJson(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public BaseJson setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public Object getObject() {
        return object;
    }

    public BaseJson setObject(Object object) {
        this.object = object;
        return this;
    }

}
