package com.example.hotelapp.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hotelapp.data.HotelClient;
import com.example.hotelapp.pojo.Guest;
import com.example.hotelapp.pojo.Room;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomViewModel extends ViewModel {
    private static final String TAG = "RoomViewModel";
    public MutableLiveData<List<Room>> listMutableLiveData = new MutableLiveData<>();

    public void reserveRoom(Room room){
        Call<Room> call = HotelClient.getInstance().bookRoom(room);
        call.enqueue(new Callback<Room>() {
            @Override
            public void onResponse(Call<Room> call, Response<Room> response) {

            }

            @Override
            public void onFailure(Call<Room> call, Throwable t) {

            }
        });

    }
}
