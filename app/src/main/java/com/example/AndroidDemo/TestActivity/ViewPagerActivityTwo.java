package com.example.AndroidDemo.TestActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.AndroidDemo.R;
import com.example.AndroidDemo.TestAdapter.MyPagerAdapter2;

import java.util.ArrayList;

/**
 * Created by huangjing on 2020/9/13.
 * Copyright © 2020. All rights reserved.
 */
public class ViewPagerActivityTwo extends AppCompatActivity {

    private ViewPager viewPager_two;
    private ArrayList<View> viewLists;
    private ArrayList<String> titleLists;
    private MyPagerAdapter2 myPagerAdapter2;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_activity_two);
        viewPager_two = findViewById(R.id.viewpager_two);

        viewLists = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        viewLists.add(li.inflate(R.layout.viewpager_view1,null,false));
        viewLists.add(li.inflate(R.layout.viewpager_view2,null,false));
        viewLists.add(li.inflate(R.layout.viewpager_view3,null,false));

        titleLists = new ArrayList<String>();
        titleLists.add("绿色");
        titleLists.add("黄色");
        titleLists.add("红色");

        myPagerAdapter2 = new MyPagerAdapter2(viewLists,titleLists);
        viewPager_two.setAdapter(myPagerAdapter2);



    }
}
