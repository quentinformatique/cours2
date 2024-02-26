package com.example.listeressourcesbuts4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] modules;
    String[] modulesA;
    String[] modulesB;
    String[] allModules;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView) findViewById(R.id.liste_module);
        this.modules = getResources().getStringArray(R.array.tronc_commun);
        this.modulesA = getResources().getStringArray(R.array.parcours_A);
        this.modulesB = getResources().getStringArray(R.array.parcours_B);

        this.allModules = new String[modules.length + modulesA.length + modulesB.length];
        System.arraycopy(modules, 0, allModules, 0, modules.length);
        System.arraycopy(modulesA, 0, allModules, modules.length, modulesA.length);
        System.arraycopy(modulesB, 0, allModules, modules.length + modulesA.length, modulesB.length);

        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        this.adapter.addAll(allModules);
        listView.setAdapter(adapter);
    }

    public void clicTous(View view) {
        this.adapter.clear();
        this.adapter.addAll(allModules);

    }

    public void clicTroncCommun(View view) {
        this.adapter.clear();
        this.adapter.addAll(modules);
    }

    public void clicAxeB(View view) {
        this.adapter.clear();
        this.adapter.addAll(modulesB);
    }

    public void clicAxeA(View view) {
        this.adapter.clear();
        this.adapter.addAll(modulesA);
    }
}