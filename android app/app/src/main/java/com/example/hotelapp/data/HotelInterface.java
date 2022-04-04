package com.example.hotelapp.data;

import com.example.hotelapp.pojo.Guest;
import com.example.hotelapp.pojo.ReservationListModel;
import com.example.hotelapp.pojo.Room;

import java.util.List;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HotelInterface {
    @GET("guests/")
    Single<List<Guest>> getGuestData();

    @POST("guests/")
    Call<Guest> registerGuest(@Body Guest guest);

    @POST("rooms/")
    Call<Room> bookRoom(@Body Room room);
    @POST("reservations/")
    Call<ReservationListModel> bookReservation(@Body ReservationListModel reservationListModel);

}

