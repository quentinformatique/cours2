package com.example.aleatoirefixe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int alea = OutilAleatoire.tirageAleatoire(100);

        TextView resultat = findViewById((R.id.))

    }
}