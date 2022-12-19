package com.example.tasty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailsForRecipe extends Fragment {
    TextView title,ingredientsValue;
    AllDataForOneItem allDataForOneItem;
    ImageView imageView;
    View view;
    RecyclerView recyclerView1,recyclerView2;
    MyRecyclerViewForInstructions myRecyclerViewForInstructions;
    MyRecyclerViewForFilling myRecyclerViewForFilling;
    public DetailsForRecipe() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_details_for_recipe, container, false);
        title = view.findViewById(R.id.detailForRecipes_txtv_title);
        ingredientsValue=view.findViewById(R.id.detailForRecipes_txtv_ingridentsValue);
        allDataForOneItem = new AllDataForOneItem();
        imageView = view.findViewById(R.id.detalisForRecipes_imageView);
        if (getArguments() != null) {
            Integer id = getArguments().getInt("islam", 0);
           getData(id);

        }

        return view;
    }

    public void getData(Integer id) {
        Retrofit retrofit = Client.getRetrofit();
        EndPoint endPoint = retrofit.create(EndPoint.class);
        Call<AllDataForOneItem> call3 = endPoint.getDetailAboutItem(id);
        call3.enqueue(new Callback<AllDataForOneItem>() {
            @Override
            public void onResponse(Call<AllDataForOneItem> call, Response<AllDataForOneItem> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                allDataForOneItem = response.body();
                title.setText(allDataForOneItem.getName().toString());
                Picasso.with(imageView.getContext())
                        .load(allDataForOneItem.getThumbnail_url())
                        .into(imageView);
                 ingredientsValue.setText(allDataForOneItem.getYields());
                setAdapterforfilling(allDataForOneItem.getSections().get(0).getComponents(),R.id.fragmentDetail_recyclerview_filling);
                setAdapter(allDataForOneItem.getInstructions(),R.id.fragmentDetail_recyclerview_ingridents);
            }

            @Override
            public void onFailure(Call<AllDataForOneItem> call, Throwable t) {
            }
        });
    }
    public void setAdapterforfilling( List<UserModelForFilling> data,int id) {
        recyclerView1=view.findViewById(id);
        myRecyclerViewForFilling = new MyRecyclerViewForFilling(data);
        recyclerView1.setAdapter(myRecyclerViewForFilling);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
       DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView1.addItemDecoration(dividerItemDecoration);

    }
    public void setAdapter( List<steps> data,int id) {
        recyclerView2=view.findViewById(id);
        myRecyclerViewForInstructions = new MyRecyclerViewForInstructions(data);
        recyclerView2.setAdapter(myRecyclerViewForInstructions);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
    }
}