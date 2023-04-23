package hbrnt;

import hbrnt.entity.*;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class Main
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        // Здесь заполняется табоица LinkedPurchaseList!!!
//        CriteriaQuery<PurchaseList> criteria = cb.createQuery(PurchaseList.class);
//        Root<PurchaseList> root = criteria.from(PurchaseList.class);
//        criteria.select(root);
//        List<PurchaseList> purchases = session.createQuery(criteria).getResultList();
//        purchases.stream().forEach(p-> session.persist(new LinkedPurchaseList(p.getStudent(), p.getCourse())));

        // Здесь добавляем нового студента к существующему курсу
//        Student student = new Student("Перепчук Дмитрий", 18);
//        session.persist(student);
//        Course first =session.get(Course.class,2);
//        Subscription ss= new Subscription(new Date(),student,first);
//        session.persist(ss);

        // Здесь удаляем студента
        CriteriaQuery<Student> criteria = cb.createQuery(Student.class);
        Root<Student> root = criteria.from(Student.class);
        criteria.select(root).
                where(cb.equal(
                        root.<String>get("name"),
                        "Перепчук Дмитрий")
                );
        Student dima = session.createQuery((criteria)).getSingleResult();
        session.remove(dima);
        session.flush();


        //Сабскрипшен удалился вместе с удалением студента, поэтому в коде ниже ошибка
//        CriteriaQuery<Subscription> s = cb.createQuery(Subscription.class);
//        Root <Subscription> r= s.from(Subscription.class);
//        s.select(r).
//                where(cb.equal(
//                        r.get("student"),
//                        dima
//                ));
//        Subscription sub = session.createQuery((s)).getSingleResult();

        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
