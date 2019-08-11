package com.example.bookyourpg;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchPgAdapter extends RecyclerView.Adapter<SearchPgAdapter.ViewHolder> {
    private Context mcontext;
    private ArrayList<modelsearchPG>mList;
    SearchPgAdapter(Context context, ArrayList<modelsearchPG>list){
    mcontext=context;
    mList=list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(mcontext);
       View view= layoutInflater.inflate(R.layout.cardview,parent,false );
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
    //modelsearchPG pgItem=mList.get(position);
   // ImageView image=viewHolder.item_image;
   // TextView title,details,price;
//    title=viewHolder.item_title;
//    details=viewHolder.item_detail;
//    price=viewHolder.item_price;

    viewHolder.item_image.setImageResource(mList.get(position).getImage());
       viewHolder.item_title.setText(mList.get(position).getTitle());
        viewHolder.item_detail.setText(mList.get(position).getDetails());
        viewHolder.item_price.setText(mList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_image;
        TextView item_title,item_detail,item_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_image = itemView.findViewById(R.id.item_image);
            item_title = itemView.findViewById(R.id.item_title);
            item_detail = itemView.findViewById(R.id.item_detail);
            item_price = itemView.findViewById(R.id.item_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Toast.makeText(v.getContext(), "success" + position, Toast.LENGTH_SHORT).show();
                        switch (position){
                            case 0:
                                Intent in=new Intent(v.getContext(),DetailPg.class);
                        }
                }
            });
        }
    }

}
