package com.beans;

public class ConsumerBean {
    private String UserName;
    private String emailID;
    private Integer phoneNo;
    private ShopkeeperAddressBean address;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public Integer getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Integer phoneNo) {
        this.phoneNo = phoneNo;
    }

    public ShopkeeperAddressBean getAddress() {
        return address;
    }

    public void setAddress(ShopkeeperAddressBean address) {
        this.address = address;
    }
}
