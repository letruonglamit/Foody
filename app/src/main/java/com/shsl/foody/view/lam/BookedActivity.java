package com.shsl.foody.view.lam;

import android.support.constraint.solver.SolverVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shsl.foody.R;
import com.shsl.foody.view.lam.Object.Booking;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BookedActivity extends AppCompatActivity{

    private static final String TAG = "test";
    private ArrayList<Booking> bookingList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BookingAdapter mAdapter;
    private ArrayList<Integer> bookedList = new ArrayList<>();
    private int maxFood = 10;
    private int mNumBooked = 0;
    private TextView mCost;
    private int price = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);
        initData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_booking);

        mCost = (TextView) findViewById(R.id.cost);

        mAdapter = new BookingAdapter(bookingList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mCost.setText(String.valueOf(price).toString());

    }

<<<<<<< HEAD
=======



>>>>>>> origin
    private void initData(){
        initDataTemp();
        for(int i=0;i<maxFood;i++){
            bookedList.add(0);
        }
    }

    private void initDataTemp(){

        String bookingListAsString = getIntent().getStringExtra("list_as_string");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Integer>>(){}.getType();
        ArrayList<Integer> bookedArrayList = gson.fromJson(bookingListAsString, type);
        for (Integer booked : bookedArrayList){
            Log.i("Booking Data", booked.toString());
        }


        String foods[] = {"Gimbap & Chicken","Chả Cá Hà Thành","Lẩu Cua Khôi","Octopus King","Trà Sữa Tocotoco","Trứng Chén Nướng","Hotdog Bamy"};
        int imageFoods[] = {R.drawable.food_mobile_han,R.drawable.food_chaca,R.drawable.food_lau_cua_khoi,R.drawable.food_octopus_king,R.drawable.foody_trasuatoco,R.drawable.foody_trung_chennuong,R.drawable.foodyhotdog};
        int prices[] = {200,145,150,100,80,35,50};
        bookingList.clear();

        for (Integer booked : bookedArrayList){
            Log.i("Booking Data", booked.toString());
            int i = Integer.parseInt(booked.toString());
            if(i>0){
                Booking item = new Booking();
                item.setCardName(foods[i]);
                item.setImageResourceId(imageFoods[i]);
                item.setPrice(prices[i]);
                item.setIsfav(0);
                item.setIsturned(0);
                bookingList.add(item);
<<<<<<< HEAD
=======

>>>>>>> origin
                price+=prices[i];
            }


        }
    }



}

