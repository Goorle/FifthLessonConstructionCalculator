package com.msaggik.fifthlessonconstructioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.msaggik.fifthlessonconstructioncalculator.materials.Wallpaper;

public class WallpaperActivity extends AppCompatActivity {

    // поля
    private EditText square; // площадь оклеиваемой поверхности
    private EditText widthWallpaper, heightWallpaper, costWallpaper; // параметры рулона обоев
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        // привязка полей к разметке
        square = findViewById(R.id.squareWallpaper);
        widthWallpaper = findViewById(R.id.widthWallpaper);
        heightWallpaper = findViewById(R.id.heightWallpaper);
        costWallpaper = findViewById(R.id.costWallpaper);
        button = findViewById(R.id.calculationWallpaper);

        // обработка нажатия кнопки
        button.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // считывание введённых данных
            int width = Integer.parseInt(widthWallpaper.getText().toString()); // значение ширины рулона обоев (см)
            int height = Integer.parseInt(heightWallpaper.getText().toString()); // значение длины одного рулона обоев (м)
            int cost = Integer.parseInt(costWallpaper.getText().toString()); // значение стоимости одного рулона обоев (монет)

            Wallpaper wallpaper = new Wallpaper(width, height, cost); // создание объекта рулона обоев

            int countWallpaper = calculationCountWallpaper(wallpaper);
            int costWallPaper = countWallpaper * wallpaper.getCostWallpaper();
            String result = String.format("Для строительства нужно %d рулонов.\nИх общая стоимость %d монет", countWallpaper, costWallPaper);

            Intent intent = new Intent(getApplicationContext(), CalculationActivity.class); // создание объекта намерения
            intent.putExtra("result", result);
            intent.putExtra("classActivity", "Wallpaper");

            startActivity(intent); // запуск намерения
        }
    };

    private int calculationCountWallpaper(Wallpaper wallpaper){
        int squareInt = Integer.parseInt(square.getText().toString());
        int count = 0;

        count = squareInt / ((wallpaper.getHeightWallpaper() * wallpaper.getWidthWallpaper())/100);
        if (squareInt % ((wallpaper.getHeightWallpaper() * wallpaper.getWidthWallpaper())/100) > 0) { // если при делении образуется остаток, то нужен ещё один рулон
            count++;
        }
        return count;
    }
}