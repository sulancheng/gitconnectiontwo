package com.example.mycalljni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Jniclient jniclient = new Jniclient();
        String hehe = jniclient.hehe();
        Log.i("hehe",hehe+"");
        // hehe();
        //uninstallLisetner("/data/data/com.example.mycalljni", Build.VERSION.SDK_INT);
    }
}
