package ehu.isad.model;

public class BotoakModel {
    String bozkatua;
    String bozkatuDu;
    Integer urtea;
    Integer puntuak;

    public BotoakModel(String bozkatua, String bozkatuDu, Integer urtea, Integer puntuak) {
        this.bozkatua = bozkatua;
        this.bozkatuDu = bozkatuDu;
        this.urtea = urtea;
        this.puntuak = puntuak;
    }

    public String getBozkatua() {
        return bozkatua;
    }

    public String getBozkatuDu() {
        return bozkatuDu;
    }

    public Integer getUrtea() {
        return urtea;
    }

    public Integer getPuntuak() {
        return puntuak;
    }
}
