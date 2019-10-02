package com.example.bookyourpg;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class serviceAdapter extends RecyclerView.Adapter<holderService> {
Context context;
ArrayList<modelServices> modelServices;

    public serviceAdapter(Context context, ArrayList<com.example.bookyourpg.modelServices> modelServices) {
        this.context = context;
        this.modelServices = modelServices;
    }

    @NonNull
    @Override
    public holderService onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_service,null);
        return new holderService(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holderService holderService, int i) {
        holderService.name.setText(modelServices.get(i).getName());
        holderService.serviceName.setText(modelServices.get(i).getService());
        holderService.location.setText(modelServices.get(i).getLocation());
     //   holderService.rating.setText((int) modelServices.get(i).getRating());
        holderService.imageViewservice.setImageResource(modelServices.get(i).getImage());
        holderService.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String sName=modelServices.get(position).getName();
                Intent intent=new Intent(context,activityServices.class);
                intent.putExtra("emName",sName);
                ByteArrayOutputStream stream=new ByteArrayOutputStream();
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return modelServices.size();
    }
}
