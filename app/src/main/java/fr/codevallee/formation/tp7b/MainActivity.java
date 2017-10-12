package fr.codevallee.formation.tp7b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Activity du menu principale: Un seul bouton, le bouton commencer
        //On récupére le bouton commencer
        final Button boutonCommencer = (Button) findViewById(R.id.button_commencer);

        //Et on lui assigne la fonction de lancer l'activity question
        boutonCommencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                startActivity(intent);
            }
        });

    }
}
