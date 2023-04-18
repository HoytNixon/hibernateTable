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

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", teacher=" + teacher +
                ", price=" + price +
                '}';
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

    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
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

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
