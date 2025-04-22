package com.tecvipul.callguard_spamawareness;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SpamTypesActivity extends AppCompatActivity {

    private List<SpamType> spamTypes = new ArrayList<>();
    private List<SpamType> filteredList = new ArrayList<>();
    private SpamTypeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spam_types);


        EditText searchBox = findViewById(R.id.searchEditText);
        RecyclerView recyclerView = findViewById(R.id.spamTypesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        // Sample Data
        spamTypes.add(new SpamType("Robocalls", "Automated calls with pre-recorded messages"));
        spamTypes.add(new SpamType("Phishing Calls", "Attempts to steal personal or financial information"));
        spamTypes.add(new SpamType("Wangiri Scam", "One-ring calls to trick you into calling back premium numbers"));
        spamTypes.add(new SpamType("Spoofed Calls", "Fake caller ID to appear as a trusted number"));
        spamTypes.add(new SpamType("Extortion Calls", "Threats demanding money or personal favors"));
        spamTypes.add(new SpamType("Telemarketing", "Unsolicited sales calls for products or services"));
        spamTypes.add(new SpamType("Fake Charity Calls", "Requests for donations to fake charities"));
        spamTypes.add(new SpamType("Loan Scam Calls", "False promises of instant loans to gather data or upfront fees"));
        spamTypes.add(new SpamType("IRS/Tax Scam", "Claiming tax dues and threatening legal action"));
        spamTypes.add(new SpamType("Tech Support Scam", "Fake support calls to gain remote access to your device"));
        spamTypes.add(new SpamType("Job Offer Scam", "Fraudulent employment offers requiring registration fees"));
        spamTypes.add(new SpamType("Lucky Draw/Prize Scam", "Telling you you've won a prize to extract personal info"));
        spamTypes.add(new SpamType("Bank Impersonation", "Pretending to be your bank to collect account details"));
        spamTypes.add(new SpamType("Insurance Scam", "Fake policies or renewals to collect money or data"));
        spamTypes.add(new SpamType("KYC Update Scam", "Requesting sensitive info under the pretext of updating KYC"));
        spamTypes.add(new SpamType("Missed Call Scam", "Leaving missed calls to lure you into calling back"));
        spamTypes.add(new SpamType("Credit Card Scam", "Fake calls for credit card upgrades or issues"));
        spamTypes.add(new SpamType("SIM Swap Fraud", "Tricking telecom into transferring your number to a scammer"));
        spamTypes.add(new SpamType("Dating Scam", "Posing as potential partners to build trust and steal money"));
        spamTypes.add(new SpamType("Courier Scam", "Claiming parcels are stuck in customs to get fees or info"));
        spamTypes.add(new SpamType("Pay Later Scam", "Pretending to be pay-later service to steal login details"));
        spamTypes.add(new SpamType("Electricity Disconnection Scam", "Threatening power cut unless payment is made"));
        spamTypes.add(new SpamType("Social Media Impersonation", "Using familiar names to request money or info"));
        spamTypes.add(new SpamType("Crypto Investment Scam", "Offering fake crypto schemes with guaranteed returns"));
        spamTypes.add(new SpamType("Real Estate Scam", "Fake rental or property offers asking for advance payments"));
        spamTypes.add(new SpamType("NGO Fraud", "Claiming to represent NGOs for donations or aid"));
        spamTypes.add(new SpamType("Government Grant Scam", "Saying you're eligible for a government grant if you pay"));
        spamTypes.add(new SpamType("Courier Gift Scam", "Fake parcels from abroad with customs duty demand"));
        spamTypes.add(new SpamType("Fake Police Calls", "Threatening arrest if fines aren’t paid"));
        spamTypes.add(new SpamType("Lottery Scam", "Claiming lottery winnings to get bank details or fees"));
        spamTypes.add(new SpamType("Medical Emergency Scam", "Pretending a loved one is in hospital to get money fast"));
        spamTypes.add(new SpamType("Fake Visa or Immigration", "Offering visa processing services for a fee"));
        spamTypes.add(new SpamType("Mutual Fund Scam", "Pretending to be agents to get investment and KYC data"));
        spamTypes.add(new SpamType("Courier Delay Scam", "Claiming package delays to extract delivery fees"));
        spamTypes.add(new SpamType("Fake Business Offers", "Proposing fake partnerships or distributorships"));
        spamTypes.add(new SpamType("Online Class Scam", "Offering fake courses or certifications"));
        spamTypes.add(new SpamType("Pension Scam", "Pretending to be govt agents updating pension records"));
        spamTypes.add(new SpamType("Debt Collection Scam", "Harassing for fake debts with threats"));
        spamTypes.add(new SpamType("Fake Feedback Calls", "Survey or feedback requests leading to scams"));
        spamTypes.add(new SpamType("Electric Bill Refund", "Offering bill refunds in exchange for bank info"));
        spamTypes.add(new SpamType("Mobile Number Porting Scam", "Tricking you into porting your number to another provider"));
        spamTypes.add(new SpamType("Fake Police Verification", "Requesting personal documents pretending to be police"));
        spamTypes.add(new SpamType("Aadhaar Verification Scam", "Claiming Aadhaar deactivation to get sensitive info"));
        spamTypes.add(new SpamType("Fake Call from CEO", "Pretending to be senior company official asking for urgent action"));
        spamTypes.add(new SpamType("False Arrest Scam", "Claiming your ID is linked to a crime and demanding bribe"));
        spamTypes.add(new SpamType("Fake Stock Tips", "Offering guaranteed stock returns to get investment"));
        spamTypes.add(new SpamType("Fake Health Insurance", "Selling bogus policies over phone"));
        spamTypes.add(new SpamType("Work from Home Scam", "Promising high-paying jobs requiring initial payment"));
        spamTypes.add(new SpamType("Fake Bill Payment Reminder", "Asking for immediate payment to avoid disconnection"));
        spamTypes.add(new SpamType("Voice Assistant Activation Scam", "Tricking users to enable malicious phone services"));
        // Add more here if needed...

        filteredList.addAll(spamTypes); // Initially show all
        adapter = new SpamTypeAdapter(filteredList);
        recyclerView.setAdapter(adapter);

        // Search Functionality
        searchBox.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterSpamTypes(s.toString());
            }
            @Override public void afterTextChanged(Editable s) {}
        });
    }

    private void filterSpamTypes(String query) {
        filteredList.clear();
        for (SpamType spamType : spamTypes) {
            if (spamType.getType().toLowerCase().contains(query.toLowerCase())
                    || spamType.getCause().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(spamType);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
