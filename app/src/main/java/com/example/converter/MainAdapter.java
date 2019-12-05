package com.example.converter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private final List<Convertation> convertations = new ArrayList<>();
    private final ClickListener listener;

    MainAdapter(ClickListener click) {
        listener = click;
    }

    void update(List<Convertation> c) {
        convertations.clear();
        convertations.addAll(c);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.main_adapter_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(convertations.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return convertations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view_item);
        }

        public void bind(Convertation convertation, ClickListener listener) {
            textView.setText(convertation.label);
            itemView.setOnClickListener(v -> listener.onItemClick(convertation));
        }
    }
}
