package com.example.bookyourpg;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class main_class extends AppCompatActivity {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    RecyclerView recyclerView;
    modelsearchPG mm;
    ArrayList<modelsearchPG> pgArrayList;
     Button cardSearch;
    private String[] urls = new String[]{"https://backgroundimages.withfloats.com/actual/585c238a1f07f509f0ab114c.jpg","https://4.imimg.com/data4/XP/JB/MY-29402471/pg-rooms-500x500.jpg", "https://files.qatarliving.com/2019/04/11/Rent-room-stockholm.jpg", "https://q-ak.bstatic.com/images/hotel/max1024x768/120/120254697.jpg",
            "https://qphs.fs.quoracdn.net/main-qimg-b017a797a40123831b6d92ce3c3f4e44", "https://tuffclassified.com/oc-content/uploads/11786/1180695_preview.jpg", "https://glimageurl.golocall.com/golocal-post/image/36919_1475569517.jpeg"};

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardSearch= findViewById(R.id.buttonBook);
        init();
        cardSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(main_class.this, "sucess", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(main_class.this,MainActivity.class));
            }
        });
    }
    public void init() {

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(main_class.this,urls));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES = urls.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });


    }
}
