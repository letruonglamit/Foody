package com.shsl.foody;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class TableList extends AppCompatActivity {


    private RecyclerView recyclerview;

    private String[] status;
    private TypedArray profile_pics;
    private String[] people;
    private List<Table> tableList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        status = getResources().getStringArray(R.array.status);
        profile_pics = getResources().obtainTypedArray(R.array.profile_pics);
        people = getResources().getStringArray(R.array.people);

        tableList =new ArrayList<Table>();
        for (int i = 0; i < status.length; i++) {
            Table table = new Table(status[i], people[i], profile_pics.getResourceId(i, -1));
            tableList.add(table);
        }

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(TableList.this);
        //StaggeredGridLayoutManager;
        //GridLayoutManager gridLayoutManager


        recyclerview.setLayoutManager(layoutManager);

        RVAdapter adapter = new RVAdapter(tableList,TableList.this);
        recyclerview.setAdapter(adapter);

    }
}
