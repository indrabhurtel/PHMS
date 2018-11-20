package com.example.indrabhurtel.first_screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.jar.Attributes;

public class RegistrationActivity extends AppCompatActivity {
    EditText editTextName;
    EditText
    Button buttonAdd;

    DatabaseReference databaseArtists;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        databaseArtists = FirebaseDatabase.getInstance().getReference("artists");

        editTextName = (EditText)findViewById(R.id.editTextName);
        buttonAdd = (Button)findViewById(R.id.btnRegister);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addName();

            }
        });
        }
        private void addName(){

        String name = editTextName.getText().toString().trim();

        if (!TextUtils.isEmpty(name)){

            String id = databaseArtists.push().getKey();
            Artist artist = new Artist(id,name );
            databaseArtists.child(id).setValue(artist);

            Toast.makeText(this, "Name added", Toast.LENGTH_LONG).show();

        }

        else{

            Toast.makeText(this, "You should enter name", Toast.LENGTH_LONG).show();
        }
        }
}
