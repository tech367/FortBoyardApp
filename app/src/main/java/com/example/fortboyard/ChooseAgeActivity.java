package com.example.fortboyard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fortboyard.databinding.ActivityChooseBinding;


public class ChooseAgeActivity extends AppCompatActivity {

    ActivityChooseBinding binding;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChooseBinding.inflate(getLayoutInflater());

        EdgeToEdge.enable(this);

        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseAgeActivity.this, ChooseWhyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.babyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.babyCard.setStrokeColor(getResources().getColor(R.color.purple));
                counter = 1;
                binding.oldBabyCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.teenCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.oldTeenCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.grownUpCard.setStrokeColor(getResources().getColor(R.color.grey));
            }
        });

        binding.oldBabyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.oldBabyCard.setStrokeColor(getResources().getColor(R.color.purple));
                counter = 2;
                binding.babyCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.teenCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.oldTeenCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.grownUpCard.setStrokeColor(getResources().getColor(R.color.grey));
            }
        });

        binding.teenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.teenCard.setStrokeColor(getResources().getColor(R.color.purple));
                counter = 3;
                binding.babyCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.oldBabyCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.oldTeenCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.grownUpCard.setStrokeColor(getResources().getColor(R.color.grey));
            }
        });

        binding.oldTeenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.oldTeenCard.setStrokeColor(getResources().getColor(R.color.purple));
                counter = 4;
                binding.babyCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.oldBabyCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.teenCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.grownUpCard.setStrokeColor(getResources().getColor(R.color.grey));
            }
        });

        binding.grownUpCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.grownUpCard.setStrokeColor(getResources().getColor(R.color.purple));
                counter = 5;
                binding.babyCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.teenCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.oldBabyCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.oldTeenCard.setStrokeColor(getResources().getColor(R.color.grey));
            }
        });















        //buttonNextFm = findViewById(R.id.buttonNextFm);





    }
}