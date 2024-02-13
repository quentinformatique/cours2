package com.example.affichealeatoire;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void generate(View view) {
        TextView labelNombre;
        labelNombre = findViewById(R.id.value);

        String nombre;
        nombre = String.valueOf(OutilAleatoire.tirageAleatoire(100));


        labelNombre.setText(getString(R.string.number) + " " + nombre);
    }
}