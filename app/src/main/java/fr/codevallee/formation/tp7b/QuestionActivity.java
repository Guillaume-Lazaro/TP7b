package fr.codevallee.formation.tp7b;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);

        //On récupére le numéro de la question en cours
        Intent intent = getIntent();
        final int questionActuelle = intent.getIntExtra("question_actuelle",0);
        final int score = intent.getIntExtra("score",0);

        //Récupération des ressources pour pouvoir récupérer la question
        Resources res = getResources();
        String questionCourante = res.getStringArray(R.array.questions)[questionActuelle];

        //On parse la question courante en un intitulé et 2 réponses:
        String intitule = questionCourante.split("_")[0];
        String reponseA = questionCourante.split("_")[1];
        String reponseB = questionCourante.split("_")[2];

        //On récupére le numéro de la bonne réponse
        final int bonneReponse = Integer.parseInt(questionCourante.split("_")[3]);

        //Maintenant, on crée l'interface
        final TextView questionView = (TextView) findViewById(R.id.text_question);
        final Button bouton1 = (Button) findViewById(R.id.button_1);
        final Button bouton2 = (Button) findViewById(R.id.button_2);

        questionView.setText(intitule);
        bouton1.setText(reponseA);
        bouton2.setText(reponseB);

        bouton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuestionActivity.this, ReponseActivity.class);
                String nextMessage="";
                if(bonneReponse==1) {
                    nextMessage += "Bravo! C'était la bonne réponse!";
                    intent.putExtra("score", score+1);
                } else {
                    nextMessage += "Faux! C'était la mauvaise réponse!";
                    intent.putExtra("score", score);
                }

                intent.putExtra("message", nextMessage);
                intent.putExtra("question_actuelle", questionActuelle);
                startActivity(intent);
            }
        });

        bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuestionActivity.this, ReponseActivity.class);
                String nextMessage="";
                if(bonneReponse==2) {
                    nextMessage += "Bravo! C'était la bonne réponse!";
                    intent.putExtra("score", score+1);
                } else {
                    nextMessage += "Faux! C'était la mauvaise réponse!";
                    intent.putExtra("score", score);
                }

                intent.putExtra("message", nextMessage);
                intent.putExtra("question_actuelle", questionActuelle);
                startActivity(intent);
            }
        });
    }
}