package com.example.retrofitapp_rwn;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    //relative url
    @GET("posts")
    Call<List<Post>> getPosts();
}
