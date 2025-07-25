package borislavK.entities;

import jakarta.persistence.Entity;

@Entity
public class Libro extends ElencoCatalogo {
    private String autore;
    private String genere;


    public Libro() {
    }

    public Libro(String codiceIsbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(codiceIsbn, titolo, annoPubblicazione, numeroPagine);
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
        return "Libro{" +
                "isbn='" + getCodiceIsbn() + '\'' +
                ", titolo='" + getTitolo() + '\'' +
                ", annoPubblicazione=" + getAnnoPubblicazione() +
                ", numeroPagine=" + getNumeroPagine() +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
