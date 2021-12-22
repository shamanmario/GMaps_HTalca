package com.example.gmaps_htalca;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Formulario extends AppCompatActivity {

    private TextView textoUbicacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        textoUbicacion = findViewById(R.id.textoUbicacion);

    }

    public void BuscarUbicacion(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                Ubicacion ubicacion = (Ubicacion) data.getSerializableExtra("ubicacion");
                textoUbicacion.setText("Ubicación seleccionada: "+ubicacion.GetLatitudLongitud());
            }
        }
    }
}