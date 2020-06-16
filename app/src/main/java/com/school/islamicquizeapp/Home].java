package com.school.islamicquizeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

class Home extends  AppCompatActivity{
        private static RecyclerView.Adapter adapter;
        private RecyclerView.LayoutManager layoutManager;
        private static RecyclerView recyclerView;
        private static ArrayList<DataModel> data;
        static View.OnClickListener myOnClickListener;
        private static ArrayList<Integer> removedItems;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_home);



                recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
                recyclerView.setHasFixedSize(true);

                layoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

                data = new ArrayList<DataModel>();
                for (int i = 0; i < MyData.nameArray.length; i++) {
                        data.add(new DataModel(
                                MyData.nameArray[i],
                                MyData.versionArray[i],
                                MyData.id_[i]
                        ));
                }
                removedItems = new ArrayList<Integer>();

                adapter = new CustomAdapter(data);
                recyclerView.setAdapter(adapter);
        }





}
