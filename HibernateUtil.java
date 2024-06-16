package pbouas;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    // Field untuk menyimpan SessionFactory
    private static SessionFactory sessionFactory;

    // Blok statis untuk menginisialisasi SessionFactory
    static {
        try {
            // Membuat SessionFactory dari hibernate.cfg.xml
            setSessionFactory(new Configuration().configure().buildSessionFactory());
        } catch (Throwable ex) {
            // Mencatat kesalahan jika pembuatan SessionFactory gagal
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Metode untuk mendapatkan SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Metode untuk mengatur SessionFactory
    public static void setSessionFactory(SessionFactory aSessionFactory) {
        sessionFactory = aSessionFactory;
    }
}
