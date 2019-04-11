package com.example.liwc8.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int TYPE_BOOK = 0;
    private static final int TYPE_APP = 1;
    private ListView list_content;
    private ArrayList<Object> mData = null;
    private MultiLayoutAdapter myAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mData=new ArrayList<>();
        for(int i = 0;i < 20;i++){
            switch ((int)(Math.random() * 2)){
                case TYPE_BOOK:
                    mData.add(new Book("《第一行代码》","郭霖"));
                    break;
                case TYPE_APP:
                    mData.add(new App("百度",R.mipmap.iv_icon_baidu));
                    break;
            }
        }
        list_content=(ListView)findViewById(R.id.list_content);
        myAdapter=new MultiLayoutAdapter(MainActivity.this,mData);
        list_content.setAdapter(myAdapter);
    }
}
