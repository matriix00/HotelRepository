package com.example.hotelapp.ui.main;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.hotelapp.R;
import com.example.hotelapp.pojo.Guest;
import com.example.hotelapp.ui.RoomReservation;
import com.example.hotelapp.ui.main.GuestListAdapter;
import com.example.hotelapp.ui.main.GuestsViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;

public class RegistrationForm extends AppCompatActivity {
    private static final String TAG = "RegistrationForm";
    GuestsViewModel guestsViewModel;
    RecyclerView recyclerView;
    TextInputEditText name,passid,mobile,email;
    Button registerBtn;
    Spinner spinner;
    Guest g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        spinner = findViewById(R.id.spinner);
        name=findViewById(R.id.name);
        passid=findViewById(R.id.passid);
        mobile=findViewById(R.id.mobile);
        email=findViewById(R.id.email);
        registerBtn=findViewById(R.id.new_reservation);
        addSpinnerData();
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerGuest();
                Intent i = new Intent(RegistrationForm.this, RoomReservation.class);
                Log.e(TAG, "onClick:gid "+g.getId() );
                i.putExtra("guest_id",g.getId());
                startActivity(i);

            }
        });

        guestsViewModel = ViewModelProviders.of(this).get(GuestsViewModel.class);
        /*guestsViewModel = ViewModelProviders.of(this).get(GuestsViewModel.class);
        guestsViewModel.getGuests();
        recyclerView = findViewById(R.id.rv);
        final GuestListAdapter adapter = new GuestListAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
        guestsViewModel.listMutableLiveData.observe(this, new Observer<List<Guest>>() {
            @Override
            public void onChanged(List<Guest> guests) {
                adapter.setList(guests);
                adapter.notifyDataSetChanged();
            }
        });
*/
    }
    private void registerGuest(){
        if(!isNameValid() || !isMobileValid() || !isEmailValid() || !isPassportValid() ){
            Toast.makeText(this, "Erorrr", Toast.LENGTH_SHORT).show();
        }else {
            int passidVal=Integer.parseInt(passid.getText().toString());
            String nameVal=name.getText().toString();
            String emailVal=email.getText().toString();
            int mobileVal=Integer.parseInt(mobile.getText().toString());
            String spinnerVal=spinner.getSelectedItem().toString();
            Log.e(TAG, "registerGuest: evv :"+ passidVal+" "+nameVal+" "+emailVal+" "+mobileVal+" "+spinnerVal+" ");
            g = new Guest(passidVal,nameVal,emailVal,mobileVal,spinnerVal);
            g.setId(passidVal);
            guestsViewModel.register(g);
        }
    }

    private boolean isNameValid(){
        String val = name.getEditableText().toString();
        if(val.isEmpty()){
            name.setError("Field can not be empty");
            return false;
        }else {
            name.setError(null);
            name.setEnabled(false);
            return true;
        }

    }
    private boolean isEmailValid(){
        String val = email.getEditableText().toString();
        String email_pattern = "^[a-zA-Z0-9!#\\$%\\&'\\*\\+\\-/\\=\\?\\^_`\\{\\|\\}~]+(\\.[a-zA-Z0-9!#\\$%\\&'\\*\\+\\-/\\=\\?\\^_`\\{\\|\\}~]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
        if(val.isEmpty()){
            email.setError("Field can not be empty");
            return false;
        }else if (!val.matches(email_pattern)) {
            email.setError("Invalid email address");
            return false;
        }else{
            email.setError(null);
            email.setEnabled(false);
            return true;
        }
    }
    private boolean isMobileValid(){
        String val = mobile.getEditableText().toString();
        if(val.isEmpty()){
            mobile.setError("Field can not be empty");
            return false;
        }else {
            mobile.setError(null);
            return true;
        }
    }
    private boolean isPassportValid(){
        String val = passid.getEditableText().toString();
        if(val.isEmpty()){
            passid.setError("Field can not be empty");
            return false;
        }else if(val.length()!=5){
            passid.setError("Field can not be less than 14 number");
            return false;
        }else {
            passid.setError(null);
            passid.setEnabled(false);
            return true;
        }

    }



    private void addSpinnerData() {
        SortedSet<String> countries = new TreeSet<>();
        for (Locale locale : Locale.getAvailableLocales()) {
            if (!TextUtils.isEmpty(locale.getDisplayCountry())) {
                countries.add(locale.getDisplayCountry());
            }
        }

        Spinner citizenship = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, countries.toArray(new String[0]));
        citizenship.setAdapter(spinadapter);
    }
}