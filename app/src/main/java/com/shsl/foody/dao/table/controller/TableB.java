package com.shsl.foody.dao.table.controller;

import com.google.gson.annotations.SerializedName;
import com.shsl.foody.view.na.models.Food;

import java.util.List;


public class TableB {



    @SerializedName("tableName")
    public String name;
    @SerializedName("person")
    public String person;
    @SerializedName("status")
    public int status;
    @SerializedName("cost")
    public long cost;

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public long getCost() {return cost;}



    public TableB(String name, String person, int status, long cost, List<Food> list) {

        this.name = name;
        this.person = person;
        this.status = status;
        this.cost = cost;
    }

    public void setCost(long cost) {this.cost = cost;}

    public int getStatus() {
        return status;
    }

    public String getPerson() {
        return person;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setPerson(String person) {
        this.person = person;
    }



}
