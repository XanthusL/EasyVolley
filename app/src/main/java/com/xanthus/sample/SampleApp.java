package com.xanthus.sample;

import android.app.Application;

import com.xanthus.easyvolley.EasyVolley;

/**
 * Created by liyiheng on 17/1/3.
 */

public class SampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EasyVolley.init(this);

        //HashMap<String, String> headers = new HashMap<>();
        //headers.put("key","value");
        //EasyVolley.setHeaders(headers);
    }
}
