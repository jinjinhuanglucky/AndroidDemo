package com.example.AndroidDemo;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.AndroidDemo.fragments.Baby;
import com.example.AndroidDemo.fragments.Collage;
import com.example.AndroidDemo.fragments.FirstPage;
import com.example.AndroidDemo.fragments.Mine;
import com.example.AndroidDemo.fragments.Square;
import com.example.AndroidDemo.TestLayout.BottomLayout;

/**
 * Created by huangjing on 2020/9/12.
 * Copyright © 2020. All rights reserved.
 */

public class MainActivity extends FragmentActivity {
    private FirstPage firstPage;
    private Collage collage;
    private Baby baby;
    private Square square;
    private Mine mine;

    BottomLayout firstPageLayout;
    BottomLayout collageLayout;
    BottomLayout squareLayout;
    BottomLayout mineLayout;
   // BabyLayout babyLayout;
    BottomLayout  babyLayout;

    FragmentManager fragmentManager;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_avtivity_main);
        ActionBar actionBar = getActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        initBottomLayout();
    }

//为底部导航栏设置默认状态和选中状态的文字和图片样式
    private void initBottomLayout() {
        firstPageLayout = findViewById(R.id.firstpage);
        collageLayout = findViewById(R.id.collage);
        babyLayout =  findViewById(R.id.baby);
        squareLayout = findViewById(R.id.square);
        mineLayout = findViewById(R.id.mine);

        firstPageLayout.setNormalImage(R.drawable.firstpage_normal);
        firstPageLayout.setFocusedImage(R.drawable.firstpage_focused);
        firstPageLayout.setFocused(true);
        firstPageLayout.setTvText("首页");

        collageLayout.setNormalImage(R.drawable.collage_normal);
        collageLayout.setFocusedImage(R.drawable.collage_focused);
        collageLayout.setFocused(false);
        collageLayout.setTvText("大学");

        babyLayout.setFocused(false);
        babyLayout.setNormalImage(R.drawable.baby_normal);
        babyLayout.setFocusedImage(R.drawable.baby_focused);
        squareLayout.setNormalImage(R.drawable.square_normal);
        squareLayout.setFocusedImage(R.drawable.square_focused);
        squareLayout.setFocused(false);
        squareLayout.setTvText("广场");

        mineLayout.setNormalImage(R.drawable.mine_normal);
        mineLayout.setFocusedImage(R.drawable.mine_focused);
        mineLayout.setTvText("我的");
        mineLayout.setFocused(false);

        firstPageLayout.setOnClickListener(new mClick());
        collageLayout.setOnClickListener(new mClick());
        squareLayout.setOnClickListener(new mClick());
        mineLayout.setOnClickListener(new mClick());
        babyLayout.setOnClickListener(new mClick());

        frameLayout = findViewById(R.id.frameLayout_container);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        firstPage = new FirstPage();
        transaction.add(R.id.frameLayout_container,firstPage);
        transaction.commit();

    }

//点击菜单切换界面
    private class mClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (v.getId()){
                case R.id.firstpage:
                    firstPageLayout.setFocused(true);
                    collageLayout.setFocused(false);
                    babyLayout.setFocused(false);
                    squareLayout.setFocused(false);
                    mineLayout.setFocused(false);
                    if(firstPage == null){
                        firstPage = new FirstPage();
                        transaction.replace(R.id.frameLayout_container,firstPage);
                    }else{
                        transaction.replace(R.id.frameLayout_container,firstPage);
                    }
                    break;
                case R.id.collage:
                    firstPageLayout.setFocused(false);
                    collageLayout.setFocused(true);
                    babyLayout.setFocused(false);
                    squareLayout.setFocused(false);
                    mineLayout.setFocused(false);
                    if(collage == null){
                        collage = new Collage();
                        transaction.replace(R.id.frameLayout_container, collage);
                    }else{
                        transaction.replace(R.id.frameLayout_container,collage);
                    }
                    break;
                case R.id.baby:
                    firstPageLayout.setFocused(false);
                    collageLayout.setFocused(false);
                    babyLayout.setFocused(true);
                    squareLayout.setFocused(false);
                    mineLayout.setFocused(false);
                    if(baby == null){
                        baby = new Baby();
                        transaction.replace(R.id.frameLayout_container, baby);
                    }else{
                        transaction.replace(R.id.frameLayout_container,baby);
                    }
                    break;
                case R.id.square:
                    firstPageLayout.setFocused(false);
                    collageLayout.setFocused(false);
                    babyLayout.setFocused(false);
                    squareLayout.setFocused(true);
                    mineLayout.setFocused(false);
                    if(square == null){
                        square = new Square();
                        transaction.replace(R.id.frameLayout_container, square);
                    }else{
                        transaction.replace(R.id.frameLayout_container,square);
                    }
                    break;
                case R.id.mine:
                    firstPageLayout.setFocused(false);
                    collageLayout.setFocused(false);
                    babyLayout.setFocused(false);
                    squareLayout.setFocused(false);
                    mineLayout.setFocused(true);
                    if(mine == null){
                        mine = new Mine();
                        transaction.replace(R.id.frameLayout_container, mine);
                    }else{
                        transaction.replace(R.id.frameLayout_container,mine);
                    }
                    break;


            }
            transaction.commit();
        }
    }
}

