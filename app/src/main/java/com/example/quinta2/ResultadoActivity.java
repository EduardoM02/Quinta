package com.example.quinta2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultadoActivity extends AppCompatActivity {

    private ImageView imageViewPaketaxo;
    private TextView textViewMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        imageViewPaketaxo = findViewById(R.id.imageViewPaketaxo);
        textViewMensaje = findViewById(R.id.textViewMensaje);

        // Recibir el extra del Intent
        Intent intent = getIntent();
        String paketaxoSeleccionado = intent.getStringExtra("paketaxo");

        if (paketaxoSeleccionado != null) {
            int imageResId = getResources().getIdentifier(paketaxoSeleccionado, "drawable", getPackageName());

            if (imageResId != 0) {
                imageViewPaketaxo.setImageResource(imageResId);
                textViewMensaje.setVisibility(View.GONE);
            } else {
                textViewMensaje.setText("No se encontró la imagen del Paketaxo.");
                imageViewPaketaxo.setVisibility(View.GONE);
            }
        } else {
            textViewMensaje.setText("Las Sabritas seleccionadas no coinciden con ningún Paketaxo.");
            imageViewPaketaxo.setVisibility(View.GONE);
        }
    }
}
