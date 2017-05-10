package com.shsl.foody;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.shsl.foody.view.lam.AccountFragment;
import com.shsl.foody.view.lam.ManageFragment;
import com.shsl.foody.view.lam.StatisticFragment;
import com.shsl.foody.view.lam.StatusFragment;


public class MainActivityA extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener{

   AHBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maina);

        bottomNavigation= (AHBottomNavigation) findViewById(R.id.myBottomNavigation_ID);
        bottomNavigation.setOnTabSelectedListener(this);
        this.createNavItems();
    }

    private void createNavItems()
    {
        //CREATE ITEMS
        AHBottomNavigationItem managerItem=new AHBottomNavigationItem("Manage",R.drawable.ic_manage);
        AHBottomNavigationItem statusItem=new AHBottomNavigationItem("Status",R.drawable.ic_status);
        AHBottomNavigationItem statisticItem=new AHBottomNavigationItem("Statistic",R.drawable.ic_statistic);
        AHBottomNavigationItem accountItem=new AHBottomNavigationItem("Account",R.drawable.ic_account);

        //ADD THEM to bar
        bottomNavigation.addItem(managerItem);
        bottomNavigation.addItem(statusItem);
        bottomNavigation.addItem(statisticItem);
        bottomNavigation.addItem(accountItem);

        //set properties
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        //set current item
        bottomNavigation.setCurrentItem(0);

    }

    @Override
    public void onTabSelected(int position, boolean wasSelected) {
        //show fragment
        if (position==0)
        {
            StatusFragment statusFragment =new StatusFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, statusFragment).commit();
        }else  if (position==1)
        {
            ManageFragment manageFragment =new ManageFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, manageFragment).commit();
        }else  if (position==2)
        {
            AccountFragment accountFragment =new AccountFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, accountFragment).commit();
        }else if(position == 3){
            StatisticFragment statisticFragment =new StatisticFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, statisticFragment).commit();
        }

    }
}
















