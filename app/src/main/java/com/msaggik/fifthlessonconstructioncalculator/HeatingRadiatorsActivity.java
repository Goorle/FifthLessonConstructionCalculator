package com.msaggik.fifthlessonconstructioncalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.msaggik.fifthlessonconstructioncalculator.materials.HeatingRadiators;


public class HeatingRadiatorsActivity extends AppCompatActivity {

    private EditText squareSection, powerSection, costSection;
    private Button calculationHeatingRadiators;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heating_radiators);

        squareSection = findViewById(R.id.squareSection);
        powerSection = findViewById(R.id.powerSection);
        costSection = findViewById(R.id.costSection);
        calculationHeatingRadiators = findViewById(R.id.calculationHeatingRadiators);

        calculationHeatingRadiators.setOnClickListener(view -> {
            if (squareSection.getText().toString().isEmpty() &&
                powerSection.getText().toString().isEmpty() &&
                costSection.getText().toString().isEmpty()){
                Toast.makeText(HeatingRadiatorsActivity.this, "Заполните все поля", Toast.LENGTH_LONG).show();
            }
            else{
                double square = Double.parseDouble(squareSection.getText().toString());
                int power = Integer.parseInt(powerSection.getText().toString());
                double cost = Double.parseDouble(costSection.getText().toString());

                HeatingRadiators heatingRadiators = new HeatingRadiators(power, cost);

                int countRadiators = calculateCountRadiators(square, power);

                String result = "Необходимо " + countRadiators + " секций радиатора\nОбщая стоимость " + (countRadiators * heatingRadiators.getCostRadiators()) + " монет.";

                Intent intent = new Intent(getApplicationContext(), CalculationActivity.class);

                intent.putExtra("result", result);
                intent.putExtra("classActivity", "HeatingRadiators");

                startActivity(intent);
            }
        });
    }

    private int calculateCountRadiators(double square, int power){
        return (int) Math.ceil(square * (100.0f/power));
    }
}