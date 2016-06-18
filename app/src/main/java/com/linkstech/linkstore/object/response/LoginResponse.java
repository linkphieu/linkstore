package com.linkstech.linkstore.object.response;

import com.linkstech.linkstore.object.UserObject;

/**
 * Created by Link Larkin on 6/17/2016.
 */
public class LoginResponse extends BaseResponse {
    private UserObject data;

    public UserObject getData() {
        return data;
    }

    public void setData(UserObject data) {
        this.data = data;
    }
}
