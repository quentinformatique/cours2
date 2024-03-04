package com.example.listeressourcesbuts4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] modules;
    String[] modulesA;
    String[] modulesB;
    String[] allModules;
    TextView titre;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView) findViewById(R.id.liste_module);
        this.modules = getResources().getStringArray(R.array.tronc_commun);
        this.modulesA = getResources().getStringArray(R.array.parcours_A);
        this.modulesB = getResources().getStringArray(R.array.parcours_D);
        this.titre = findViewById(R.id.intitule_liste);

        this.allModules = new String[modules.length + modulesA.length + modulesB.length];
        System.arraycopy(modules, 0, allModules, 0, modules.length);
        System.arraycopy(modulesA, 0, allModules, modules.length, modulesA.length);
        System.arraycopy(modulesB, 0, allModules, modules.length + modulesA.length, modulesB.length);

        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        this.adapter.addAll(allModules);
        listView.setAdapter(adapter);
        // on change le texte
        this.titre.setText(R.string.libelle_tous);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_general, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.option_tous) {
            this.adapter.clear();
            this.adapter.addAll(allModules);
            this.titre.setText(R.string.libelle_tous);
        } else if (id == R.id.option_commun) {
            this.adapter.clear();
            this.adapter.addAll(modules);
            this.titre.setText(R.string.libelle_commun);
        } else if (id == R.id.option_parcoursA) {
            this.adapter.clear();
            this.adapter.addAll(modulesA);
            this.titre.setText(R.string.libelle_parcoursA);
        } else if (id == R.id.option_parcoursD) {
            this.adapter.clear();
            this.adapter.addAll(modulesB);
            this.titre.setText(R.string.libelle_parcoursD);
        }
        return super.onOptionsItemSelected(item);
    }

}