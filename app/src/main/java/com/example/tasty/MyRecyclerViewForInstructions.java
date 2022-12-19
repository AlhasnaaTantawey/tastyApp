package com.example.tasty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyRecyclerViewForInstructions extends RecyclerView.Adapter<MyRecyclerViewForInstructions.ViewHoder>{
    List<steps> data;

    public MyRecyclerViewForInstructions(List<steps> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_view_for_ingridents, parent, false);
         ViewHoder holder=new ViewHoder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewForInstructions.ViewHoder holder, int position) {
        steps steps = data.get(position);
       holder.number.setText(steps.getPosition().toString());
       holder.value.setText(steps.getDisplay_text().toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected class ViewHoder extends RecyclerView.ViewHolder {
        TextView number,value;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.grouviewingridents_txt_number);
            value=itemView.findViewById(R.id.grouviewingridents_txt_textvalue);

        }
    }
}
