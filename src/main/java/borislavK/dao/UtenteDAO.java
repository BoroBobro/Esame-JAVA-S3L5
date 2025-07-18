package borislavK.dao;

import borislavK.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(utente);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
