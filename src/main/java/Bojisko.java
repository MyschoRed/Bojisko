public class Bojisko {

    public static void main(String[] args) {
        Kocka kocka = new Kocka(10);

        Bojovnik goro = new Bojovnik("Goro", 100, 20, 10, kocka);
        Bojovnik shadow = new Bojovnik("Shadow", 100, 18, 12, kocka);

        Arena arena = new Arena(goro, shadow, kocka);

        arena.zapas();
    }
}
