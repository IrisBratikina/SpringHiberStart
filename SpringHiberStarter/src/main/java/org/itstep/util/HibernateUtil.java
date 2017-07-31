package org.itstep.util;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateUtil {
	private final SessionFactory sessionFactory = buildSessionFactory();
	 
    private SessionFactory buildSessionFactory() {
    	String sep = System.getProperty("file.separator");
    	try {
            return new AnnotationConfiguration().configure(
            		new File("src"+sep+"main"+sep+"java"+sep+
            				"org"+sep+"itstep"+sep+"config"+sep+"hibernate.cgf.xml")).buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public void shutdown() {
    	getSessionFactory().close();
    }
}
