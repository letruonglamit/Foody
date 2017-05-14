package com.shsl.foody.view.lam;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shsl.foody.R;
import com.shsl.foody.view.lam.Object.Booking;

import java.util.ArrayList;

public class BookedAdapter extends RecyclerView.Adapter<BookedAdapter.MyViewHolder> {

    private ArrayList<Booking> bookingList;

    private static ClickListener clickListener;




    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        public TextView titleTextView;
        public ImageView coverImageView;
        public TextView txtBooked, txtPrice;

        private int booked = 0;

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }


        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }



        public MyViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);
            titleTextView = (TextView) v.findViewById(R.id.titleTextView);
            coverImageView = (ImageView) v.findViewById(R.id.foodImageView);
            txtBooked = (TextView) v.findViewById(R.id.numBooking);
            txtPrice = (TextView) v.findViewById(R.id.numPrice);



        }

    }


    public BookedAdapter(ArrayList<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_booking, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.titleTextView.setText(bookingList.get(position).getCardName());
        holder.coverImageView.setImageResource(bookingList.get(position).getImageResourceId());
        holder.txtPrice.setText(String.valueOf(bookingList.get(position).getPrice()));

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
        return bookingList.size();
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        BookedAdapter.clickListener = clickListener;
    }



}
