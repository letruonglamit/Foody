package com.shsl.foody;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.shsl.foody.adapters.RVTableAdapter;
import com.shsl.foody.models.Food;
import com.shsl.foody.models.Table;

import java.util.ArrayList;
import java.util.List;

public class ListTable extends AppCompatActivity {
    private String[] names;
    private int[] number;
    private int[] cost;
    private List<Food> foodList;
    RVTableAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_table);
        RecyclerView recyclerView = (RecyclerView) findViewById(
                R.id.recycler_view);
        recyclerView.addItemDecoration(new MarginDecoration(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        names = getResources().getStringArray(R.array.food_name);
        number = getResources().getIntArray(R.array.number_of);
        cost = getResources().getIntArray(R.array.cost);

        long total = 0;
        foodList=new ArrayList<Food>();
        for (int i = 0; i < names.length; i++) {
            Food food = new Food(names[i], number[i], cost[i]);
            total+= cost[i]*number[i];
            foodList.add(food);
        }

        final List<Table> list = new ArrayList<Table>();
        for(int i=0; i<14; i++){
            Table table = new Table();
            table.setName("Bàn " + String.valueOf(i));
            if(i%3==0) {
                table.setStatus(0);
                table.setPerson("Hiếu thái sơn!");
                table.setCost(total);
                table.setList(foodList);
            }
            list.add(table);
        }
        adapter = new RVTableAdapter(list);
        adapter.setOnItemClickListener(new RVTableAdapter.ClickListener(){
            @Override
            public void onItemClick(int position, View v) {
//                Log.d(TAG, "onItemClick position: " + position);
                Gson gson = new Gson();
                Intent intent = new Intent(getBaseContext(),TableDetail.class);
                intent.putExtra("name", list.get(position).getName());
                intent.putExtra("person", list.get(position).getPerson());
                intent.putExtra("cost", list.get(position).getCost());
                intent.putExtra("status", list.get(position).getStatus());
                intent.putExtra("foodlist", gson.toJson(list.get(position).getList()));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

    }
}