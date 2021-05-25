package com.empiregroup.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DashAdapter extends RecyclerView.Adapter<DashAdapter.MyViewHolder> {

    List<Object> objectList;

    public String[] lst_count = {
            "20",
            "08",
            "00",
            "08",
            "00"
    };

    public String[] lst_head = {
            "Booking Scheduled Today",
            "Booking Scheduled Tomorrow",
            "Booking Scheduled Tomorrow",
            "Cancelled Bookings",
            "Pending Bookings"
    };
    public String[] lst_desc = {
           "Bookings which are scheduled for today",
            "Bookings which are scheduled for tomorrow",
            "These are bookings which have been completed",
            "Bookings which have been cancelled",
            "These are bookings which have not been assigned to interpreter"
    };

    public DashAdapter(){}

    static class MyViewHolder extends RecyclerView.ViewHolder  {

        TextView txtCount, txtHead, txtDesc;

        MyViewHolder(View view) {
            super(view);

            txtCount = view.findViewById(R.id.txtCount);
            txtHead = view.findViewById(R.id.txtHead);
            txtDesc = view.findViewById(R.id.txtDesc);

        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_dash, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtCount.setText(lst_count[position]);
        holder.txtHead.setText(lst_head[position]);
        holder.txtDesc.setText(lst_desc[position]);
    }

    @Override
    public int getItemCount() {
        return lst_count.length;
    }
}
