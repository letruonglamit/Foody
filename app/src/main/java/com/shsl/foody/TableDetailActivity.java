package com.shsl.foody;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shsl.foody.adapters.RVFoodAdapter;
import com.shsl.foody.models.Food;
import com.shsl.foody.models.Table;

import java.lang.reflect.Type;
import java.util.List;

public class TableDetail extends AppCompatActivity {
    private RecyclerView recyclerview;
    private TextView txtTableName;
    private TextView txtPerson;
    private TextView txtCost;
    private ToggleButton txtStatus;
    private Table table;
    private List<Food> foodList;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_detail);
        getFormWidget();

        intent = getIntent();
        String tableName = intent.getStringExtra("name");
        String person = intent.getStringExtra("person");
        int status = intent.getIntExtra("status",1);
        long cost = intent.getLongExtra("cost",0);
        Gson gson = new Gson();
        String strObj = intent.getStringExtra("foodlist");
        Type type = new TypeToken<List<Food>>(){}.getType();
        foodList = gson.fromJson(strObj, type);

        txtTableName.setText(tableName);
        txtPerson.setText(person);
        txtCost.setText(String.valueOf(cost)+".000đ");
        if(status==0) txtStatus.setChecked(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(TableDetail.this);
        //StaggeredGridLayoutManager;
        //GridLayoutManager gridLayoutManager
        recyclerview.setLayoutManager(layoutManager);
        RVFoodAdapter adapter = new RVFoodAdapter(foodList,TableDetail.this);
        recyclerview.setAdapter(adapter);
    }

    public void getFormWidget(){
        recyclerview = (RecyclerView) findViewById(R.id.rv);
        txtTableName = (TextView) findViewById(R.id.textTable);
        txtPerson = (TextView) findViewById(R.id.textPerson);
        txtCost = (TextView) findViewById(R.id.textCost);
        txtStatus = (ToggleButton) findViewById(R.id.toggleButton);
    }

    // Khi người dùng Click vào button Cancel.
    public void buttonCancelClicked(View view)  {
        // Không làm gì, trở về MainActivity.
        this.onBackPressed();
    }

    // Khi người dùng Click vào button Cancel.
    public void buttonSaveClicked(View view)  {
        Table table = new Table();
        table.setName(txtTableName.getText().toString());
        table.setPerson(txtPerson.getText().toString());
        table.setList(foodList);
        table.setCost(Long.parseLong(txtCost.getText().toString()));
        if(txtStatus.isChecked() == true){
//            Log.i("Detail",txtStatus.getTextOn().toString());
            table.setStatus(0); //Đã phục vụ
        } else {
            table.setStatus(1); //Đang trống
        }
        this.onBackPressed();
    }
}
