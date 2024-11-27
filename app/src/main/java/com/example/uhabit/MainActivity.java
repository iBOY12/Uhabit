package com.example.uhabit;

import java.util.List;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private List<Habit> habitList;
    private HabitAdapter habitAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText usernameEditText = findViewById(R.id.usernameEditText);
        String name = usernameEditText.getText().toString();
        Button startButton = findViewById(R.id.StartButton);

        startButton.setText("Enter your name to start");
        startButton.setEnabled(false);

        usernameEditText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String name = usernameEditText.getText().toString();

                boolean isEnabled = nameCountMoreThan(3,name); // Check if input is empty
                startButton.setEnabled(isEnabled); // Enable/disable the button

                // Update button text based on enabled state
                if (isEnabled) {
                    startButton.setText("Start New Habit");
                    startButton.setAlpha(1f);
                } else {
                    startButton.setText("Enter your name to start "); // Disabled message
                    startButton.setAlpha(0.5f);
                }
            }


            public boolean nameCountMoreThan(int count,String name){
                if (name.length() >= count){
                    return true;
                }else{
                    return false;
                }
            }

        });
    }
    public void SecondPage(View m) {
        Intent i = new Intent(this, SecondActivity2.class);
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        String name = usernameEditText.getText().toString();
        Log.d(name,"dd");
        i.putExtra("hello",name);
        startActivity(i);

        }

    }


