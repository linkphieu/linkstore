package com.linkstech.linkstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linkstech.linkstore.R;
import com.linkstech.linkstore.helper.ViewHolder;
import com.linkstech.linkstore.object.ProductShow;

import java.text.DecimalFormat;

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
        screenName.setText(item.getUserScreenName());
        TextView price = ViewHolder.getView(convertView, R.id.price);
        price.setText(item.getPrice() + "");
        TextView show = ViewHolder.getView(convertView, R.id.show_text);
        show.setText(item.getShow());
        TextView price_unit = ViewHolder.getView(convertView, R.id.price_unit);
        price_unit.setText(" " + item.getPriceUnit());
        TextView liked = ViewHolder.getView(convertView, R.id.like_count);
        liked.setText(item.getLiked().split(",").length);
        TextView commentCount = ViewHolder.getView(convertView, R.id.comment_count);
        commentCount.setText(item.getCommentCount());
        TextView distance = ViewHolder.getView(convertView, R.id.distance);
        double distanced = item.getDistance();
        if (distanced < 1000) {
            distance.setText((int) distanced);
        } else {
            DecimalFormat df = new DecimalFormat("#.#");
            String dx = df.format(distanced / 1000);
            distanced = Double.valueOf(dx);
            distance.setText("" + distanced);
        }
        return convertView;
    }
}
