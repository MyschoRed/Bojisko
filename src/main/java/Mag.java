public class Mag extends Bojovnik {
    private int mana;
    private int maximalnaMana;
    private int magickyUtok;

    public Mag(String meno, int zivot, int utok, int obrana, Kocka kocka, int mana, int magickyUtok) {
        super(meno, zivot, utok, obrana, kocka);
        this.mana = mana;
        this.maximalnaMana = mana;
        this.magickyUtok = magickyUtok;
    }

    @Override
    public void utok(Bojovnik nepriatel) {
        if (mana < maximalnaMana) {
            mana += 10;
            if (mana > maximalnaMana) {
                mana = maximalnaMana;
            }
            super.utok(nepriatel);
        } else {
            int uder = magickyUtok + kocka.hod();
            nastavSpravu(String.format("%s pouzil magiu za %s HP", meno, uder));
            nepriatel.branSa(uder);
            mana = 0;
        }
    }

    public String grafickaMana() {
        return grafickyUkazovatel(mana, maximalnaMana);
    }
}
