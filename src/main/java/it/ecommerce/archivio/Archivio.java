package it.ecommerce.archivio;

import it.ecommerce.classi.CatalogoBibliotecario;
import it.ecommerce.classi.CatalogoHelper;
import it.ecommerce.classi.Libri;
import it.ecommerce.classi.Riviste;

import java.util.ArrayList;
import java.util.List;

public class Archivio {
    List<CatalogoBibliotecario> catalogo = new ArrayList<>();

    public void aggiungiElemento (CatalogoBibliotecario elemento) {
        try {
            if(catalogo.stream().anyMatch(e -> e.getIsbn().equals(elemento.getIsbn()))) {
                throw new Exception("ISBN già presente nel catalogo, impossibile aggiungere nuovamente.");

            }
            catalogo.add(elemento);
            System.out.println("Elemento creato correttamente");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public CatalogoBibliotecario ricercaPerISBN(String isbn) throws Exception {
       try {
           return catalogo.stream()
                   .filter(elemento -> elemento.getIsbn().equals(isbn))
                   .findFirst()
                   .get();

       } catch (Exception e) {
           System.out.println("Errore: Elemento con ISBN " + isbn + " non trovato");
           return null;
       }

    }

   public void rimuoviElemento (String isbn) {
       catalogo.removeIf(elemento->elemento.getIsbn().equals(isbn));
   }

    public List<CatalogoBibliotecario> ricercaPerAnno(int anno) {
        return catalogo.stream()
                .filter(elemento -> elemento.getAnnoPubblicazione() == anno)
                .toList();
    }

   public List<Libri> ricercaPerAutore(String autore) {
       return catalogo.stream()
               .filter(elemento -> elemento instanceof Libri)
               .map(elemento -> (Libri) elemento)
               .filter(elemento -> elemento.getAutore().equals(autore))
               .toList();
   }

   public void aggiornaElemento(String isbn, CatalogoBibliotecario nuovoElemento) throws Exception {
       if (catalogo.stream().anyMatch(e -> e.getIsbn().equals(nuovoElemento.getIsbn()) && !e.getIsbn().equals(isbn))) {
           throw new Exception("ISBN già presente nel catalogo, impossibile aggiornare con questo ISBN.");
       }
        for (int i = 0; i < catalogo.size(); i++) {
            if (catalogo.get(i).getIsbn().equals(isbn)) {
                catalogo.set(i, nuovoElemento);
                System.out.println("Elemento aggiornato con successo");
                System.out.println(catalogo.get(i));
                return;
            }
        }
        throw new Exception("Elemento con ISBN " + isbn + " non trovato");
   }

   public void stampaStatistiche() {
        long numeroLibri = catalogo.stream()
                .filter(elemento -> elemento instanceof Libri)
                .count();

        long numeroRiviste = catalogo.stream()
                .filter(elemento -> elemento instanceof Riviste)
                .count();

        CatalogoBibliotecario maxPagine = catalogo.stream()
                .max((elemento1, elemento2) -> elemento1.getNumeroPagine() - elemento2.getNumeroPagine())
                .orElse(null);

        double mediaPagine = catalogo.stream()
                .mapToInt(elemento -> elemento.getNumeroPagine())
                .average()
                .orElse(0.0);
       System.out.println("");
       System.out.println("Numero di libri: " + numeroLibri);
       System.out.println("Numero di riviste: " + numeroRiviste);
       System.out.println("Elemento con più pagine: " + (maxPagine != null ? maxPagine.getTitolo() : "Nessuno"));
       System.out.println("Media pagine: " + mediaPagine);
       System.out.println("");
   }

   public void stampaCatalogo() {
        if(catalogo.isEmpty()) {
            System.out.println("Il catalogo è al momento vuoto.");
        } else {
            System.out.println("Catalogo:");
            catalogo.forEach(elemento -> System.out.println(elemento));
            }
        }

    public List<CatalogoBibliotecario> getCatalogo() {
        return catalogo;
    }
}



