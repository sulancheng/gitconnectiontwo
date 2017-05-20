package com.example.mykotlintest

import android.app.Activity
import android.os.Bundle

/**
 * Created by sucheng
 * on 2017/5/19.
 */

class DiaoyonActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myutils = Myutils()
        myutils.one(1, 3)
        myutils.print("nihao")
        Myutils.testtwo()
    }
}
