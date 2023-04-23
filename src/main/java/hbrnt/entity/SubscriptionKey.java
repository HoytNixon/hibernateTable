package hbrnt.entity;

import jakarta.persistence.Column;

import java.io.Serializable;

public class SubscriptionKey implements Serializable {
    @Column(name = "student_id")
    public Long studentId;
    @Column(name="course_id")
    public Long courseId;

    public SubscriptionKey() {
    }

    public SubscriptionKey(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
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
        int result = getStudentId().hashCode();
        result = 31 * result + getCourseId().hashCode();
        return result;
    }
}
