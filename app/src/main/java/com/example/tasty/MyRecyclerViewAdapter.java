package com.example.tasty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHoder> {
    List<UserModel> dataImage;
    SearchFragment searchFragment;
    DetailsForRecipe detailsForRecipe;

    public MyRecyclerViewAdapter(List<UserModel> dataImage, SearchFragment searchFragment) {
        this.dataImage = dataImage;
        this.searchFragment = searchFragment;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.groupview, parent, false);
        ViewHoder holder = new ViewHoder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        UserModel userModel = dataImage.get(position);
        String url_image = userModel.getImage();
        Picasso.with(holder.image.getContext())
                .load(url_image)
                .into(holder.image);

        holder.nameTextView.setText(userModel.getName());
        Integer id = userModel.getId();
    }

    @Override
    public int getItemCount() {
        return dataImage.size();
    }

    protected class ViewHoder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView nameTextView;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.groupView_image);
            nameTextView = itemView.findViewById(R.id.groupView_textView);
            detailsForRecipe = new DetailsForRecipe();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UserModel userModel = dataImage.get(getAdapterPosition());
                    Bundle bundle = new Bundle();
                    bundle.putInt("islam", userModel.getId());
                    DetailsForRecipe detailsForRecipe = new DetailsForRecipe();
                    detailsForRecipe.setArguments(bundle);
                    searchFragment.getParentFragmentManager()
                            .beginTransaction()
                            .replace(R.id.layout_fragment, detailsForRecipe)
                            .addToBackStack("null")
                            .commit();

                }
            });
        }
    }
}
