package com.xanthus.easyvolley;


import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * 对Volley中Request的Listener<T>和ErrorListener进行简单的封装
 * Created by Xanthus on 2016/3/6.
 */
public abstract class EasyCallBack {

    protected Response.Listener<String> stringListener;
    protected Response.ErrorListener errorListener;

    public EasyCallBack() {
        stringListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                EasyCallBack.this.onResponse(response);
            }
        };
        errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                EasyCallBack.this.onErrorResponse(error);
            }
        };
    }

    public Response.Listener<String> getStringListener() {
        return stringListener;
    }

    public Response.ErrorListener getErrorListener() {
        return errorListener;
    }

    protected abstract void onResponse(String response);

    protected abstract void onErrorResponse(VolleyError error);


}
