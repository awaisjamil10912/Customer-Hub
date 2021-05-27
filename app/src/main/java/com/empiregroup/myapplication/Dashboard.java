package com.empiregroup.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.empiregroup.myapplication.adapters.DashAdapter;
import com.empiregroup.myapplication.entities.DashModel;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    RecyclerView dashRecyclerView;
    ImageButton imageButton;
    DrawerLayout drawer;
    NavigationView navigation;
    List<DashModel> dashModelList;
    DatabaseReference databaseDash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        init();


        dashRecyclerView.setHasFixedSize(true);
        dashRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        databaseDash.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    DashModel dashModel = dataSnapshot.getValue(DashModel.class);


                    dashModelList.add(dashModel);
                }
                dashRecyclerView.setAdapter(new DashAdapter(dashModelList));
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        //dashRecyclerView.setAdapter(new DashAdapter());


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

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        break;


                }
                return true;
            }
        });

    }

    public void init() {
        dashRecyclerView = findViewById(R.id.dashRecyclerView);
        imageButton = findViewById(R.id.imageButton);
        drawer = findViewById(R.id.drawer);
        navigation = findViewById(R.id.navigation);

        dashModelList = new ArrayList<>();

        databaseDash = FirebaseDatabase.getInstance().getReference("Dash");

    }

}