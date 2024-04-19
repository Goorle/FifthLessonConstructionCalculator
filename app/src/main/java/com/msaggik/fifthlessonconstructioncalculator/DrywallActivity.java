package com.msaggik.fifthlessonconstructioncalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.msaggik.fifthlessonconstructioncalculator.materials.DryWall;

public class DrywallActivity extends AppCompatActivity {

    private EditText square, heightDryWall, widthDryWall, costDryWall;
    private Button calculationQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drywall);

        square = findViewById(R.id.squareWall);
        heightDryWall = findViewById(R.id.heightWall);
        widthDryWall = findViewById(R.id.widthWall);
        costDryWall = findViewById(R.id.costWall);
        calculationQuantity = findViewById(R.id.buttonCalculationDryWall);

        calculationQuantity.setOnClickListener(v -> {
            if (square.getText().toString().isEmpty() &&
                heightDryWall.getText().toString().isEmpty() &&
                widthDryWall.getText().toString().isEmpty() &&
                costDryWall.getText().toString().isEmpty()){
                Toast.makeText(DrywallActivity.this, "Заполните все поля", Toast.LENGTH_LONG).show();
            }
            else{

                double squareWall = Double.parseDouble(square.getText().toString());

                double height = Double.parseDouble(heightDryWall.getText().toString());
                double width = Double.parseDouble(widthDryWall.getText().toString());
                double cost = Double.parseDouble(costDryWall.getText().toString());

                DryWall dryWall = new DryWall(height, width, cost);

                int countDrywall = calculateCountDrywall(squareWall, dryWall);

                String result = "Необходимо " + countDrywall + " гипсокартона.\nСтоимость " + (countDrywall * dryWall.getCost() + " монет.");

                Intent intent = new Intent(getApplicationContext(), CalculationActivity.class);

                intent.putExtra("result", result);
                intent.putExtra("classActivity", "Drywall");
                startActivity(intent);
            }
        });
    }

    private int calculateCountDrywall(double squareWall, DryWall dryWall){
        double squareDrywall = dryWall.getHeightDryWall() * dryWall.getWidthDryWall();
        return (int) Math.ceil(squareWall / squareDrywall);
    }
}