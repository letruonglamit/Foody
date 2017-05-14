package com.shsl.foody.dao.table;

import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.shsl.foody.dao.table.controller.*;

public class TableBinding  {

    APIInterface apiInterface;

    public void TableBinding() {
        apiInterface = APIClient.getClient().create(APIInterface.class);
    }


    /**
     GET List Resources
     **/
    public List getListTable() {
        Call<TableB> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<MultipleResource>() {
            @Override
            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {


                Log.d("TAG",response.code()+"");

                String displayResponse = "";

                MultipleResource resource = response.body();
                String text = resource.tableName;
                String total = resource.status;

                List<MultipleResource.Datum> datumList = resource.data;

                return datumList;


            }

            @Override
            public void onFailure(Call<MultipleResource> call, Throwable t) {
                call.cancel();
            }
        });
    }

    public  void update(String table,int status, long price){
        /**
         POST name and job Url encoded.
         **/
        Call<TableB> call3 = apiInterface.doCreateUserWithField(table,status,price);
        call3.enqueue(new Callback<TableB>() {
            @Override
            public void onResponse(Call<TableB> call, Response<TableB> response) {


            }

            @Override
            public void onFailure(Call<TableB> call, Throwable t) {
                call.cancel();
            }
        });
    }



    public  void clean(){

        Call<TableB> call3 = apiInterface.doCreateUserWithField(0,0,"");
        call3.enqueue(new Callback<TableB>() {
            @Override
            public void onResponse(Call<TableB> call, Response<TableB> response) {


            }

            @Override
            public void onFailure(Call<TableB> call, Throwable t) {
                call.cancel();
            }
        });
    }


    /**
     GET List
     **/
    public List getListPrice() {
        Call<TableB> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<MultipleResource>() {
            @Override
            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {


                Log.d("TAG",response.code()+"");

                String displayResponse = "";

                MultipleResource resource = response.body();
                String text = resource.tableName;
                String total = resource.status;

                List<MultipleResource.Datum> datumList = resource.data;

                return datumList;


            }

            @Override
            public void onFailure(Call<MultipleResource> call, Throwable t) {
                call.cancel();
            }
        });
    }

}
