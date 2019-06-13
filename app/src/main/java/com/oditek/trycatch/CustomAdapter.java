package com.oditek.trycatch;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context mContext;

    List<Model> list;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    public CustomAdapter(Context mContext, List<Model> list) {
        this.mContext = mContext;
        this.list = list;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Model model = list.get(position);
        final int image = model.getImage();
        final String name = model.getName();
        final String details = model.getDetails();


        holder.image.setImageResource(image);
        holder.name.setText(name);
        holder.details.setText(details);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name, details;
        public ImageView image;
        public CardView mCardView;
        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.iv1);
            name = (TextView) itemView.findViewById(R.id.tv1);
            details = (TextView) itemView.findViewById(R.id.tv2);

            mCardView = (CardView) itemView.findViewById(R.id.card_view);
        }

    }

}