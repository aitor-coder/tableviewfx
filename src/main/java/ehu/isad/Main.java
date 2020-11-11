package ehu.isad;

import ehu.isad.controller.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent mainUI;
  private Parent herrialdeakUI;
  private Parent bozkaketaUI;
  private Parent erroreaUI;
  private Parent rankingUI;


  private Stage stage;


  private Scene hasieraScene;
  private Scene herrialdeScene;
  private Scene bozkaketaScene;
  private Scene erroreaScene;
  private Scene rankingScene;

  private HasieraController hasieraController;
  private HerrialdeaController herrialdeaController;
  private AukeratuController aukeratuController;
  private ErroreaController erroreaController;
  private RankingController rankingController;
//  private StudentsController studentsController;


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Taula Demo");
    stage.setScene(hasieraScene);
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

//    FXMLLoader loaderKautotu = new FXMLLoader(getClass().getResource("/tableview.fxml"));
//    mainUI = (Parent) loaderKautotu.load();
//    studentsController = loaderKautotu.getController();
//    studentsController.setMainApp(this);

    FXMLLoader loaderHasiera=new FXMLLoader(getClass().getResource("/hasiera.fxml"));
    mainUI=loaderHasiera.load();
    hasieraController=loaderHasiera.getController();
    hasieraController.setMainApp(this);
    hasieraScene=new Scene(mainUI);

    FXMLLoader loaderAukerak=new FXMLLoader(getClass().getResource("/aukeraketak.fxml"));
    herrialdeakUI=loaderAukerak.load();
    aukeratuController=loaderAukerak.getController();
    aukeratuController.setMainApp(this);
    herrialdeScene=new Scene(herrialdeakUI);

    FXMLLoader loaderEurobisio=new FXMLLoader(getClass().getResource("/herrialdeak.fxml"));
    bozkaketaUI=loaderEurobisio.load();
    herrialdeaController=loaderEurobisio.getController();
    herrialdeaController.setMainApp(this);
    bozkaketaScene=new Scene(bozkaketaUI);

    FXMLLoader loaderErrorea=new FXMLLoader(getClass().getResource("/errorea.fxml"));
    erroreaUI=(Parent) loaderErrorea.load();
    erroreaController=loaderErrorea.getController();
    erroreaController.setMainApp(this);
    erroreaScene=new Scene(erroreaUI);

    FXMLLoader loaderRanking=new FXMLLoader(getClass().getResource("/ranking.fxml"));
    rankingUI=(Parent) loaderRanking.load();
    rankingController=loaderRanking.getController();
    rankingController.setMainApp(this);
    rankingScene=new Scene(rankingUI);



  }


  public static void main(String[] args) {
    launch(args);
  }

  public void mainErakutsi() {
    stage.setScene(hasieraScene);
    stage.show();
  }
  public void herrialdeaErakutsi(){
    stage.setScene(herrialdeScene);
    stage.show();
  }
  public void bozkaketaErakutsi(String herria){
    stage.setScene(bozkaketaScene);
    herrialdeaController.herrialdeaEzarri(herria);
    stage.show();
  }
  public void erroreaErakutsi(String herria){
    stage.setScene(erroreaScene);
    erroreaController.mezuaJarri(herria);
    stage.show();
  }
  public void rankingErakutsi(){
    stage.setScene(rankingScene);
    rankingController.eman_rankinga();
    stage.show();
  }
}