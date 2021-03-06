package com.example.retrofitapp_rwn;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;

    private JsonPlaceHolderApi jsonPlaceHolderApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

//        Retrofit retrofit = new Retrofit().Builder()
//                .baseUrl("http://jsonplaceholder.typicode.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

//        getPosts();
        getComments();

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

//        call.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                if (!response.isSuccessful()) {
//                    tvResult.setText("Code:  " + response.code());
//                    return;
//                }
//                List<Post> posts = response.body();
//
//                for (Post post : posts) {
//                    String content = "";
//                    content += "ID:  " + post.getId() + ""  + "\n";
//                    content += "User ID:  " + post.getUserId() +  "\n";
//                    content += "Title:  " + post.getTitle()  + "\n";
//                    content += "Body:  " + post.getBody() +  "\n";
//
//                    tvResult.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                tvResult.setText(t.getMessage());
//            }
//        });
    }

    private void getPosts() {
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    tvResult.setText("Code:  " + response.code());
                    return;
                }
                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID:  " + post.getId() + "" + "\n";
                    content += "User ID:  " + post.getUserId() + "\n";
                    content += "Title:  " + post.getTitle() + "\n";
                    content += "Body:  " + post.getBody() + "\n";

                    tvResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                tvResult.setText(t.getMessage());
            }
        });
    }

    private void getComments() {
        Call<List<Comment>> call = jsonPlaceHolderApi.getComments(2);

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                if(!response.isSuccessful()){
                    tvResult.setText("Code:  "+ response.code());
                    return;
                }

                List<Comment> comments = response.body();

                for (Comment comment : comments){
                    String content = "";
                    content += "ID:  " + comment.getId() + "" + "\n";
                    content += "Post ID:  " + comment.getPostId() + "" + "\n";
                    content += "Name:  " + comment.getName() + "" + "\n";
                    content += "Email:  " + comment.getEmail() + "" + "\n";
                    content += "Comment:  " + comment.getBody() + "" + "\n";

                    tvResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                tvResult.setText(t.getMessage());
            }
        });
    }
}
