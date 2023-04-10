package hbrnt;

import hbrnt.entity.Student;
import org.hibernate.Session;

public class Main
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        HibernateUtil.shutdown();
    }
}
