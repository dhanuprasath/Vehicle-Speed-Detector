package com.example.vehicle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class vehicletype extends AppCompatActivity {

    private EditText editTextName, editTextVehicleModel, editTextVehicleNumber;
    private Spinner spinnerVehicleType;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicletype);

        // Initialize Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("vehicles");

        // Initialize UI elements
        editTextName = findViewById(R.id.editTextName);
        spinnerVehicleType = findViewById(R.id.spinnerVehicleType);
        editTextVehicleModel = findViewById(R.id.editTextVehicleModel);
        editTextVehicleNumber = findViewById(R.id.editTextVehicleNumber);
        Button buttonNext = findViewById(R.id.buttonNext);

        // Populate the spinner with vehicle types
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.vehicle_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVehicleType.setAdapter(adapter);

        // Set click listener for the "Next" button
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveVehicleInfo();
            }
        });
    }

    private void saveVehicleInfo() {
        String name = editTextName.getText().toString().trim();
        String vehicleType = spinnerVehicleType.getSelectedItem().toString();
        String vehicleModel = editTextVehicleModel.getText().toString().trim();
        String vehicleNumber = editTextVehicleNumber.getText().toString().trim();

        if (!name.isEmpty() && !vehicleModel.isEmpty() && !vehicleNumber.isEmpty()) {
            // Create a Vehicle object
            Vehicle vehicle = new Vehicle();
            vehicle.setName(name);
            vehicle.setVehicleType(vehicleType);
            vehicle.setVehicleModel(vehicleModel);
            vehicle.setVehicleNumber(vehicleNumber);

            // Push the vehicle object to Firebase
            String key = databaseReference.push().getKey(); // Generate a unique key
            databaseReference.child(key).setValue(vehicle);

            // Clear EditText fields for the next entry
            editTextName.setText("");
            spinnerVehicleType.setSelection(0);
            editTextVehicleModel.setText("");
            editTextVehicleNumber.setText("");
            Toast.makeText(this, "Data added successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,startstop.class);
            startActivity(intent);


        } else {
            // Handle empty fields or display an error message
            // You can add validation and error handling here.
            Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
        }
    }







}
