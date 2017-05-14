package com.shsl.foody.dao.table;

import com.journaldev.retrofitintro.pojo.MultipleResource;
import com.journaldev.retrofitintro.pojo.User;
import com.journaldev.retrofitintro.pojo.UserList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by anupamchugh on 09/01/17.
 */

interface APIInterface {

    @GET("/api/unknown")
    Call<MultipleResource> doGetListResources();

    @POST("/api/tables")
    Call<TableBinding> createUser(@Body TableBinding user);

    @GET("/api/tables?")
    Call<TableBinding> doGetUserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/tables?")
    Call<TableBinding> doCreateUserWithField(@Field("tableName") String name, @Field("status") String job);
}
