package hbrnt.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name ="Teachers")
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 45)
    private String name;
    @Column(nullable = false)
    private int salary;
    @Column(nullable = false)
    private int age;

    public Teacher() {
    }

    public Teacher(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher teacher)) return false;

        if (getSalary() != teacher.getSalary()) return false;
        if (getAge() != teacher.getAge()) return false;
        return getName().equals(teacher.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSalary();
        result = 31 * result + getAge();
        return result;
    }
}
