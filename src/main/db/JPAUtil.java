package main.db;



import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//singleton
public class JPAUtil {

    private static final EntityManagerFactory emf;

    //factory initialization
    static {
        emf= Persistence.createEntityManagerFactory("NewPersistenceUnit");
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}
