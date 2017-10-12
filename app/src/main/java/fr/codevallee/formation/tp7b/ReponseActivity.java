package fr.codevallee.formation.tp7b;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReponseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reponse_layout);

        //On récupére les données utiles:
        Intent intent = getIntent();
        String texte = intent.getStringExtra("message");
        final int questionActuelle = intent.getIntExtra("question_actuelle", 0);
        final int score = intent.getIntExtra("score",0);

        final Button boutonContinuer = (Button) findViewById(R.id.button_continuer);

        //On affiche si réponse était bonne ou mauvaise:
        TextView textReponse = (TextView) findViewById(R.id.text_reponse);
        textReponse.setText(texte);

        //Si il reste des question on continue:
        if(questionActuelle+1<getResources().getStringArray(R.array.questions).length) {
            boutonContinuer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ReponseActivity.this, QuestionActivity.class);
                    intent.putExtra("question_actuelle", questionActuelle + 1);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            });
        } else { //Sinon on s'arréte là:
            boutonContinuer.setText("Terminé");
            boutonContinuer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ReponseActivity.this, ScoreActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            });
        }
    }
}
