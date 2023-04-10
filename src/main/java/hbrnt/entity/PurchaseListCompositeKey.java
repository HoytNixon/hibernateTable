package hbrnt.entity;

import jakarta.persistence.Column;

import java.io.Serializable;

public class PurchaseListCompositeKey implements Serializable {
    @Column(name= "student_name")
    private String studentName;
    @Column(name= "course_name")
    private String courseName;

    public PurchaseListCompositeKey() {
    }

    public PurchaseListCompositeKey(String student, String course) {
        this.studentName = student;
        this.courseName = course;
    }

    public String getStudent() {
        return studentName;
    }

    public void setStudent(String student) {
        this.studentName = student;
    }

    public String getCourse() {
        return courseName;
    }

    public void setCourse(String course) {
        this.courseName = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseListCompositeKey that)) return false;

        if (getStudent() != null ? !getStudent().equals(that.getStudent()) : that.getStudent() != null) return false;
        return getCourse() != null ? getCourse().equals(that.getCourse()) : that.getCourse() == null;
    }

    @Override
    public int hashCode() {
        int result = getStudent() != null ? getStudent().hashCode() : 0;
        result = 31 * result + (getCourse() != null ? getCourse().hashCode() : 0);
        return result;
    }
}
