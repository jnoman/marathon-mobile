package com.jamal.marathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewData();
            }
        });
    }
    public void openViewData() {

        EditText EditText_nom = (EditText) findViewById(R.id.editTextTextPersonNom);
        EditText EditText_prenom = (EditText) findViewById(R.id.editTextTextPersonPrenom);
        EditText EditText_email = (EditText) findViewById(R.id.editTextTextPersonEmail);

        String nom = EditText_nom.getText().toString();
        String prenom = EditText_prenom.getText().toString();
        String email = EditText_email.getText().toString();


        TextView textView_nom = (TextView) findViewById(R.id.textViewTextPersonNomMessage);
        TextView textView_Prenom = (TextView) findViewById(R.id.textViewTextPersonPrenomMessage);
        TextView textView_email = (TextView) findViewById(R.id.textViewTextPersonEmailMessage);


        if (matchRegex("^[A-Za-z]{3,}$", nom)) {
            textView_nom.setVisibility(View.INVISIBLE);
            if (matchRegex("^[A-Za-z]{3,}$", prenom)) {
                textView_Prenom.setVisibility(View.INVISIBLE);
                if (matchRegex("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", email)) {
                    textView_email.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(this, ViewData.class);
                    intent.putExtra("nom", nom);
                    intent.putExtra("prenom", prenom);
                    intent.putExtra("email", email);
                    startActivity(intent);
                } else {
                    textView_email.setVisibility(View.VISIBLE);
                }
            } else {
                textView_Prenom.setVisibility(View.VISIBLE);
            }
        } else {
            textView_nom.setVisibility(View.VISIBLE);
        }
    }

    public boolean matchRegex(String regex, String text){
        Pattern VALID_Match_ADDRESS_REGEX = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_Match_ADDRESS_REGEX.matcher(text);
        return matcher.find();
    }
}