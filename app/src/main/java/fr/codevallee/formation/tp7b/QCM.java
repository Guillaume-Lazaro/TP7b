package fr.codevallee.formation.tp7b;


public class QCM {

    private String question;
    private String reponseA;
    private String reponseB;
    private int reponse;

    public QCM(String question, String reponseA, String reponseB, int reponse) {
        this.question = question;
        this.reponseA = reponseA;
        this.reponseB = reponseB;
        this.reponse = reponse;
    }

    public boolean win(int tentative) {
        if(tentative==this.reponse)
            return true;
        else
            return false;
    }

    public int getBonneReponse() {
        return this.reponse;
    }


}
