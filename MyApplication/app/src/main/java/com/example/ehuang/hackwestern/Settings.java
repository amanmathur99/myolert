package com.example.ehuang.hackwestern;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends AppCompatActivity {

    private Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = pref.edit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText msgtxt = (EditText) findViewById(R.id.message);
                EditText tele1txt = (EditText) findViewById(R.id.number1);
                EditText tele2txt = (EditText) findViewById(R.id.number2);

                String msg = msgtxt.getText().toString();
                String tele1 = tele1txt.getText().toString();
                String tele2 = tele2txt.getText().toString();

                editor.putString("message",msg);
                editor.putString("num1",tele1);
                editor.putString("num2",tele2);
            }
        });

    }

}