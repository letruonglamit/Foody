package com.shsl.foody.view.na.models;

import java.util.ArrayList;
import java.util.List;

public class Table {
    String name;
    String person;
    int status;
    long cost;
    List<Food> list;

    public Table(){
        this.name = null;
        this.person = null;
        this.status = 1;//0=đang phục vụ; 1=đang trống
        this.list = new ArrayList<Food>();
        this.cost = 0;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public long getCost() {return cost;}

    public List<Food> getList() {
        return list;
    }

    public void setList(List<Food> list) {
        this.list = list;
    }

    public Table(String name, String person, int status, long cost, List<Food> list) {

        this.name = name;
        this.person = person;
        this.status = status;
        this.cost = cost;
        this.list = list;
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
