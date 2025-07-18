package borislavK.dao;

import borislavK.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class PrestitiDAO {
    private final EntityManager em;

    public PrestitiDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Prestito prestito) {
        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(prestito);
            tx.commit();
            System.out.println("Prestito" + prestito.getId() + "registrato");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Prestito> findPrestitoAttivoPerUtente(String numeroTessera) {
        TypedQuery<Prestito> query = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :tessera AND p.dataRestituzioneEffettiva IS NULL",
                Prestito.class
        );
        query.setParameter("tessera", numeroTessera);
        return query.getResultList();
    }

    public List<Prestito> findPrestitoScadutoEnonRestituiro() {
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL AND p.dataRestituzionePrevista < :oggi", Prestito.class);
        query.setParameter("oggi", LocalDate.now());
        return query.getResultList();
    }
}
