package com.example.custombuttons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.UUID;

public class GeradorUUIDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerador_uuidactivity);

        Button buttonSaidaUUID = findViewById(R.id.buttonSaidaUUID);
        TextView textViewSaidaUUID = findViewById(R.id.textViewSaidaUUID);

        Button buttonGeradorUUIDProximaActivity = findViewById(R.id.buttonGeradorUUIDProximaActivity);
        Button buttonGeradorUUIDAnteriorActivity = findViewById(R.id.buttonGeradorUUIDAnteriorActivity);

        buttonSaidaUUID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UUID uuid = UUID.randomUUID();

                textViewSaidaUUID.setText(uuid.toString());
            }
        });

        buttonGeradorUUIDAnteriorActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GeradorUUIDActivity.this, FormularioActivity.class);
                startActivity(intent);
            }
        });
        buttonGeradorUUIDProximaActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GeradorUUIDActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}