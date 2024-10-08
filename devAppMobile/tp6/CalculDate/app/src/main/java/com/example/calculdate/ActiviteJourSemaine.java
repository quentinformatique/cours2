/*  Activité secondaire de l'application qui effectue des calculs sur les dates
    ActiviteJourSemaine.java                                              08/23
 */
package com.example.calculdate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Classe activité secondaire de l'application qui effectue des calculs sur les
 * dates.
 * Elle effectue la recherche du jour de la semaine à partir d'une date
 *
 * @author Servières
 * @version 1.0
 */
public class ActiviteJourSemaine extends AppCompatActivity {

    /**
     * Zone pour afficher le résultat
     */
    private TextView resultatJourSemaine;

    /**
     * Widget de sélection d'une date
     */
    private DatePicker selecteurPourJour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite_jour_semaine);
        resultatJourSemaine = findViewById(R.id.resultat_jour);
        selecteurPourJour = findViewById(R.id.selecteurDate);
    }

    /**
     * Méthode invoquée automatiquement lors d'un clic sur le bouton
     * "Rechercher le jour de la semaine associé à  une date"
     *
     * @param view source du clic
     */
    public void clicRechercherJour(View view) {
        int jour = selecteurPourJour.getDayOfMonth();
        int mois = selecteurPourJour.getMonth() + 1;
        int an = selecteurPourJour.getYear();

        // on affiche le résultat
        String jourSemaine = OutilDate.jourSemaine(jour, mois, an);
        resultatJourSemaine.setText("le jour de la semaine est : " + jourSemaine);
    }

    /**
     * Méthode invoquée automatiquement lors d'un clic sur le bouton
     * de remise à zéro
     *
     * @param view source du clic
     */
    public void clicRaz(View view) {
        resultatJourSemaine.setText("");
    }

    /**
     * Méthode invoquée automatiquement lors d'un clic sur le bouton
     * de retour vers l'activité principale
     *
     * @param view source du clic
     */
    public void clicRetour(View view) {
        Intent intention = new Intent();
        intention.putExtra(MainActivity.CLE_MESSAGE, "Merci d'avoir utilisé la recherche du jour");
        intention.putExtra(MainActivity.CLE_RESULTAT, "Dernière recherche : " + resultatJourSemaine.getText().toString());
        setResult(Activity.RESULT_OK, intention);
        setResult(Activity.RESULT_OK);
        finish();
    }

    private void traiterResulstatRetour() {

    }


}
