package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.ZerbitzuKudeatzailea;
import ehu.isad.model.HerrialdeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AukeratuController implements Initializable {
    private Main main;

    @FXML
    private ImageView irudia;

    @FXML
    private ComboBox<HerrialdeModel> combo_herriak;

    @FXML
    private Button bozkaketara_joan;

    @FXML
    void botoak_erakutsi(ActionEvent event) {
        ZerbitzuKudeatzailea zk=new ZerbitzuKudeatzailea();

        if (zk.bozkatu_du(combo_herriak.getValue().getIzena(),2019)){
           main.erroreaErakutsi(combo_herriak.getValue().getIzena());
        }else {
           main.bozkaketaErakutsi(combo_herriak.getValue().getIzena());
        }

    }

    public void setMainApp(Main main) {
        this.main=main;
    }
    private ObservableList<HerrialdeModel> herrialde_zerrenda= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ZerbitzuKudeatzailea zk=new ZerbitzuKudeatzailea();
        List<HerrialdeModel> herrialdeak=zk.eman_herrialde_guztiak();
        herrialde_zerrenda.addAll(herrialdeak);
        combo_herriak.setItems(herrialde_zerrenda);
        combo_herriak.setEditable(false);
        combo_herriak.setConverter(new StringConverter<HerrialdeModel>() {
            @Override
            public String toString(HerrialdeModel object) {
                if (object==null){
                    return "";
                }
                return object.getIzena();
            }

            @Override
            public HerrialdeModel fromString(String string) {
                return null;
            }
        });
    }
}
