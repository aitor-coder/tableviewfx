package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ErroreaController {
    private Main main;

    @FXML
    private Label errore_testua;

    public void mezuaJarri(String herria){
        errore_testua.setText(herria+"-k jada banatu ditu bere puntuak.");
    }

    public void setMainApp(Main main) {
        this.main=main;
    }
}
