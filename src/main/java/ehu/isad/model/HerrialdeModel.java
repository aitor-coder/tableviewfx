package ehu.isad.model;

public class HerrialdeModel {
    String izena;
    String bandera;
    Integer botoGuztiak;

    public HerrialdeModel(String Izena, String Bandera){
        this.izena=Izena;
        this.bandera=Bandera+".png";
    }
    public String toString(){
        return "Herria:{Izena:"+izena+",Bandera:"+bandera+"}";
    }
    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera+".png";
    }

    public Integer getBotoGuztiak() {
        return botoGuztiak;
    }

    public HerrialdeModel(String izena, String bandera, Integer botoGuztiak) {
        this.izena = izena;
        this.bandera = bandera+".png";
        this.botoGuztiak = botoGuztiak;
    }
}
