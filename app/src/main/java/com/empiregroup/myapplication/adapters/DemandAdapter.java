package com.empiregroup.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.empiregroup.myapplication.R;
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
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ondemand, parent, false);



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
