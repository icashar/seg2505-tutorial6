package com.example.recyclerviewtutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private final String[] localDataSet;

    /**
     * Holds the views for one row.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    /**
     * The adapter receives the data it will display.
     */
    public CustomAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }

    // Called when RecyclerView needs a NEW row. Inflates the layout, no data yet.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);
        return new ViewHolder(view);
    }

    // Called to put the data for one position into a row (new or recycled).
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.getTextView().setText(localDataSet[position]);
    }

    // Tells RecyclerView how many items there are.
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}