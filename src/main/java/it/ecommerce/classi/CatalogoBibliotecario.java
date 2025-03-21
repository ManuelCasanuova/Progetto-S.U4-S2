package it.ecommerce.classi;

public abstract class CatalogoBibliotecario {
    private String isbn;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    public CatalogoBibliotecario(String isbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return
                "\n" +
                "ISBN= " + isbn + '\n' +
                "Titolo= " + titolo + '\n' +
                "Anno di pubblicazione= " + annoPubblicazione + '\n' +
                "Numero delle Pagine= " + numeroPagine + '\n'
                ;
    }
}
