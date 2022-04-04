package com.example.hotelapp.pojo;

public class ReservationListModel {
    private int id;
    private int period;
    private int guest_id;
    private int room_id;

    public ReservationListModel(int period, int guest_id, int room_id) {
        this.period = period;
        this.guest_id = guest_id;
        this.room_id = room_id;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
}
