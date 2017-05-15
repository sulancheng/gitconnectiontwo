package com.atguigu.ccalljava2;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    private JNI jni;
    {
        System.loadLibrary("ccalljava2");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jni = new JNI();
        jni.callbackSayHello();
    }
}
