package com.example.bookyourpg;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class activityServices extends AppCompatActivity {
    RecyclerView recyclerView;
    serviceAdapter serviceAdapter;
    String vv;
    Button btnPlumber,btnLaundry,btnElectrician;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        recyclerView=findViewById(R.id.listServices);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        serviceAdapter=new serviceAdapter(this,getMyList());
        recyclerView.setAdapter(serviceAdapter);
        btnPlumber=findViewById(R.id.btnCall);
        Intent intent=getIntent();
//        String mName=intent.getStringExtra("emName");
//        vv  =getIntent().getExtras().getString("emName");
//        switch (vv) {
//            case "Harish":
//                btnPlumber.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(v.getContext(), "" + vv, Toast.LENGTH_SHORT).show();
//                    }
//                });
//        }
    }
    ArrayList<modelServices> getMyList(){
        ArrayList<modelServices> model=new ArrayList<>();
        modelServices m=new modelServices();
        modelServices m1=new modelServices();
        modelServices m2=new modelServices();
        m.setName("Harish");
        m.setService("Plumber");
        m.setLocation("North Delhi");
        m.setImage(R.drawable.plumber);
        model.add(m);
        m1.setName("Ramesh Kumar");
        m1.setService("Laundry Service");
        m1.setLocation("North Delhi");
        m1.setImage(R.drawable.laundry);
        model.add(m1);
        m2.setName("Manish Singh");
        m2.setService("Electrician");
        m2.setLocation("North Delhi");
        m2.setImage(R.drawable.electrician);
        model.add(m2);
        return model;
    }

}
