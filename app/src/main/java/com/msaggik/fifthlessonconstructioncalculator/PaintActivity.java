package com.msaggik.fifthlessonconstructioncalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.msaggik.fifthlessonconstructioncalculator.materials.Paint;

public class PaintActivity extends AppCompatActivity {

    private EditText squarePaint, consumptionPaint, costPaint;
    private Button calculationPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        squarePaint = findViewById(R.id.squarePaint);
        consumptionPaint = findViewById(R.id.consumptionPaint);
        costPaint = findViewById(R.id.costPaint);
        calculationPaint = findViewById(R.id.calculationPaint);

        calculationPaint.setOnClickListener(view -> {

            if (squarePaint.getText().toString().isEmpty() &&
                consumptionPaint.getText().toString().isEmpty() &&
                costPaint.getText().toString().isEmpty()){
                Toast.makeText(PaintActivity.this, "Заполнитет все поля", Toast.LENGTH_LONG).show();
            }
            else{
                double square = Double.parseDouble(squarePaint.getText().toString());
                double consumption = Double.parseDouble(consumptionPaint.getText().toString());
                double cost = Double.parseDouble(costPaint.getText().toString());

                Paint paint = new Paint(cost, consumption);
                int count = countPaint(square, paint.getConsumption());

                String result = "Необходимо " + count + " литро.\nОбщая стоимость " + (count * paint.getCost()) + " монет.";

                Intent intent = new Intent(getApplicationContext(), CalculationActivity.class);
                intent.putExtra("result", result);
                intent.putExtra("classActivity", "Paint");

                startActivity(intent);
            }
        });
    }

    private int countPaint(double square, double consumption){
        return (int) Math.ceil(square * consumption);
    }
}