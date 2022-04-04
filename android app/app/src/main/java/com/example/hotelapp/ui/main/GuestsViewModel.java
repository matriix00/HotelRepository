package com.example.hotelapp.ui.main;


import android.util.Log;
import android.widget.Toast;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.hotelapp.data.HotelClient;
import com.example.hotelapp.pojo.Guest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GuestsViewModel extends ViewModel {
    private static final String TAG = "GuestsViewModel";
    public MutableLiveData<List<Guest>>listMutableLiveData = new MutableLiveData<>();
    public void getGuests(){
        Single<List<Guest>> observable = HotelClient.getInstance().getGuestData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o->listMutableLiveData.setValue(o),l-> Log.e(TAG, "getGuests: evv : "+l.getMessage() ));
    }
    public void register(Guest guest){
        Call<Guest> call =HotelClient.getInstance().storeData(guest);
        call.enqueue(new Callback<Guest>() {
            @Override
            public void onResponse(Call<Guest> call, Response<Guest> response) {
               /* try {
                    JSONObject jsonObject = new JSONObject(response.errorBody().string());
                    String result = jsonObject.getString("passid");
                    Log.e(TAG, "onResponse: evv : "+result );
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/

            }

            @Override
            public void onFailure(Call<Guest> call, Throwable t) {
                Log.e(TAG, "onFailure: evv: "+t.getMessage() );
            }
        });
    }
}
