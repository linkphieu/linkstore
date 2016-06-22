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
//                ProductResponse response = new Gson().fromJson(new String(responseBody), ProductResponse.class);
//                System.out.println(response);
//                if (response.getStatus() == Util.SUCCESS) {
////                    ArrayList<ProductShow> productShows = response.getData();
//
//                }
//                LoginFragment.errorText.setText(response.getMessage());
                ArrayList<ProductShow> productShows = new ArrayList<ProductShow>();
                if (test == 1) {

                    productShows.add(new ProductShow(1, 1, "testUser", "Sản phẩm", 200000, " VNĐ", 10, 10, 100, " m"));
                    productShows.add(new ProductShow(1, 1, "testUser", "Sản phẩm", 100000, " VNĐ", 10, 10, 100, " m"));
                    productShows.add(new ProductShow(1, 1, "testUser", "Sản phẩm", 200000, " VNĐ", 10, 10, 100, " m"));
                }else{
                    productShows.add(new ProductShow(1, 1, "testUser", "Sản phẩm", 200000, " VNĐ", 10, 10, 100, " m"));
                    productShows.add(new ProductShow(1, 1, "testUser", "Sản phẩm", 100000, " VNĐ", 10, 10, 100, " m"));
                    productShows.add(new ProductShow(1, 1, "testUser", "Sản phẩm", 200000, " VNĐ", 10, 10, 100, " m"));
                    productShows.add(new ProductShow(1, 1, "testUser", "Sản phẩm", 200000, " VNĐ", 10, 10, 100, " m"));
                    productShows.add(new ProductShow(1, 1, "testUser", "Sản phẩm", 100000, " VNĐ", 10, 10, 100, " m"));
                    productShows.add(new ProductShow(1, 1, "testUser", "Sản phẩm", 200000, " VNĐ", 10, 10, 100, " m"));
                }
                ProductFragment.loadProduct(productShows);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                LoginResponse loginResponse = new Gson().fromJson(new String(responseBody), LoginResponse.class);
//                System.out.println(loginResponse);
//                LoginFragment.errorText.setText("Server error " + statusCode);
                ArrayList<ProductShow> productShows = new ArrayList<ProductShow>();
                productShows.add(new ProductShow(1, 1, "testUser", "Sản phẩm", 200000, " VNĐ", 10, 10, 100, " m"));
                ProductFragment.loadProduct(productShows);
            }

        });
    }
}
