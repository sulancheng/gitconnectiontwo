package com.atguigu.ccalljava2;

import android.util.Log;

/**
 * 作者：杨光福 on 2016/4/19 09:19
 * 微信：yangguangfu520
 * QQ号：541433511
 * 作用：xxxx
 */
public class JNI {



    /**
     * 触发C代码让其调用sayHello()方法
     */
    public native void callbackSayHello();


    public void sayHello(){
        Log.e(JNI.class.getSimpleName(),"sayHello-----------------------");
    }
}
