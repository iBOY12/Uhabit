package com.example.uhabit;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity2 extends AppCompatActivity {
    private RecyclerView habitsRecyclerView;
    private HabitAdapter habitAdapter;
    private List<Habit> habitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        // Setting up references for welcome text, RecyclerView, and add button
        TextView welcomeTextView = findViewById(R.id.thewelcometext);
        habitsRecyclerView = findViewById(R.id.habitsRecyclerView);
        Button addHabitButton = findViewById(R.id.addHabitButton);

        // Setting personalized welcome message
        Intent intent = getIntent();
        String name = intent.getStringExtra("hello");
        welcomeTextView.setText("Welcome to Uhabit, " + name);

        // Setting up RecyclerView
        habitAdapter = new HabitAdapter(habitList);
        habitsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        habitsRecyclerView.setAdapter(habitAdapter);

        // Listener for "Add New Habit" button
        addHabitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddHabitDialog(); // Show the dialog to add a new habit
            }
        });
    }

    // Method to show the dialog for adding a new habit
    private void showAddHabitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_habit, null);
        builder.setView(dialogView);

        // Finding input fields and button inside the dialog layout
        EditText habitNameEditText = dialogView.findViewById(R.id.habitNameEditText);
        EditText habitExplanationEditText = dialogView.findViewById(R.id.habitExplanationEditText);
        EditText startDateEditText = dialogView.findViewById(R.id.startDateEditText);
        Button saveHabitButton = dialogView.findViewById(R.id.saveHabitButton);

        // Creating the dialog
        AlertDialog dialog = builder.create();

        // Handling "Save Habit" button click inside the dialog
        saveHabitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String habitName = habitNameEditText.getText().toString().trim();
                String habitExplanation = habitExplanationEditText.getText().toString().trim();
                String startDate = startDateEditText.getText().toString().trim();

                // Checking if all fields are filled
                if (!habitName.isEmpty() && !habitExplanation.isEmpty() && !startDate.isEmpty()) {
                    addNewHabit(habitName, habitExplanation, startDate);
                    dialog.dismiss(); // Close the dialog after saving the habit
                } else {
                    // Show an error message if any fields are empty
                    if (habitName.isEmpty()) {
                        habitNameEditText.setError("Required");
                    }
                    if (habitExplanation.isEmpty()) {
                        habitExplanationEditText.setError("Required");
                    }
                    if (startDate.isEmpty()) {
                        startDateEditText.setError("Required");
                    }
                }
            }
        });

        // Show the dialog
        dialog.show();
    }

    // Method to add the new habit to the RecyclerView and list
    private void addNewHabit(String habitName, String habitExplanation, String startDate) {
        Habit newHabit = new Habit(habitName, habitExplanation, startDate);  // Create a new habit object
        habitList.add(newHabit);  // Add it to the list
        habitAdapter.notifyItemInserted(habitList.size() - 1);  // Notify adapter that a new item was added
    }
}
