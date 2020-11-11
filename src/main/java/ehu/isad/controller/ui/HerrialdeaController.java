package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.ZerbitzuKudeatzailea;
import ehu.isad.model.BotoakModel;
import ehu.isad.model.BozkaketaModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.*;

public class HerrialdeaController implements Initializable {
    private Main main;
    private String herria;
    public void herrialdeaEzarri(String herrialde){
        this.herria=herrialde;
    }
    @FXML
    private TableView<BozkaketaModel> taula;
    @FXML
    private TableColumn<BozkaketaModel, Image> bandera;
    @FXML
    private TableColumn<BozkaketaModel, String> herrialdea;

    @FXML
    private TableColumn<BozkaketaModel, String> artista;

    @FXML
    private TableColumn<BozkaketaModel, String> abestia;

    @FXML
    private TableColumn<BozkaketaModel, Integer> puntua;

    @FXML
    private Button bozkaketa_egin;
    @FXML
    private ImageView irudia;
    @FXML
    void puntuak_aldatu(ActionEvent event) {
        ZerbitzuKudeatzailea zk=new ZerbitzuKudeatzailea();
        int botoGuztiak=0;
        List<BotoakModel> bozkaketaGuztiak=new ArrayList<BotoakModel>();
        BozkaketaModel bozkaketa;
        for (int i = 0; i < bozkaketa_zerrenda.size(); i ++){
            bozkaketa = bozkaketa_zerrenda.get(i);
            if (bozkaketa.getPuntuak() > 0){
                Calendar c=Calendar.getInstance();
                BotoakModel botoa=new BotoakModel(bozkaketa.getHerrialdea(),herria, c.get(Calendar.YEAR),bozkaketa.getPuntuak());
                bozkaketaGuztiak.add(botoa);
                botoGuztiak=botoGuztiak+bozkaketa.getPuntuak();
            }
            if (botoGuztiak==5){
                break;
            }
        }
        for(int z=0;z<bozkaketaGuztiak.size();z++){
            zk.sartu_botoak(bozkaketaGuztiak.get(z));
        }
        main.rankingErakutsi();
    }
    private ObservableList<BozkaketaModel> bozkaketa_zerrenda=FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ZerbitzuKudeatzailea zk=new ZerbitzuKudeatzailea();
        List<BozkaketaModel> bozkaketak=zk.eman_herrialde_info_guztia();
        taula.setEditable(true);
        bozkaketa_zerrenda.addAll(bozkaketak);

        puntua.setCellValueFactory(new PropertyValueFactory<>("puntuak"));
        herrialdea.setCellValueFactory(new PropertyValueFactory<>("herrialdea"));
        artista.setCellValueFactory(new PropertyValueFactory<>("artista"));
        abestia.setCellValueFactory(new PropertyValueFactory<>("abestia"));

        bandera.setCellValueFactory(new PropertyValueFactory<>("bandera"));

        bandera.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty){
                    final ImageView imageview = new ImageView();
                    imageview.setFitHeight(50);
                    imageview.setFitWidth(50);
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);
                    // tbData.refresh();
                }else{
                    setGraphic(null);
                    setText(null);
                }
            };
        });


        Callback<TableColumn<BozkaketaModel, Integer>, TableCell<BozkaketaModel, Integer>> defaultTextFieldCellFactory
                = TextFieldTableCell.forTableColumn(new IntegerStringConverter());
        puntua.setCellFactory(col -> {
            TableCell<BozkaketaModel, Integer> cell = defaultTextFieldCellFactory.call(col);

            cell.setOnMouseClicked(event -> {
                if(herria.equals(cell.getTableView().getSelectionModel().getSelectedItem().getHerrialdea())){
                    cell.setEditable(false);
                }else{
                    cell.setEditable(true);
                }

            });

            return cell ;
        });


        puntua.setOnEditCommit(
                t -> {
                    t.getTableView().getItems().get(t.getTablePosition().getRow())
                            .setPuntuak(t.getNewValue());


                }
        );

        taula.setItems(bozkaketa_zerrenda);

    }

    public void setMainApp(Main main) {
        this.main = main;
    }
}
