package com.android_get_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter postAdapter;
    private UserViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        postViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        postViewModel.getPosts().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> posts) {
                postAdapter = new Adapter(posts);
                recyclerView.setAdapter(postAdapter);
            }
        });
    }

}