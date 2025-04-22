package com.tecvipul.callguard_spamawareness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RedFlagsAdapter extends RecyclerView.Adapter<RedFlagsAdapter.RedFlagViewHolder> {

    private List<String> redFlags;

    public RedFlagsAdapter(List<String> redFlags) {
        this.redFlags = redFlags;
    }

    @NonNull
    @Override
    public RedFlagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_red_flag, parent, false);
        return new RedFlagViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RedFlagViewHolder holder, int position) {
        String flag = redFlags.get(position);
        holder.flagText.setText(flag);
    }

    @Override
    public int getItemCount() {
        return redFlags.size();
    }

    // Method to update the list of red flags and refresh the RecyclerView
    public void updateList(List<String> newRedFlags) {
        this.redFlags = newRedFlags;
        notifyDataSetChanged();  // Notify the adapter that the dataset has changed
    }

    // ViewHolder class to hold each red flag item view
    static class RedFlagViewHolder extends RecyclerView.ViewHolder {
        TextView flagText;

        public RedFlagViewHolder(@NonNull View itemView) {
            super(itemView);
            flagText = itemView.findViewById(R.id.flagText);  // Reference to the TextView
        }
    }
}
