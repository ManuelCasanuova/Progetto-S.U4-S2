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
            System.err.println("Errore nell'aggiunta dell'elemento: " + e.getMessage());
        }
    }

    public CatalogoBibliotecario ricercaPerISBN(String isbn) {
        try {
            return catalogo.stream()
                    .filter(elemento -> elemento.getIsbn().equals(isbn))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Elemento con ISBN " + isbn + " non trovato"));
        } catch (Exception e) {

            return null;
        }
    }

   public void rimuoviElemento (String isbn) {
       try {
           boolean removed = catalogo.removeIf(elemento->elemento.getIsbn().equals(isbn));

           if (!removed) {
               throw new Exception("Elemento con ISBN " + isbn + " non trovato, impossibile rimuoverlo.");
           }else {
               System.out.println("Elemento con ISBN " + isbn + " rimosso con successo.");
           }

       } catch (Exception e) {
           System.err.println("Errore nella rimozione dell'elemento: " + e.getMessage());
       }
   }

    public List<CatalogoBibliotecario> ricercaPerAnno(int anno) {
        try {
            List<CatalogoBibliotecario> risultato = catalogo.stream()
                    .filter(elemento -> elemento.getAnnoPubblicazione() == anno)
                    .toList();
            if (risultato.isEmpty()) {
                throw new Exception("Nessun elemento trovato per l'anno " + anno);
            }
            return risultato;
        } catch (Exception e) {
            System.err.println("Errore nella ricerca per anno: " + e.getMessage());
            return new ArrayList<>();
        }
    }

   public List<Libri> ricercaPerAutore(String autore) {
       try {
           List<Libri> risultato = catalogo.stream()
                   .filter(elemento -> elemento instanceof Libri)
                   .map(elemento -> (Libri) elemento)
                   .filter(elemento -> elemento.getAutore().equals(autore))
                   .toList();
           if(risultato.isEmpty()) {
               throw new Exception("Nessun libro trovato per l'autore " + autore);
           }
           return risultato;

       } catch (Exception e) {
           System.err.println("Errore nella ricerca per autore: " + e.getMessage());
           return new ArrayList<>();
       }
   }

   public void aggiornaElemento(String isbn, CatalogoBibliotecario nuovoElemento) throws Exception {
       try {
           if (catalogo.stream().anyMatch(e -> e.getIsbn().equals(nuovoElemento.getIsbn()) && !e.getIsbn().equals(isbn))) {
               throw new Exception("ISBN già presente nel catalogo, impossibile aggiornare con questo ISBN.");
           }
           for (int i = 0; i < catalogo.size(); i++) {
               if (catalogo.get(i).getIsbn().equals(isbn)) {
                   catalogo.set(i, nuovoElemento);
                   System.out.println("Elemento aggiornato con successo: " + catalogo.get(i));
                   return;
               }
           }
           throw new Exception("Elemento con ISBN " + isbn + " non trovato");
       } catch (Exception e) {
           System.err.println("Errore nell'aggiornamento dell'elemento: " + e.getMessage());
       }
   }

   public void stampaStatistiche() {
       try {
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
       } catch (Exception e) {
           System.err.println("Errore nell'aggiornamento dell'elemento: " + e.getMessage());
       }
   }

    public void stampaCatalogo() {
        try {
            if (catalogo.isEmpty()) {
                System.out.println("Il catalogo è al momento vuoto.");
            } else {
                System.out.println("Catalogo:");
                catalogo.forEach(elemento -> System.out.println(elemento));
            }
        } catch (Exception e) {
            System.err.println("Errore nella stampa del catalogo: " + e.getMessage());
        }
    }

    public List<CatalogoBibliotecario> getCatalogo() {
        return catalogo;
    }
}



