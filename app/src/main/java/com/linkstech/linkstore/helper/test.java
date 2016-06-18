package com.linkstech.linkstore.helper;


import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Link Larkin on 6/16/2016.
 */
public class test {
    public static void main(String[] args) {
        while (true){
            try {
                Thread.sleep(5000);
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        loadData();
                    }
                };
                thread.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
    public static void loadData() {
        RequestUtil.doGet("http://localhost:8084/Linkstech/service/login?username=admin&password=trung123", new RequestParams(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                System.out.println(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
