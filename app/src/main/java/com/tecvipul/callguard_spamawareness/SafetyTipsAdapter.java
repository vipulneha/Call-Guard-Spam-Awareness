package com.tecvipul.callguard_spamawareness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SafetyTipsAdapter extends RecyclerView.Adapter<SafetyTipsAdapter.ViewHolder> {

    private List<String> tips;

    public SafetyTipsAdapter(List<String> tips) {
        this.tips = tips;
    }

    // 🔥 Add this to fix updateList() issue
    public void updateList(List<String> newTips) {
        this.tips = newTips;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SafetyTipsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_safety_tip, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SafetyTipsAdapter.ViewHolder holder, int position) {
        holder.tipText.setText(tips.get(position));
    }

    @Override
    public int getItemCount() {
        return tips.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tipText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tipText = itemView.findViewById(R.id.tipText);
        }
    }
}
