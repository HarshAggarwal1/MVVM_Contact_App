package com.harsh.mvvmapp.clickhandler;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.harsh.mvvmapp.activity.MainActivity;
import com.harsh.mvvmapp.repository.entity.Contact;
import com.harsh.mvvmapp.viewmodel.MyViewModel;

public class AddContactActivityClickHandler {
    private final Context context;
    private final Contact contact;
    private final MyViewModel myViewModel;

    public AddContactActivityClickHandler(Context context, Contact contact, MyViewModel myViewModel) {
        this.context = context;
        this.contact = contact;
        this.myViewModel = myViewModel;
    }

    public void onAddContactButtonClicked(View view) {
        if (contact.getName().isEmpty() || contact.getPhone().isEmpty()) {
            Toast.makeText(this.context, "Empty Fields Not Allowed!", Toast.LENGTH_SHORT).show();
            return;
        }
        myViewModel.addContact(contact);
        Intent intent = new Intent(this.context, MainActivity.class);
        this.context.startActivity(intent);
    }
}
