package com.example.su.myappconectiontwo.aboutjni;

import android.app.Activity;
import android.os.Bundle;

import com.example.su.myappconectiontwo.R;

public class AboutJniActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_jni);
        JniClient jniClient = new JniClient();
        jniClient.callbackAdd();
        jniClient.sayHello();
    }
}
