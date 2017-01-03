package com.xanthus.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.xanthus.easyvolley.EasyCallBack;
import com.xanthus.easyvolley.EasyVolley;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_http_get).setOnClickListener(this);
        findViewById(R.id.button_http_post).setOnClickListener(this);
        mTextView = ((TextView) findViewById(R.id.textView));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_http_get:
                EasyVolley.stringGet("https://www.baidu.com", new EasyCallBack() {
                    @Override
                    protected void onResponse(String response) {
                        mTextView.setText("GET:\n"+response);
                    }

                    @Override
                    protected void onErrorResponse(VolleyError error) {
                        if (error != null) {
                            Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.button_http_post:
                EasyVolley.stringPost("https://www.baidu.com", null, new EasyCallBack() {
                    @Override
                    protected void onResponse(String response) {
                        mTextView.setText("POST:\n"+response);
                    }

                    @Override
                    protected void onErrorResponse(VolleyError error) {
                        if (error != null) {
                            Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
        }
    }
}
