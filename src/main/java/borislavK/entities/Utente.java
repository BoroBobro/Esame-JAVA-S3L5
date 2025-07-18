package borislavK.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String cognome;
    private LocalDate dataNascita;

    @Column(unique = true)
    private String numeroTessara;


    public Utente() {
    }

    public Utente(long id, String nome, String cognome, LocalDate dataNascita, String numeroTessara) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroTessara = numeroTessara;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getNumeroTessara() {
        return numeroTessara;
    }

    public void setNumeroTessara(String numeroTessara) {
        this.numeroTessara = numeroTessara;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", numeroTessara='" + numeroTessara + '\'' +
                '}';
    }
}
