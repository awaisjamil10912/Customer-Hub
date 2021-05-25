package com.empiregroup.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.empiregroup.myapplication.entities.LanguageModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class activity_onDemand extends AppCompatActivity {
    Button btncont;
    RecyclerView lrecyclerView;
    ImageButton imageButton;
    List<LanguageModel> languageModelList;
    DatabaseReference databaseLanguages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_demand);
        init();

        lrecyclerView.setHasFixedSize(true);
        lrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //lrecyclerView.setAdapter(new DemandAdapter());

        databaseLanguages.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    LanguageModel languageModel = dataSnapshot.getValue(LanguageModel.class);
                    languageModelList.add(languageModel);
                }
                lrecyclerView.setAdapter(new DemandAdapter(languageModelList));
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }


    public void init() {
        btncont = findViewById(R.id.btncont);
        lrecyclerView = findViewById(R.id.lrecyclerView);
        imageButton = findViewById(R.id.imageButton);
        languageModelList = new ArrayList<>();

        databaseLanguages = FirebaseDatabase.getInstance().getReference();
    }

}