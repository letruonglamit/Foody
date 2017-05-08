package com.shsl.foody;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by TiNa on 08/05/2017.
 */

public class TableRVAdapter extends RecyclerView.Adapter<TextViewHolder>{
    private List<Table> tables;
    private Context context;

    public TableRVAdapter(List<Table> tables, Context context) {
        this.tables = tables;
        this.context= context;
    }



    @Override
    public void onBindViewHolder(TextViewHolder holder, int i) {
        if(tables.get(i).getStatus()==0){
            holder.textView.setText("Served");
        } else {
            holder.textView.setText(tables.get(i).getName());
        }
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context,TableDetail.class);
//                context.startActivity(intent);
            }
        });

    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_item, parent, false);
        return new TextViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return tables.size();
    }
}
