package com.example.hotelapp.pojo;

public class Room {
    private int id;
    private int room_id;
    private String type;
    private int cost;
    private boolean reserved;

    public Room( String type,int room_id, int cost, boolean reserved) {
        this.room_id = room_id;
        this.type = type;
        this.cost = cost;
        this.reserved = reserved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
