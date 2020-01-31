package com.neca.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
        Cat cat = new Cat();
        cat.setId(1);
        cat.setName("Micko");
        cat.setColor("grey");

        Configuration config = new Configuration().configure().addAnnotatedClass(Cat.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = (SessionFactory) config.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        Transaction tr = session.beginTransaction();
        
        session.save(cat);
        
        tr.commit();
        
    }
}
