package borislavK;

import borislavK.dao.ElencoCatalogoDAO;
import borislavK.dao.PrestitiDAO;
import borislavK.dao.UtenteDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Elenco");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        ElencoCatalogoDAO catalogoDAO = new ElencoCatalogoDAO(em);
        PrestitiDAO prestitiDAO = new PrestitiDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
    }
}
