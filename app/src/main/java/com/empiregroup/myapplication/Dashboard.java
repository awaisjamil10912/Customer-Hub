package com.empiregroup.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class Dashboard extends AppCompatActivity {

    RecyclerView dashRecyclerView;
    ImageButton imageButton;
    DrawerLayout drawer;
    NavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        init();


        dashRecyclerView.setHasFixedSize(true);
        dashRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dashRecyclerView.setAdapter(new DashAdapter());


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
                        startActivity(new Intent(getApplicationContext(), activity_onDemand.class));
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

    }

}