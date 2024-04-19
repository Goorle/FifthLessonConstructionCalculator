package com.msaggik.fifthlessonconstructioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // поля
    private Button buttonWallpaper, buttonDrywall, buttonElectricalWiring, buttonPaint, buttonHeatingRadiators; // кнопки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // привязка полей к разметке
        buttonWallpaper = findViewById(R.id.buttonWallpaper);
        buttonDrywall = findViewById(R.id.buttonDrywall);
        buttonElectricalWiring = findViewById(R.id.buttonElectricalWiring);
        buttonPaint = findViewById(R.id.buttonPaint);
        buttonHeatingRadiators = findViewById(R.id.buttonHeatingRadiators);

        // обработка нажатия кнопок
        buttonWallpaper.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WallpaperActivity.class);
            startActivity(intent);
        });
        buttonDrywall.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DrywallActivity.class);
            startActivity(intent);
        });
        buttonElectricalWiring.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ElectricalWiringActivity.class);
            startActivity(intent);
        });
        buttonPaint.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), PaintActivity.class);
            startActivity(intent);
        });
        buttonHeatingRadiators.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), HeatingRadiatorsActivity.class);
            startActivity(intent);
        });
    }
}