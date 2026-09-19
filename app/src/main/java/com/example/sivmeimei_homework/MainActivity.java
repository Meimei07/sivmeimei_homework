package com.example.sivmeimei_homework;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sivmeimei_homework.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Handle login btn click event
        binding.btnLogin.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "You submit something.", Toast.LENGTH_SHORT).show();
        });

        // Handle forgot password btn click event
        binding.btnForgotPassword.setOnClickListener(view ->
            Toast.makeText(MainActivity.this, "You forgot password!", Toast.LENGTH_SHORT).show()
        );
    }
}