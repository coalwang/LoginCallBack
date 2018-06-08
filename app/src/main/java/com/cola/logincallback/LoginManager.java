package com.cola.logincallback;

import android.util.Log;

import java.util.ArrayList;

public class LoginManager {

    // 登录回调接口，放在ArrayList中，很多地方都会注册该接口
    private ArrayList<LoginCallback> mLoginCallbackArrayList = new ArrayList<>();

    private static LoginManager sLoginManager;

    private Object mObjectLock = new Object();

    /**
     * 单例模式获取实例
     */
    public static LoginManager getInstance(){
        if (sLoginManager == null){  // 第一次判断是否为null，避免实例不为null的时候，都去拿到锁，浪费资源
            synchronized (LoginManager.class){
                if (sLoginManager == null){
                    sLoginManager = new LoginManager();
                }
            }
        }
        return sLoginManager;
    }

    public void removeLoginCallback(LoginCallback loginCallback){
        synchronized (mObjectLock){
            mLoginCallbackArrayList.remove(loginCallback);
        }
    }

    public void addLoginCallback(LoginCallback loginCallback){
        synchronized (mObjectLock){
            mLoginCallbackArrayList.add(loginCallback);
        }
    }

    public void notifyLoginStateChanged(boolean isLogin){
        if (isLogin == true){  // 如果是登录了，通知所有实现登录接口的类调用登入方法
            for (LoginCallback loginCallback : mLoginCallbackArrayList){
                loginCallback.loginIn();
            }
        }else if (isLogin == false){
            for (LoginCallback loginCallback : mLoginCallbackArrayList){
                loginCallback.loginOut();
            }
        }
    }
}
