package com.shsl.foody.dao.table.controller;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class MultipleResource {

    @SerializedName("tableName")
    public String tableName;
    @SerializedName("status")
    public String status;

    public List<TableList.Datum> data = new ArrayList<>();

    public class Datum {

        @SerializedName("tableName")
        public String tableName;
        @SerializedName("status")
        public String status;
        @SerializedName("price")
        public String price;
        @SerializedName("name")
        public String name;

    }
}
