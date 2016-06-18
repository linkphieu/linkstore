package com.linkstech.linkstore.object.response;

import com.linkstech.linkstore.object.BaseObject;

/**
 * Created by Link Larkin on 6/17/2016.
 */
public class BaseResponse extends BaseObject{
    private int status;
    private String message;

    public BaseResponse() {
    }

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
