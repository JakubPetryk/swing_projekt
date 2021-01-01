


public class Wypozyczenia {

    private String imie;
    private String nazwisko;
    private String nazwa;
    private String dlugosc_wypozyczenia;
    private double cena;


    public Wypozyczenia(String imie, String nazwisko, String nazwa, String dlugosc_wypozyczenia, int cena) {


        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nazwa = nazwa;
        this.dlugosc_wypozyczenia = dlugosc_wypozyczenia;
        this.cena = cena;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getDlugosc_wypozyczenia() {
        return dlugosc_wypozyczenia;
    }

    public void setDlugosc_wypozyczenia(String dlugosc_wypozyczenia) {
        this.dlugosc_wypozyczenia = dlugosc_wypozyczenia;
    }

    public double getCena() {

        return cena;
    }

    public void setCena(double cena) {

        this.cena = cena;
    }

}
