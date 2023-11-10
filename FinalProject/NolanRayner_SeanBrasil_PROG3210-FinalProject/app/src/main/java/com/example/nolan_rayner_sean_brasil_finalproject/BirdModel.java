package com.example.nolan_rayner_sean_brasil_finalproject;

public class BirdModel {
    private int id;
    private Integer birdImage;
    private String birdName;
    private String birdLocation;
    private String birdStatus;
    private String birdDescription;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Integer getImage() {
        return birdImage;
    }
    public void setImage(Integer image) {
        this.birdImage = image;
    }

    public String getName() {
        return birdName;
    }
    public void setName(String Name) {
        this.birdName = Name;
    }

    public String getBirdLocation() {
        return birdLocation;
    }
    public void setBirdLocation(String BirdLocation) {
        this.birdLocation = BirdLocation;
    }

    public String getBirdStatus() {
        return birdStatus;
    }
    public void setBirdStatus(String BirdStatus) {
        this.birdStatus = BirdStatus;
    }

    public String getBirdDescription() {
        return birdDescription;
    }
    public void setBirdDescription(String BirdDescription) {
        this.birdLocation = BirdDescription;
    }

    public BirdModel(Integer birdImage,String birdname,String birdLocation,String birdStatus, String birdDescription){
        this.birdImage = birdImage;
        this.birdName = birdname;
        this.birdLocation = birdLocation;
        this.birdStatus = birdStatus;
        this.birdDescription = birdDescription;
    }

}
