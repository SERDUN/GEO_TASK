package com.example.user.geotask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.geotask.screen.beginningPathFragment.BeginningPathRecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("1");
//        arrayList.add("2");
//        arrayList.add("3");
//        arrayList.add("3");
//
//        BeginningPathRecyclerAdapter beginningPathRecyclerAdapter = new BeginningPathRecyclerAdapter(arrayList);
//
//        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.rvPlaces);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(beginningPathRecyclerAdapter);
    }
}
