package com.android_get_api;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends ViewModel {
    private MutableLiveData<List<UserModel>> posts;
    private RetrofitClient repository;

    public UserViewModel() {
        repository = new RetrofitClient();
        posts = new MutableLiveData<>();
        loadPosts();
    }

    private void loadPosts() {
        Call<List<UserModel>> call = repository.getPosts();
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    posts.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                // Handle error
            }
        });
    }

    public LiveData<List<UserModel>> getPosts() {
        return posts;
    }
}