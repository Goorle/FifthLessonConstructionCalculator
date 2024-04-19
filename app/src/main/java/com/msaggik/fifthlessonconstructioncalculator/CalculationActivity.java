package com.msaggik.fifthlessonconstructioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ObjectStreamException;

public class CalculationActivity extends AppCompatActivity {

    // поля
    private TextView output; // вывод результата
    private Button buttonBack, buttonNew; // кнопки возврата назад

    private String classActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        // привязка полей к разметке
        output = findViewById(R.id.output);
        buttonBack = findViewById(R.id.buttonBack);
        buttonNew = findViewById(R.id.buttonNew);

        // извлечение данных из намерения
        Bundle bundle = getIntent().getExtras(); // контейнер с извлечёнными данными в виде ключ-значение

        if (bundle != null) {
            String result = bundle.getString("result");
            classActivity = bundle.getString("classActivity");
            output.setText(result);
        }

        // обработка нажатия кнопок
        buttonBack.setOnClickListener(view -> {
            Intent intent = null;
            switch (classActivity){
                case "Wallpaper":
                    intent = new Intent(getApplicationContext(), WallpaperActivity.class);
                case "Drywall":
                    intent = new Intent(getApplicationContext(), DrywallActivity.class);
                case "ElectricalWiring":
                    intent = new Intent(getApplicationContext(), ElectricalWiringActivity.class);
                case "Paint":
                    intent = new Intent(getApplicationContext(), PaintActivity.class);
                case "HeatingRadiators":
                    intent = new Intent(getApplicationContext(), HeatingRadiatorsActivity.class);
            }

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
       buttonNew.setOnClickListener(view -> {
           Intent intent = new Intent(getApplicationContext(), MainActivity.class);
           intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

           startActivity(intent);
       });
    }

}