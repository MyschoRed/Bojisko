public class Arena {
    private Bojovnik bojovnikA;
    private Bojovnik bojovnikB;
    private Kocka kocka;

    public Arena(Bojovnik bojovnikA, Bojovnik bojovnikB, Kocka kocka) {
        this.bojovnikA = bojovnikA;
        this.bojovnikB = bojovnikB;
        this.kocka = kocka;
    }

    public void vykresli() {
        System.out.println("__________ Arena __________ \n");
        System.out.print("Bojovnici: \n");
        vypisBojovnika(bojovnikA);
        System.out.println();
        vypisBojovnika(bojovnikB);
        System.out.println();
    }

    private void vypisSpravu(String sprava) {
        System.out.println(sprava);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.err.println("Chyba, nepodarilo sa uspat vlakno!");
        }
    }

    public void zapas() {
        Bojovnik bojovnikA = this.bojovnikA;
        Bojovnik bojovnikB = this.bojovnikB;
        System.out.println("Vitajte v arene!");
        System.out.printf("Dnes sa pobiju proti sebe %s s %s! %n", bojovnikA, bojovnikB);
        boolean zacinaBojovnikB = (kocka.hod()) <= kocka.vratPocetStien() / 2;
        if (zacinaBojovnikB) {
            bojovnikA = this.bojovnikB;
            bojovnikB = this.bojovnikA;
        }
        System.out.printf("Zacinat bude bojovnik %s! %nZapas moze zacat...", bojovnikA);

        while (bojovnikA.jeZivy() && bojovnikB.jeZivy()) {
            bojovnikA.utok(bojovnikB);
            vykresli();
            vypisSpravu(bojovnikA.vratPoslednuSpravu());
            vypisSpravu(bojovnikB.vratPoslednuSpravu());
            if (bojovnikB.jeZivy()) {
                bojovnikB.utok(bojovnikA);
                vykresli();
                vypisSpravu(bojovnikB.vratPoslednuSpravu());
                vypisSpravu(bojovnikA.vratPoslednuSpravu());
            }
            System.out.println();
        }
    }

    private void vypisBojovnika(Bojovnik bojovnik) {
        System.out.println(bojovnik);
        System.out.print("Zivot: ");
        System.out.println(bojovnik.grafickyZivot());
        if (bojovnik instanceof Mag) {
            System.out.print("Mana: ");
            System.out.println(((Mag) bojovnik).grafickaMana());
        }
    }
}
