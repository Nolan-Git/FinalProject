package com.example.nolan_rayner_sean_brasil_finalproject;

public class BirdModel {
//bird modle, get the name location status and description
    private String birdName;
    private String birdLocation;
    private String birdStatus;
    private String birdDescription;

    private int id;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }


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

    public BirdModel(String birdname,String birdLocation,String birdStatus, String birdDescription){

        this.birdName = birdname;
        this.birdLocation = birdLocation;
        this.birdStatus = birdStatus;
        this.birdDescription = birdDescription;
    }

}
