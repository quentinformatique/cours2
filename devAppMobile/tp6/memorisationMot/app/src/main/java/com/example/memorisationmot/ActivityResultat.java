package com.example.memorisationmot;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class ActivityResultat extends AppCompatActivity {

    /** Clé pour la liste des mots corrects transmis à l'activité fille "propositions" */
    public static final String CLE_MOT_CORRECT = "memorisemot.MOT_CORRECT";
    /**
     * Identifiants des widgets  TextView contenant les mots proposés par le joueur
     */
    private static final int[] IDENT_TEXT_PROPOSITION = {R.id.proposition1, R.id.proposition2,
            R.id.proposition3, R.id.proposition4, R.id.proposition5};

    /**
     * Identifiants des widgets  TextView contenant les mots corrects
     */
    private static final int[] IDENT_TEXT_MOT_OK = {R.id.motok1, R.id.motok2,
            R.id.motok3, R.id.motok4, R.id.motok5};

    /**
     * Zone de texte pour afficher les mots proposés par l'utilisateur
     */
    private TextView[] zoneMotUtilisateur;

    /**
     * Zone de texte pour afficher les mots corrects qu'il fallait retrouver
     */
    private TextView[] zoneMotCorrect;

    /**
     * Zone pour afficher combien de mots l'utilisateur a effectivement retrouvé
     */
    private TextView etiqCombienTrouve;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite_resultat);
        etiqCombienTrouve = findViewById(R.id.texte_combien);

        // accès sur les zones d'affichage des mots utilisateur
        zoneMotUtilisateur = new TextView[MainActivity.NB_MOT];
        for (int i = 0; i < IDENT_TEXT_PROPOSITION.length; i++) {
            zoneMotUtilisateur[i] = findViewById(IDENT_TEXT_PROPOSITION[i]);
        }

        // accès sur les zones d'affichage des mots corrects et des résultats
        zoneMotCorrect = new TextView[MainActivity.NB_MOT];
        for (int i = 0; i < IDENT_TEXT_MOT_OK.length; i++) {
            zoneMotCorrect[i] = findViewById(IDENT_TEXT_MOT_OK[i]);
        }

        // on récupère l'intention à l'origine de l'activité

        Intent intention = getIntent();

        // on récupère les listes de mots contenus dans l'intention
        ArrayList<String> motUtilisateur = intention.getStringArrayListExtra(ActivityPropositions.CLE_MOT_UTILISATEUR);

        // on place les mots dans les zones d'affichage
        for (int i = 0; i < MainActivity.NB_MOT; i++) {
            zoneMotUtilisateur[i].setText(motUtilisateur.get(i));
        }

        ArrayList<String> motCorrect = intention.getStringArrayListExtra(MainActivity.CLE_MOT_CORRECT);
        for (int i = 0; i < MainActivity.NB_MOT; i++) {
            zoneMotCorrect[i].setText(motCorrect.get(i));
        }


        if (BaseDeMot.identique(motUtilisateur, motCorrect)) {

            //  on modifie le titre de l'activité : gagné
            TextView etiqTitreActivite = findViewById(R.id.nom_activite_resultat);
            etiqTitreActivite.setText(R.string.message_gagne1);
            etiqCombienTrouve.setText(R.string.message_gagne2);
        } else {

            // on affiche combien de mots ont été retrouvés
            etiqCombienTrouve.setText(
                    String.format(etiqCombienTrouve.getText().toString(),
                            BaseDeMot.combienEnCommun(motUtilisateur, motCorrect)));
        }

    }


    /**
     * Méthode invoquée lorsque l'utilisateur clique sur "Rejouer".
     * L'activité principale de l'application est relancée.
     *
     * @param bouton bouton sur lequel l'utilisateur a cliqué
     */
    public void clicRejouer(View bouton) {

        // on crée une intention pour lancer l'activité suivante
        Intent intention = new Intent(this, MainActivity.class);

        // on lance l'activité suivante
        startActivity(intention);

    }

    public void clicRejouerTentative(View bouton) {


        // on récupère l'intention à l'origine de l'activité

        Intent intention = getIntent();

        // on rejouer avec les mêmes mots
        ArrayList<String> motUtilisateur = intention.getStringArrayListExtra(ActivityPropositions.CLE_MOT_UTILISATEUR);

        Intent intentionRejouer = new Intent(this, ActivityPropositions.class);
        intention.putStringArrayListExtra(CLE_MOT_CORRECT, motUtilisateur);
        startActivity(intention);

    }


}
