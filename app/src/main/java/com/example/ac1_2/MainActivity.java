package com.example.ac1_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

Button btnSaibaMais1, btnSaibaMais2, btnSaibaMais3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnSaibaMais1 = (Button)findViewById(R.id.btnMaisRestaurante1);
        btnSaibaMais2 = (Button)findViewById(R.id.btnMaisRestaurante2);
        btnSaibaMais3 = (Button)findViewById(R.id.btnMaisRestaurante3);

        btnSaibaMais1.setOnClickListener( v-> {
            Intent i = new Intent(this, Restaurante1.class);
            startActivity(i);
        });

        btnSaibaMais2.setOnClickListener( v-> {
            Intent i = new Intent(this, Restaurante2.class);
            startActivity(i);
        });

        btnSaibaMais3.setOnClickListener( v-> {
            Intent i = new Intent(this, Restaurante3.class);
            startActivity(i);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}