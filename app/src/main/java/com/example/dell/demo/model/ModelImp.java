package com.example.dell.demo.model;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 张艳： on 2017/9/17.
 */

public class ModelImp implements IModel {
    @Override
    public void getCablck(Callback callback) {
        String url = "http://v.juhe.cn/toutiao/index?type=top&key=097060266650f67b2cebd2a06aded587";
        OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }
}
