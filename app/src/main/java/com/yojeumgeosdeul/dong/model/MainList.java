package com.yojeumgeosdeul.dong.model;

public class MainList {
    String ivMainItem;
    String tvMainStore;
    String tvMainStoreDong;
    String tvGainPersent;
    String tvMainPersent;
    String tvTime;
    String tvLocation;
    
    public MainList(String ivMainItem, String tvMainStore, String tvMainStoreDong, String tvGainPersent, String tvMainPersent, String tvTime, String tvLocation) {
        this.ivMainItem = ivMainItem;
        this.tvMainStore = tvMainStore;
        this.tvMainStoreDong = tvMainStoreDong;
        this.tvGainPersent = tvGainPersent;
        this.tvMainPersent = tvMainPersent;
        this.tvTime = tvTime;
        this.tvLocation = tvLocation;
    }
    
    public String getIvMainItem() {
        return ivMainItem;
    }
    
    public String getTvGainPersent() {
        return tvGainPersent;
    }
    
    public String getTvLocation() {
        return tvLocation;
    }
    
    public String getTvMainPersent() {
        return tvMainPersent;
    }
    
    public String getTvMainStore() {
        return tvMainStore;
    }
    
    public String getTvMainStoreDong() {
        return tvMainStoreDong;
    }
    
    public String getTvTime() {
        return tvTime;
    }
}
