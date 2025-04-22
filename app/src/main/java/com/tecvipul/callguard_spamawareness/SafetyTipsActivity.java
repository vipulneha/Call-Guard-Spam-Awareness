package com.tecvipul.callguard_spamawareness;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SafetyTipsActivity extends AppCompatActivity {

    private SafetyTipsAdapter adapter;
    private List<String> fullList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_tips);

        EditText searchEditText = findViewById(R.id.searchEditText);
        RecyclerView recyclerView = findViewById(R.id.safetyTipsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Full list of tips
        fullList = new ArrayList<>();
        fullList.add("Never share personal or financial information over the phone");
        fullList.add("Register your number on the national Do Not Call registry");
        fullList.add("Use call blocking apps to filter potential spam calls");
        fullList.add("Be wary of calls from unknown international numbers");
        fullList.add("Don't respond to prompts like 'Press 1 to speak to an agent'");
        fullList.add("Verify caller identity by calling back on official numbers");
        fullList.add("Don't trust caller ID - numbers can be spoofed");
        fullList.add("Hang up immediately if you suspect a scam");
        fullList.add("Report scam calls to your phone carrier and authorities");
        fullList.add("Educate family members, especially elderly, about phone scams");

        adapter = new SafetyTipsAdapter(new ArrayList<>(fullList));
        recyclerView.setAdapter(adapter);

        // Search functionality
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterTips(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void filterTips(String query) {
        List<String> filteredList = new ArrayList<>();
        for (String tip : fullList) {
            if (tip.toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(tip);
            }
        }
        adapter.updateList(filteredList);
    }
}
