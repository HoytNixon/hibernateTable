package hbrnt.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Courses")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", length = 500)
    private String name;
    private int duration;
    @Enumerated(EnumType.STRING)
    private CourseType type;
    @Column(length = 500)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Teacher_ID", referencedColumnName = "id")
    private Teacher teacher;
    @Column(name = "students_count")
    private int studentsCount;
    private int price;
    @Column(name = "price_per_hour")
    @Formula("price / duration")
    private int pricePerHour;
    @OneToMany(mappedBy ="course", cascade = CascadeType.ALL)
    public Set<Subscription> subscriptedStudents = new HashSet<>();
    public Course() {
    }

    public Course(Teacher teacher) {
        this.teacher= teacher;
    }

    public Course(String name, int duration, CourseType type, String description, Teacher teacher, int studentsCount, int price, int pricePerHour) {
        this.name = name;
        this.duration = duration;
        this.type = type;
        this.description = description;
        this.teacher = teacher;
        this.studentsCount = studentsCount;
        this.price = price;
        this.pricePerHour = pricePerHour;
    }

    public Set<Subscription> getStudents() {
        return subscriptedStudents;
    }


    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", teacher=" + teacher +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public CourseType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
