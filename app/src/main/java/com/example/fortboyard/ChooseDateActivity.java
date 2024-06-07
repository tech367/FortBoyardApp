package com.example.fortboyard;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.example.fortboyard.databinding.ActivityChooseDateBinding;

import java.util.Calendar;

public class ChooseDateActivity extends AppCompatActivity {

    ActivityChooseDateBinding binding;

    private DatePickerDialog datePickerDialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChooseDateBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        binding.datePickerButton.setText("Не выбрано");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initDatePicker();

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseDateActivity.this, ChooseGiftActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.cardNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.cardNine.setStrokeColor(getResources().getColor(R.color.yellow_highligt));
                binding.cardTwelve.setStrokeColor(getResources().getColor(R.color.grey));
                binding.cardFifteen.setStrokeColor(getResources().getColor(R.color.grey));
                binding.cardEighteen.setStrokeColor(getResources().getColor(R.color.grey));
            }
        });

        binding.cardTwelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.cardNine.setStrokeColor(getResources().getColor(R.color.grey));
                binding.cardTwelve.setStrokeColor(getResources().getColor(R.color.yellow_highligt));
                binding.cardFifteen.setStrokeColor(getResources().getColor(R.color.grey));
                binding.cardEighteen.setStrokeColor(getResources().getColor(R.color.grey));
            }
        });

        binding.cardFifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.cardNine.setStrokeColor(getResources().getColor(R.color.grey));
                binding.cardTwelve.setStrokeColor(getResources().getColor(R.color.grey));
                binding.cardFifteen.setStrokeColor(getResources().getColor(R.color.yellow_highligt));
                binding.cardEighteen.setStrokeColor(getResources().getColor(R.color.grey));
            }
        });

        binding.cardEighteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.cardNine.setStrokeColor(getResources().getColor(R.color.grey));
                binding.cardTwelve.setStrokeColor(getResources().getColor(R.color.grey));
                binding.cardFifteen.setStrokeColor(getResources().getColor(R.color.grey));
                binding.cardEighteen.setStrokeColor(getResources().getColor(R.color.yellow_highligt));
            }
        });










    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                binding.datePickerButton.setText(date);
            }
        };


        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_YEAR);



        int style = AlertDialog.THEME_HOLO_DARK;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);


    }







    private String makeDateString(int day, int month, int year) {
        return day + ", " + getMonthFormat(month) + " " + year;
    }

    private String getMonthFormat(int month) {
        if (month == 1)
            return "январь";
        if (month == 2)
            return "февраль";
        if (month == 3)
            return "март";
        if (month == 4)
            return "апрель";
        if (month == 5)
            return "май";
        if (month == 6)
            return "июнь";
        if (month == 7)
            return "июль";
        if (month == 8)
            return "август";
        if (month == 9)
            return "сентябрь";
        if (month == 10)
            return "октябрь";
        if (month == 11)
            return "ноябрь";
        if (month == 12)
            return "декабрь";

        return "январь";

    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }
}