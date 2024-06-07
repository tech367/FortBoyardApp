package com.example.fortboyard;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fortboyard.databinding.ActivityProfileBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding binding;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("user");

    ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityProfileBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getData();
        binding.textViewNameSet.setText(users.get(0).name);
        binding.textViewEmailSet.setText(users.get(0).email);
        binding.textViewNumberSet.setText(users.get(0).phone);




        binding.imageViewSetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNameAlert();
            }
        });

        binding.imageViewSetEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEmailAlert();
            }
        });

        binding.imageViewSetPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumberAlert();
            }
        });


    }

    public void showNameAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_alert,null);
        builder.setView(dialogView);
        TextView info = (TextView)dialogView.findViewById(R.id.textViewChangedData);
        Button closeBtn = (Button)dialogView.findViewById(R.id.buttonChangeData);
        EditText editText = (EditText)dialogView.findViewById(R.id.editTextChangeData);
        info.setText("Введите новое имя пользователя:");
        final AlertDialog dialog = builder.create();
        closeBtn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void showEmailAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_alert,null);
        builder.setView(dialogView);
        TextView info = (TextView)dialogView.findViewById(R.id.textViewChangedData);
        Button closeBtn = (Button)dialogView.findViewById(R.id.buttonChangeData);
        EditText editText = (EditText)dialogView.findViewById(R.id.editTextChangeData);
        info.setText("Введите новый адрес почтового ящика:");
        final AlertDialog dialog = builder.create();
        closeBtn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void showNumberAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_alert,null);
        builder.setView(dialogView);
        TextView info = (TextView)dialogView.findViewById(R.id.textViewChangedData);
        Button closeBtn = (Button)dialogView.findViewById(R.id.buttonChangeData);
        EditText editText = (EditText)dialogView.findViewById(R.id.editTextChangeData);
        info.setText("Введите новый номер телефона:");
        final AlertDialog dialog = builder.create();
        closeBtn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void getData(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                User user = dataSnapshot.getValue(User.class);
                users.add(user);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}