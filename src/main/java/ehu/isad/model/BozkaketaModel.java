package ehu.isad.model;


import javafx.scene.image.Image;

public class BozkaketaModel {
    Image bandera;
    String herrialdea;
    String artista;
    String abestia;
    Integer puntuak;

    public BozkaketaModel(String bandera, String herrialdea, String artista, String abestia,Integer i) {
        this.bandera = new Image("banderak/"+bandera+".png");
        this.herrialdea = herrialdea;
        this.artista = artista;
        this.abestia = abestia;
        this.puntuak=i;
    }

    @Override
    public String toString() {
        return "BozkaketaModel{" +
                "bandera='" + bandera + '\'' +
                ", herrialdea='" + herrialdea + '\'' +
                ", artista='" + artista + '\'' +
                ", abestia='" + abestia + '\'' +
                ", puntuak=" + puntuak +
                '}';
    }

    public Image getBandera() {
        return bandera;
    }

    public void setBandera(Image bandera) {
        this.bandera = bandera;
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAbestia() {
        return abestia;
    }

    public void setAbestia(String abestia) {
        this.abestia = abestia;
    }

    public Integer getPuntuak() {
        return puntuak;
    }

    public void setPuntuak(Integer puntuak) {
        this.puntuak = puntuak;
    }
}
