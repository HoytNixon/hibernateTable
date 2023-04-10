package hbrnt.entity;

import jakarta.persistence.*;

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
    private String courseName;
    private int duration;
    @Enumerated(EnumType.STRING)
    private CourseType type;
    @Column(length = 500)
    private String description;
    @ManyToOne
    @JoinColumn(name="Teacher_ID", referencedColumnName = "id")
    private Teacher teacher;
    @Column(name = "students_count")
    private int studentsCount;
    private int price;
    @Column(name = "price_per_hour")
    private int pricePerHour= price/ duration;
    public Course(Teacher teacher) {
        this.teacher= teacher;
    }

    public int getPrice() {
        return price;
    }
        public Course(String courseName, int duration, CourseType type, String description, Teacher teacher, int studentsCount, int price) {
        this.courseName = courseName;
        this.duration = duration;
        this.type = type;
        this.description = description;
        this.teacher = teacher;
        this.studentsCount = studentsCount;
        this.price = price;
    }
}
