package it.itismeucci;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PrimaryController {

    @FXML
    private GridPane griglia;

    @FXML
    private Label outPutVincitore;

    Griglia grigliaPrincipale = new Griglia();

    boolean turnoGiocatore1 = true; // se true giocatore1, se false giocatore2

    private boolean gameOver = false;

    public void segnaPunto(ActionEvent event) {
        if (gameOver) {
            return; // se il gioco è finito non si possono cliccare i pulsanti
        }

        Button btn = (Button) event.getSource();
        Integer riga = GridPane.getRowIndex(btn);
        Integer colonna = GridPane.getColumnIndex(btn);

        // la funzione segnaPunto() restituisce true se la cella è vuota o false se la
        // cella è piena
        if (grigliaPrincipale.segnaPunto(riga, colonna) == true) {
            if (turnoGiocatore1 == true) {
                btn.setText("O");
                btn.setDisable(true);
                btn.setStyle("-fx-base: coral");
            } else {
                btn.setText("X");
                btn.setDisable(true);
                btn.setStyle("-fx-base: blue");
            }
            turnoGiocatore1 = !turnoGiocatore1;

            char vincitore = grigliaPrincipale.verificaVincitore();

            if (vincitore != ' ') {
                outPutVincitore.setText("HA VINTO IL GIOCATORE " + vincitore);
                gameOver = true;

                // la funzione isPieno() restituisce true se è piena e false se ancora mancano
                // delle celle
            } else if (grigliaPrincipale.isPieno() == true) {
                outPutVincitore.setText("PAREGGIO");
                gameOver = true;
            }
        }
    }

    @FXML
    public void reset() {
        grigliaPrincipale.reset();
        ObservableList<Node> buttons = griglia.getChildren();
        for (Node node : buttons) {
            if (node instanceof Button) {
                Button btn = (Button) node;
                btn.setText(" ");
                btn.setDisable(false);
                btn.setStyle(null);
                btn.setStyle("-fx-border-color: yellow");
            }
        }
        turnoGiocatore1 = true;
        gameOver = false;
        outPutVincitore.setText(" ");

    }
}
