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

public class RedFlagsActivity extends AppCompatActivity {

    private RedFlagsAdapter adapter;
    private List<String> fullList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_flags);

        EditText searchEditText = findViewById(R.id.searchEditText);
        RecyclerView recyclerView = findViewById(R.id.redFlagsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Full list of red flags
        fullList = new ArrayList<>();
        fullList.add("Asking for personal/bank information");
        fullList.add("Requesting you to call back premium rate numbers");
        fullList.add("Urgent threats or 'limited time offers'");
        fullList.add("Calls at odd hours (late night/early morning)");
        fullList.add("Unknown international numbers");
        fullList.add("Caller claims to be from government but demands immediate payment");
        fullList.add("Offers that sound too good to be true");
        fullList.add("Requests for payment via gift cards or cryptocurrency");
        fullList.add("Caller pressures you to make quick decisions");
        fullList.add("Caller is vague about the organization they represent");

        // Set the adapter
        adapter = new RedFlagsAdapter(new ArrayList<>(fullList));
        recyclerView.setAdapter(adapter);

        // Search functionality
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                filterRedFlags(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });
    }

    // Filter the list based on search query
    private void filterRedFlags(String query) {
        List<String> filteredList = new ArrayList<>();
        for (String flag : fullList) {
            if (flag.toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(flag);
            }
        }
        adapter.updateList(filteredList);  // Update the RecyclerView with the filtered list
    }
}
