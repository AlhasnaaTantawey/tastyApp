package com.example.tasty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class SearchFragment extends Fragment {

    RecyclerView recyclerView1, recyclerView2, recyclerView3, recyclerView4, recyclerView5;
    TextView txt1, txt2, txt3, txt4, txt5, txt6;
    ImageView imageView;
    MyRecyclerViewAdapter myRecyclerViewAdapter;
    List<UserModel> dataImage;
    View view;
    AllData allData;
    List<Item> result;
    ProgressBar progressBar;
    public SearchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        progressBar = view.findViewById(R.id.searchfragment_progress_cicle);
        imageView = view.findViewById(R.id.searchFramgment_imageView);
        txt6 = view.findViewById(R.id.searchfragment_txtv_onpicture);
        dataImage = new ArrayList<>();
        allData = new AllData();
        Retrofit retrofit = Client.getRetrofit();
        EndPoint endPoint = retrofit.create(EndPoint.class);
        Call<AllData> call = endPoint.getAllItems();
        call.enqueue(new Callback<AllData>() {
            @Override
            public void onResponse(Call<AllData> call, Response<AllData> response) {
                if (!response.isSuccessful()) {
                    Log.i("islam",response.message());
                    return;
                }
                allData = response.body();
                result = allData.getResults();
                setPoster();
                setpictureAndTitle();

            }
            @Override
            public void onFailure(Call<AllData> call, Throwable t) {
                Log.i("islam","fail");

            }
        });
//        Call<AllData> call2 = endPoint.getAllTags();
//        call2.enqueue(new Callback<AllData>() {
//            @Override
//            public void onResponse(Call<AllData> call, Response<AllData> response) {
//                if (!response.isSuccessful()) {
//                    return;
//                }
//                allData = response.body();
//                for (int i = 0; i < allData.getResults().size(); i++) {
//                    String tag = allData.getResults().get(i).getType();
//                    Log.i("islam", tag);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<AllData> call, Throwable t) {
//
//            }
//        });


        return view;
    }

    public void setAdapter(RecyclerView recyclerView, int id, int index) {
        dataImage = result.get(index).getItems();
        recyclerView = view.findViewById(id);
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(dataImage,this);
        recyclerView.setAdapter(myRecyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false));
    }

    public void setTextForTitle(TextView txt, int id, String text) {
        txt = view.findViewById(id);
        txt.setText(text);
    }

    public void setPoster() {
        txt6.setText(result.get(0).getOneItem().getName());
        Picasso.with(imageView.getContext())
                .load(result.get(0).getOneItem().getThumbnail_url())
                .into(imageView);
    }

    public void setpictureAndTitle() {
        progressBar.setVisibility(View.GONE);
        setAdapter(recyclerView1, R.id.main_recycler1, 2);
        setTextForTitle(txt1, R.id.searchFrag_txtV_txt1, result.get(2).getName().toString());
        setAdapter(recyclerView2, R.id.main_recycler2, 3);
        setTextForTitle(txt2, R.id.searchFrag_txtV_txt2, result.get(3).getName().toString());
        setAdapter(recyclerView3, R.id.main_recycler3, 4);
        setTextForTitle(txt3, R.id.searchFrag_txtV_txt3, result.get(4).getName().toString());
        setAdapter(recyclerView4, R.id.main_recycler4, 5);
        setTextForTitle(txt4, R.id.searchFrag_txtV_txt4, result.get(5).getName().toString());
        setAdapter(recyclerView5, R.id.main_recycler5, 6);
        setTextForTitle(txt5, R.id.searchFrag_txtV_txt5, result.get(6).getName().toString());
    }
}