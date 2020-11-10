package ehu.isad.model;

public class ArtistaModel {
    String izen_artistikoa;
    Integer partaide_kop;


    public ArtistaModel (String Izena,Integer i){
        this.izen_artistikoa=Izena;
        if (i==null){
            this.partaide_kop=0;
        }
        else {
            this.partaide_kop=i;
        }
    }

    public String getIzena() {
        return izen_artistikoa;
    }

    public void setIzena(String izena) {
        this.izen_artistikoa = izena;
    }

    public Integer getPartaide_kop() {
        return partaide_kop;
    }

    public void setPartaide_kop(Integer partaide_kop) {
        this.partaide_kop = partaide_kop;
    }

    @Override
    public String toString() {
        return "ArtistaModel{" +
                "izena='" + izen_artistikoa + '\'' +
                ", partaide_kop=" + partaide_kop +
                '}';
    }
}
