package com.shsl.foody;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ListTable extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_table);
        RecyclerView recyclerView = (RecyclerView) findViewById(
                R.id.recycler_view);
        recyclerView.addItemDecoration(new MarginDecoration(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        List<Table> list = new ArrayList<Table>();
        for(int i=0; i<8; i++){
            Table table = new Table();
            table.setName("Bàn " + String.valueOf(i));
            if(i%3==0) table.setStatus(0);
            list.add(table);
        }
        recyclerView.setAdapter(new TableRVAdapter(list,this));
    }
}