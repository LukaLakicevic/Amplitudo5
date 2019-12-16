package com.bignerdranch.android.amplitudo5;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.android.amplitudo5.models.Post;

import static com.bignerdranch.android.amplitudo5.ApiClient.apiService;
import static com.bignerdranch.android.amplitudo5.DataHolder.holder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView apiTextView = findViewById(R.id.api_txt_view);

        String email = holder.getEmail();
        String password = holder.getPassword();

        Post post = new Post(holder.getEmail(), holder.getPassword());

        apiService.createPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()) {
                    apiTextView.setText("Code: " + response.code());
                    Toast.makeText(MainActivity.this, "Server error", Toast.LENGTH_SHORT).show();
                    return;

                }

                Post postResponce = response.body();

                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "Name: " + postResponce.getName() + "\n";
                content += "gender: " + postResponce.getGender() + "\n";
                content += "city: " + postResponce.getCity() + "\n";
                content += "country: " + postResponce.getCountry() + "\n";
                content += "email: " + postResponce.getEmail() + "\n";
                content += "image: " + postResponce.getImage() + "\n\n";

                apiTextView.setText(content);

                Toast.makeText(MainActivity.this, holder.getEmail() + holder.getPassword(), Toast.LENGTH_SHORT).show();



            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                apiTextView.setText(t.getMessage());
                Log.e("MainActivity", t.getMessage());
            }
        });
    }
}
