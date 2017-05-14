package com.shsl.foody.view.na.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shsl.foody.R;
import com.shsl.foody.view.na.models.Table;

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
                .inflate(R.layout.table_recyclerview_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        int whiteColorValue = Color.parseColor("#FFFFFFFF");
        if(tableList.get(position).getStatus()==0){
            //change background when table is served
            holder.textView.setBackgroundResource(R.drawable.tablet);
            holder.textView.setTextColor(whiteColorValue);
        }
        holder.textView.setText(tableList.get(position).getName());
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
