package com.empiregroup.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.empiregroup.myapplication.entities.LanguageModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DemandAdapter extends RecyclerView.Adapter<DemandAdapter.MyViewHolder> {

    List<LanguageModel> languageModelList;

    public DemandAdapter(List<LanguageModel> languageModels) {
         this.languageModelList = languageModels;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        CheckedTextView checkedTextView;

        MyViewHolder(View view) {
            super(view);

            checkedTextView = view.findViewById(R.id.checkedTextView);
        }
    }


    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_ondemand, viewGroup, false);



        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DemandAdapter.MyViewHolder holder, int position) {

        holder.checkedTextView.setText(languageModelList.get(position).getNativeName());
    }

    @Override
    public int getItemCount() {
        return languageModelList.size();
    }



}
