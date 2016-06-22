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
        RequestController.getINSTANCE().getProduct(new RequestParams(),1);
//        ArrayList<ProductShow> productShows = new ArrayList<ProductShow>();
//        productShows.add(new ProductShow(1, 1, "testUser", "Sản phẩm", 200000, " VNĐ", 10, 10, 100, " m"));
//        productShows.add(new ProductShow(1, 1, "testUser", "Sản phẩm", 100000, " VNĐ", 10, 10, 100, " m"));
//        productShows.add(new ProductShow(1, 1, "testUser", "Sản phẩm", 200000, " VNĐ", 10, 10, 100, " m"));
//        ProductFragment.loadProduct(productShows);
        return view;
    }

    public static void loadProduct(ArrayList<ProductShow> productShows) {
        adapter.addAll(productShows);
    }
}

