package com.imran.tubesakb.data;

public class DataModel {
    Integer ID;
    String imageURL;
    String namaImage;
    String kategoti;

    public DataModel(Integer ID, String imageURL, String namaImage, String kategori){
        this.ID = ID;
        this.imageURL = imageURL;
        this.namaImage = namaImage;
        this.kategoti = kategori;
    }

    public Integer getID() {
        return ID;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getNamaImage() {
        return namaImage;
    }

    public String getKategoti(){
        return kategoti;
    }
}
