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
    private SubscriptionKey id= new SubscriptionKey();
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;
    public Subscription() {
    }

    public Subscription(Date subscriptionDate, Student studen, Course cours) {
        this.subscriptionDate = subscriptionDate;
        this.student = studen;
        this.course = cours;
        this.id.courseId=cours.getId();
        this.id.studentId = studen.getId();
        course.getStudents().add(this);
        student.subscriptedCourses.add(this);

    }

    public Date getSubscription_date() {
        return subscriptionDate;
    }

    public void setSubscription_date(Date subscription_date) {
        this.subscriptionDate = subscription_date;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public SubscriptionKey getId() {
        return id;
    }

}
