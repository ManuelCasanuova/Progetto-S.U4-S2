package it.ecommerce.classi;

public class Riviste extends CatalogoBibliotecario {
    public Periodicita periodicita;

    public Riviste(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Periodicita= " + periodicita + '\n' +
                "Tipologia= Rivista"
                ;
    }
}
