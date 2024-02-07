package com.example.kalkulator_spalania;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = findViewById(R.id.submitButton);
        EditText fuelConsumptionField = findViewById(R.id.fuelConsumption);
        EditText distanceField = findViewById(R.id.distance);
        EditText fuelCostField = findViewById(R.id.fuelCost);

        submitButton.setOnClickListener(view -> {
            String message;

            if (fuelConsumptionField.getText().toString().trim().isEmpty() ||
                    distanceField.getText().toString().trim().isEmpty() ||
                    fuelCostField.getText().toString().trim().isEmpty()
            ) message = "Brak danych do obliczeń!";
            else {
                float fuelConsumption = Float.parseFloat(fuelConsumptionField.getText().toString().trim());
                float distance = Float.parseFloat(distanceField.getText().toString().trim());
                float fuelCost = Float.parseFloat(fuelCostField.getText().toString().trim());

                float fuelUsed = fuelConsumption / 100 * distance;
                message = String.format("Na przejechanie %.2f km zużyłeś %.2f l, które kosztowało %.2f zł!", distance, fuelUsed, (fuelCost * fuelUsed));
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder.setMessage(message)
                    .setTitle("Aplikacja obliczająca spalanie")
                    .setPositiveButton("OK", (dialog, id) -> {});
            AlertDialog dialog = builder.create();
            dialog.show();
        });

    }
}