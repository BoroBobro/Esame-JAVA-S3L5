package borislavK.entities;

import jakarta.persistence.Entity;

@Entity
public class Rivista extends ElencoCatalogo {

    private Periodicità periodicità;

    public Rivista() {
    }

    public Rivista(String codiceIsbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(codiceIsbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodica() {
        return periodicità;
    }

    public void setPeriodica(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "isbn='" + getCodiceIsbn() + '\'' +
                ", titolo='" + getTitolo() + '\'' +
                ", annoPubblicazione=" + getAnnoPubblicazione() +
                ", numeroPagine=" + getNumeroPagine() +
                ", periodicita=" + periodicità +
                '}';
    }
}
