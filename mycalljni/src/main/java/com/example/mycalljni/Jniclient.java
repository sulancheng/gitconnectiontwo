package com.example.mycalljni;

import android.util.Log;

/**
 * Created by su
 * on 2017/5/8.
 */
public class Jniclient {
    {
        System.loadLibrary("mycalljni");
    }

    public native String hehe();


    public int clienthehe(int x, int y) {
        Log.e("TAG", "add() x=" + x + " y=" + y);
        return x + y;
    }
}
