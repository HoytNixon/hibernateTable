package hbrnt.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45)
    private String name;
    @Column
    private int age;
    @Column(name="registration_date")
    @Temporal(TemporalType.DATE)
    private Date registrationDate= new Date();

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    public Set<Subscription> subscriptedCourses = new HashSet<>();
    protected Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistration_date() {
        return registrationDate;
    }

    public void setRegistration_date(Date registration_date) {
        this.registrationDate = registration_date;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;

        if (getAge() != student.getAge()) return false;
        if (!getName().equals(student.getName())) return false;
        return getRegistration_date().equals(student.getRegistration_date());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + getRegistration_date().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Студент " + name + "--" + age + " лет";
    }
}
