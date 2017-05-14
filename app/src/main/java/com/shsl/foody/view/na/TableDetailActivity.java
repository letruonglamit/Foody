package com.shsl.foody.view.na;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shsl.foody.R;
import com.shsl.foody.dao.table.TableBinding;
import com.shsl.foody.view.lam.BookingActivity;
import com.shsl.foody.view.na.adapters.RVFoodAdapter;
import com.shsl.foody.view.na.models.Food;
import com.shsl.foody.view.na.models.Table;

import java.lang.reflect.Type;
import java.util.List;

public class TableDetailActivity extends AppCompatActivity{
    private RecyclerView recyclerview;
    private TextView txtTableName;
    private TextView txtPerson;
    private TextView txtCost;
    private ToggleButton txtStatus;
    private ImageButton btnPay, btnAdd;
    private List<Food> foodList;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_detail);
        getFormWidget();

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        //read values of table sent from ListTableActivity
        intent = getIntent();
        String tableName = intent.getStringExtra("name");
        String person = intent.getStringExtra("person");
        int status = intent.getIntExtra("status",1);
        long cost = intent.getLongExtra("cost",0);
        Gson gson = new Gson();
        String strObj = intent.getStringExtra("foodlist");
        Log.i("CHECK",strObj.toString());
        Type type = new TypeToken<List<Food>>(){}.getType();
        foodList = gson.fromJson(strObj, type);

        //set value display on textfield and recycler view
        txtTableName.setText(tableName);
        txtPerson.setText(person);
        txtCost.setText(String.valueOf(cost)+".000đ");
        if(status==0) txtStatus.setChecked(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(TableDetailActivity.this);
        recyclerview.setLayoutManager(layoutManager);
        RVFoodAdapter adapter = new RVFoodAdapter(foodList,TableDetailActivity.this);
        recyclerview.setAdapter(adapter);
    }

    public void getFormWidget(){
        recyclerview = (RecyclerView) findViewById(R.id.rv);
        txtTableName = (TextView) findViewById(R.id.textTable);
        txtPerson = (TextView) findViewById(R.id.textPerson);
        txtCost = (TextView) findViewById(R.id.textCost);
        txtStatus = (ToggleButton) findViewById(R.id.toggleButton);
        btnAdd = (ImageButton) findViewById(R.id.btn_add);
        btnPay = (ImageButton) findViewById(R.id.btn_pay);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TableDetailActivity.this, BookingActivity.class);
                startActivity(intent);
            }
        });

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });
    }

    // Khi người dùng Click vào button Cancel.
    public void buttonCancelClicked(View view)  {
        // Không làm gì, trở về ListTableActivity.
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


    public void dialog(){
        showAlertDialogOne();
    }

    private void showAlertDialogOne() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // khởi tạo dialog
        alertDialogBuilder.setMessage("Do you want to pay?");
        // thiết lập nội dung cho dialog
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(TableDetailActivity.this,"Payment success",Toast.LENGTH_LONG).show();
                payment();

            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }



    public void payment(){
        TableBinding tableBinding = new TableBinding();
        tableBinding.clean();
    }


}
