package pbouas;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher extends User {

    // Kolom untuk menyimpan teacher ID yang unik
    @Column(name = "teacher_id", nullable = false, unique = true)
    private String teacherId;

    // Relasi One-to-Many dengan entitas Student sebagai supervisor
    @OneToMany(mappedBy = "supervisor")
    private Set<Student> studentSupervised = new HashSet<>();

    // Konstruktor untuk menginisialisasi username, password, dan teacherId
    public Teacher(String username, String password, String teacherId) {
        super(username, password);
        this.teacherId = teacherId;
    }

    // Untuk mengakses dan mengatur nilai field teacherId
    public String getTeacherId() {
        return teacherId;
    }

    // Untuk mengakses dan mengatur nilai field teacherId
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    // Untuk mengakses dan mengatur nilai field studentSupervised
    public Set<Student> getStudentSupervised() {
        return studentSupervised;
    }

    // Untuk mengakses dan mengatur nilai field studentSupervised
    public void setStudentSupervised(Set<Student> studentSupervised) {
        this.studentSupervised = studentSupervised;
    }
}
