package com.example.memorisationmot;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityPropositions extends AppCompatActivity {

    /** Clé pour le tableau des mots proposés par l'utilisteur */
    public static final String CLE_MOT_UTILISATEUR
            = "com.multiactivite.exercice.android.memorisemot.MOT_UTILISATEUR";

    /**
     * Identifiants des widgets  EditText
     */
    private static final int[] IDENT_EDIT_TEXT = {R.id.saisie_mot1, R.id.saisie_mot2,
            R.id.saisie_mot3, R.id.saisie_mot4, R.id.saisie_mot5};


    /** Zone de saisie pour les mots proposés par l'utilisateur */
    private EditText[] tableZoneSaisie;

    /** Liste des mots corrects */
    private ArrayList<String> listeCorrecte;

    /** Liste des mots proposés par l'utilisateur */
    private ArrayList<String> reponseUtilisateur;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite_proposition);
        // accès sur les zones de saisie des mots utilisateur
        tableZoneSaisie = new EditText[MainActivity.NB_MOT];
        for (int i = 0; i < IDENT_EDIT_TEXT.length; i++) {
            tableZoneSaisie[i] = findViewById(IDENT_EDIT_TEXT[i]);
        }

        // on récupère l'intention à l'origine de l'activité
        Intent intention = getIntent();

        // on récupère les listes de mots contenus dans l'intention
        listeCorrecte = intention.getStringArrayListExtra(MainActivity.CLE_MOT_CORRECT);
    }

    /**
     * Méthode appelée lorsque l'utilisateur clique sur le bouton "Soumettre"
     * @param bouton  bouton sur lequel l'utilisateur a cliqué
     */
    public void clicSoumettre(View bouton) {

        // on constitue la liste des mots saisis par l'utilistateur
        reponseUtilisateur = new ArrayList<>();
        for (int i = 0; i < MainActivity.NB_MOT; i++) {
            reponseUtilisateur.add(tableZoneSaisie[i].getText().toString());
        }


        // on crée une intention pour lancer l'activité suivante
        Intent intention = new Intent(this, ActivityResultat.class);

        // on ajoute les listes de mots à l'intention
        intention.putStringArrayListExtra(CLE_MOT_UTILISATEUR, reponseUtilisateur);
        intention.putStringArrayListExtra(MainActivity.CLE_MOT_CORRECT, listeCorrecte);

        // on lance l'activité suivante
        startActivity(intention);

    }


}
