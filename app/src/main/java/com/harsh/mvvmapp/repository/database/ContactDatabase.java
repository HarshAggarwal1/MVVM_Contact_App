package com.harsh.mvvmapp.repository.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.harsh.mvvmapp.repository.dao.ContactDAO;
import com.harsh.mvvmapp.repository.entity.Contact;

@Database(entities = {Contact.class}, version = 1, exportSchema = false)
public abstract class ContactDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "contact_db";
    private static ContactDatabase INSTANCE;

    public static synchronized ContactDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ContactDatabase.class,
                    DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public abstract ContactDAO getContactDAO();
}
