package hbrnt.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.io.Serializable;
@Entity
@Immutable
public class LinkedPurchaseList implements Serializable {
    @Embeddable
    public static class Id implements Serializable{
        @Column(name = "student_id")
        protected Long studentId;
        @Column(name = "course_id")
        protected Long courseId;

        public Id() {
        }

        public Id(Long studentId, Long courseId){
            this.courseId=courseId;
            this.studentId= studentId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Id id)) return false;

            if (!studentId.equals(id.studentId)) return false;
            return courseId.equals(id.courseId);
        }

        @Override
        public int hashCode() {
            int result = studentId.hashCode();
            result = 31 * result + courseId.hashCode();
            return result;
        }
    }
    @EmbeddedId
    protected Id id = new Id();
    @Column(name = "student_id", insertable = false, updatable = false)
    private Student student;
    @Column(name="course_id", insertable = false, updatable = false)
    private Course course;

    public LinkedPurchaseList() {
    }

    public LinkedPurchaseList(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.id.studentId= student.getId();
        this.id.courseId= course.getId();
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
}
