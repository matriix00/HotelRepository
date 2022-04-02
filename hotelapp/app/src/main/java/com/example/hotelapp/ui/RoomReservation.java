package com.example.hotelapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import com.example.hotelapp.R;
import com.example.hotelapp.pojo.Guest;
import com.example.hotelapp.pojo.Room;
import com.example.hotelapp.ui.main.GuestsViewModel;
import com.example.hotelapp.ui.main.RoomViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class RoomReservation extends AppCompatActivity {
    RoomViewModel roomViewModel;
    RecyclerView recyclerView;
    TextInputEditText name,passid,mobile,email;
    Button registerBtn;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_reservation);



        roomViewModel.reserveRoom(new Room());

    }
}