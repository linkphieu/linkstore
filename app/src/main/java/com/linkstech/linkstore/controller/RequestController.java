package com.linkstech.linkstore.controller;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.linkstech.linkstore.MainActivity;
import com.linkstech.linkstore.R;
import com.linkstech.linkstore.fragment.LoginFragment;
import com.linkstech.linkstore.fragment.ProductFragment;
import com.linkstech.linkstore.helper.RequestUtil;
import com.linkstech.linkstore.helper.ViewHolder;
import com.linkstech.linkstore.object.ProductShow;
import com.linkstech.linkstore.object.Util;
import com.linkstech.linkstore.object.response.LoginResponse;
import com.linkstech.linkstore.object.response.ProductResponse;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Link Larkin on 6/17/2016.
 */
public class RequestController {
    private static RequestController requestController;

    private RequestController() {
    }

    public static RequestController getINSTANCE() {
        if (requestController == null) {
            requestController = new RequestController();
        }
        return requestController;
    }

    public void login(RequestParams requestParams, final FragmentManager fragmentManager) {
        RequestUtil.doGet(Util.LOGIN_URL, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                LoginResponse loginResponse = new Gson().fromJson(new String(responseBody), LoginResponse.class);
                System.out.println(loginResponse);
                if (loginResponse.getStatus() == Util.SUCCESS) {
                    Util.user = loginResponse.getData();
                    MainActivity.userInfo.setVisibility(View.VISIBLE);
                    MainActivity.btLogin.setVisibility(View.GONE);
                    TextView username = ViewHolder.getView(MainActivity.userInfo, R.id.username);
                    username.setText(Util.user.getUsername());
                    FragmentSwitch.getINSTANCE().switchFragment(FragmentSwitch.PRODUCT, fragmentManager);
                }
                LoginFragment.errorText.setText(loginResponse.getMessage());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                LoginResponse loginResponse = new Gson().fromJson(new String(responseBody), LoginResponse.class);
//                System.out.println(loginResponse);
                LoginFragment.errorText.setText("Server error " + statusCode);
            }
        });
    }

    public void getProduct(RequestParams requestParams, final int test) {
        RequestUtil.doGet(Util.PRODUCT_URL, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responseS = new String(responseBody);
                System.out.println(responseS);
                ProductResponse response = new Gson().fromJson(new String(responseBody), ProductResponse.class);

                if (response.getStatus() == Util.SUCCESS) {
                    ArrayList<ProductShow> productShows = response.getData();
                    ProductFragment.addProduct(productShows);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println(new String(responseBody));
            }

        });
    }
}
