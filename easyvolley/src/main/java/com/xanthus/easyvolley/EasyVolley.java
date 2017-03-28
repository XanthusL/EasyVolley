package com.xanthus.easyvolley;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * 对Volley进行简单的封装
 * Created by Xanthus on 2016/3/6.
 */
public class EasyVolley {
    //只用一个RequestQueue,在init()方法中实例化
    private static RequestQueue sRequestQueue;
    //http请求头
    private static Map<String, String> sHeaders;

    public static void init(Context context) {
        sRequestQueue = Volley.newRequestQueue(context);
        sHeaders = new HashMap<>();
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }
    
    public static void httpReuqest(int type, String url, final Map<String, String> params, EasyCallBack callBack) {
        if (sRequestQueue == null) {
            throw new RuntimeException("尚未初始化,需要EasyVolley.init();");
        }
        XRequest request = new XRequest(type, url, callBack) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (params != null) {
                    return params;
                }
                return super.getParams();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (sHeaders != null) {
                    Log.e("EasyVolley", sHeaders.toString());
                    return sHeaders;
                }
                return super.getHeaders();
            }
        };
        sRequestQueue.add(request);
    }

    /**
     * 以GET方式请求String类型的数据
     *
     */
    public static void stringGet(String url, EasyCallBack callBack) {
        if (sRequestQueue == null) {
            throw new RuntimeException("尚未初始化,需要EasyVolley.init();");
        }
        XRequest request = new XRequest(Request.Method.GET, url, callBack) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (sHeaders != null) {
                    Log.e("EasyVolley", sHeaders.toString());
                    return sHeaders;
                }
                return super.getHeaders();
            }
        };
        sRequestQueue.add(request);
    }

    /**
     * 以POST方式请求String类型的数据
     */
    public static void stringPost(String url, final Map<String, String> params, EasyCallBack callBack) {
        if (sRequestQueue == null) {
            throw new RuntimeException("尚未初始化,需要EasyVolley.init();");
        }

        XRequest request = new XRequest(Request.Method.POST, url, callBack) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (sHeaders != null) {
                    Log.e("EasyVolley", sHeaders.toString());
                    return sHeaders;
                }
                return super.getHeaders();
            }
        };
        sRequestQueue.add(request);
    }

    /**
     * 用于多个重名参数的情况
     *
     * @param params   将参数以类似GET请求的方式拼接(?param1=123&param2=456)
     */
    public static void stringPost(String url,  EasyCallBack callBack,final String params) {
        if (sRequestQueue == null) {
            throw new RuntimeException("尚未初始化,需要EasyVolley.init();");
        }
        XRequest request = new XRequest(Request.Method.POST, url, callBack) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                if (params != null) {
                    return params.getBytes();
                }
                return null;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (sHeaders != null) {
                    return sHeaders;
                }
                return super.getHeaders();
            }
        };
        sRequestQueue.add(request);
    }

    /**
     * 用于设置http请求头
     */
    public static void setHeaders(Map<String, String> headers) {
        EasyVolley.sHeaders = headers;
    }

    /**
     * 获取http请求头
     */
    public static Map<String, String> getHeaders() {
        return sHeaders;
    }
}
