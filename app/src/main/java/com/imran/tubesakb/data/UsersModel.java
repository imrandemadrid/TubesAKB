package com.imran.tubesakb.data;

public class UsersModel {
    String uid;
    String nama;
    String userEmail;

    public UsersModel(){}

    public UsersModel(String uid, String nama, String userEmail) {
        this.uid = uid;
        this.nama = nama;
        this.userEmail = userEmail;
    }

    public String getUid() {
        return uid;
    }

    public String getNama() {
        return nama;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
