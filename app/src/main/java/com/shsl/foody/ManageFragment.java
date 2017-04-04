package com.shsl.foody;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ManageFragment extends Fragment {

    ArrayList<MenuFood> listitems = new ArrayList<>();
    RecyclerView MyRecyclerView;
    String Wonders[] = {"Gimbap & Chicken","Chả Cá Hà Thành","Lẩu Cua Khôi","Octopus King","Trà Sữa Tocotoco","Trứng Chén Nướng","Hotdog Bamy"};
    int  Images[] = {R.drawable.food_mobile_han,R.drawable.food_chaca,R.drawable.food_lau_cua_khoi,R.drawable.food_octopus_king,R.drawable.foody_trasuatoco,R.drawable.foody_trung_chennuong,R.drawable.foodyhotdog};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeList();
        getActivity().setTitle("7 Wonders of the Modern World");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.card_menu, container, false);
        MyRecyclerView = (RecyclerView) view.findViewById(R.id.cardView);
        MyRecyclerView.setHasFixedSize(true);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        if (listitems.size() > 0 & MyRecyclerView != null) {
            MyRecyclerView.setAdapter(new MyAdapter(listitems));
        }
        MyRecyclerView.setLayoutManager(MyLayoutManager);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private ArrayList<MenuFood> list;

        public MyAdapter(ArrayList<MenuFood> Data) {
            list = Data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
            // create a new view
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycle_items_shopping, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {

            holder.titleTextView.setText(list.get(position).getCardName());
            holder.coverImageView.setImageResource(list.get(position).getImageResourceId());

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public ImageView coverImageView;
        public ImageView likeImageView;
        public ImageView shareImageView;

        public MyViewHolder(View v) {
            super(v);
            titleTextView = (TextView) v.findViewById(R.id.titleTextView);
            coverImageView = (ImageView) v.findViewById(R.id.foodImageView);






        }
    }

    public void initializeList() {
        listitems.clear();

        for(int i =0;i<7;i++){


            MenuFood item = new MenuFood();
            item.setCardName(Wonders[i]);
            item.setImageResourceId(Images[i]);
            item.setIsfav(0);
            item.setIsturned(0);
            listitems.add(item);

        }




    }
}