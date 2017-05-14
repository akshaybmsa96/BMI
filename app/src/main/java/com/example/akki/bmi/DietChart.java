package com.example.akki.bmi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Adapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DietChart extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_chart);


        expListView = (ExpandableListView) findViewById(R.id.list);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("BreakFast");
        listDataHeader.add("MidMorning");
        listDataHeader.add("Lunch");
        listDataHeader.add("Supper");
        listDataHeader.add("Dinner");

        // Adding child data
        List<String> BreakFast = new ArrayList<String>();
        BreakFast.add("High Fibre cereal ( porridge,flakes etc)");
        BreakFast.add("200ml Milk + 1tsp sugar");
        BreakFast.add("200ml Fruit Juice");
        BreakFast.add("Mug Tea/Coffee");

        List<String> MidMorning = new ArrayList<String>();
        MidMorning.add("2 Digestive Biscuits");
        MidMorning.add("Fruits");
        MidMorning.add("200ml Juice");;

        List<String> Lunch = new ArrayList<String>();
        Lunch.add("Brown Rice-1 Cup");
        Lunch.add("2 Chapaati");
        Lunch.add("Green Vegetables");
        Lunch.add("Curd/Whey 1 Cup");
        Lunch.add("Salad");

        List<String> Supper = new ArrayList<String>();
        Supper.add("Milk 1 Cup");
        Supper.add("Fruits");
        Supper.add("Coffee/Fruit Juice");

        List<String> Dinner = new ArrayList<String>();
        Dinner.add("Soup 1 bowl");
        Dinner.add("2 Chapaati");
        Dinner.add("Mix Vegetables");
        Dinner.add("Salad");

        listDataChild.put(listDataHeader.get(0), BreakFast); // Header, Child data
        listDataChild.put(listDataHeader.get(1), MidMorning);
        listDataChild.put(listDataHeader.get(2), Lunch);
        listDataChild.put(listDataHeader.get(3), Supper);
        listDataChild.put(listDataHeader.get(4), Dinner);


    }
}
