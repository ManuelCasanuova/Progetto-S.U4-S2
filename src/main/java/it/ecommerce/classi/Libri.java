package it.ecommerce.classi;

public class Libri extends CatalogoBibliotecario{
    private String autore;
    private String genere;

    public Libri(String ISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return super.toString()  +
                "Autore= " + autore + '\n' +
                "Genere= " + genere + '\n' +
                "Tipologia= Libro"
                ;
    }
}
