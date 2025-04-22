package com.tecvipul.callguard_spamawareness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SpamTypeAdapter extends RecyclerView.Adapter<SpamTypeAdapter.SpamTypeViewHolder> {

    private List<SpamType> spamTypes;

    public SpamTypeAdapter(List<SpamType> spamTypes) {
        this.spamTypes = spamTypes;
    }

    @NonNull
    @Override
    public SpamTypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_spam_type, parent, false);
        return new SpamTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpamTypeViewHolder holder, int position) {
        SpamType spamType = spamTypes.get(position);
        holder.title.setText(spamType.getTitle());
        holder.description.setText(spamType.getDescription());
    }

    @Override
    public int getItemCount() {
        return spamTypes.size();
    }

    static class SpamTypeViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;

        public SpamTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.spamTypeTitle);
            description = itemView.findViewById(R.id.spamTypeDescription);
        }
    }
}