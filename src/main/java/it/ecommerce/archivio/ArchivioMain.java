package it.ecommerce.archivio;

import it.ecommerce.classi.*;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ArchivioMain {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        CatalogoHelper catalogoHelper = new CatalogoHelper();
        Archivio archivio = new Archivio();
        archivio.getCatalogo().addAll(catalogoHelper.getCatalogo());

        System.out.println("************************************************");
        System.out.println("Benvenuto nell'archivio bibliotecario di Manuel!");
        System.out.println("************************************************");
        System.out.println("");

        while (true) {
            System.out.println("Vuoi visualizzare il catalogo? inserisci 1 per SI, 2 per NO");
            int visualizzaCatalogo = scanner.nextInt();
            scanner.nextLine();
            if (visualizzaCatalogo == 1) {
                archivio.stampaCatalogo();;
            }

            System.out.println("");
            System.out.println("Seleziona dal menù sottostante una delle seguenti opzioni:");
            System.out.println("\n1. Aggiungi un nuovo elemento all'archivio bibliotecario\n2. Cerca un libro o una rivista tramite ISBN\n3. Rimuovi un libro o una rivista tramite ISBN\n4. Ricerca libro o rivista per anno\n5. Ricerca libro o rivista per autore\n6. Aggiorna un libro o una rivista tramite ISBN\n7. Stampa le statistiche\n0. Esci");
            System.out.println("");
            int scelta= scanner.nextInt();
            scanner.nextLine();

            switch (scelta){
                case 1:
                    System.out.println("");
                    System.out.println("Aggiunta di un nuovo elemento");
                    System.out.println("");
                    System.out.println("Scegli 1 per inserire un nuovo libro, oppure 2 per una rivista");
                    int selezione= scanner.nextInt();
                    scanner.nextLine();
                            if(selezione==1){
                                System.out.println("");
                                System.out.println("Inserisci l'ISBN del libro");
                                String isbn = scanner.nextLine();
                                System.out.println("Inserisci il titolo del libro");
                                String titolo = scanner.nextLine();
                                System.out.println("Inserisci l'anno di pubblicazione del libro");
                                int annoPubblicazione = scanner.nextInt();
                                System.out.println("Inserisci il numero di pagine del libro");
                                int numeroPagine = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Inserisci l'autore del libro");
                                String autore = scanner.nextLine();
                                System.out.println("Inserisci il genere del libro");
                                String genere = scanner.nextLine();
                                archivio.aggiungiElemento(new Libri(isbn, titolo, annoPubblicazione, numeroPagine, autore, genere));
                                System.out.println("");
                            }else if(selezione==2) {
                                System.out.println("");
                                System.out.println("Inserisci l'ISBN della rivista");
                                String isbn = scanner.nextLine();
                                System.out.println("Inserisci il titolo della rivista");
                                String titolo = scanner.nextLine();
                                System.out.println("Inserisci l'anno di pubblicazione della rivista");
                                int annoPubblicazione = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Inserisci il numero di pagine della rivista");
                                int numeroPagine = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Inserisci la periodicità della rivista");
                                System.out.println("Seleziona \n1 per SETTIMANALE\n2 per MENSILE\n3 per SEMESTRALE");
                                int sceltaPeriodicita = scanner.nextInt();
                                scanner.nextLine();
                                Periodicita periodicita = sceltaPeriodicita == 1 ? Periodicita.SETTIMANALE : sceltaPeriodicita == 2 ? Periodicita.MENSILE : Periodicita.SEMESTRALE;
                                archivio.aggiungiElemento(new Riviste(isbn, titolo, annoPubblicazione, numeroPagine, periodicita));
                                System.out.println("");
                            }else{
                                System.out.println("Scelta non valida");
                            }
                            break;


                case 2:
                                System.out.println("Ricerca di un libro o di una rivista");
                                System.out.println("Inserisci l'ISBN");
                                String isbn = scanner.nextLine();
                                System.out.println("");
                                System.out.println("Elemento con ISBN " + isbn + " ricercato è: " + archivio.ricercaPerISBN(isbn));
                                System.out.println("");
                                break;
                case 3:
                                System.out.println("Rimozione di un libro o di una rivista");
                                System.out.println("Inserisci l'ISBN");
                                isbn = scanner.nextLine();
                                archivio.rimuoviElemento(isbn);
                                System.out.println("");
                                System.out.println("Elemento con ISBN " + isbn + " rimosso con successo");
                                System.out.println("");

                                break;
                case 4:
                                System.out.println("Ricerca di un libro o di una rivista per anno");
                                System.out.println("Inserisci l'anno");
                                int anno = scanner.nextInt();
                                System.out.println("");
                                System.out.println("Elementi con anno di pubblicazione " + anno + ":" + archivio.ricercaPerAnno(anno));
                                System.out.println("");
                                break;
                case 5:
                                System.out.println("Ricerca di un libro o di una rivista per autore");
                                System.out.println("Inserisci l'autore");
                                String autore = scanner.nextLine();
                                System.out.println("");
                                System.out.println("Elementi con autore " + autore + ":" + archivio.ricercaPerAutore(autore));
                                System.out.println("");

                                break;

                case 6:
                                System.out.println("Aggiornamento di un libro o di una rivista");
                                System.out.println("Inserisci l'ISBN");
                                isbn = scanner.nextLine();
                                Object elemento = archivio.ricercaPerISBN(isbn);
                                if(elemento == null){
                                    throw new Exception("Elemento con ISBN " + isbn + " non trovato");
                                }else {

                                    if (archivio.ricercaPerISBN(isbn) instanceof Libri) {
                                        System.out.println("Aggiorna il titolo del libro");
                                        String titolo = scanner.nextLine();
                                        System.out.println("Aggiorna l'anno di pubblicazione del libro");
                                        int annoPubblicazione = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Aggiorna il numero di pagine del libro");
                                        int numeroPagine = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Aggiorna l'autore del libro");
                                        autore = scanner.nextLine();
                                        System.out.println("Aggiorna il genere del libro");
                                        String genere = scanner.nextLine();
                                        archivio.aggiornaElemento(isbn, new Libri(isbn, titolo, annoPubblicazione, numeroPagine, autore, genere));

                                    } else if (archivio.ricercaPerISBN(isbn) instanceof Riviste) {
                                        System.out.println("Aggiorna il titolo della rivista");
                                        String titolo = scanner.nextLine();
                                        System.out.println("Aggiorna l'anno di pubblicazione della rivista");
                                        int annoPubblicazione = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Aggiorna il numero di pagine della rivista");
                                        int numeroPagine = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Inserisci la periodicità della rivista");
                                        System.out.println("Seleziona \n1 per SETTIMANALE\n2 per MENSILE\n3 per SEMESTRALE");
                                        int sceltaPeriodicita = scanner.nextInt();
                                        scanner.nextLine();
                                        Periodicita periodicita = sceltaPeriodicita == 1 ? Periodicita.SETTIMANALE : sceltaPeriodicita == 2 ? Periodicita.MENSILE : Periodicita.SEMESTRALE;
                                            archivio.aggiornaElemento(isbn,new Riviste(isbn, titolo, annoPubblicazione, numeroPagine, periodicita));

                                    } else {
                                        System.out.println("Scelta non valida");
                                    }
                                    break;
                                }
                case 7:
                                System.out.println("Stampa delle statistiche");
                                archivio.stampaStatistiche();
                                break;
                case 0:
                                System.out.println("Grazie di aver visistato l'archivio bibliotecario di Manuel, arrivederci!");
                                return;
                default:
                    System.out.println("Scelta non valida.");

            }

        }


    }
}
