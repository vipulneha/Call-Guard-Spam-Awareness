package com.tecvipul.callguard_spamawareness;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Toolbar

        // Set click listeners
        findViewById(R.id.btnSpamTypes).setOnClickListener(v ->
                startActivity(new Intent(this, SpamTypesActivity.class)));

        findViewById(R.id.btnSafetyTips).setOnClickListener(v ->
                startActivity(new Intent(this, SafetyTipsActivity.class)));

        findViewById(R.id.btnRedFlags).setOnClickListener(v ->
                startActivity(new Intent(this, RedFlagsActivity.class)));

        findViewById(R.id.btnAbout).setOnClickListener(v ->
                startActivity(new Intent(this, AboutActivity.class)));


        // FAB click listener
        FloatingActionButton fab = findViewById(R.id.fabEmergency);
        fab.setOnClickListener(view -> {
            // Handle emergency action
            startActivity(new Intent(this, EmergencyHelpActivity.class));
        });
    }
}