package com.example.mykotlintest

import android.util.Log

/**
 * Created by sucheng
 * on 2017/5/19.
 */

class Myutils {
    fun one(a: Int, b: Int): Int?{
        return a + b
    }

    fun print(text: String) {
        Log.i("tag", text)
    }

    companion object {
        fun testtwo() {
            Log.i("tag", "测试2")
        }
    }
}
