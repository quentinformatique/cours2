package com.example.calculreduction;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText saisiePrix;
    private EditText saisieReduc;
    private EditText saisieEco;
    private EditText saisiePayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saisiePrix = findViewById(R.id.saisiePrix);
        saisieReduc = findViewById(R.id.saisieReduc);
        saisieEco = findViewById(R.id.saisieEco);
        saisiePayer = findViewById(R.id.saisiePayer);

    }

    @SuppressLint("DefaultLocale")
    public void calculer(View view) {
    String prixString = saisiePrix.getText().toString();
    String reducString = saisieReduc.getText().toString();

    if (TextUtils.isEmpty(prixString) || TextUtils.isEmpty(reducString)) {
        // affichaage d'un toast pour informer l'utilisateur
        Toast.makeText(this, "Erreur, veuillez saisir les deux champs", Toast.LENGTH_LONG).show();
        return;
    }

    double prix = Double.parseDouble(prixString);
    double reduc = Double.parseDouble(reducString);

    if (reduc < 0 || reduc > 100 || TextUtils.isEmpty(reducString)) {
        saisieReduc.setError("Erreur, taux > à 100%");
        return;
    }

    double eco = prix * reduc / 100;
    double aPayer = prix - eco;

        saisieEco.setText(String.format("%.2f", eco));
        saisiePayer.setText(String.format("%.2f", aPayer));
}

    public void annuler(View view) {
        saisiePrix.setText("");
        saisieReduc.setText("");
        saisieEco.setText("");
        saisiePayer.setText("");
    }
}