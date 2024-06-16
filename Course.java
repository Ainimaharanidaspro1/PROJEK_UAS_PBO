package pbouas;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    // ID unik untuk setiap course, dihasilkan secara otomatis oleh basis data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Nama course, tidak boleh null
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    // ID unik untuk setiap course, tidak boleh null dan harus unik
    @Column(name = "course_id", nullable = false, unique = true)
    private String courseId;

    // Konstruktor default (diperlukan oleh Hibernate)
    public Course() {
    }

    // Konstruktor untuk menginisialisasi nama dan ID course
    public Course(String name, String courseId) {
        this.name = name;
        this.courseId = courseId;
    }

    // Getter untuk ID course
    public int getId() {
        return id;
    }

    // Setter untuk ID course
    public void setId(int id) {
        this.id = id;
    }

    // Getter untuk nama course
    public String getName() {
        return name;
    }

    // Setter untuk nama course
    public void setName(String name) {
        this.name = name;
    }

    // Getter untuk ID unik course
    public String getCourseId() {
        return courseId;
    }

    // Setter untuk ID unik course
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}

//Getter dan Setter diatas tadi Untuk mengakses dan mengubah nilai field id, name, dan courseId.