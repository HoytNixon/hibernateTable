package hbrnt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name= "Subscriptions")
public class Subscription implements Serializable {
    @Column(name = "subscription_date")
    private Date subscriptionDate = new Date();
    @EmbeddedId
    private SubscriptionKey id;

    @Column(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @Column (name = "course_id", insertable = false, updatable = false)
    private Course course;
    public Subscription() {
    }
    public Date getSubscription_date() {
        return subscriptionDate;
    }

    public void setSubscription_date(Date subscription_date) {
        this.subscriptionDate = subscription_date;
    }

    public SubscriptionKey getId() {
        return id;
    }

}
