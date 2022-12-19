package com.example.tasty;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface EndPoint {
    @Headers({"x-rapidapi-host: tasty.p.rapidapi.com",
            "x-rapidapi-key: 6d8f11b279mshd422c1c6017bdb2p128792jsn1f1b95aff697"
    })
    @GET("feeds/list?size=20&timezone=+02&vegetarian=<REQUIRED>&from=0")
    Call<AllData> getAllItems() ;

    @Headers({"x-rapidapi-host: tasty.p.rapidapi.com", "x-rapidapi-key: 6d8f11b279mshd422c1c6017bdb2p128792jsn1f1b95aff697"})
    @GET("tags/list")
    Call<AllData> getAllTags();

    @Headers({"x-rapidapi-host: tasty.p.rapidapi.com", "x-rapidapi-key: 6d8f11b279mshd422c1c6017bdb2p128792jsn1f1b95aff697"})
    @GET("recipes/detail")
    Call<AllDataForOneItem> getDetailAboutItem(@Query("id")Integer id);


}
