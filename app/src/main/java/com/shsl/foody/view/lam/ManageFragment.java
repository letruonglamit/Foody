package com.shsl.foody.view.lam;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.support.v4.app.Fragment;
=======
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
>>>>>>> origin
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
<<<<<<< HEAD

import com.shsl.foody.R;
import com.shsl.foody.view.na.ListTableActivity;
=======
import android.widget.ImageView;
import android.widget.TextView;

import com.shsl.foody.R;

import java.util.ArrayList;
>>>>>>> origin


public class ManageFragment extends Fragment {

    Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.manage_fragment, container, false);

        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                Intent intent = new Intent(getContext(), ListTableActivity.class);
=======
                Intent intent = new Intent(getContext(), BookingActivity.class);
>>>>>>> origin
                startActivity(intent);
            }
        });

        return view;
    }




}