package com.example.firebasenoticia;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declaramos una variable DataBaseReference para acceder a la base de datos de FireBase.

    DatabaseReference miDatabaseReference = FirebaseDatabase.getInstance().getReference();



    // Creamos una variable que permita acceder al nodo child (variable) declarado en la base de datos de Firebase. La variable se llamará noticia.


    DatabaseReference mChild=miDatabaseReference.child("noticia");

    private TextView txtMensaje;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMensaje= (TextView) findViewById(R.id.txtNoticia);


    }

    @Override
    protected void onStart() {
        super.onStart();
        mChild.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                String valor = dataSnapshot.getValue().toString();
                txtMensaje.setText(valor);

            }

            @Override
            public void onCancelled( DatabaseError error) {
            }
        });
    }
}
