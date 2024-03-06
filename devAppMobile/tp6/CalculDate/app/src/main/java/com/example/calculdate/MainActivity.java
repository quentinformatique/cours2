/*  Activité principale de l'application qui effectue des calculs sur les dates
    MainActivity.java                                               08/23
 */
package com.example.calculdate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Classe activité principale de l'application qui effectue des calculs sur les
 * dates. La vue contient 2 boutons permettant de lancer des activités filles :
 *   - EcartDate  : nombre de jours qui séparent 2 dates
 *   - JourSemaine : jour de la semaine pour une date donnée
 * Les activités filles sont dotées d'un bouton de retour permettant de revenir
 * sur l'activité principale
 * @author  Servières
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {


    /** Zone de texte qui affiche le message de retour,
     *  après retour de l'activité fille
     */
    private TextView messageRetour;

    public final static String CLE_MESSAGE = "MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageRetour = findViewById(R.id.retour_activite);
    }

    /**
     * Méthode appelée lors du clic sur le bouton de recherche du jour
     * de la semaine
     * @param bouton sur lequel l'utilisateur a cliqué
     */
    public void clicJourSemaine(View bouton) {
        Intent intention = new Intent(MainActivity.this, ActiviteJourSemaine.class);
        startActivity(intention);
    }

    /**
     * Méthode appelée lors du clic sur le bouton de calcul
     * de l'écart entre 2 dates
     * @param bouton sur lequel l'utilisateur a cliqué
     */
    public void clicEcartDate(View bouton) {
        Intent intention = new Intent(MainActivity.this, ActiviteEcartDate.class);
        startActivity(intention);
    }

    

}
