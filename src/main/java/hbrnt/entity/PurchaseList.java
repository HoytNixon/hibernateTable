package hbrnt.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class PurchaseList implements Serializable {
    @EmbeddedId
    private PurchaseListCompositeKey id;
    @Column(name= "student_name", length = 500, insertable = false, updatable = false)
    private String student;
    @Column(name= "course_name", length = 500, insertable = false, updatable = false)
    private String course;
    private int price ;
    @Temporal(TemporalType.DATE)
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public PurchaseList() {
    }

}
