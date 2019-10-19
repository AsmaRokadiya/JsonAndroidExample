package com.example.jsonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {


    Button btnsubmit;
    String responseText;
    StringBuffer response;
    Activity activity;
    URL url;
    ProgressDialog progressDialog;
    ListView listView;

    String path="https://api.myjson.com/bins/13wavw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsubmit=(Button) findViewById(R.id.btn);
        listView=(ListView)findViewById(R.id.list1);

    }
}
