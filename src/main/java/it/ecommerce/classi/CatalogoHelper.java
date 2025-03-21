package it.ecommerce.classi;

import java.util.ArrayList;
import java.util.List;

public class CatalogoHelper {

public static List <CatalogoBibliotecario> catalogo = new ArrayList<>(List.of(
 new Libri("1", "Il Signore degli Anelli", 1954, 1234, "JRR Tolkien", "Fantasy"),
 new Libri( "2", "Gli Indifferenti", 1929, 234, "Alberto Moravia", "Dramatic"),
 new Libri("3", "La Divina Commedia", 475, 234, "Dante Alighieri", "Letteratura"),
 new Libri("4", "Il Gattopardo", 1958, 234, "Giuseppe Tomasi di Lampedusa", "Storico"),
 new Riviste("5", "Giornale della Scienza", 2010, 234, Periodicita.SETTIMANALE),
 new Riviste("6", "Giornale della Politica", 2010, 234, Periodicita.MENSILE),
 new Riviste("7", "Giornale dei Sport", 2010, 234, Periodicita.SEMESTRALE),
 new Riviste("8", "Giornale della Cultura", 2010, 234, Periodicita.SETTIMANALE)
    ));

 public static List<CatalogoBibliotecario> getCatalogo() {
  return catalogo;
 }

}
