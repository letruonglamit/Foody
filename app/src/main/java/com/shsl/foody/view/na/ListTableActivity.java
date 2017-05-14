package com.shsl.foody.view.na;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.shsl.foody.R;
import com.shsl.foody.dao.table.TableBinding;
import com.shsl.foody.dao.table.controller.TableB;
import com.shsl.foody.view.na.adapters.RVTableAdapter;
import com.shsl.foody.view.na.models.Food;

import java.util.ArrayList;
import java.util.List;

public class ListTableActivity extends AppCompatActivity {
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

        //read values from strings.xml
        names = getResources().getStringArray(R.array.food_name);
        number = getResources().getIntArray(R.array.number_of);
        cost = getResources().getIntArray(R.array.cost);

        long total = 0;
        foodList=new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Food food = new Food(names[i], number[i], cost[i]);
            total+= cost[i]*number[i];
            foodList.add(food);
        }

        final List<com.shsl.foody.view.na.models.Table> list = new ArrayList<>();

        TableBinding tableBinding = new TableBinding();
        List<TableB> list = tableBinding.getListTable();
        for(int i=0; i<14; i++){
            com.shsl.foody.view.na.models.Table table = new com.shsl.foody.view.na.models.Table();
            table.setName(String.valueOf(i));

        }
        adapter = new RVTableAdapter(list);
        adapter.setOnItemClickListener(new RVTableAdapter.ClickListener(){
            @Override
            public void onItemClick(int position, View v) {
                Gson gson = new Gson();
                Intent intent = new Intent(getBaseContext(),TableDetailActivity.class);
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