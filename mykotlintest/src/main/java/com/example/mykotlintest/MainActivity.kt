package com.example.mykotlintest
import android.app.Activity
import android.os.Bundle
class MainActivity : Activity() {
    // c  a  s  k
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // Student.printname("nihao")
    }
    override fun onStart() {
        super.onStart()
    }
}
