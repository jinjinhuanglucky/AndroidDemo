package com.example.AndroidDemo.TestActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.AndroidDemo.R;
import com.example.AndroidDemo.TestAdapter.MyPagerAdapter;

import java.util.ArrayList;

/**
 * Created by huangjing on 2020/9/13.
 * Copyright © 2020. All rights reserved.
 */
public class ViewPagerActivityOne extends AppCompatActivity {

    private ViewPager viewPager_one;
    private ArrayList<View> arrayList;
    private MyPagerAdapter myPagerAdapter;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_activity_one);
        viewPager_one = findViewById(R.id.viewpager_one);

        arrayList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        arrayList.add(li.inflate(R.layout.viewpager_view1,null,false));
        arrayList.add(li.inflate(R.layout.viewpager_view2,null,false));
        arrayList.add(li.inflate(R.layout.viewpager_view3,null,false));

        myPagerAdapter = new MyPagerAdapter(arrayList);
        viewPager_one.setAdapter(myPagerAdapter);

    }
}
