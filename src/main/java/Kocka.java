import java.util.Random;

public class Kocka {
    private int pocetStien;
    private Random random = new Random();

    public Kocka() {
        pocetStien = 6;
        random = new Random();
    }

    public Kocka(int pocetStien) {
        this.pocetStien = pocetStien;
        random = new Random();
    }

    public int vratPocetStien() {
        return pocetStien;
    }

    /**
     * Vykona hod kockou
     * @return Cislo od 1 do pocetStien
     */
    public int hod(){
        return random.nextInt(pocetStien) + 1;
    }

    @Override
    public String toString() {
        return String.format("Kocka s %s stenami", pocetStien);
    }
}
