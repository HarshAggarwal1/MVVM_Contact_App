package com.harsh.mvvmapp.repository.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.harsh.mvvmapp.repository.entity.Contact;

import java.util.List;

@Dao
public interface ContactDAO {
    @Insert
    void addContact(Contact contact);

    @Delete
    void deleteContact(Contact contact);

    @Query("SELECT * FROM contacts")
    LiveData<List<Contact>> getAllContacts();

}
