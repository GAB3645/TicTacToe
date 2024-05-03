package it.itismeucci;

public class Griglia {

    private final int grandezzaGriglia = 3;
    private char[][] grigliaPrincipale;

    private static final char VUOTO = ' ';
    private static final char GIOCATORE1 = 'O';
    private static final char GIOCATORE2 = 'X';

    private boolean turnoGiocatore1 = true; //true = giocatore1 - false = giocatore2


    public Griglia() {
        this.grigliaPrincipale = new char[grandezzaGriglia][grandezzaGriglia];

        for (int i = 0; i < grandezzaGriglia; i++) {
            for (int j = 0; j < grandezzaGriglia; j++) {
                grigliaPrincipale[i][j] = VUOTO;
            }
        }
    }

    
    public boolean segnaPunto(int riga, int colonna) {
        if (grigliaPrincipale[riga][colonna] == VUOTO) {
            if (turnoGiocatore1) {
                grigliaPrincipale[riga][colonna] = GIOCATORE1;
            } else {
                grigliaPrincipale[riga][colonna] = GIOCATORE2;
            }
            turnoGiocatore1 = !turnoGiocatore1;
            return true; //punto segnato
        }
        return false; //la cella è già occupata
    }


    public char verificaVincitore() {  //controlla tutta la griglia per capire chi è il vincitore
        for (int i = 0; i < grandezzaGriglia; i++) {
            if (grigliaPrincipale[i][0] == grigliaPrincipale[i][1] && grigliaPrincipale[i][1] == grigliaPrincipale[i][2] && grigliaPrincipale[i][0] != VUOTO) {
                return grigliaPrincipale[i][0]; //returna X o O a seconda del carattere in quella posizione che abbiamo controllato
            }
            if (grigliaPrincipale[0][i] == grigliaPrincipale[1][i] && grigliaPrincipale[1][i] == grigliaPrincipale[2][i] && grigliaPrincipale[0][i] != VUOTO) {
                return grigliaPrincipale[0][i];
            }
        }
        //controlla le linee in diagonale 
        if (grigliaPrincipale[0][0] == grigliaPrincipale[1][1] && grigliaPrincipale[1][1] == grigliaPrincipale[2][2] && grigliaPrincipale[0][0] != VUOTO) {
            return grigliaPrincipale[0][0];
        }
        if (grigliaPrincipale[0][2] == grigliaPrincipale[1][1] && grigliaPrincipale[1][1] == grigliaPrincipale[2][0] && grigliaPrincipale[0][2] != VUOTO) {
            return grigliaPrincipale[0][2];
        }


        return VUOTO; //pareggio 
    }


    public boolean isPieno() {
        for (int i = 0; i < grandezzaGriglia; i++) {
            for (int j = 0; j < grandezzaGriglia; j++) {
                if (grigliaPrincipale[i][j] == VUOTO) {
                    return false; //ancora la griglia non è piena 
                }
            }
        }
        return true; //la griglia è piena
    }


    public void reset() {  //resetta tutta la griglia con il carattere vuoto
        for (int i = 0; i < grandezzaGriglia; i++) {
            for (int j = 0; j < grandezzaGriglia; j++) {
                grigliaPrincipale[i][j] = VUOTO;
            }
        }
        turnoGiocatore1 = true;  //ripartiamo con il primo giocatore
    }
}
