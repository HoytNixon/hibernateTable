package hbrnt.entity;

import jakarta.persistence.Column;

import java.io.Serializable;

public class SubscriptionKey implements Serializable {
    @Column(name = "student_id")
    private int studentId;
    @Column(name="course_id")
    private int courseId;

    public SubscriptionKey() {
    }

    public SubscriptionKey(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubscriptionKey that)) return false;

        if (getStudentId() != that.getStudentId()) return false;
        return getCourseId() == that.getCourseId();
    }

    @Override
    public int hashCode() {
        int result = getStudentId();
        result = 31 * result + getCourseId();
        return result;
    }
}
