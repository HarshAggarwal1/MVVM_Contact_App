package com.harsh.mvvmapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.harsh.mvvmapp.R;
import com.harsh.mvvmapp.databinding.ContactListItemBinding;
import com.harsh.mvvmapp.repository.entity.Contact;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Contact> contacts;

    public MyAdapter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.contact_list_item,
                parent,
                false
        );
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.binding.setContact(contact);
    }

    @Override
    public int getItemCount() {
        return contacts == null ? 0 : contacts.size();
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    public Contact getContactAt(int position) {
        return contacts.get(position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final ContactListItemBinding binding;

        public MyViewHolder(@NonNull ContactListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
