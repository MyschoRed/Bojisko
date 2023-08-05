public class Bojovnik {
    protected String meno;
    protected int zivot;
    protected int maximalnyZivot;
    protected int utok;
    protected int obrana;
    protected Kocka kocka;
    private String sprava;

    public Bojovnik(String meno, int zivot, int utok, int obrana, Kocka kocka) {
        this.meno = meno;
        this.zivot = zivot;
        this.maximalnyZivot = zivot;
        this.utok = utok;
        this.obrana = obrana;
        this.kocka = kocka;
    }

    @Override
    public String toString() {
        return meno;
    }

    public boolean jeZivy() {
        return zivot > 0;
    }

    protected String grafickyUkazovatel(int aktualny, int maximalny) {
        String grafickyZivot = "[";
        int celkom = 20;
        double pocetDielikov = Math.round(((double) aktualny / maximalny) * celkom);
        if ((pocetDielikov == 0) && (jeZivy())) {
            pocetDielikov = 1;
        }
        for (int i = 0; i < pocetDielikov; i++) {
            grafickyZivot += "█";
        }
        for (int i = 0; i < celkom - pocetDielikov; i++) {
            grafickyZivot += " ";
        }
        grafickyZivot += "]";
        return grafickyZivot;
    }

    public String grafickyZivot() {
        return grafickyUkazovatel(zivot, maximalnyZivot);
    }

    public void branSa(int uder) {
        int zranenie = uder - (obrana + kocka.hod());
        if (zranenie > 0) {
            zivot -= zranenie;
            sprava = String.format("%s utrpel poskodenie %s HP", meno, zranenie);
            if (zivot <= 0) {
                zivot = 0;
                sprava += " a zomrel";
            }
        } else {
            sprava = String.format("%s odrazil utok", meno);
        }
        nastavSpravu(sprava);
    }

    public void utok(Bojovnik nepriatel) {
        int uder = utok + kocka.hod();
        nastavSpravu(String.format("%s utoci s uderom za %s HP", meno, uder));
        nepriatel.branSa(uder);
    }

    protected void nastavSpravu(String sprava) {
        this.sprava = sprava;
    }

    public String vratPoslednuSpravu() {
        return sprava;
    }
}
