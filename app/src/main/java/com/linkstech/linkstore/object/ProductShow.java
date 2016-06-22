package com.linkstech.linkstore.object;

/**
 * Created by Link Larkin on 6/22/2016.
 */
public class ProductShow {
    private int id;
    private int userId;
    private String userScreenName;
    private String show;
    private long price;
    private String priceUnit;
    private int likeCount;
    private int commentCount;
    private int distance;
    private String distanceUnit;

    public ProductShow() {
    }

    public ProductShow(int id, int userId, String userScreenName, String show, long price, String priceUnit, int likeCount, int commentCount, int distance, String distanceUnit) {
        this.id = id;
        this.userId = userId;
        this.userScreenName = userScreenName;
        this.show = show;
        this.price = price;
        this.priceUnit = priceUnit;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.distance = distance;
        this.distanceUnit = distanceUnit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserScreenName() {
        return userScreenName;
    }

    public void setUserScreenName(String userScreenName) {
        this.userScreenName = userScreenName;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }
}
