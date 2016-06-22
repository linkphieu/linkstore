package com.linkstech.linkstore.object.response;

import com.linkstech.linkstore.object.ProductShow;

import java.util.ArrayList;

/**
 * Created by Link Larkin on 6/22/2016.
 */
public class ProductResponse extends BaseResponse {
    private ArrayList<ProductShow> data;

    public ArrayList<ProductShow> getData() {
        return data;
    }

    public void setData(ArrayList<ProductShow> data) {
        this.data = data;
    }
}
