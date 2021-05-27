package com.empiregroup.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.empiregroup.myapplication.adapters.DemandAdapter;
import com.empiregroup.myapplication.entities.LanguageModel;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OnDemand extends AppCompatActivity {
    Button btncont;
    RecyclerView lrecyclerView;
    ImageButton imageButton;
    List<LanguageModel> languageModelList;
    DatabaseReference databaseLanguages;

    DrawerLayout drawer;
    NavigationView navigation;

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



        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START))
                    drawer.closeDrawer(GravityCompat.START);
                else
                    drawer.openDrawer(GravityCompat.START);

            }
        });


        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(), Dashboard.class));
                        break;

                    case R.id.ondemand_bookings:
                        startActivity(new Intent(getApplicationContext(), OnDemand.class));
                        break;




                }
                return true;
            }
        });

    }


    public void init() {
        btncont = findViewById(R.id.btncont);
        lrecyclerView = findViewById(R.id.lrecyclerView);
        imageButton = findViewById(R.id.imageButton);
        drawer = findViewById(R.id.drawer);
        navigation = findViewById(R.id.navigation);
        languageModelList = new ArrayList<>();

        databaseLanguages = FirebaseDatabase.getInstance().getReference("Languages");
    }

}