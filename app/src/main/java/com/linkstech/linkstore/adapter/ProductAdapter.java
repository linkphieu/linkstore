package com.linkstech.linkstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linkstech.linkstore.R;
import com.linkstech.linkstore.controller.RequestController;
import com.linkstech.linkstore.helper.ViewHolder;
import com.linkstech.linkstore.object.ProductShow;
import com.loopj.android.http.RequestParams;

/**
 * Created by Link Larkin on 6/22/2016.
 */
public class ProductAdapter extends BaseItemAdapter<ProductShow> {
    public ProductAdapter(Context context) {
        super(context, R.layout.product_item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext()).inflate(this.getResource(), null);
        }
        final ProductShow item = getItem(position);
        TextView screenName = ViewHolder.getView(convertView, R.id.screen_name);
        screenName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestController.getINSTANCE().getProduct(new RequestParams(),2);
            }
        });
        screenName.setText(item.getUserScreenName());
        TextView price = ViewHolder.getView(convertView, R.id.price);
        price.setText(item.getPrice() + "");
        TextView show = ViewHolder.getView(convertView, R.id.show_text);
        show.setText(item.getShow());
        return convertView;
    }
}
