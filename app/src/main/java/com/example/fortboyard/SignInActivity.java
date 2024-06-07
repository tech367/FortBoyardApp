package com.example.fortboyard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fortboyard.databinding.ActivitySignInBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignInActivity extends AppCompatActivity {


    ActivitySignInBinding binding;
    private FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("user");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mAuth = FirebaseAuth.getInstance();






        binding.buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChecked()){
                    if (isChecked()){

                        mAuth.createUserWithEmailAndPassword(binding.emailSignIn.getText().toString(), binding.passwordRepeateSign.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(SignInActivity.this, "Регистрация завершена!", Toast.LENGTH_SHORT).show();
                                    FirebaseUser currentUser = mAuth.getCurrentUser();
                                    currentUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Toast.makeText(SignInActivity.this, "Подтвердите почту!", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                    Intent intent = new Intent(SignInActivity.this, LogInActivity.class);
                                    User user = new User("User", binding.emailSignIn.getText().toString()+"", "00000000000", binding.passwordSign.getText().toString()+"");
                                    myRef.child(user.phone).setValue(user);
                                    intent.putExtra("e-mail", binding.emailSignIn.getText().toString());
                                    intent.putExtra("password", binding.passwordSign.getText().toString());
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(SignInActivity.this, "Что-то пошло не так...", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }

                }

            }
        });




    }




    public boolean isChecked(){
        if (binding.emailSignIn.getText().toString().equals("") || binding.passwordSign.getText().equals("") || binding.passwordRepeateSign.getText().toString().equals("")){
            Toast.makeText(this, "Проверьте заполнение всех полей", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!binding.passwordSign.getText().toString().equals(binding.passwordRepeateSign.getText().toString())){
            Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }



}