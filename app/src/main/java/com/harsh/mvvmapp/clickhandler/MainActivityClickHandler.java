package com.harsh.mvvmapp.clickhandler;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.harsh.mvvmapp.activity.AddContactActivity;
import com.harsh.mvvmapp.databinding.ActivityMainBinding;

public class MainActivityClickHandler {
    Context context;
    ActivityMainBinding mainBinding;

    public MainActivityClickHandler(Context context, ActivityMainBinding mainBinding) {
        this.context = context;
        this.mainBinding = mainBinding;
    }

    public void onFabClicked(View view) {
        Intent intent = new Intent(view.getContext(), AddContactActivity.class);
        context.startActivity(intent);
    }
}
