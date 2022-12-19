package com.example.tasty;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewForFilling extends RecyclerView.Adapter<MyRecyclerViewForFilling.ViewHoder>{
    List<UserModelForFilling> data;

    public MyRecyclerViewForFilling(List<UserModelForFilling> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_view_for_filling, parent, false);
        ViewHoder holder=new ViewHoder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewForFilling.ViewHoder holder, int position) {
        UserModelForFilling userModelForFilling = data.get(position);
        holder.number.setText(userModelForFilling.getRaw_text());
        holder.value.setText(userModelForFilling.getIngredient().getName().toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected class ViewHoder extends RecyclerView.ViewHolder {
        TextView number,value;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            value=itemView.findViewById(R.id.groupviewforfilling_txt_filling);
            number = itemView.findViewById(R.id.groupviewforfilling_txt_spoon);


        }
    }
}
