package com.example.quinta2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Map<CheckBox, String> checkBoxImageMap = new HashMap<>();
    private Button btnVerificar;
    private final List<String> paketaxoAmarillo = Arrays.asList("img_9", "img_20", "img_34", "img_36");
    private final List<String> paketaxoVerde = Arrays.asList("img_25", "img_24", "img_23", "img_37");
    private final List<String> paketaxoAzul = Arrays.asList("img_23", "img_28", "img_26", "img_22");
    private final List<String> paketaxoMorado = Arrays.asList("img_21", "img_27", "img_38", "img_35");


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));



        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 20, 20, 20);

        layout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));



        for (int i = 1; i <= 39; i++) {

            LinearLayout itemLayout = new LinearLayout(this);
            itemLayout.setOrientation(LinearLayout.HORIZONTAL);

            itemLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));

            itemLayout.setPadding(10, 10, 10, 10);


            String imageName = "img_" + i;
            int imageResId = getResources().getIdentifier(imageName, "drawable", getPackageName());

            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
            imageView.setImageResource(imageResId != 0 ? imageResId : android.R.drawable.ic_delete);


            CheckBox checkBox = new CheckBox(this);
            checkBox.setText("Imagen " + i);


            checkBoxImageMap.put(checkBox, imageName);


            itemLayout.addView(imageView);
            itemLayout.addView(checkBox);
            layout.addView(itemLayout);

        }



        btnVerificar = new Button(this);
        btnVerificar.setText("Verificar Paketaxo");
        btnVerificar.setOnClickListener(v -> verificarSeleccion());

        layout.addView(btnVerificar);


        scrollView.addView(layout);
        setContentView(scrollView);

    }

    private void verificarSeleccion() {

        List<String> seleccionadas = new ArrayList<>();

        for (Map.Entry<CheckBox, String> entry : checkBoxImageMap.entrySet()) {

            if (entry.getKey().isChecked()) {

                seleccionadas.add(entry.getValue());

            }

        }


        if (seleccionadas.size() != 4) {

            Toast.makeText(this, "Debes seleccionar exactamente 4 imágenes", Toast.LENGTH_SHORT).show();
            return;

        }


        String paketaxoSeleccionado = null;

        if (seleccionadas.containsAll(paketaxoAmarillo)) {

            paketaxoSeleccionado = "paketaxo_amarillo";

        } else if (seleccionadas.containsAll(paketaxoVerde)) {

            paketaxoSeleccionado = "paketaxo_verde";

        } else if (seleccionadas.containsAll(paketaxoAzul)) {

            paketaxoSeleccionado = "paketaxo_azul";

        } else if (seleccionadas.containsAll(paketaxoMorado)) {

            paketaxoSeleccionado = "paketaxo_morado";

        }


        Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);

        if (paketaxoSeleccionado != null) {

            intent.putExtra("paketaxo", paketaxoSeleccionado);

        }

        startActivity(intent);

    }

}

