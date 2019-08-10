package com.example.bookyourpg;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
       View view= layoutInflater.inflate(R.layout.search_pg,parent,false );
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
    modelsearchPG pgItem=mList.get(position);
    ImageView image=viewHolder.item_image;
    TextView title,details,price;
    title=viewHolder.item_title;
    details=viewHolder.item_detail;
    price=viewHolder.item_price;

    image.setImageResource(pgItem.getImage());
        title.setText(pgItem.getTitle());
        details.setText(pgItem.getDetails());
        price.setText(pgItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_image;
        TextView item_title,item_detail,item_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_image=itemView.findViewById(R.id.item_image);
            item_title=itemView.findViewById(R.id.item_title);
            item_detail=itemView.findViewById(R.id.item_detail);
            item_price=itemView.findViewById(R.id.item_price);
        }
    }
}
