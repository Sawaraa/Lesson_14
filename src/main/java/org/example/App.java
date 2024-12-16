package org.example;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main( String[] args ) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Cart cart = new Cart(2);
        Item item = new Item(7, "cokie");
        Item item2 = new Item(2, "water");
        session.persist(item);
        session.persist(item2);
        cart.setItems(new HashSet<>(Arrays.asList(item,item2)));
        session.persist(cart);
//        Cart cart2 = (Cart) session.get(Cart.class, 1);
//        Item item2 = (Item) session.get(Item.class, 1);
//        System.out.println(cart2);
//        System.out.println(item2);
//		Person person = new Person("Andrew", "Horlovych", 35);
//		Car car = new Car("Tesla");
//		Car car2 = new Car("Audi");
//		person.setCars(new HashSet<>(Arrays.asList(car, car2)));
//		session.persist(person);

        transaction.commit();
        session.close();


    }
}
