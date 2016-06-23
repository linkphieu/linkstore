package com.linkstech.linkstore.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.linkstech.linkstore.R;
import com.linkstech.linkstore.adapter.ProductAdapter;
import com.linkstech.linkstore.controller.RequestController;
import com.linkstech.linkstore.helper.ViewHolder;
import com.linkstech.linkstore.object.ProductShow;
import com.linkstech.linkstore.object.Util;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;

/**
 * Created by Link Larkin on 6/16/2016.
 */
public class ProductFragment extends Fragment {
    private static ProductAdapter adapter;
    private View view;
    private ListView ll;

    public ProductFragment() {

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_product, container, false);
        adapter = new ProductAdapter(this.getActivity());
        ll = ViewHolder.getView(view, R.id.product_list);
        ll.setAdapter(adapter);
        RequestParams params = new RequestParams();
        params.add("token", Util.user.getToken());
        RequestController.getINSTANCE().getProduct(params,1);
        return view;
    }

    public static void addProduct(ArrayList<ProductShow> productShows) {
        adapter.addAll(productShows);
    }
}

