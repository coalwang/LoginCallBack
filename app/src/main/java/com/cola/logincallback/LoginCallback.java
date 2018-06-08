package com.cola.logincallback;

/**
 * 登录回调的接口，包含两个登入登出的方法，如果需要在回调时携带参数可以在括号中传入参数
 *
 */
public interface LoginCallback {

    /**
     * 登入回调的方法
     */
    void loginIn();

    /**
     * 登出回调的方法
     */
    void loginOut();
}
