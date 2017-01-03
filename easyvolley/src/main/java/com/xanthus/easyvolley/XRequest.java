package com.xanthus.easyvolley;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

/**
 * 继承StringRequest
 * Created by Xanthus on 2016/3/6.
 */
public class XRequest extends StringRequest {
    public XRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    public XRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    public XRequest(int method, String url, EasyCallBack callBack) {
        super(method, url, callBack.getStringListener(), callBack.getErrorListener());
    }
}
