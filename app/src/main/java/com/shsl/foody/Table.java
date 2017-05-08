package com.shsl.foody;

public class Table {

    String status;
    String person;
    int photoID;

    Table(String status, String person, int photoID) {
        this.status = status;
        this.person = person;
        this.photoID = photoID;
    }

    public String getStatus() {
        return status;
    }

    public String getPerson() {
        return person;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }
}
