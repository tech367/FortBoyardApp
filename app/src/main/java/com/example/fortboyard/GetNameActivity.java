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

import com.example.fortboyard.databinding.ActivityGetNameBinding;

public class GetNameActivity extends AppCompatActivity {

    ActivityGetNameBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityGetNameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        binding.buttonNextGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.editTextText.getText().toString().length() <2 ){
                    Toast.makeText(GetNameActivity.this, "Проверьте верность введённых данных!", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(GetNameActivity.this, MainScreenActivity.class));
                }
            }
        });
    }
}