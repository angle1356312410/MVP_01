package com.example.dell.demo.presenter;

import android.os.Handler;
import android.util.Log;

import com.example.dell.demo.model.Bean;
import com.example.dell.demo.model.ModelImp;
import com.example.dell.demo.view.ViewImp;
import com.google.gson.Gson;

import java.io.IOException;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * 张艳： on 2017/9/17.
 */

public class PresenterImp {

    ViewImp viewImp;
    ModelImp modelImp;

    Handler handler=new Handler();
    public PresenterImp(final ViewImp viewImp) {
        this.viewImp = viewImp;
        modelImp=new ModelImp();



    }
    public  void getCablck(final ViewImp viewImp){
        modelImp.getCablck(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewImp.Error();
                    }
                },2000);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e(TAG, "onFailure: 请求成功了" );

                String string = response.body().string();
                Gson gson=new Gson();
                Bean bean = gson.fromJson(string, Bean.class);
                viewImp.Success(bean);

            }
        });
    }
}
