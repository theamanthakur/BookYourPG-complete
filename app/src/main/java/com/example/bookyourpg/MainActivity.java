package com.example.bookyourpg;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity  {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    RecyclerView recyclerView;
    modelsearchPG mm,mm1,mm2,mm3;
    ArrayList<modelsearchPG> pgArrayList;
    private CardView cardSearch;

    private String[] urls = new String[]{"https://backgroundimages.withfloats.com/actual/585c238a1f07f509f0ab114c.jpg","https://4.imimg.com/data4/XP/JB/MY-29402471/pg-rooms-500x500.jpg", "https://files.qatarliving.com/2019/04/11/Rent-room-stockholm.jpg", "https://q-ak.bstatic.com/images/hotel/max1024x768/120/120254697.jpg",
            "https://qphs.fs.quoracdn.net/main-qimg-b017a797a40123831b6d92ce3c3f4e44", "https://tuffclassified.com/oc-content/uploads/11786/1180695_preview.jpg", "https://glimageurl.golocall.com/golocal-post/image/36919_1475569517.jpeg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_pg);
        recyclerView=findViewById(R.id.rvSeachPg);

   //    final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
    //    RecyclerView.LayoutManager rvLayoutManager=linearLayoutManager;
     //   recyclerView.setLayoutManager(rvLayoutManager) ;
        pgArrayList=new ArrayList<>();
      //  cardSearch=(CardView) findViewById(R.id.card_search);
//        cardSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            pgArrayList.add(new modelsearchPG(R.drawable.oasisgirls,"OASIS GIRLS","Kamla Nagar,New Delhi","18000 Rs."));
//                pgArrayList.add(new modelsearchPG(R.drawable.dalimaboys,"DALIMA BOYS","Hudson Lane,New Delhi","15000 Rs."));
//                pgArrayList.add(new modelsearchPG(R.drawable.greengirls,"GREEN GIRLS","Gurgaon Sec-40","16000 Rs."));
//                pgArrayList.add(new modelsearchPG(R.drawable.whitekothi,"WHITE KOTHI","Hudson Lane,New Delhi","15000"));
       // pgArrayList.add(new modelsearchPG())
//        });
          mm=new modelsearchPG();
          mm.setTitle("OASIS GIRLS");
          mm.setPrice("15000 Rs.");
          mm.setDetails("Kamla Nagar \n"+
                  "New Delhi IN");
          mm.setImage(R.drawable.oasisgirls);
          pgArrayList.add(mm);
        mm1=new modelsearchPG();

        mm1.setTitle("GREEN GIRLS");
        mm1.setPrice("17000 Rs.");
        mm1.setDetails("Gurgaon Sec-40 \n"+
                "Delhi NCR");
        mm1.setImage(R.drawable.greengirls);
        pgArrayList.add(mm1);
        mm2=new modelsearchPG();

        mm2.setTitle("DALIMA BOYS");
        mm2.setPrice("18000 Rs.");
        mm2.setDetails("HUdson Lane \n"+
                "New Delhi");
        mm2.setImage(R.drawable.dalimaboys);
        pgArrayList.add(mm2);
        mm3=new modelsearchPG();

        mm3.setTitle("WHITE KOHTI");
        mm3.setPrice("14000 Rs.");
        mm3.setDetails("Hudson Lane \n"+
                "New Delhi");
        mm3.setImage(R.drawable.whitekothi);
        pgArrayList.add(mm3);

//         LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        RecyclerView.LayoutManager rvLayoutManager=linearLayoutManager;
      //  Toast.makeText(this, ""+pgArrayList.get(1).getPrice(), Toast.LENGTH_SHORT).show();
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this)) ;
       // recyclerView.setLayoutManager(rvLayoutManager);
        SearchPgAdapter adapter=new SearchPgAdapter(this,pgArrayList);
        recyclerView.setAdapter(adapter);

     //   init();


    }
    ////////////////////////////////FOR IMAGE SLIDER////////////////////////////////////////////////////////
    private void init() {

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(MainActivity.this, urls));

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


////////////////////////////////FOR IMAGE SLIDER////////////////////////////////////////////////////////
}

