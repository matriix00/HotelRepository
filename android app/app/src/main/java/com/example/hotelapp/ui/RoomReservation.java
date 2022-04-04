package com.example.hotelapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hotelapp.R;
import com.example.hotelapp.pojo.Guest;
import com.example.hotelapp.pojo.ReservationListModel;
import com.example.hotelapp.pojo.Room;
import com.example.hotelapp.ui.main.GuestsViewModel;
import com.example.hotelapp.ui.main.RoomViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class RoomReservation extends AppCompatActivity {
    RoomViewModel roomViewModel;
    TextView costtv;
    EditText roomet,periodet;
    Button bookBtn;
    Spinner spinner;
    ArrayList<String>spinList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_reservation);
        periodet = findViewById(R.id.period);
        roomet = findViewById(R.id.room_id);
        costtv = findViewById(R.id.cost_tv);
        bookBtn = findViewById(R.id.book);
        spinner = findViewById(R.id.cost_spinner);
        spinList= new ArrayList<>();
        spinList.add("Select room type");
        spinList.add("Single");
        spinList.add("Double");
        spinList.add("Sweat");
        ArrayAdapter<String> spinadapte = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,spinList);
        spinner.setAdapter(spinadapte);

        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookNow();
                bookG();
            }
        });


    }


    private boolean  checkSpinn() {

               if (spinner.getSelectedItem()=="Select room type"){
            costtv.setText("");
            Toast.makeText(this, "Please Fill spinner", Toast.LENGTH_SHORT).show();
            return false;
        }else if(spinner.getSelectedItem()=="Single"){
            costtv.setText("80");
        }else if(spinner.getSelectedItem()=="Double"){
            costtv.setText("120");
        }else{
            costtv.setText("250");
        }
        return true;
    }

    private void bookNow() {
        String type = null;
        if (!spinner.getSelectedItem().toString().equals("Select room type")){
             type = spinner.getSelectedItem().toString();

        }
        int room_idtxt = Integer.parseInt(roomet.getText().toString());
        int cost = Integer.parseInt(costtv.getText().toString());
        boolean chk = checkSpinn();
        if (chk)roomViewModel.reserveRoom(new Room(type,room_idtxt,cost,true));
    }

    private void bookG() {
        int room_idtxt = Integer.parseInt(roomet.getText().toString());
        Bundle c = getIntent().getExtras();
        int gid =c.getInt("guest_id");
        int periodI = Integer.parseInt(periodet.getText().toString());
        roomViewModel.bookreserve(new ReservationListModel(periodI,gid,room_idtxt));
    }

}