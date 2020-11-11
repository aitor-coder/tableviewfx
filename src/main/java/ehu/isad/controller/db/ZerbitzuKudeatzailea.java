package ehu.isad.controller.db;

import ehu.isad.controller.ui.HerrialdeaController;
import ehu.isad.model.ArtistaModel;
import ehu.isad.model.BotoakModel;
import ehu.isad.model.BozkaketaModel;
import ehu.isad.model.HerrialdeModel;
import javafx.scene.image.Image;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ZerbitzuKudeatzailea {
    public ZerbitzuKudeatzailea(){

    }
    public List<HerrialdeModel> eman_herrialde_guztiak()  {
        String sententzia="select izena, bandera from Herrialde;";
        List<HerrialdeModel> herrialde_zerrenda=new ArrayList<>();
        DBKudeatzaile db=DBKudeatzaile.getInstantzia();
        ResultSet erantzuna=db.execSQL(sententzia);
        HerrialdeModel herria = null;
        while (true){
            try {
                if (!erantzuna.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                herria=new HerrialdeModel(erantzuna.getString("izena"),erantzuna.getString("bandera"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println(herria.toString());
            herrialde_zerrenda.add(herria);
        }
        return herrialde_zerrenda;
    }

    public List<ArtistaModel> eman_artista_guztiak(){
        String sententzia="select izena, bandera from Herrialde;";
        List<ArtistaModel> artista_zerrenda=new ArrayList<>();
        DBKudeatzaile db=DBKudeatzaile.getInstantzia();
        ResultSet erantzuna=db.execSQL(sententzia);
        ArtistaModel artista = null;
        while (true){
            try {
                if (!erantzuna.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                artista=new ArtistaModel(erantzuna.getString("izenArtistikoa"),erantzuna.getInt("partaideKop"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println(artista.toString());
            artista_zerrenda.add(artista);
        }
        return artista_zerrenda;
    }

    public List<BozkaketaModel> eman_herrialde_info_guztia(){
        String sententzia="select bandera,artista,herrialdea,abestia from Herrialde,Ordezkaritza where Herrialde.izena=Ordezkaritza.herrialdea order by herrialdea";
        List<BozkaketaModel> bozkaketak=new ArrayList<>();
        DBKudeatzaile db=DBKudeatzaile.getInstantzia();
        ResultSet erantzuna=db.execSQL(sententzia);
        BozkaketaModel b = null;

        while (true){
            try {
                if (!erantzuna.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String bandera= null;
            try {
                bandera = erantzuna.getString("bandera");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String artista= null;
            try {
                artista = erantzuna.getString("artista");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String herrialdea= null;
            try {
                herrialdea = erantzuna.getString("herrialdea");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String abestia= null;
            try {
                abestia = erantzuna.getString("abestia");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            b=new BozkaketaModel(bandera,herrialdea,artista,abestia,0);
            System.out.println(b.toString());
            bozkaketak.add(b);
        }

        return bozkaketak;

    }
    public boolean bozkatu_du(String herria, int urtea){
        String sententzia="select bozkatuDu from Bozkaketa where bozkatuDu='"+herria+"' and urtea='"+urtea+"'";
        DBKudeatzaile db=DBKudeatzaile.getInstantzia();
        ResultSet erantzuna=db.execSQL(sententzia);
        try {
            if (!erantzuna.next()){
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public void sartu_botoak(BotoakModel botoa) {
        String sententzia = "insert into Bozkaketa VALUES ('" + botoa.getBozkatua() + "','" + botoa.getBozkatuDu() + "'," + botoa.getUrtea() + "," + botoa.getPuntuak() + ")";
        DBKudeatzaile db = DBKudeatzaile.getInstantzia();
        ResultSet erantzuna = db.execSQL(sententzia);
    }
    public List<HerrialdeModel> eman_top_3(){
        Calendar c=Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR));
        String sententzia ="select bozkatuaIzanDa,bandera,sum(puntuak) as puntuak from Bozkaketa,Herrialde where izena=bozkatuaIzanDa AND urtea="+c.get(Calendar.YEAR)+" group by bozkatuaIzanDa order by puntuak DESC";
        DBKudeatzaile db=DBKudeatzaile.getInstantzia();
        ResultSet erantzuna=db.execSQL(sententzia);
        List<HerrialdeModel> ranking=new ArrayList<HerrialdeModel>();
        HerrialdeModel herrialdea;

        String bozkatuaIzan="";
        String bandera="";
        Integer puntuak=0;

        while (true){
            try {
                if (!erantzuna.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                bozkatuaIzan=erantzuna.getString("bozkatuaIzanDa");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                bandera=erantzuna.getString("bandera");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                puntuak=erantzuna.getInt("puntuak");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            herrialdea=new HerrialdeModel(bozkatuaIzan,bandera,puntuak);
            ranking.add(herrialdea);
        }
        return ranking;
    }
 }
