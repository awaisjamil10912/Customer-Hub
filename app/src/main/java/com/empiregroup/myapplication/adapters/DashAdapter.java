package com.empiregroup.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.empiregroup.myapplication.R;
import com.empiregroup.myapplication.entities.DashModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DashAdapter extends RecyclerView.Adapter<DashAdapter.MyViewHolder> {

    List<DashModel> dashModelList;

    public DashAdapter(List<DashModel> dashModels) {
        this.dashModelList = dashModels;

    }

    @NonNull
    @NotNull
    @Override
    public DashAdapter.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_dash, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DashAdapter.MyViewHolder holder, int position) {
        holder.txtHead.setText(dashModelList.get(position).getName());
        holder.txtDesc.setText(dashModelList.get(position).getDesc());
        holder.txtCount.setText(dashModelList.get(position).getCount());

    }

    @Override
    public int getItemCount() {
        return dashModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtHead, txtDesc, txtCount;

        MyViewHolder(View view) {
            super(view);

            txtHead = view.findViewById(R.id.txtHead);
            txtDesc = view.findViewById(R.id.txtDesc);
            txtCount = view.findViewById(R.id.txtCount);


        }
    }
}
