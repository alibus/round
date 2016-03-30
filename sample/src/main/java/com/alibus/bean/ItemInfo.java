package com.alibus.bean;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：round
 * 类描述：
 * 创建人：alibus
 * 创建时间：16-3-24 下午4:37
 * 修改人：alibus
 * 修改时间：16-3-24 下午4:37
 * 修改备注：
 */
public class ItemInfo{

    String username;
    String imageUri;
    String describe;
    int supportNumber;
    int opposeNumber;
    int hotspot;
    List<String> priviewList;

    public ItemInfo(){

    }

    public ItemInfo(String username, String imageUri, String describe, int supportNumber, int opposeNumber, List<String> priviewList) {
        this.username = username;
        this.imageUri = imageUri;
        this.describe = describe;
        this.supportNumber = supportNumber;
        this.opposeNumber = opposeNumber;
        this.priviewList = priviewList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getSupportNumber() {
        return supportNumber;
    }

    public void setSupportNumber(int supportNumber) {
        this.supportNumber = supportNumber;
    }

    public int getOpposeNumber() {
        return opposeNumber;
    }

    public int getHotspot() {
        return hotspot;
    }


    public void setOpposeNumber(int opposeNumber) {
        this.opposeNumber = opposeNumber;
    }

    public List<String> getPriviewList() {
        return priviewList;
    }

    public void setPriviewList(List<String> priviewList) {
        this.priviewList = priviewList;
    }
}
