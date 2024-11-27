package com.example.displaycredential;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create and configure the ViewModel
        studentViewModel = configureViewModel();

        // Check if the activity is being created for the first time
        if (isFirstTimeLaunch(savedInstanceState)) {
            setupFragments();
        }
    }

    private StudentViewModel configureViewModel() {
        return new ViewModelProvider(this).get(StudentViewModel.class);
    }

    private boolean isFirstTimeLaunch(Bundle savedInstanceState) {
        return savedInstanceState == null;
    }

    private void setupFragments() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_data_entry, new DataEntryFragment())
                .replace(R.id.fragment_container_display, new DisplayFragment())
                .commit();
    }
}
