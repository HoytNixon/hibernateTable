package hbrnt.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class PurchaseList implements Serializable {
    @EmbeddedId
    private PurchaseListCompositeKey id;
    @Column(name= "student_name", length = 500, insertable = false, updatable = false)
    private Student student;
    @Column(name= "course_name", length = 500, insertable = false, updatable = false)
    private Course course;

    @Override
    public String toString() {
        return "PurchaseList{" +
                "course=" + course +
                ", price=" + price +
                ", subscriptionDate=" + subscriptionDate +
                '}';
    }

    @Basic(fetch = FetchType.LAZY)
    private int price ;
    @Basic(fetch = FetchType.LAZY)
    @Temporal(TemporalType.DATE)
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public PurchaseList() {
    }

    public PurchaseListCompositeKey getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
