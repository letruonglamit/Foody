package com.shsl.foody;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by TiNa on 10/05/2017.
 */

public class RVTableAdapter  extends RecyclerView.Adapter<RVTableAdapter.MyViewHolder> {

    private List<Table> tableList;
    private static ClickListener clickListener;



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textView;

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }


        public MyViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            textView = (TextView) itemView.findViewById(R.id.text);
        }

    }


    public RVTableAdapter(List<Table> tableList) {
        this.tableList = tableList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.table_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        int orangeColorValue = Color.parseColor("#FFFFFFFF");
        if(tableList.get(position).getStatus()==0){
//            holder.textView.setBackgroundColor(orangeColorValue);
            holder.textView.setBackgroundResource(R.drawable.tablet);
            holder.textView.setTextColor(orangeColorValue);
        }
        holder.textView.setText(tableList.get(position).getName());

//        holder.coverImageView.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                String a = holder.txtBooked.getText().toString();
//                int abc = Integer.parseInt(a)+1;
//                String b = String.valueOf(abc);
//                holder.txtBooked.setText(b);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        RVTableAdapter.clickListener = clickListener;
    }
}
