package vn.ute.library.util;
import jakarta.persistence.*;
public final class JPAUtil_24110329 {
    private static final EntityManagerFactory EMF =
        Persistence.createEntityManagerFactory("LibraryPU");
    private JPAUtil_24110329() {}
    public static EntityManager getEntityManager(){ return EMF.createEntityManager(); }
    public static void close(){ if(EMF.isOpen()) EMF.close(); }
}
