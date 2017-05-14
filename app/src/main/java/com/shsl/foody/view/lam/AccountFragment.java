package com.shsl.foody.view.lam;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shsl.foody.R;
import com.shsl.foody.view.le.User;


/**
 * Created by CuuVuiVe on 5/10/2017.
 */

public class AccountFragment extends Fragment {

    public ImageView image;
    private int nums ;
    private int reviews;
    private String moneys;
    private String times;
    private String adds;
    private String phones;
    private String sexs;
    private String names;
    private String roles;
    private TextView textViewNum, textViewMoney, textViewTime, textViewPhone, textViewAdd,
            textViewSex, textViewName, textViewRole, textViewReview;

    public  void account()
    {


        User newuser=new User();

        newuser.setReview(review);
        reviews=newuser.getReview();

        newuser.setName(name);
        names=newuser.getName();

        newuser.setRole(role);
        roles=newuser.getRole();

        newuser.setNumber(num);
        nums =newuser.getNumber();

        newuser.setMoney(money);
        moneys =newuser.getMoney();

        newuser.setTime(time);
        times =newuser.getTime();

        newuser.setAddress(add);
        adds =newuser.getAddress();

        newuser.setPhonenumber(phone);
        phones =newuser.getPhonenumber();

        newuser.setSex(sex);
        sexs =newuser.getSex();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);
        textViewNum =(TextView)view.findViewById(R.id.txt_number);
        textViewMoney =(TextView)view.findViewById(R.id.txt_money);
        textViewTime =(TextView)view.findViewById(R.id.txt_time);
        textViewPhone =(TextView)view.findViewById(R.id.txt_phone);
        textViewAdd =(TextView)view.findViewById(R.id.txt_address);
        textViewSex =(TextView)view.findViewById(R.id.txt_sex);
        textViewName =(TextView)view.findViewById(R.id.TxtName);
        textViewRole =(TextView)view.findViewById(R.id.role);
        textViewReview =(TextView)view.findViewById(R.id.number);
        image=(ImageView)view.findViewById(R.id.imageView);

        account();

        textViewNum.setText(String.valueOf(nums));
        textViewMoney.setText(String.valueOf(moneys));
        textViewTime.setText(String.valueOf(times));
        textViewPhone.setText(String.valueOf(phones));
        textViewAdd.setText(String.valueOf(adds));
        textViewSex.setText(String.valueOf(sexs));
        textViewName.setText(String.valueOf(names));
        textViewRole.setText(String.valueOf(roles));
        textViewReview.setText(String.valueOf(reviews));
        image.setImageResource(R.drawable.heo);

        return view;
    }



}
