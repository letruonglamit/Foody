package com.shsl.foody;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MemberViewHolder> {

    private List<Table> tables;
    private Context context;

    public RVAdapter(List<Table> tables, Context context) {
        this.tables = tables;
        this.context=context;
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView status_tv;
        private TextView person_tv;
        private ImageView pic_iv;

        public MemberViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cv);
            status_tv = (TextView) itemView.findViewById(R.id.tv_status);
            person_tv = (TextView) itemView.findViewById(R.id.tv_person);
            pic_iv = (ImageView) itemView.findViewById(R.id.profile_pic);



        }
    }

    @Override
    public void onBindViewHolder(MemberViewHolder memberViewHolder, int i) {
        memberViewHolder.status_tv.setText(tables.get(i).getStatus());
        memberViewHolder.person_tv.setText(tables.get(i).getPerson());
        memberViewHolder.pic_iv.setImageResource(tables.get(i).getPhotoID());

        final int pos=i;

        memberViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(context,"clicked"+pos, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context,TableDetail.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public MemberViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_row_item, viewGroup, false);
        MemberViewHolder memberViewHolder = new MemberViewHolder(view);
        return memberViewHolder;
    }

    @Override
    public int getItemCount() {
        return tables.size();
    }
}
