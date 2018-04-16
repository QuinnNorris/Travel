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
    private Object beanObject;

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

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getBeanObject() {
        return beanObject;
    }

    public void setBeanObject(Object beanObject) {
        this.beanObject = beanObject;
    }
}
