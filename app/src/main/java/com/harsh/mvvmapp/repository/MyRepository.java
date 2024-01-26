package com.harsh.mvvmapp.repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import com.harsh.mvvmapp.repository.dao.ContactDAO;
import com.harsh.mvvmapp.repository.database.ContactDatabase;
import com.harsh.mvvmapp.repository.entity.Contact;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRepository {

    private final ContactDAO contactDAO;
    private final ExecutorService executorService;
    private Handler handler;

    public MyRepository(Application application) {
        ContactDatabase contactDatabase = ContactDatabase.getInstance(application);
        this.contactDAO = contactDatabase.getContactDAO();
        executorService = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }

    public void addContact(Contact contact) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.addContact(contact);
            }
        });
    }
    public void deleteContact(Contact contact) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.deleteContact(contact);
            }
        });
    }
    public LiveData<List<Contact>> getAllContacts() {
        return contactDAO.getAllContacts();
    }

}
