# EasyVolley

对Volley进行简单的封装,方便使用

retrofit + RxJava 的封装见[ApkBus](https://github.com/XanthusL/ApkBus)


## usage


1.初始化,建议在Application中进行初始化操作

      EasyVolley.init(this);
      
2.简单使用

        
        // GET请求-----------------------------------------------------
        EasyVolley.stringGet("this param is URL", new EasyCallBack() {
            //请求成功的回调(http状态码200)
            @Override
            protected void onResponse(String response) {

            }

            //错误回调
            @Override
            protected void onErrorResponse(VolleyError error) {
                  // 由于异常导致此错误回调时,error.networkResponse为null
                  // 因此使用error.networkResponse时建议对其进行非空判断,避免NP
                  
                  //error.networkResponse.statCode为http状态码
                  //error.networkResponse.data为数据内容
            }
        });
        
        // POST请求-----------------------------------------------------
        EasyVolley.stringPost("url", new HashMap<String, String>(), new EasyCallBack() {
            @Override
            protected void onResponse(String response) {

            }

            @Override
            protected void onErrorResponse(VolleyError error) {

            }
        });
        
        // POST请求,有同名参数时-----------------------------------------
        EasyVolley.stringPost("url", new EasyCallBack() {
            @Override
            protected void onResponse(String response) {

            }

            @Override
            protected void onErrorResponse(VolleyError error) {

            }
        }, "?param=abc&param=456");


        
3.对请求错误的情况进行统一判断和处理

      可在EasyCallBack.java中对错误情况进行判断和处理,就不必使用时在各个逻辑的错误回调中单独判断;
      EasyCallBack的onErrorResponse()方法也可以改为非抽象方法,这样就可以仅在需要的时候重写该方法.
      详见EasyCallBack.java中的注释
      
4.设置请求头.如添加授权信息等

      HashMap<String,String> map = new HashMap();
      map.put("test1","hahahaha");
      EasyVolley.setHeaders(map);
        
        
###just notes

https://www.codingame.com/home

https://coderbyte.com/challenges

http://gocode.io/

https://leetcode.com/
