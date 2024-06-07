package com.example.fortboyard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fortboyard.databinding.ActivityGetNumberBinding;

public class GetNumberActivity extends AppCompatActivity {

    ActivityGetNumberBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityGetNumberBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.buttonNextGetNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!binding.editTextPhone.getText().toString().equals("") && ((binding.editTextPhone.getText().toString().length()) == 11 )){
                    startActivity(new Intent(GetNumberActivity.this, GetNameActivity.class));
                } else {
                    Toast.makeText(GetNumberActivity.this, "Проверьте верность введённых данных!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}