package com.shsl.foody.view.lam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.shsl.foody.R;
<<<<<<< HEAD
import com.shsl.foody.dao.table.TableBinding;
=======
>>>>>>> origin

import java.util.ArrayList;

public class StatisticsFragment extends Fragment {

    BarChart chart ;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;
    private ImageButton btnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_statistics,container,false);
        btnBack = (ImageButton) rootView.findViewById(R.id.btn_back);
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent  = new Intent(StatisticsFragment.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
        chart = (BarChart) rootView.findViewById(R.id.chart1);

        BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<>();

        AddValuesToBARENTRY();

        AddValuesToBarEntryLabels();

        Bardataset = new BarDataSet(BARENTRY, "Statistic");

        BARDATA = new BarData(BarEntryLabels, Bardataset);

        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(BARDATA);

        chart.animateY(3000);
        return rootView;
    }

<<<<<<< HEAD


    public void AddValuesToBARENTRY(){


        TableBinding tableBinding = new TableBinding();
        tableBinding.getListPrice();
=======
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_statistics);
//
//        btnBack = (ImageButton) findViewById(R.id.btn_back);
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent  = new Intent(StatisticsFragment.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//        chart = (BarChart) findViewById(R.id.chart1);
//
//        BARENTRY = new ArrayList<>();
//
//        BarEntryLabels = new ArrayList<>();
//
//        AddValuesToBARENTRY();
//
//        AddValuesToBarEntryLabels();
//
//        Bardataset = new BarDataSet(BARENTRY, "Statistic");
//
//        BARDATA = new BarData(BarEntryLabels, Bardataset);
//
//        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
//
//        chart.setData(BARDATA);
//
//        chart.animateY(3000);
//
//    }

    public void AddValuesToBARENTRY(){

>>>>>>> origin
        BARENTRY.add(new BarEntry(2f, 0));
        BARENTRY.add(new BarEntry(4f, 1));
        BARENTRY.add(new BarEntry(6f, 2));
        BARENTRY.add(new BarEntry(8f, 3));
        BARENTRY.add(new BarEntry(7f, 4));
        BARENTRY.add(new BarEntry(3f, 5));

    }

    public void AddValuesToBarEntryLabels(){

        BarEntryLabels.add("January");
        BarEntryLabels.add("February");
        BarEntryLabels.add("March");
        BarEntryLabels.add("April");
        BarEntryLabels.add("May");
        BarEntryLabels.add("June");

    }
}
