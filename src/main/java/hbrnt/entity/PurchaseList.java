package hbrnt.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class PurchaseList implements Serializable {
    @Embeddable
    public static class Id implements Serializable{

        @Column(name = "student_name",length = 500)
        protected String studentName;
        @Column(name = "course_name",length = 500)
        protected String courseName;
        public Id() {
        }

        public Id(String studentName, String courseName){
            this.courseName=courseName;
            this.studentName= studentName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Id id)) return false;

            if (!studentName.equals(id.studentName)) return false;
            return courseName.equals(id.courseName);
        }

        @Override
        public int hashCode() {
            int result = studentName.hashCode();
            result = 31 * result + courseName.hashCode();
            return result;
        }

    }
    @EmbeddedId
    private Id id = new Id();
    @ManyToOne()
    @JoinColumn (name= "student_name",insertable = false, updatable = false, referencedColumnName="name")
    private Student student;
    @ManyToOne()
    @JoinColumn (name= "course_name",insertable = false, updatable = false,referencedColumnName="name")
    private Course course;
    @Basic(fetch = FetchType.LAZY)
    private int price ;

    @Basic(fetch = FetchType.LAZY)
    @Temporal(TemporalType.DATE)
    @Column(name = "subscription_date")
    private Date subscriptionDate= new Date();

    public PurchaseList() {
    }
    public PurchaseList(Student student, Course course, int price) {
        this.student = student;
        this.course = course;
        this.price=price;
        this.id.studentName= student.getName();
        this.id.courseName= course.getName();
    }

    public Id getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public void setId(Id id) {
        this.id = id;
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

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "PurchaseList{" +
                "course=" + course +
                ", price=" + price +
                ", subscriptionDate=" + subscriptionDate +
                '}';
    }
}
