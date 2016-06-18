package com.linkstech.linkstore.helper;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by Hoang Son on 2/27/2015.
 */
public final class RequestUtil {
    private static AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

    public static void doGet(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        asyncHttpClient.get(url, params, responseHandler);
    }

    public static void doPost(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        asyncHttpClient.post(url, params, responseHandler);
    }


}
