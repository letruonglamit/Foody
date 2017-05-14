package com.shsl.foody.dao.login;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterfaceLogin {

    @GET("api/{username}/{password}")
    Call<Login> authenticate(@Path("username") String username, @Path("password") String password);

    @POST("api/{username}/{password}")
    Call<Login> registration(@Path("username") String username, @Path("password") String password);
}
