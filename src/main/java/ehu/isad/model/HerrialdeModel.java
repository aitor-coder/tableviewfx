package ehu.isad.model;

public class HerrialdeModel {
    String izena;
    String bandera;


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


}
