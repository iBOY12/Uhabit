package com.example.uhabit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.HabitViewHolder> {

    private final List<Habit> habitList;

    public HabitAdapter(List<Habit> habitList) {
        this.habitList = habitList;
    }

    @NonNull
    @Override
    public HabitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_habit, parent, false);
        return new HabitViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitViewHolder holder, int position) {
        Habit habit = habitList.get(position);
        holder.habitNameTextView.setText(habit.getName());
        holder.habitExplanationTextView.setText(habit.getExplanation());
        holder.habitStartDateTextView.setText(habit.getStartDate());
    }

    @Override
    public int getItemCount() {
        return habitList.size();
    }

    // Inner class for the ViewHolder
    static class HabitViewHolder extends RecyclerView.ViewHolder {
        TextView habitNameTextView;
        TextView habitExplanationTextView;
        TextView habitStartDateTextView;

        public HabitViewHolder(View itemView) {
            super(itemView);
            habitNameTextView = itemView.findViewById(R.id.habitNameTextView);
            habitExplanationTextView = itemView.findViewById(R.id.habitExplanationTextView);
            habitStartDateTextView = itemView.findViewById(R.id.habitStartDateTextView);
        }
    }
}
