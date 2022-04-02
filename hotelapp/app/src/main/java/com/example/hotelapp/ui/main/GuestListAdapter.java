package com.example.hotelapp.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelapp.R;
import com.example.hotelapp.pojo.Guest;

import java.util.ArrayList;
import java.util.List;

public class GuestListAdapter extends RecyclerView.Adapter<GuestListAdapter.GuestViewHolder> {
    private List<Guest> guestsList = new ArrayList<>();

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GuestViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.guest_data,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder holder, int position) {
        holder.passTv.setText(guestsList.get(position).getPassid()+"");
        holder.nameTv.setText(guestsList.get(position).getName());
        holder.mobileTv.setText(guestsList.get(position).getMobile()+"");
    }

    @Override
    public int getItemCount() {
        return guestsList.size();
    }
    public void setList(List<Guest> guestsList){
        this.guestsList=guestsList;
    }

    public class GuestViewHolder extends RecyclerView.ViewHolder{
        TextView passTv,nameTv,mobileTv;
        public GuestViewHolder(@NonNull View itemView) {
            super(itemView);
            passTv=itemView.findViewById(R.id.passid);
            nameTv=itemView.findViewById(R.id.name);
            mobileTv=itemView.findViewById(R.id.mobile);
        }
    }
}
