public class Bojisko {

    public static void main(String[] args) {
        Kocka kocka = new Kocka(10);

        Bojovnik goro = new Bojovnik("Goro", 100, 20, 10, kocka);
        Mag gandalf = new Mag("Gandalf", 60, 15, 12, kocka, 30, 45);

        Arena arena = new Arena(goro, gandalf, kocka);

        arena.zapas();
    }
}
