package com.harsh.mvvmapp.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.harsh.mvvmapp.R;
import com.harsh.mvvmapp.clickhandler.AddContactActivityClickHandler;
import com.harsh.mvvmapp.repository.entity.Contact;
import com.harsh.mvvmapp.viewmodel.MyViewModel;

public class AddContactActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.harsh.mvvmapp.databinding.ActivityAddContactBinding addContactBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_add_contact
        );

        // View Model
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        // Compose Contact
        Contact contact = new Contact("", "");

        // Click Handler
        AddContactActivityClickHandler clickHandler = new AddContactActivityClickHandler(this, contact, myViewModel);

        // Set Binding
        addContactBinding.setContact(contact);
        addContactBinding.setClickHandler(clickHandler);
    }
}
