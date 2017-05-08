package com.shsl.foody;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TableDetail extends AppCompatActivity {

    private RecyclerView recyclerview;

    private String[] names;
    private int[] number;
    private int[] cost;
    private List<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_detail);

        names = getResources().getStringArray(R.array.food_name);
        number = getResources().getIntArray(R.array.number_of);
        cost = getResources().getIntArray(R.array.cost);
        Log.i("Detail",names[0]+number[0]+cost[0]);

        foodList=new ArrayList<Food>();
        for (int i = 0; i < names.length; i++) {
            Food food = new Food(names[i], number[i], cost[i]);
            foodList.add(food);
        }

        recyclerview = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(TableDetail.this);
        //StaggeredGridLayoutManager;
        //GridLayoutManager gridLayoutManager


        recyclerview.setLayoutManager(layoutManager);

        RVFoodAdapter adapter = new RVFoodAdapter(foodList,TableDetail.this);
        recyclerview.setAdapter(adapter);
    }
}
