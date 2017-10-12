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

        //Activity qui sert à poser la question en cours (elle commence par 0), à afficher les réponses et à passer à l'écran réponse
        //On récupére le numéro de la question en cours et le score actuelle
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

        //Ici, on assigne l'action correspondante à chaque boutons, pour chacun, on vérifie si ça correspond à la bonne réponse,
        // et si c'est le cas, on fait passer "bonne réponse", sinon "mauvaise réponse"
        bouton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuestionActivity.this, ReponseActivity.class);
                String nextMessage="";
                if(bonneReponse==1) {
                    nextMessage = getString(R.string.reponse_correcte);
                    intent.putExtra("score", score+1);
                } else {
                    nextMessage = getString(R.string.reponse_fausse);
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
                    nextMessage = getString(R.string.reponse_correcte);
                    intent.putExtra("score", score+1);
                } else {
                    nextMessage = getString(R.string.reponse_fausse);
                    intent.putExtra("score", score);
                }

                intent.putExtra("message", nextMessage);
                intent.putExtra("question_actuelle", questionActuelle);
                startActivity(intent);
            }
        });
    }
}