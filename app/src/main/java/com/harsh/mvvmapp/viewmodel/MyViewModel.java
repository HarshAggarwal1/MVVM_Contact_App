package com.harsh.mvvmapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.harsh.mvvmapp.repository.MyRepository;
import com.harsh.mvvmapp.repository.entity.Contact;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private final MyRepository myRepository;
    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new MyRepository(application);
    }

    public void addContact(Contact contact) {
        myRepository.addContact(contact);
    }

    public void deleteContact(Contact contact) {
        myRepository.deleteContact(contact);
    }

    public LiveData<List<Contact>> getAllContacts() {
        return myRepository.getAllContacts();
    }
}
