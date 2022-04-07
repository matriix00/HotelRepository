package com.example.hotelapp.data;

import com.example.hotelapp.pojo.Guest;
import com.example.hotelapp.pojo.ReservationListModel;
import com.example.hotelapp.pojo.Room;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HotelClient {
    private static final String BASE_URL = "http://192.168.1.4:8000/";
    private static HotelClient INSTANCE;
    private HotelInterface hotelInterface;

    public HotelClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        hotelInterface = retrofit.create(HotelInterface.class);

    }

    public static HotelClient getInstance(){
        if (INSTANCE == null){
            INSTANCE = new HotelClient();
        }
        return INSTANCE;
    }
    public Single<List<Guest>> getGuestData(){return hotelInterface.getGuestData();}
    public Call<Guest> storeData(Guest guest){return hotelInterface.registerGuest(guest);}
    public Call<Room> bookRoom(Room room){return hotelInterface.bookRoom(room);}
    public Call<ReservationListModel> bookReserve(ReservationListModel reservationListModel){return hotelInterface.bookReservation(reservationListModel);}

}
