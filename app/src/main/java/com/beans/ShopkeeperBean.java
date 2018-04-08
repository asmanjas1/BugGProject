package com.beans;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ShopkeeperBean implements Serializable {
    @SerializedName("shopkeeperId")
    private Integer shopkeeperId;
    @SerializedName("firstName")
    private String ownerFirstName;
    @SerializedName("lastName")
    private String ownerLastName;
    @SerializedName("shopName")
    private String shopName;
    @SerializedName("address")
    private ShopkeeperAddressBean address;
    @SerializedName("phoneNumber")
    private Long phoneNumber;

    public ShopkeeperBean(Integer shopkeeperId, String ownerFirstName, String ownerLastName, String shopName, ShopkeeperAddressBean address, Long phoneNumber) {
        this.shopkeeperId = shopkeeperId;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.shopName = shopName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getShopkeeperId() {
        return shopkeeperId;
    }

    public void setShopkeeperId(Integer shopkeeperId) {
        this.shopkeeperId = shopkeeperId;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public ShopkeeperAddressBean getAddress() {
        return address;
    }

    public void setAddress(ShopkeeperAddressBean address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
