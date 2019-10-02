package com.example.bookyourpg;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookyourpg.models.NewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchPgAdapter extends RecyclerView.Adapter<SearchPgAdapter.ViewHolder> {
    private Context mcontext;
    private ArrayList<NewModel> mList;
    private ArrayList<ArrayList<String>> featureArrayList;

    public SearchPgAdapter(Context context, ArrayList<NewModel> list, ArrayList<ArrayList<String>> featureArrayList) {
        mcontext = context;
        mList = list;
        this.featureArrayList = featureArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mcontext);
        View view = layoutInflater.inflate(R.layout.cardview, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        // feature arrayList contain the list of all the feature that the pg had and hence we can show them using arrayAdapter
        Log.d("SPA", "onBindViewHolder: " + mList.get(position).getIMAGES());
        NewModel newModel = mList.get(position);
        if (newModel.getIMAGES().size() > 0)
            Picasso.get().load(newModel.getIMAGES().get(0)).into(viewHolder.item_image);
        viewHolder.item_title.setText(newModel.getName());
        viewHolder.item_detail.setText(newModel.getDescription());
        viewHolder.item_price.setText(newModel.getPrice());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_image;
        TextView item_title, item_detail, item_price;

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

                    switch (position) {
                        case 0:
                            Intent in = new Intent(v.getContext(), DetailPg.class);
                             mcontext.startActivity(in);
                    }
                }
            });
        }
    }

}
