package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class HasieraController implements Initializable {
    private Main main;

    @FXML
    private ImageView irudia;


    @FXML
    private Button jarraitu;

    @FXML
    void bozkatzera_joan(ActionEvent event) {
        main.herrialdeaErakutsi();

    }

    public void setMainApp(Main main) {
        this.main=main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
