package it.ecommerce.classi;

public class Riviste extends CatalogoBibliotecario {
    public Periodicita periodicita;

    public Riviste(String ISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
}
