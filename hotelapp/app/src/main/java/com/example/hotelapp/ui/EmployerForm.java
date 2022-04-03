package com.example.hotelapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.hotelapp.R;
import com.example.hotelapp.pojo.Guest;
import com.example.hotelapp.ui.main.GuestListAdapter;
import com.example.hotelapp.ui.main.GuestsViewModel;

import java.util.List;

public class EmployerForm extends AppCompatActivity {
    private static final String TAG = "EmployerForm";
    GuestsViewModel guestsViewModel;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employerform);

        Log.e(TAG, "onCreate: employer form created" );
        guestsViewModel = ViewModelProviders.of(this).get(GuestsViewModel.class);
        guestsViewModel.getGuests();
        recyclerView = findViewById(R.id.rv);
        final GuestListAdapter adapter = new GuestListAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
        guestsViewModel.listMutableLiveData.observe(this, new Observer<List<Guest>>() {
            @Override
            public void onChanged(List<Guest> guests) {
                Log.e(TAG, "onChanged: data set" );
                adapter.setList(guests);
                adapter.notifyDataSetChanged();
            }
        });
    }
}