package com.example.retrofitapp_rwn;

import com.google.gson.annotations.SerializedName;

public class Post {

/* "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body":*/

    private int userId;
    private int id;
    private String title;
    private String body;

    //in case the variable name differs with the key
//    SerializedName("body")
//    private String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
