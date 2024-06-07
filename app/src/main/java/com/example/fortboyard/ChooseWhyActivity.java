package com.example.fortboyard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fortboyard.databinding.ActivityChooseWhyBinding;


public class ChooseWhyActivity extends AppCompatActivity {

    ActivityChooseWhyBinding binding;

    private Button buttonNext;
    private int counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChooseWhyBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseWhyActivity.this, ChooseDateActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.birthdayCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.birthdayCard.setStrokeColor(getResources().getColor(R.color.light_green));
                counter = 1;
                binding.classPartyCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.schoolOffCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.onlyGameCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.coPartyCard.setStrokeColor(getResources().getColor(R.color.grey));

            }
        });

        binding.classPartyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.classPartyCard.setStrokeColor(getResources().getColor(R.color.light_green));
                counter = 2;
                binding.birthdayCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.schoolOffCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.onlyGameCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.coPartyCard.setStrokeColor(getResources().getColor(R.color.grey));

            }
        });

        binding.schoolOffCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.schoolOffCard.setStrokeColor(getResources().getColor(R.color.light_green));
                counter = 3;
                binding.classPartyCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.birthdayCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.onlyGameCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.coPartyCard.setStrokeColor(getResources().getColor(R.color.grey));

            }
        });

        binding.onlyGameCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.onlyGameCard.setStrokeColor(getResources().getColor(R.color.light_green));
                counter = 4;
                binding.classPartyCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.schoolOffCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.birthdayCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.coPartyCard.setStrokeColor(getResources().getColor(R.color.grey));

            }
        });

        binding.coPartyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.coPartyCard.setStrokeColor(getResources().getColor(R.color.light_green));
                counter = 5;
                binding.classPartyCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.schoolOffCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.onlyGameCard.setStrokeColor(getResources().getColor(R.color.grey));
                binding.birthdayCard.setStrokeColor(getResources().getColor(R.color.grey));

            }
        });
    }
}