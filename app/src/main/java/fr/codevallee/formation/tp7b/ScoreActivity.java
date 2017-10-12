package fr.codevallee.formation.tp7b;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_layout);

        //On récupére les données utiles:
        Intent intent = getIntent();
        final int score = intent.getIntExtra("score",0);

        TextView scoreView = (TextView) findViewById(R.id.text_score);
        scoreView.setText("Votre score est de "+score+"/"+getResources().getStringArray(R.array.questions).length);

        final Button boutonTerminer = (Button) findViewById(R.id.button_terminer);
        boutonTerminer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
