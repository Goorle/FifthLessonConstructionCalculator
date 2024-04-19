package com.msaggik.fifthlessonconstructioncalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.msaggik.fifthlessonconstructioncalculator.materials.ElectricalWiring;

public class ElectricalWiringActivity extends AppCompatActivity {

    private EditText squareEditText, costEditText;
    private Button buttonCalculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrical_wiring);

        squareEditText = findViewById(R.id.squarePaint);
        costEditText = findViewById(R.id.costElectricalWiring);
        buttonCalculation = findViewById(R.id.calculationElectricalWiring);

        buttonCalculation.setOnClickListener(view -> {

            if (squareEditText.getText().toString().isEmpty() &&
                costEditText.getText().toString().isEmpty()){
                Toast.makeText(ElectricalWiringActivity.this, "Заполните все поля", Toast.LENGTH_LONG).show();
            }
            else{
                double square = Double.parseDouble(squareEditText.getText().toString());
                Double cost = Double.parseDouble(costEditText.getText().toString());

                ElectricalWiring electricalWiring = new ElectricalWiring(cost);

                int count = calculateCountWiring(square);

                String result = "Необходимо " + count + " метров провода\nОбщая стоимость " + (count * electricalWiring.getCost()) + " монет.";

                Intent intent = new Intent(getApplicationContext(), CalculationActivity.class);
                intent.putExtra("result", result);
                intent.putExtra("classActivity", "ElectricalWiring");

                startActivity(intent);
            }
        });

    }

    private int calculateCountWiring(double square){
        return (int) Math.ceil(square * 2 + square * 0.15);
    }
}