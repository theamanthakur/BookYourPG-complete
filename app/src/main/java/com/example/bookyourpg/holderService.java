package com.example.bookyourpg;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class holderService extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView imageViewservice;
    TextView name, serviceName, location, rating;
     ItemClickListener itemClickListener;

    public holderService(@NonNull View itemView) {
        super(itemView);
        this.imageViewservice = itemView.findViewById(R.id.imageViewService);
        this.name = itemView.findViewById(R.id.providename);
        this.serviceName = itemView.findViewById(R.id.serviceName);
        this.location = itemView.findViewById(R.id.servicelocation);
        this.rating = itemView.findViewById(R.id.textViewRating);
            itemView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClickListener(v,getLayoutPosition());
   }
public void setItemClickListener(ItemClickListener ic){

        this.itemClickListener=ic;
}
}

