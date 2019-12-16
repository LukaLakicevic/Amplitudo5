package com.bignerdranch.android.amplitudo5;


import com.bignerdranch.android.amplitudo5.models.City;
import com.bignerdranch.android.amplitudo5.models.Post;
import com.bignerdranch.android.amplitudo5.models.TestPost;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiService {


    @POST("api/login")
    Call<Post> createPost(@Body Post post);
}