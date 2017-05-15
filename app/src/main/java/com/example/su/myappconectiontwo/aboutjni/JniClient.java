package com.example.su.myappconectiontwo.aboutjni;

import android.util.Log;

/**
 * Created by su
 * on 2017/5/8.
 */
public class JniClient {
    static  {
        System.loadLibrary("app");
    }
    public native void callbackAdd();
    /**
     * 触发C代码让其调用sayHello()方法
     */
    public native void callbackSayHello();
    public int add(int x, int y) {
        Log.e("TAG", "add() x=" + x + " y=" + y);
        return x + y;
    }




    public void sayHello(){
        Log.e(JniClient.class.getSimpleName(),"sayHello-----------------------");
    }
}
