package com.potato.commonpro.model;

/**
 * 快递公司
 */
public class Courier {

    private int courierId; //快递公司编号

    private String courierName; // 快递公司名称

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

}
