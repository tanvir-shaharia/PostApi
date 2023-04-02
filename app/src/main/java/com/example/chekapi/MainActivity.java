package com.example.chekapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.chekapi.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;

    List<UserData> userDataList;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userDataList=new ArrayList<>();

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        apiInterface.userlist().enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {

                if (response.body() != null){
                    Toast.makeText(MainActivity.this, "Data signal true", Toast.LENGTH_SHORT).show();
                    userDataList=response.body();
                    PostAdapter adapter = new PostAdapter(MainActivity.this,userDataList);
                    binding.recylr.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }
}