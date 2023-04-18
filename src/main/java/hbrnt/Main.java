package hbrnt;

import hbrnt.entity.PurchaseList;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;

public class Main
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> criteria = cb.createQuery(PurchaseList.class);
        Root<PurchaseList> root = criteria.from(PurchaseList.class);
        criteria.select(root);
        List<PurchaseList> purchases = session.createQuery(criteria).getResultList();
        purchases.stream().forEach(System.out::println);
        HibernateUtil.shutdown();
    }
}
