package com.jamal.marathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ViewData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        Intent intent = getIntent();

        TextView nom = (TextView) findViewById(R.id.textViewTextPersonNom);
        TextView prenom = (TextView) findViewById(R.id.textViewTextPersonPrenom);
        TextView email = (TextView) findViewById(R.id.textViewTextPersonEmail);

        nom.setText(intent.getStringExtra("nom"));
        prenom.setText(intent.getStringExtra("prenom"));
        email.setText(intent.getStringExtra("email"));

    }
}