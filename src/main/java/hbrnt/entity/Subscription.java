package hbrnt.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name= "Subscriptions")
public class Subscription implements Serializable {
    @Column(name = "subscription_date")
    private Date subscriptionDate = new Date();
    @EmbeddedId
    private SubscriptionKey id;

    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;
    public Subscription() {
    }

    public Subscription(Date subscriptionDate, Student student, Course course) {
        this.subscriptionDate = subscriptionDate;
        this.student = student;
        this.course = course;
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
