package com.kkhjl.cloud.member.bo;

import java.io.Serializable;
public class MemberInfo implements Serializable {
    private long id;
    private String name;
    private String address;
    private long identify;
    private long sort;

    public long getSort() {
        return sort;
    }

    public void setSort(long sort) {
        this.sort = sort;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getIdentify() {
        return identify;
    }

    public void setIdentify(long identify) {
        this.identify = identify;
    }
}
