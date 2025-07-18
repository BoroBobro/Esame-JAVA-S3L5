package borislavK.dao;

import borislavK.entities.ElencoCatalogo;
import borislavK.entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ElencoCatalogoDAO {
    private EntityManager em;

    public ElencoCatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(ElencoCatalogo elenco) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(elenco);
            tx.commit();
            System.out.println("Elenco dei prodotti " + elenco.getCodiceIsbn() + "creato con sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ElencoCatalogo findByIsbn(String codiceIsbn) {
        return em.find(ElencoCatalogo.class, codiceIsbn);
    }


    public void findByIsbnAndDelete(String codiceIsbn) {
        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            ElencoCatalogo found = this.findByIsbn(codiceIsbn);
            em.remove(found);
            System.out.println("Catologo cancellato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public List<ElencoCatalogo> findByAnno(int anno) {
        TypedQuery<ElencoCatalogo> query = em.createQuery("SELECT e FROM ElencoCatalogo e WHERE e.annoPubblicazione = :anno", ElencoCatalogo.class);
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    public List<Libro> findByAutore(String autore) {
        TypedQuery<Libro> query = em.createQuery(
                "SELECT l FROM Libro l WHERE l.autore = :autore", Libro.class
        );
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<ElencoCatalogo> findByTitolo(String titoloParziale) {
        TypedQuery<ElencoCatalogo> query = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE LOWER(e.titolo) LIKE LOWER(CONCAT('%', :titolo, '%'))", ElencoCatalogo.class);
        query.setParameter("titolo", titoloParziale);
        return query.getResultList();
    }

}
