package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.ZerbitzuKudeatzailea;
import ehu.isad.model.HerrialdeModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class RankingController {
    private Main main;


    public void setMainApp(Main main) {
        this.main=main;
    }


    @FXML
    private Label postua_1;

    @FXML
    private ImageView irudia_1;

    @FXML
    private Label postua_2;

    @FXML
    private ImageView irudia_2;

    @FXML
    private Label postua_3;

    @FXML
    private ImageView irudia_3;
    public void eman_rankinga(){
        ZerbitzuKudeatzailea zk=new ZerbitzuKudeatzailea();
        List<HerrialdeModel> top3=zk.eman_top_3();

        if (top3.size()==1){
            Image i1=new Image(getClass().getResourceAsStream("/banderak/"+top3.get(0).getBandera()));
            irudia_1.setImage(i1);
            postua_1.setText(top3.get(0).getIzena()+" - "+top3.get(0).getBotoGuztiak()+" Puntu");
            postua_2.setText("");
            postua_3.setText("");
        }else{
            if(top3.size()==2){
                Image i1=new Image(getClass().getResourceAsStream("/banderak/"+top3.get(0).getBandera()));
                Image i2=new Image(getClass().getResourceAsStream("/banderak/"+top3.get(1).getBandera()));
                irudia_1.setImage(i1);
                irudia_2.setImage(i2);
                postua_1.setText(top3.get(0).getIzena()+" - "+top3.get(0).getBotoGuztiak()+" Puntu");
                postua_2.setText(top3.get(1).getIzena()+" - "+top3.get(1).getBotoGuztiak()+" Puntu");
                postua_3.setText("");

            }else {
                Image i1=new Image(getClass().getResourceAsStream("/banderak/"+top3.get(0).getBandera()));
                Image i2=new Image(getClass().getResourceAsStream("/banderak/"+top3.get(1).getBandera()));
                Image i3=new Image(getClass().getResourceAsStream("/banderak/"+top3.get(2).getBandera()));

                irudia_1.setImage(i1);
                irudia_2.setImage(i2);
                irudia_3.setImage(i3);

                postua_1.setText(top3.get(0).getIzena()+" - "+top3.get(0).getBotoGuztiak()+" Puntu");
                postua_2.setText(top3.get(1).getIzena()+" - "+top3.get(1).getBotoGuztiak()+" Puntu");
                postua_3.setText(top3.get(2).getIzena()+" - "+top3.get(2).getBotoGuztiak()+" Puntu");
            }
        }

    }

}
