package com.linkstech.linkstore.object;

import com.google.gson.Gson;

/**
 * Created by Link Larkin on 6/17/2016.
 */
public class BaseObject {
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
