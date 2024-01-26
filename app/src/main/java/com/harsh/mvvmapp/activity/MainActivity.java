package com.harsh.mvvmapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.harsh.mvvmapp.R;
import com.harsh.mvvmapp.adapter.MyAdapter;
import com.harsh.mvvmapp.clickhandler.MainActivityClickHandler;
import com.harsh.mvvmapp.databinding.ActivityMainBinding;
import com.harsh.mvvmapp.repository.entity.Contact;
import com.harsh.mvvmapp.viewmodel.MyViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.harsh.mvvmapp.databinding.ActivityMainBinding mainBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        );
        MainActivityClickHandler clickHandler = new MainActivityClickHandler(this, mainBinding);
        mainBinding.setClickHandler(clickHandler);

        // Recycler View
        mainBinding.recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );
        mainBinding.recyclerView.setHasFixedSize(true);

        // Adapter
        myAdapter = new MyAdapter();
        mainBinding.recyclerView.setAdapter(myAdapter);

        // View Model
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);


        // Observe
        myViewModel.getAllContacts().observe(
                this,
                new Observer<List<Contact>>() {
                    @Override
                    public void onChanged(List<Contact> contacts) {
                        myAdapter.setContacts(contacts);
                    }
                }
        );

        // swipe to delete
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                myViewModel.deleteContact(myAdapter.getContactAt(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this, "Contact Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(mainBinding.recyclerView);
    }
}