package com.example.su.myappconectiontwo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private String[] iconName = { "通讯录", "日历", "照相机", "时钟", "游戏", "短信", "铃声",
            "设置", "语音", "天气", "浏览器", "视频" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button tiaoz = (Button) findViewById(R.id.tiaoz);
        tiaoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EditActivity.class));
            }
        });
        GridView gridview = (GridView) findViewById(R.id.gv);
        gridview.setAdapter(new Adapter());
    }
    private class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return iconName.length;
        }

        @Override
        public String getItem(int arg0) {
            return iconName[arg0];
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            arg1 = getLayoutInflater().inflate(R.layout.wallet_item, null);
            TextView textView = (TextView) arg1.findViewById(R.id.text) ;
            textView.setText(iconName[arg0]) ;
            return arg1;
        }
    }
}
