package com.shsl.foody.view.lam;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.shsl.foody.R;
import com.shsl.foody.view.lam.Object.Booking;
import com.shsl.foody.view.lam.drawable.BagdeDrawable;

import java.util.ArrayList;

public class BookingActivity extends AppCompatActivity implements BookingAdapter.ClickListener {

    private static final String TAG = "test";
    private ArrayList<Booking> bookingList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BookingAdapter mAdapter;
    private ArrayList<Integer> bookedList = new ArrayList<>();
    private int maxFood = 10;
    private int mNumBooked = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        initData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_booking);

        mAdapter = new BookingAdapter(bookingList);

        mAdapter.setOnItemClickListener(new BookingAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.d(TAG, "onItemClick position: " + position);

                invalidateOptionsMenu();
                addBooking(position, v);
                mNumBooked++;


            }

            @Override
            public void onItemLongClick(int position, View v) {
                Log.d(TAG, "onItemLongClick pos = " +position);
                invalidateOptionsMenu();

                addBooking(position, v);
                mNumBooked--;
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    private void addBooking(int position, View v) {
        int value =bookedList.get(position);
        value++;
        bookedList.set(position, value);
        Log.d(TAG, "addBooking "+bookedList);

    }
    private void subBooking(int position, View v) {
        int value =bookedList.get(position);
        value--;
        bookedList.set(position, value);
        Log.d(TAG, "addBooking "+bookedList);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem itemCart = menu.findItem(R.id.action_shopping);
        LayerDrawable icon = (LayerDrawable) itemCart.getIcon();
        setBadgeCount(this, icon, String.valueOf(mNumBooked));
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_shopping){
            Toast toast=Toast.makeText(this, "item",   Toast.LENGTH_SHORT);
            toast.show();

            Gson gson = new Gson();

            String jsonBookedList = gson.toJson(bookedList);

            Intent intent = new Intent(BookingActivity.this, BookedActivity.class);
            intent.putExtra("list_as_string", jsonBookedList);
            startActivity(intent);


        }
        return super.onOptionsItemSelected(item);
    }

    public void setBadgeCount(Context context, LayerDrawable icon, String count) {

        BagdeDrawable badge;

        // Reuse drawable if possible
        Drawable reuse = icon.findDrawableByLayerId(R.id.ic_badge);
        if (reuse != null && reuse instanceof BagdeDrawable) {
            badge = (BagdeDrawable) reuse;
        } else {
            badge = new BagdeDrawable(context);
        }

        badge.setCount(count);
        icon.mutate();
        icon.setDrawableByLayerId(R.id.ic_badge, badge);
    }




    @Override
    public void onItemClick(int position, View v) {

    }

    @Override
    public void onItemLongClick(int position, View v) {

    }
    private void initData(){
        initDataTemp();
        for(int i=0;i<maxFood;i++){
            bookedList.add(0);
        }
    }

    private void initDataTemp(){
        String foods[] = {"Gimbap & Chicken","Chả Cá Hà Thành","Lẩu Cua Khôi","Octopus King","Trà Sữa Tocotoco","Trứng Chén Nướng","Hotdog Bamy"};
        int imageFoods[] = {R.drawable.food_mobile_han,R.drawable.food_chaca,R.drawable.food_lau_cua_khoi,R.drawable.food_octopus_king,R.drawable.foody_trasuatoco,R.drawable.foody_trung_chennuong,R.drawable.foodyhotdog};
        bookingList.clear();

        for(int i =0;i<7;i++){

            Booking item = new Booking();
            item.setCardName(foods[i]);
            item.setImageResourceId(imageFoods[i]);
            item.setIsfav(0);
            item.setIsturned(0);
            bookingList.add(item);

        }
    }



}
