package com.shsl.foody.view.na.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shsl.foody.R;
import com.shsl.foody.view.na.models.Food;

import java.util.List;

public class RVFoodAdapter extends RecyclerView.Adapter<RVFoodAdapter.FoodViewHolder>{

    private List<Food> food;
    private Context context;

    public RVFoodAdapter(List<Food> food, Context context) {
        this.food = food;
        this.context=context;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView name_tv;
        private TextView number_tv;
        private TextView cost_tv;

        public FoodViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            name_tv = (TextView) itemView.findViewById(R.id.food_name);
            number_tv = (TextView) itemView.findViewById(R.id.number_of);
            cost_tv = (TextView) itemView.findViewById(R.id.cost_value);
        }
    }

    @Override
    public void onBindViewHolder(FoodViewHolder foodViewHolder, int i) {
        foodViewHolder.name_tv.setText(food.get(i).getName());
        foodViewHolder.number_tv.setText(String.valueOf(food.get(i).getNumber()));
        foodViewHolder.cost_tv.setText(String.valueOf(food.get(i).getCost())+"k");

        final int pos=i;

        foodViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context,"clicked"+pos, Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_detail_table, viewGroup, false);
        FoodViewHolder foodViewHolder = new FoodViewHolder(view);
        return foodViewHolder;
    }

    @Override
    public int getItemCount() {
        return food.size();
    }
}
