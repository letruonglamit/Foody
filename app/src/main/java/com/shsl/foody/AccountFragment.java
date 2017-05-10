package com.shsl.foody;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * Created by CuuVuiVe on 5/10/2017.
 */

public class AccountFragment extends Fragment {

    public ImageView image;
    private int num =2, nums ;
    private int review=4, reviews;
    private String money="5 trieu", moneys;
    private String time="20 gio", times;
    private String add="195 nguyen luong bang", adds;
    private String phone="0129848844", phones;
    private String sex="nu", sexs;
    private String name="Hieu thai son", names;
    private String role="cashier", roles;
    private TextView tvnum,tvmoney,tvtime,tvphone,tvadd,tvsex, tvname,tvrole,tvreview;



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
        tvnum=(TextView)view.findViewById(R.id.txt_number);
        tvmoney=(TextView)view.findViewById(R.id.txt_money);
        tvtime=(TextView)view.findViewById(R.id.txt_time);
        tvphone=(TextView)view.findViewById(R.id.txt_phone);
        tvadd=(TextView)view.findViewById(R.id.txt_address);
        tvsex=(TextView)view.findViewById(R.id.txt_sex);
        tvname=(TextView)view.findViewById(R.id.TxtName);
        tvrole=(TextView)view.findViewById(R.id.role);
        tvreview=(TextView)view.findViewById(R.id.number);
        image=(ImageView)view.findViewById(R.id.imageView);

        account();

        tvnum.setText(String.valueOf(nums));
        tvmoney.setText(String.valueOf(moneys));
        tvtime.setText(String.valueOf(times));
        tvphone.setText(String.valueOf(phones));
        tvadd.setText(String.valueOf(adds));
        tvsex.setText(String.valueOf(sexs));
        tvname.setText(String.valueOf(names));
        tvrole.setText(String.valueOf(roles));
        tvreview.setText(String.valueOf(reviews));
        image.setImageResource(R.drawable.heo);

        return view;
    }



}
