package com.example.ash.firebasewithrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ash on 6/7/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    ArrayList<ContractsDataModel> list;
    Context context;

    public MyAdapter(ArrayList<ContractsDataModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameView.setText(list.get(position).getName());
        holder.numberView.setText(list.get(position).getNumber());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameView , numberView;

        public ViewHolder(View itemView) {
            super(itemView);

            nameView = (TextView) itemView.findViewById(R.id.nameTView);
            numberView = (TextView) itemView.findViewById(R.id.numberTView);
        }
    }

}
