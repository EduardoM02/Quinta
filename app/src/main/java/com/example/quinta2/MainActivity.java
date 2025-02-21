package com.example.quinta2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        layout.setBackgroundColor(Color.LTGRAY);


        for (int i = 1; i <= 43; i++) {

            LinearLayout itemLayout = new LinearLayout(this);
            itemLayout.setOrientation(LinearLayout.HORIZONTAL);

            itemLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));

            itemLayout.setPadding(10, 10, 10, 10);

            // Obtener imagenes de la carpeta "drawable/"
            int imageResId = getResources().getIdentifier("img_" + i, "drawable", getPackageName());

            // Crear ImageView para mostrar la imagen
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(200, 200));

            // Asignar ID
            if (imageResId != 0) {

                imageView.setImageResource(imageResId);

            } else {

                imageView.setImageResource(android.R.drawable.ic_delete);

            }


            CheckBox checkBox = new CheckBox(this);
            checkBox.setText("Imagen " + i);


            itemLayout.addView(imageView);
            itemLayout.addView(checkBox);


            layout.addView(itemLayout);

        }


        scrollView.addView(layout);


        setContentView(scrollView);

    }

}