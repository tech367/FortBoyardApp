package com.example.fortboyard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fortboyard.databinding.ActivityChooseGiftBinding;


public class ChooseGiftActivity extends AppCompatActivity {

    ActivityChooseGiftBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityChooseGiftBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        binding.additionalTimeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.additionalTimeCard.setStrokeColor(getResources().getColor(R.color.purple));
                binding.sweetCloudCard.setStrokeColor(getResources().getColor(R.color.grey));
            }
        });

        binding.sweetCloudCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.sweetCloudCard.setStrokeColor(getResources().getColor(R.color.light_green));
                binding.additionalTimeCard.setStrokeColor(getResources().getColor(R.color.grey));
            }
        });

        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseGiftActivity.this, BasketActivity.class));
                finish();
            }
        });




    }
}