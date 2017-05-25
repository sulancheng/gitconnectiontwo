package com.example.su.myappconectiontwo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.su.myappconectiontwo.shouxieban.ShouXieActivity;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button tiaoz = (Button) findViewById(R.id.tiaoz);
        tiaoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ShouXieActivity.class));
            }
        });
    }
}
