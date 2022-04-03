package com.example.hotelapp.ui.main;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelapp.R;
import com.example.hotelapp.pojo.Guest;
import com.example.hotelapp.pojo.ReservationListModel;

import java.util.ArrayList;
import java.util.List;

public class GuestListAdapter extends RecyclerView.Adapter<GuestListAdapter.GuestViewHolder> {
    private static final String TAG = "GuestListAdapter";
    private List<Guest> guestsList = new ArrayList<>();

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GuestViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.guest_data,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder holder, int position) {
        List<ReservationListModel>b = guestsList.get(position).getReservedList();
        if(b.get(0)!=null){
            Log.e(TAG, "onBindViewHolder: "+b.get(0).getPeriod());

        }
        Log.e(TAG, "onBindViewHolder: "+b);
        holder.idTv.setText(guestsList.get(position).getName());
        holder.roomIdTv.setText(guestsList.get(position).getReservedList().get(0).getRoom_id()+"");
        holder.periodTv.setText(guestsList.get(position).getReservedList().get(0).getPeriod()+"");
    }

    @Override
    public int getItemCount() {
        return guestsList.size();
    }
    public void setList(List<Guest> guestsList){

        this.guestsList=guestsList;

    }

    public class GuestViewHolder extends RecyclerView.ViewHolder{
        TextView idTv,roomIdTv,periodTv;
        public GuestViewHolder(@NonNull View itemView) {
            super(itemView);
            idTv=itemView.findViewById(R.id.passid);
            roomIdTv=itemView.findViewById(R.id.name);
            periodTv=itemView.findViewById(R.id.mobile);
        }
    }
}
